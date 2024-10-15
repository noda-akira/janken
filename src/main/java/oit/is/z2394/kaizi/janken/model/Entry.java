package oit.is.z2394.kaizi.janken.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Entry {
  private ArrayList<String> users = new ArrayList<>();
  private int roomNo = 1;

  public void addUser(String name) {
    if (!users.contains(name)) {
      users.add(name);
    }
  }

  public void removeUser(String name) {
    users.remove(name); // ユーザを削除するメソッドを追加
  }

  public ArrayList<String> getUsers() {
    return users;
  }

  public int getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(int roomNo) {
    this.roomNo = roomNo;
  }
}
