import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.solid.principles.srp.with.entity.Item;

public class ItemTest {

  private final Item item = new Item();

  @Test
  void testInitialState() {
    Assertions.assertEquals("", item.getName());
    Assertions.assertEquals(0L, item.getValue());
  }

  @Test
  void testName() {
    final String itemName = "Camiseta Branca M";
    item.setName(itemName);

    Assertions.assertEquals(itemName, item.getName());
  }

  @Test
  void testValue() {
    final long itemValue = 100L;
    item.setValue(itemValue);

    Assertions.assertEquals(itemValue, item.getValue());
  }

  @Test
  void testValidation() {
    final Item item = new Item();
    item.setName("Caderno para anotações");
    item.setValue(10L);

    Assertions.assertTrue(item.isValid());

    item.setName("");
    item.setValue(10L);
    Assertions.assertFalse(item.isValid());

    item.setName("Caderno para anotações");
    item.setValue(0L);
    Assertions.assertFalse(item.isValid());

    item.setName("");
    item.setValue(0L);
    Assertions.assertFalse(item.isValid());
  }

  @Test
  void testItemWhenIsNotValid() {
    final Item item = new Item();

    Assertions.assertFalse(item.isValid());
  }
}
