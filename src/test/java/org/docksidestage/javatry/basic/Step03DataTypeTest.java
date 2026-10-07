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
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of data type. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step03DataTypeTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          Basic Type
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_datatype_basicType() {
        String sea = "mystic";
        Integer land = 416;

        // #1on1: Date/DateTimeという言葉 (2026/10/07)
        // 日付(Date): 年月日
        // 日時(DateTime): 年月日+時分秒
        //
        // 歴史的にこうじゃないときがあるのでちょい注意。
        // e.g. java.util.Date, OracleDB DATE型が時分秒
        // $エポックDayの32ビット問題の話
        // 
        // jfluteの個人的な分析、日付系クラス、日付(系)クラスというように、
        // DateとDateTimeを含んだ抽象概念として、Dateを使うことがあったりしないかな!?
        //
        // 言葉にこだわること自体がトレーニング。
        //
        LocalDate piari = LocalDate.of(2001, 9, 4);
        LocalDateTime bonvo = LocalDateTime.of(2001, 9, 4, 12, 34, 56);
        Boolean dstore = true;
        BigDecimal amba = new BigDecimal("9.4");

        piari = piari.plusDays(1);
        land = piari.getYear();
        bonvo = bonvo.plusMonths(1);
        land = bonvo.getMonthValue();
        land--;
        if (dstore) {
            BigDecimal addedDecimal = amba.add(new BigDecimal(land));
            sea = String.valueOf(addedDecimal);
        }
        log(sea); // your answer? => 18.4
    }

    // ===================================================================================
    //                                                                           Primitive
    //                                                                           =========
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_primitive() {
        byte sea = 127; // max
        short land = 32767; // max
        int piari = 1;
        long bonvo = 9223372036854775807L; // max
        float dstore = 1.1f;
        double amba = 2.3d;
        char miraco = 'a';
        boolean dohotel = miraco == 'a';
        if (dohotel && dstore >= piari) {
            bonvo = sea;
            land = (short) bonvo;
            bonvo = piari;
            sea = (byte) land;
            if (amba == 2.3D) {
                sea = (byte) amba;
            }
        }
        if ((int) dstore > piari) {
            sea = 0;
        }
        log(sea); // your answer? => 2

        // #1on1: キャストは情報ロスが発生する可能性があるのでできるだけ避けたい (2026/10/07)
    }

    // ===================================================================================
    //                                                                              Object
    //                                                                              ======
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_object() {
        St3ImmutableStage stage = new St3ImmutableStage("hangar");
        String sea = stage.getStageName();
        log(sea); // your answer? => hangar
    }

    // #1on1: Javaでimmutableを素直に作るとなったらこうなる (2026/10/07)
    // finalは必須ではないけど、付けてた方がメンテする人が安全、読む人が読みやすい。
    private static class St3ImmutableStage {

        private final String stageName;

        public St3ImmutableStage(String stageName) {
            this.stageName = stageName;
        }

        public String getStageName() {
            return stageName;
        }
    }

    // #1on1: $要件定義の一部を上司に巻き取ってもらったけど、悔しい (2026/10/07)
    // $そこから学んで、今度こそは。
    //
    // できなかった理由:
    // $全体がちゃんとわかってなかった、現状とゴールはあったが、中のイメージが足らない
    // $業務の全体像、システムの全体像、両方
    // $AIやチームに頼って、現状報告をしてフィードバックをもらいながら全体像。
    // 全体像がすぐには把握できないことを前提に進めていく。
    //
    // 要件定義ってどこからどこまで？
    // 要求定義(これやりたい)と要件定義(つまりこういうことですね)の違い。
    //
    // 要件定義
    // → 外部設計(インターフェース設計)
    // → 内部設計(機能設計)
    // → 詳細設計(実装設計)
    // --- $このへんまで要件定義の感覚だった
    // → 実装
    // (→ テスト設計)
    // → テスト
    //
    // 今まで要件定義と思っていた領域の作業を整理整頓するきっかけになればと。
    // SIer経験とwebサービス出身のジレンマ。
}
