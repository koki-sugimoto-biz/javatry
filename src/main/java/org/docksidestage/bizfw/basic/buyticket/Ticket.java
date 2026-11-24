/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final TicketType ticketType;
    private int remainingDays;
    private final int displayPrice; // written on ticket, park guest can watch this
    private boolean alreadyIn;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(int displayPrice) {
        this(TicketType.ONE_DAY, displayPrice, 1);
    }

    public Ticket(TicketType ticketType, int displayPrice, int usableDays) {
        this.ticketType = Objects.requireNonNull(ticketType, "ticketType");
        this.displayPrice = displayPrice;
        this.remainingDays = usableDays;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        doInPark(LocalTime.now());
    }

    public void doInPark(LocalTime entryTime) {
        Objects.requireNonNull(entryTime, "entryTime");
        if (isUsedUp()) {
            throw new IllegalStateException("Ticket is used up: displayedPrice=" + displayPrice);
        }
        if (ticketType == TicketType.NIGHT_ONLY_TWO_DAY && entryTime.isBefore(LocalTime.of(18, 0))) {
            throw new IllegalStateException("Outside admission hours: time=" + entryTime);
        }
        --remainingDays;
        alreadyIn = true;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public TicketType getTicketType() {
        return ticketType;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public boolean isUsedUp() {
        return remainingDays == 0;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
