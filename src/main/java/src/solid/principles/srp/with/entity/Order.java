package src.solid.principles.srp.with.entity;

public class Order {

  private Status status;
  private ShoppingCart shoppingCart;
  private Long total;

  public Order() {
    this.status = Status.OPEN;
    this.shoppingCart = new ShoppingCart();
    this.total = 0L;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public boolean confirm() {
    if (shoppingCart.isValid()) {
      this.status = Status.CONFIRMED;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Order{" +
        "status=" + status +
        ", shoppingCart=" + shoppingCart +
        ", total=" + total +
        '}';
  }

}
