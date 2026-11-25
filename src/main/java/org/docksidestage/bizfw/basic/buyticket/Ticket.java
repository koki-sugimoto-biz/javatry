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
    // #1on1: いいね、remainingDaysの名前、わかりやすい (入った日数ではないことが明示的) (2026/11/25)
    private final TicketType ticketType;
    private int remainingDays;
    private final int displayPrice; // written on ticket, park guest can watch this
    // #1on1: alreadyInの意味は？ (2026/11/25)
    // $使い切ったらtrue
    // でも今実装が1日でも入ったらtrueになっている
    // TODO sugimoto ズレを直しましょう by jflute (2026/11/25)
    private boolean alreadyIn;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // #1on1: step6のOneDayのためのコンストラクターを互換のために残している？ (2026/11/25)
    // (BoothのOneDayでは使っていないようで)
    // $特別な意図があったっけ？
    // Boothでも使っているのであれば、OneDay用のコンストラクターで区別するためにやってるとかわかる。
    // でも、そうではないのでstep6のコードを極力変更させないためのコードなのかな？と。
    // TODO sugimoto あっても良いので、step6互換のために残しているコンストラクター、ってコメントが欲しい by jflute (2026/11/25)
    public Ticket(int displayPrice) {
        this(TicketType.ONE_DAY, displayPrice, 1);
    }

    public Ticket(TicketType ticketType, int displayPrice, int usableDays) {
        // #1on1: いいね、ticketTypeのnullチェック (2026/11/25)
        // 一方で、引数のnullチェックに関するポリシーとしては、どの程度やる？ってのはあります？
        // $マチマチではあるけど...Cなんかだと...難しい...引数の中に主役と脇役...
        // マチマチでも何かしらのポリシーが言語化できると良い。
        // TicketBoothのhandedMoneyはやっていないので、そのへん聞いてみた。
        // あと、主役と脇役の延長みたいな感じで、よく呼ばれるpublicメソッドかどうか？
        // という感じで何かしらの費用対効果の基準を考えてみると良いです。
        // (インスタンス変数に not null のコメント付ける話)
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

    // #1on1: 呼び出し側を isUsedUp() で直しちゃうかどうか？ (2026/11/25)
    // 実務でこういう場面があったら、直すかどうか？
    // $後回しにしちゃうたちだけど、AIもあるのでやれるかな!? (別チケットか!?)
    // この辺はまずはチームポリシー次第ではある。
    // 両方ある。律儀に別チケットもあれば、その場で修正していこうもある。
    // 理想は律儀に別チケット、プルリク差分も、テスト対象も最小限になるので。
    // ただ、その別チケット(リファクタリングチケット)、いつやる問題。
    // たいてい残ったままの現場が多い印象。
    // 定期的なリファクタリングタイムのお話。
    // なのでその場で修正のポリシーは、理想は達成できない想定で今やっちゃうという感じ。
    // (せめてコミットを分けようってのはある)
    // 理想を得ようとして、できなくて最下位を取ってしまう話。
    // 
    // 昨今のセキュリティ対策話と通じるところもある。
    // 別分野の話、定期点検。
    // リファクタリングとセキュリティはつながるところある。
    // (コードがきたないとセキュリティ危ないところがわかりにくい)
    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
