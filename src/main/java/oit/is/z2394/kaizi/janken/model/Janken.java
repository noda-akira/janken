package oit.is.z2394.kaizi.janken.model;

import java.util.Random;

public class Janken {

  // CPUの手をランダムに生成するメソッド
  public String cpuHand() {
    String[] hands = { "グー", "チョキ", "パー" };
    Random rand = new Random();
    int index = rand.nextInt(hands.length);
    return hands[index];
  }

  // プレイヤーとCPUの手から結果を判定するメソッド
  public String judgeResult(String yourHand, String cpuHand) {
    if (yourHand.equals(cpuHand)) {
      return "引き分け";
    } else if ((yourHand.equals("グー") && cpuHand.equals("チョキ")) ||
        (yourHand.equals("チョキ") && cpuHand.equals("パー")) ||
        (yourHand.equals("パー") && cpuHand.equals("グー"))) {
      return "勝ち";
    } else {
      return "負け";
    }
  }
}
