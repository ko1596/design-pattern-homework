package org.ntutssl.shop;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayByCreditCardStrategy implements PayStrategy, EventListener {

  private Scanner input;
  private String cardNumber;
  private String expirationDate;
  private String CVVCode;
  
  public PayByCreditCardStrategy() {
    this.CVVCode = null;
    this.expirationDate = null;
    this.cardNumber = null;
    EventManager.getInstance().subscribe(EventType.CALCULATE, this);
   }

  public void onEvent(Event event) {
    calculate(Double.parseDouble((String)event.data()));
   }

  /**
   * Card number are 16 digits.
   * The format of card expiration date is 'mm/yy', such as '06/21'.
   * CVV code are 3 digits.
   */
  @Override
  public void calculate(double totalPrice) {
    input = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("###.00");
    Pattern cardNumberPattern = Pattern.compile("[0-9]{16}");
    Pattern datePattern = Pattern.compile("(0[1-9]|1[012])/(0[1-9]|[1-9][0-9])");
    Pattern CVVPattern = Pattern.compile("[0-9]{3}");
    String string = "$"+decimalFormat.format(totalPrice*0.9);

    System.out.print("Enter the card number: ");
    if(input.hasNext(cardNumberPattern)) this.cardNumber = input.next(cardNumberPattern);
    
    System.out.print("Enter the card expiration date 'mm/yy': ");
    if(input.hasNext(datePattern)) this.expirationDate = input.next(datePattern);

    System.out.print("Enter the CVV code: ");
    if(input.hasNext(CVVPattern)) this.CVVCode = input.next(CVVPattern);

    if(this.cardNumber!=null && this.expirationDate!=null && this.CVVCode!=null){
      EventManager.getInstance().publish(new StringEvent(EventType.PRINT_RECEIPT,string));
      System.out.print("Pay successfully!\n");
    }
    else {
      System.out.print("Pay failed.\n");
    }
   }
}
