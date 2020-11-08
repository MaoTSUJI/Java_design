package idcard;

import framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
  // public List owners = new ArrayList<String>();
  public HashMap database = new HashMap<>();
  private int num = 100;

  protected Product createProduct(String owner) {
    return new IDCard(owner, num++);
  }

  protected void registerProduct(Product product) {
    // owners.add(((IDCard)product).getOwner());
    IDCard card = (IDCard) product;
    database.put(new Integer(card.getNum()), card.getOwner());
  }
  // public List getOwners() {
  //     return owners;
  // }
  public HashMap getDatabase() {
    return database;
  }
}
