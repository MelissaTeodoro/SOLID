package src.solid.principles.pages.root;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import src.solid.principles.srp.entity.ShoppingCart;

public class Root implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    final StringBuilder outBuilder = new StringBuilder();
    final ShoppingCart shoppingCart = new ShoppingCart();

    shoppingCart.addItem("Tênis Feminino", 200L);
    shoppingCart.addItem("Boné Feminino", 90L);

    outBuilder.append("items: " + shoppingCart.getItems().toString());
    outBuilder.append("\nTotal: " + shoppingCart.getTotal());
    outBuilder.append("\nStatus: " + shoppingCart.getCartStatus());
    outBuilder.append("\nConfirm order: " + shoppingCart.confirmOrder());
    outBuilder.append("\nStatus: " + shoppingCart.getCartStatus());

    if(shoppingCart.confirmOrder()) {
      outBuilder.append("\nSuccessfully confirm order!");
    } else {
      outBuilder.append("\nCart has no items!");
    }

    final String out = outBuilder.toString();
    exchange.sendResponseHeaders(200, out.length());

    final OutputStream output = exchange.getResponseBody();
    output.write(out.getBytes(StandardCharsets.ISO_8859_1));
  }
}
