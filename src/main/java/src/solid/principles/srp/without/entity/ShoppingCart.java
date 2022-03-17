package src.solid.principles.srp.without.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

  private LinkedList<Item> items;
  private CartStatus cartStatus;
  private Long total;

  public ShoppingCart() {
    this.cartStatus = CartStatus.OPEN;
    this.total = 0L;
  }

  public List<Item> getItems() {
    return items;
  }

  public boolean isValidItem(final Item item) {
    return !Objects.equals(item.getName(), "") && item.getValue() > 0;
  }

  public boolean addItem(final String name, final Long value) {
    final Item item = new Item();
    item.setName(name);
    item.setValue(value);

    if (isValidItem(item)) {
      this.total += value;
      return items.add(item);
    }
    return false;
  }

  public Long getTotal() {
    return this.total;
  }

  public CartStatus getCartStatus() {
    return this.cartStatus;
  }

  public boolean confirmOrder() {
    if (this.isValidCart()) {
      this.cartStatus = CartStatus.CONFIRMED;
      this.sendEmailConfirmOrder();

      return true;
    }
    return false;
  }

  public void sendEmailConfirmOrder() {
    System.out.println("Send order confirmation email......");
    ;
  }

  public boolean isValidCart() {
    return items.size() > 0;
  }
}
