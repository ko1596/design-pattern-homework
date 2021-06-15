package org.ntutssl.shop;

import java.util.Scanner;

public class InstructionHandler {
  private Scanner scanner;

  public InstructionHandler() {
    this.scanner = new Scanner(System.in);
   }
  
  public void run() {
    String instruction="";
    while(!instruction.equals("5")){
			printInstructions();
			instruction = this.scanner.nextLine();
			handleInstruction(instruction);
		}
   }

  private void printInstructions() {
    System.out.print("Please enter the following instruction(number) to start shopping:\n");
		System.out.print("  1. to list all the goods that the shop has\n");
		System.out.print("  2. to import your shopping list into the shopping cart\n");
		System.out.print("  3. to check the content of your shopping cart\n");
		System.out.print("  4. to go to pay\n");
		System.out.print("  5. to exit the program\n");
   }

  private void handleInstruction(String instruction) {
    try{
			switch(instruction){
				case "1":
					instructionListShop();
          break;
				case "2":
          instructionImportShoppingList();
          System.out.print("import successfully\n");
					break;
				case "3":
					instructionListShoppingCart();
					break;
				case "4":
          instructionPay();
					break;
				case "5":
					break;
        default:
					System.out.println("Invalid Instruction");
					break;

			}
	    }catch(ShopException e){
			System.out.println(e.getMessage());
		}
   }

  private void instructionListShop() {
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_SHOP, ""));
   }

  private void instructionImportShoppingList() {
    System.out.print("Please input the file path: ");
    String path = this.scanner.nextLine();
		EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_SHOPPING_LIST, path));
   }

  private void instructionListShoppingCart() {
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_CART, ""));
   }

   private void instructionPay() {
    System.out.print("Please, select a payment method by number:\n");
    System.out.print("  1. Bank Transfer\n");
    System.out.print("  2. Credit Card\n");
    String instruction = this.scanner.nextLine();
    handlePayInstruction(instruction);
  }

  private void handlePayInstruction(String instruction) {
    try{
			switch(instruction){
				case "1":
          instructionPayByBank();
          break;
				case "2":
          instructionPayByCreditCard();
					break;
        default:
					System.out.println("Invalid Instruction");
					break;
			}
	    }catch(ShopException e){
			System.out.println(e.getMessage());
		}
  }

  private void instructionPayByBank() {
    PayByBankTransferStrategy bankPay = new PayByBankTransferStrategy();
    EventManager.getInstance().publish(new StringEvent(EventType.PAY,""));
  }

  private void instructionPayByCreditCard() {
    PayByCreditCardStrategy creditCardPay = new PayByCreditCardStrategy();
    EventManager.getInstance().publish(new StringEvent(EventType.PAY, ""));
  }
}
