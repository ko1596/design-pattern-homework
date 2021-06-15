package org.ntutssl.shop;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayByBankTransferStrategy implements PayStrategy, EventListener {
  private Scanner input;
  private String accountNumber;
  private String bankCode;

  public PayByBankTransferStrategy() {
    this.bankCode = null;
    this.accountNumber =null;
    EventManager.getInstance().subscribe(EventType.CALCULATE, this);
   }

  public void onEvent(Event event) {
    calculate(Double.parseDouble((String)event.data()));
   }

  /**
   * Bank code are 3 digits.
   * Account number are 12 digits.
   */
  @Override
  public void calculate(double totalPrice) {
    this.input = new Scanner(System.in);
    DecimalFormat decimalFormat = new DecimalFormat("##0.0#");
    Pattern accountPattern = Pattern.compile("[0-9]{12}");
    Pattern codePattern = Pattern.compile("[0-9]{3}");
    String string = "$" + decimalFormat.format(totalPrice + 0.49);

    System.out.print("Enter the bank code: ");
    if(input.hasNext(codePattern)) this.bankCode = input.next(codePattern);

    System.out.print("Enter the account number: ");
    if(input.hasNext(accountPattern)) this.accountNumber = input.next(accountPattern);

    if(this.accountNumber!=null && this.bankCode != null){
      EventManager.getInstance().publish(new StringEvent(EventType.PRINT_RECEIPT,string));
      System.out.print("Pay successfully!\n");
    }else {
      System.out.print("Pay failed.\n");
    }
   }
}
