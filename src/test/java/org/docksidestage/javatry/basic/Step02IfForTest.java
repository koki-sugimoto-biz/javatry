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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
            sea = sea++ * 2;
        } else if (land && sea >= 904) {
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {
            if (sea % 2 == 0) {
                sea = sea++ * 2;
            }
            if (!land) {
                land = true; // ここを通ればseaは10と言い切れる
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {
                sea = 8;
            }
            // sea = 8 land = true
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--;
            if (sea % 2 == 1) {
                sea++;
            }
        }
        if (land) {
            sea = 10;
        }
        log(sea); // your answer? => 10

        // #1on1: $上から読んでごちゃごちゃやってるなと思って最後結局10じゃんかよ (2026/08/26)
        // 上から読むのは、javatryとしてはトレーニングになるので、それはそれでGoodです。
        // 
        // 漠然読みの紹介:
        // o 漠然読みで構造だけ把握する (全体像を見る)
        //  → 5つパート、でっかいif文
        //  → 当たりを見つけやすくなってる (逆さ読みもやりつつではあるけど)
        // o 当たり(ギャンブルポイント)を見つけて、フォーカス読み
        //  → landで逆さ読みをしていってtrueになるかどうか？
        //
        // ただ、ギャンブルに負けることはある。でも、損はない。
        // 構造把握して、ある程度踏み込んだことで、０から読むよりは速く読めるようになってる。
        // あと安定して読めるようになっている。という考え。
        //
        // 一方で、ギャンブルに負けても、次の当たりを見つけてフォーカス読み。
        // 3,4回繰り返しても、コードの規模によっては網羅読みよりも速い可能性あり。
        // 
        // ぼくらのお仕事は、全てを把握することではなく、その目的を達成すること。
        //
        // 読まなくて良いところを読まないように努力する。
        //
        // 仮説思考的なコードリーディング!?
        // 
        // done sugimoto [読み物課題] My Favorite Book: 仮説思考 by jflute (2026/08/26)
        // https://jflute.hatenadiary.jp/entry/20150111/kasetsu
        //
        // $いきなり詳細に突っ込んで論理の迷子になる経験もあった
        // 意識の実践を繰り返していけば、そのうち無意識にできるようになる
        //
        // 『仮説を事実だと思い込む』はめっちゃあるあるだなと思いました。
        // 自分の中で仮説のつもりでも、『A + B = C』の、AとBを足し算するっていう部分すら仮説のはずなのに、事実としてごっちゃにしちゃうとかは昔あった
        //  『= C』の部分も仮説だけど、左辺の式も仮説だよと認識しておかないといけない
        // スモールライトの話はめちゃくちゃ大事だけど、しっかり抽象化しないとスモールライト当てるのも難しいなと思いました。
        // #1on1: Cに辿り着くまでのプロセス自体が合ってるとも限らないってのは素晴らしい視点 (2026/09/09)
        // $インターンのときの記憶。「仮説じゃなくて想像だよ」って言われたことが印象に残ってる。by すぎもとさん
        // 確かに、仮説と想像も別物。
        // 仮説と当てずっぽうは別物ってよく言うけど、そこに近いかも。
        // 仮説は、あくまで検証して導き出した論理的な結果、ただし検証がまだ一部。
        // その先輩は素晴らしい。仮説と想像の区別をしっかりできて伝えてくれた。

        //
        // 関連：論理的に行き詰まったとき、からが始まり
        // https://jflute.hatenadiary.jp/entry/20140613/zerostart
        // 人生とかインターンとかにおいてはこの状態になったことはあったはずだけど、社会人になってからはまだなってない
        // インプットが多いのもそうだけど、脳に汗をちゃんとかけてないのかな？
        // #1on1: こう思うのは素晴らしい、自分から厳しいところに突っ込んでいかないと (2026/09/09)
        // 世の中、厳しいところに連れていってもらえないので、自分から。
        //
        // //仕事の先にある仕事は明るい
        // https://jflute.hatenadiary.jp/entry/20131028/brightness
        // ```
        // 通る道にするんです、自らの行動でね
        // いま通ってる道、自分の通りたい道ではなくても、
        // そこでの成果物を最高のものに仕上げていれば、
        // その道は本当に通りたい道への道になる。
        // いいかげんなものを出してると本当に無駄な道になる。
        // ```
        // 成果物を最高のものに仕上げるって、思ったより大変なこと。
        // だいたいみんな8割9割で妥協して進むことが多い。
    }

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) { // 拡張for文っていうらしい。listの要素を順々にstageに入れている by sugimoto
            sea = stage;
        }
        log(sea); // your answer? => magiclamp

        // #1on1: Java文法のfor文二つ (2026/08/26)
        // いんとあいのfor文: 
        // 拡張for文: // 普通のfor文!?
        //
        // よもやま: 文法用語が現場で浸透しているとは限らない
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) { // stageに"ga"が含まれているか
                break;
            }
        }
        log(sea); // your answer? => hangar
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        List<String> filteredStageList = new ArrayList<>();
        for (String stage : stageList) {
            if (stage.contains("a")) {
                filteredStageList.add(stage);
            }
        }
        for (int i = 0; i < filteredStageList.size(); i++) {
            String sea = filteredStageList.get(i);
            log(sea);
        }
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        //        List<String> stageList = prepareStageList();
        //        String sea = null;
        //        for (String stage : stageList) {
        //            if (stage.startsWith("br")) {
        //                continue;
        //            }
        //            sea = stage;
        //            if (stage.contains("ga")) {
        //                break;
        //            }
        //        }
        //        log(sea); // should be same as before-fix
        List<String> stageList = prepareStageList();
        String[] sea = { null }; // ラムダ式で使うローカル変数は、finalじゃないといけないらしい？配列の要素は変えられるらしい
        // done sugimoto flagじゃなくてもうちょいわかりやすい変数名を (習慣として) by jflute (2026/08/26)
        // TODO sugimoto determinedだと判断したっていう意味しかないかなと by jflute (2026/09/09)
        // 何を determined したのか？の方が、変数名に欲しいところかな。
        // 変数宣言のところだけで、「ああ、こういうときにtrueになるものなんだ」ってわかるように。
        // $gaを見つけたらなので、foundGa とか!?
        // yes, すごくGood。
        // あとは、意味を少し抽象化して(フォーカスを制御に移して)、
        // e.g. breakable, isBreak, breakRequested
        // 読み手への直感性を優先するのか？若干の汎用性を優先するのか？
        // すでにコメントの中だけども、ご自身でどれか好きなものを選んで修正してみてください。
        // done sugimoto 修行++: このflag変数使わなくても実現できます(パズル問題) by jflute (2026/08/26)
        //        Boolean[] determined = { false }; // 同上
        //        stageList.forEach(stage -> {
        //            if (determined[0]) {
        //                return;
        //            }
        //            if (stage.startsWith("br")) {
        //                return;
        //            }
        //            sea[0] = stage;
        //            if (stage.contains("ga")) {
        //                determined[0] = true;
        //            }
        //        });
        //        log(sea);
        stageList.forEach(stage -> {
            if (sea[0] != null && sea[0].contains("ga")) {
                return;
            }
            if (stage.startsWith("br")) {
                return;
            }
            sea[0] = stage;
        });
        log(sea[0]);

        // #1on1: なぜ？Lambdaの中で外側のローカル変数の書き換えができない文法なのか？ (2026/08/26)
        // $メソッド化したことがあやしい
        // ソースコードリーディングしてみた。
        // forEach()メソッドは、ただのfor文の代理人。
        // 引数のConsumerとかlambda式はstep8で詳しくやります。
        // まあ要は、別クラスの別メソッドを引数に入れている。
        // {} は別クラス別メソッド。
        //
        // そう考えると、別クラス別メソッドが、別メソッドの変数の代入をできたら大変だよね!?
        // ローカル変数なのに、別メソッドが書き換えとかできたらカオスになる。
        // だから、continue;break;もできない。
        //
        // ということで、できないことだらけのforEach()メソッド。
        // 代理人経由しちゃってるから、本来のfor文の機能が使えない状態になっている。
        //
        // じゃあなぜforEach()メソッドは存在するのか？
        //
        // o int iのfor文: Java当初から (1995年)
        // o 拡張for文: 10年目ぐらいから (2005年くらい)
        // o forEach()メソッド: 20年目くらいから (2015年くらい)
        //
        // ローカル変数書き換えやcontinue;break;が要らない場面だったら...
        // 制限が掛かってる道具を使った方が、安全で可読性も良い。
        // なので、ストレートなループしかしない場面なら、forEach()が適していると言える。
        // 制限があることで得られるものがある。
        // 実際、webサービスだったら、ストレートなループがほとんどの印象。
        //
        // 一方で、適材適所すぎるのもつらいのがジレンマ。
        // 使い分けを判断するのも脳みそコスト。
        // なので制限デザインが難しい。いかにうまく制限を取り入れるか？
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * prepareStageListの要素を全てlogに出力しましょう
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        List<String> stageList = prepareStageList();
        for (String stage : stageList) {
            log(stage);
        }
    }

    // #1on1: $困ってる (2026/09/09)
    // $以前は、お客さんの話のベースがあって実装が決まるタスクが多い。
    // $いまは、お客さんの要求があって要件はまだないタスクが多い。
    // $チームメンバーに何をやっているのか？を伝えるには？shareできてない悩み。
    // 
    // 実装仕事は勝手に伝わっていきやすい。
    // 要件定義のアウトプットは、曖昧でケースバイケースなので伝わりにくい。
    // 
    // そもそもチームで状況を共有し合う理由:
    // posi: チームメンバーで把握しあっていれば、変な齟齬やすれ違い、協力し合える。
    // nega: 互いに監視しあって、会社としてさぼりがないように
    //
    // 伝える方が自分も得になるという気持ちを持つことが大事。
    //
    // ブランチは、どの時点でも早めにプッシュでOK(な現場が圧倒的に多いと思う)。
    // 一方で、Issues (or JIRA) とかのコメントに毎日進んだことをメモ書く。
    // (まとめたmdをそのまま添付するとかでもいいし)
    //
    // ↑(途中経過)をどこかに残しておくのが大事な理由。(進捗共有以外の目的で)
    // 途中で、違う仕事を任されて、今やってた仕事は別の人が引き継ぐとかもあり得る。
    // 何かしらのアクシデントで、今までの担当者とコミュニケーション取れない状況で引き継ぎもありえる。
    // あと、コーヒーをMacBookにぶちまける可能性がある。
    //
    // 今の段階でこういうことを考えるきっかけが得られたのはとても良いこと。

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
