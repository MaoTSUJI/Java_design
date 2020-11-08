package idcard;

import framework.*;

public class IDCard extends Product {
  private String owner;

  IDCard(String owner) {
    System.out.println(owner + "�Υ����ɤ���ޤ���");
    this.owner = owner;
  }

  public void use() {
    System.out.println(owner + "�Υ����ɤ�Ȥ��ޤ���");
  }

  public String getOwner() {
    return owner;
  }
}
