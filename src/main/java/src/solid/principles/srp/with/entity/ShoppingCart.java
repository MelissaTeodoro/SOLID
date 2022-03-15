package src.solid.principles.srp.with.entity;

import java.util.LinkedList;

public class ShoppingCart {

  private LinkedList<Item> items = new LinkedList<>();

  public ShoppingCart() {
  }

  public ShoppingCart(LinkedList<Item> items) {
    this.items = items;
  }

  public LinkedList<Item> getItems() {
    return items;
  }

  public boolean addItem(final Item item) {
    this.items.add(item);
    return true;
  }

  public boolean isValid() {
    return this.items.size() > 0;
  }

  @Override
  public String toString() {
    return "ShoppingCart{" +
        "items=" + items +
        '}';
  }
}
