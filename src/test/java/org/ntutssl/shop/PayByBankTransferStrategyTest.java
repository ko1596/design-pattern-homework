package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PayByBankTransferStrategyTest implements EventListener{

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
        String input = "aaaa";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(inputBytes);
        InputStream originIn = System.in;
        System.setOut(printStream);
        System.setIn(stream);
        EventManager em = EventManager.getInstance();
        PayByBankTransferStrategy bank = new PayByBankTransferStrategy();
        em.subscribe(EventType.PRINT_RECEIPT, this);
        StringEvent event = new StringEvent(EventType.CALCULATE,"100.00");
        em.publish(event);
        assertEquals(this.printReceiptEvent,null);
        assertEquals("Enter the bank code: Enter the account number: Pay failed.\n",outStream.toString());
        stream.reset();
        outStream.reset();
        System.setIn(originIn);
        System.setOut(originalOut);
        em.reset();
    }

    @Test
    public void test_calculate_should_return_correct_price(){
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outStream);
        PrintStream originalOut = System.out;
        String input = "123\n123456123456\n";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(inputBytes);
        InputStream originIn = System.in;
        System.setOut(printStream);
        System.setIn(stream);
        EventManager em = EventManager.getInstance();
        PayByBankTransferStrategy bank = new PayByBankTransferStrategy();
        em.subscribe(EventType.PRINT_RECEIPT, this);
        StringEvent event = new StringEvent(EventType.CALCULATE,"100.00");
        em.publish(event);
        assertEquals(this.printReceiptEvent,"$100.49");
        assertEquals("Enter the bank code: Enter the account number: Pay successfully!\n",outStream.toString());
        stream.reset();
        System.setIn(originIn);
        System.setOut(originalOut);
        System.out.print(outStream.toString());
        outStream.reset();
        em.reset();
    }
 }
