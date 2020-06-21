package idcard;

import framework.*;

public class IDCard extends Product {
    private int num;
    private String owner;
    IDCard(String owner, int num) {  // idcardパッケージの外からnewを使って生成できないことを表す
        // IDcardFactory経由でしかインスタンスを作ることができない
        System.out.println(num + "番目: " + owner + "のカードを作ります！");  
        this.owner = owner;
        this.num = num;             
    }
    public void use() {
        System.out.println(num + "番目: " + owner + "のカードを使います");
    }
    public String getOwner() {
        return owner;
    }
    public int getNum() {
        return num;
    }
}