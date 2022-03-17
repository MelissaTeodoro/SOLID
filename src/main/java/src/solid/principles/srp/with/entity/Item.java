package src.solid.principles.srp.with.entity;

import java.util.Objects;

public class Item {

  private String name;
  private Long value;

  public Item(String name, Long value) {
    this.name = name;
    this.value = value;
  }

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

  public boolean isValid() {
    return !Objects.equals(this.name, "") && this.value > 0;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }
}
