package src.solid.principles.srp.with.service;

public class EmailService {

  private String from;
  private String to;
  private String subject;
  private String content;

  public EmailService() {
    this.from = "contact@site.com";
    this.to = "";
    this.subject = "";
    this.content = "";
  }

  public static String send() {
    return "--- Send email ---";
  }
}
