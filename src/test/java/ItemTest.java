import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

  @ParameterizedTest
  @MethodSource("itemValidateProvider")
  void testValidateItem(Item item, boolean isValid) {
    Assertions.assertEquals(isValid, item.isValid());
  }

  private static Stream<Arguments> itemValidateProvider() {
    return Stream.of(
        Arguments.of(new Item(), false),
        Arguments.of(new Item("Caderno de anotações", 10L), true),
        Arguments.of(new Item("", 10L), false),
        Arguments.of(new Item("Caderno de anotações", 0L), false),
        Arguments.of(new Item("", 0L), false)
    );
  }

}
