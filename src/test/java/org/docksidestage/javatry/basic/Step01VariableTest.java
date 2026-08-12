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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8null:mai
        // TODO sugimoto [読み物課題] 応援してる "A" にもデメリットはあるよ by jflute (2026/07/27)
        // https://jflute.hatenadiary.jp/entry/20181008/yourademerit

        // TODO sugimoto 全然話違いますが...Javatryの全容を先にお聞きして進め方考えるのアリかもです by akinari.tsuji (2026/08/12)
        // basicの後に、colorbox, debug, DI, DBFluteも別であり、どれを深く知りたいかを事前に決めておくと進めやすいかもです
        // （自分はbasicのstep06, 07を深掘りさせていただきました）
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // 1(1丁目1番地)
        String land = "oneman"; // 2(2丁目2番地)
        sea = land; // seaもlandも2丁目2番地を指してる
        land = land + "'s dreams"; // "'s dreams"(3丁目3番地), "oneman's dreams"
        log(sea); // your answer? => oneman
        // #1on1: インスタンスとは？ (2026/07/27)
        // 聞いたことありはするけど...インスタンスのイメージ？なんなんだろう？ by すぎもとさん
        // 一軒家の例。
        // インスタンスのフォーカス。
        // 質問: 変数とは違うのか？
        // 変数とインスタンスの関係性。
        // 変数とインスタンスって大抵は1:1だけど、厳密にはmany-to-oneにもなる。
        //
        // onemanとかは破棄されるのか？
        // → 破棄対象(候補)になる、いつかガベージコレクションで破棄される
        //
        // #1on1: BigDecimalインスタンスエクササイズGood (2026/07/27)
        // 仮説を言い切るところ、素晴らしい。ビジネスコミュニケーションでは大事なこと。
        // add()でreturn new BigDecimal()してるところたくさん。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
        // #1on1: プリミティヴ型は変数に値がそのまま入っているイメージ (2026/07/27)
        // 言語によっては、intって書いてもオブジェクトの場合もある。
        // 質問 → intのラッパー型(オブジェクト型)はInteger。

        // TODO sugimoto [教えてください] Goはどういうパラダイムの言語です？ by akinari.tsuji (2026/08/12)
        // Goではクラスや継承がないと聞きましたがオブジェクト指向なのかなーと気になりました。
        // Step06の内容かもなので、無視してDoneでも大丈夫です！
        // （お節介かもですが）せっかく普段と違うJavaという言語なので、業務で使う言語と比較しながら進めると面白いかもです！
        // ちなみにRubyだと全てがオブジェクトになります。なので "1.to_s"とかかけちゃいます。
        // 実行環境やクラス定義自身もオブジェクトになります（初めて知った時びっくりしました笑）。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94); // 1
        BigDecimal land = new BigDecimal(415); // 2
        sea = land;
        sea = land.add(new BigDecimal(1)); // 3, 4
        sea.add(new BigDecimal(1)); // 5, 6
        log(sea); // your answer? => 416
        // done jflute 1on1にてimmutableふぉろー予定 (2026/07/27)
        // #1on1: immutableとは？ (2026/07/27)
        // 聞いたことがあるかないかくらい。
        // Immutableは「不変な」
        // o Immutableなインスタンス(クラス)
        // o Immutableな変数
        //
        // immutableのメリデメ: (mutableに対して)
        // (メリット)
        // o 環境変数みたいな不変な担保されている方がいい(安全性) by すぎもとさん
        // o 責務がわかりやすい印象 by すぎもとさん
        // o 読み飛ばしとか、確定情報を得られやすくなって、可読性が良くなる by jflute
        //   (責務の話と通じるかも)
        // (デメリット)

        // TODO jflute 次回1on1にて、immutableのデメリットから、歴史まで (2026/07/27)
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null(Integerは参照型だからnull許容)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|"magician"(helpInstanceVariableViaMethodでreturnしてない)
        // done jflute 1on1にて、引数の変数のお話をフォロー予定 (2026/07/27)
    }

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor(sea.concat(landStr);を代入していない)
        // done sugimoto 厳密には、help内で代入をしてたとしても結果は変わらないです by jflute (2026/07/27)
        // #1on1: immutableインスタンスなので、helpメソッドを読まなくても答えが確定する (2026/07/27)
        //        (かつ、sea変数はimmutableではないけど、再代入をどこでもやってないから)
        // #1on1: 変数の型とは？ (2026/07/27)
        // 変数という箱に入れるものはこれだよ、っていう制約。
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // TODO jflute 次回1on1にて、mutableなクラスの話 (2026/07/27)
    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => harbor415(StringBuilderは内部にバッファを持っておりそちらに直接書きこれるため)
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor(returnも再代入もしていない)
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land; // is 146
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    int piari;

    public void test_variable_writing() {
        // define variables here
        String sea = "mystic";
        Integer land = null;
        log(sea, land, piari);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * Same as the previous method question.
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        // write your code here
        StringBuilder sea = new StringBuilder("Hello");
        sea.append(" World!");
        log(sea); // your answer? => Hello World!
    }
}
