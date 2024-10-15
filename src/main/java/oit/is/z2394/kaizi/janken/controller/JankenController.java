package oit.is.z2394.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2394.kaizi.janken.model.Entry;
import oit.is.z2394.kaizi.janken.model.Janken;

@Controller
@RequestMapping("/janken")
public class JankenController {

  @Autowired
  private Entry entry;

  private final Janken janken = new Janken(); // Jankenのインスタンスを作成

  // 初期ページを表示
  @GetMapping()
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser); // ユーザをエントリーに追加
    model.addAttribute("entry", this.entry.getUsers()); // 現在ログインしている全ユーザをモデルに追加
    model.addAttribute("username", loginUser); // ログインしているユーザ名をモデルに追加

    return "janken.html"; // janken.htmlを返す
  }

  // じゃんけんをプレイするメソッド
  @GetMapping("/play")
  public String playJanken(@RequestParam("hand") String yourHand, Principal prin, ModelMap model) {
    String cpuHand = janken.cpuHand(); // CPUの手を生成
    String result = janken.judgeResult(yourHand, cpuHand); // 結果を判定

    // 現在のユーザをモデルに追加
    String loginUser = prin.getName();
    this.entry.addUser(loginUser); // 現在のユーザを追加（重複を避けるためにはエントリークラスのaddUserを使います）

    model.addAttribute("myhand", yourHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", result);
    model.addAttribute("entry", this.entry.getUsers()); // ユーザリストを追加

    return "janken.html"; // 結果をjanken.htmlで表示
  }

  @GetMapping("/logout")
  public String logout(Principal prin) {
    String loginUser = prin.getName();
    this.entry.removeUser(loginUser); // ログアウト時にユーザを削除
    return "redirect:/"; // トップページにリダイレクト
  }

}
