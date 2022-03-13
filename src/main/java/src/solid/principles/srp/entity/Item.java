package src.solid.principles.srp.entity;

public class Item {

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }

  private String name;
  private Long value;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }
}
