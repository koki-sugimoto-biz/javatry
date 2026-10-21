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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? => over
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        String sea = functionSomething("mystic");
        consumeSomething(supplySomething());
        runnableSomething();
        log(sea); // your answer? => mysmys
    }

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys");
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over";
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic"));
    }

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904;
        boolean land = false;
        helloMutable(sea - 4, land, mutable);
        if (!land) {
            sea = sea + mutable.getStageName().length();
        }
        log(sea); // your answer? => 910
    }

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    // #1on1: なんでインスタンス変数はデフォルト初期化になるのか？ (2026/10/21)
    // (統一性からすると、ちょっと変)
    // $ローカル変数とインスタンス変数でスコープが違うので、インスタンス変数と宣言場所と使う場所が異なるから？
    // 発想とてもGood。
    //
    // ローカル変数はスコープが短い。デフォルト初期値を入れることが比較的少ない
    // → 宣言場所と使う場所が近いので、デフォルト初期値が活躍する場面がない。
    //   すぐに業務的な初期値を入れられる状況になることが多い
    //   逆に、デフォルト初期値が暗黙的に入るようにしてると、レアなので気づきづらくて間違えそう。
    //   (デフォルト初期値に頼りたくなるケースの方がレア)
    //   (レアなものってみんな覚えないので、勘違いや見逃しの確率が増える)
    //   (レアなケースなので = 0 って手打ちしてもそんなに面倒じゃない)
    //
    // インスタンス変数はスコープが長い(インスタンスの寿命と同じ)。
    // → しかも、インスタンス変数が初期化されてから、使われるまでタイムラグが大きいケースも多い。
    //   インスタンス変数と宣言場所と使う場所が異なる → 使われるタイミングも遠い
    //   ローカル変数とは逆に、とりあえずデフォルト初期値入れておいて待ってることも多い。
    //   インスタンスの状態を示すものなので、スタート値という概念が生まれやすい。
    //   インスタンス変数は比較的多くなりがちなので、= 0 を打つ手間が大きい。
    //
    // まあ正解はないけども、こういう風に深掘りして思考を巡らせることが大事。
    // それぞれの文法(のデザイン)には背景がある(はず)。
    // そういうところまで考えて覚えることができたら、記憶に残りやすい。
    //
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true;
        int sea = inParkCount;
        offAnnualPassport(hasAnnualPassport);
        for (int i = 0; i < 100; i++) {
            goToPark();
        }
        ++sea;
        sea = inParkCount;
        log(sea); // your answer? => ?
        // 実行したら100だった。seaの初期値が0だったら成立すると思う
        // https://qiita.com/kumaGoro_95/items/3420cbb36f4e9edfcee1
        // 今回はインスタンス変数っぽい
    }

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) {
            ++inParkCount;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    private boolean availableLogging = true;

    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAwithB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCwithB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o quote(): has two arguments as String, returns first argument quoted by second argument (quotation) 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it separately)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAwithB(): 一つのString引数、引数の "A" を "B" に置き換えたStringを戻す 
     * o replaceCwithB(): 一つのString引数、引数の "C" を "B" に置き換えたStringを戻す 
     * o quote(): 二つのString引数、第一引数を第二引数(引用符)で囲ったものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも別途作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    public void test_method_making() {
        // use after making these methods
        String replaced = replaceCwithB(replaceAwithB("ABC"));
        String sea = quote(replaced, "'");
        if (isAvailableLogging()) {
            showSea(sea);
        }
    }

    // write methods here
    // #1on1: いいね、メソッド定義位置が、メソッド呼び出し順序と一緒で直感的で把握しやすい (2026/10/21)
    // バラバラよりは、何かしらのルールに則って配置されている方が頭に入りやすい。(個人差あり)
    // $全部はないけど、replace系は近くに置いておこうとかはある。まとまり意識。
    // 既存のjavatry, まとまりもあれば、メソッド呼び出し順序もある。
    // 一方で、ミクロな場面では相反することもある。replaceの場所次第。
    // jfluteだったら、まとまりの存在感がどのくらい大きいか？
    // もし存在感が大きいなら、そもそも(位置的に)独立させる。
    // LastaFluteのActionRequestProcessorの例。
    // 程度はどうあれ、ある程度メソッド定義位置というものにぜひ注目して欲しい。
    // TODO jflute ほんのちょっと続きがあるので次回 (2026/10/21)

    // #1on1: いいね、第二引数名、わかりやすくて良い (2026/10/21)
    // 通常のローカル変数よりも、引数変数の名前の方がより大事。
    // 引数変数は、(対外的な)メソッドインターフェースの一部。
    private String replaceAwithB(String name) {
        return name.replace("A", "B");
    }

    private String replaceCwithB(String name) {
        return name.replace("C", "B");
    }

    private String quote(String text, String quoteMark) {
        return quoteMark + text + quoteMark;
    }

    private boolean isAvailableLogging() {
        return availableLogging;
    }

    private void showSea(String sea) {
        log(sea);
    }
}
