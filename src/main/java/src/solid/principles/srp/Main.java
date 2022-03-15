package src.solid.principles.srp;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.solid.principles.srp.with.pages.root.Root;

public class Main {

  public static void main(String[] args) {
    try {
      System.out.println("Creating server...");

      final int port = 8080;
      HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
      server.createContext("/", new Root());
      server.start();

      System.out.println("Server started on port: " + port);
    } catch (IOException e) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
    }
  }

}
