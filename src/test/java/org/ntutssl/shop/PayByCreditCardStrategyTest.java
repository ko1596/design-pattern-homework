package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PayByCreditCardStrategyTest implements EventListener{
    private String printReceiptEvent=null;

    public void onEvent(Event event) {
        if(event.type() == EventType.PRINT_RECEIPT)
            this.printReceiptEvent = (String)event.data();
    }

    @Test
    public void test_calculate_should_not_publish_with_incorrect_inputs(){
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outStream);
        PrintStream originalOut = System.out;
        String input = "1234567812345678\n04/25\n321\n";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(inputBytes);
        InputStream originIn = System.in;
        System.setOut(printStream);
        System.setIn(stream);
        EventManager em = EventManager.getInstance();
        PayByCreditCardStrategy creditCardPay = new PayByCreditCardStrategy();
        em.subscribe(EventType.PRINT_RECEIPT, this);
        StringEvent event = new StringEvent(EventType.CALCULATE,"20.00");
        em.publish(event);
        assertEquals(this.printReceiptEvent,"$18.00");
        assertEquals("Enter the card number: Enter the card expiration date 'mm/yy': Enter the CVV code: Pay successfully!\n",outStream.toString());
        stream.reset();
        outStream.reset();
        System.setIn(originIn);
        System.setOut(originalOut);
        em.reset();
    }
 }
