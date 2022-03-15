package src.solid.principles.srp.with.pages.root;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import src.solid.principles.srp.with.entity.Item;
import src.solid.principles.srp.with.entity.Order;
import src.solid.principles.srp.with.entity.Status;
import src.solid.principles.srp.with.service.EmailService;

public class Root implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    final StringBuilder outBuilder = new StringBuilder();

    outBuilder.append("With SRP - SOLID");

    final Order order = new Order();

    final Item item1 = new Item("Tênis Feminino", 200L);
    final Item item2 = new Item("Boné Feminino", 90L);

    order.getShoppingCart().addItem(item1);
    order.getShoppingCart().addItem(item2);

    outBuilder.append("--- Order ---");

    outBuilder.append("\nInitial Order: " + order);
    outBuilder.append("\nOrder with items: " + order);

    outBuilder.append("\n\n--- Items ---");
    outBuilder.append("\n" + order.getShoppingCart().getItems());

    outBuilder.append("\n\n--- Total Order ---");

    final Long totalValueItems = order.getShoppingCart().getItems().stream()
        .mapToLong(Item::getValue)
        .sum();

    outBuilder.append("\n" + totalValueItems);

    outBuilder.append("\n\n--- Is Valid Shopping Cart? ---");
    outBuilder.append("\n" + order.getShoppingCart().isValid());

    outBuilder.append("\n\n--- Order Status ---");
    outBuilder.append("\n" + order.getStatus());

    outBuilder.append("\n\n--- Order Status confirmed ---");
    outBuilder.append("\n" + order.confirm());
    outBuilder.append("\n" + order.getStatus());

    outBuilder.append("\n\n--- Email ---");
    final Status orderStatus = order.getStatus();

    if (orderStatus == Status.CONFIRMED) {
      outBuilder.append("\n" + EmailService.send());
    }

    outBuilder.append("\n" + orderStatus);

    final String out = outBuilder.toString();
    exchange.sendResponseHeaders(200, out.length());

    final OutputStream output = exchange.getResponseBody();
    output.write(out.getBytes(StandardCharsets.ISO_8859_1));

  }
}
