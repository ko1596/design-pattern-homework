package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShoppingCartTest implements EventListener{
    private int payCount=0;
    private int purchaseCount=0;
    private int calculateCount=0;
    private int printReceiptCount=0;
    
    public void onEvent(Event event) {
        if(event.type() == EventType.PAY)
            this.payCount +=1;
        if(event.type() == EventType.CALCULATE)
            this.calculateCount +=1;
        if(event.type() == EventType.PRINT_RECEIPT)
            this.printReceiptCount +=1;
        if(event.type() == EventType.PURCHASE)
            this.purchaseCount +=1;
    }

    @Test
    public void test_list_empty_shopping_cart(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        ShoppingCart shoppingCart = new ShoppingCart();
        EventManager em = EventManager.getInstance();
        StringEvent stringEvent = new StringEvent(EventType.LIST_CART,"");
        em.publish(stringEvent);
        String line1 = "Your shopping cart is empty\n";
        assertEquals(line1,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_add_collection_and_list(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        ShoppingCart shoppingCart = new ShoppingCart();
        EventManager em = EventManager.getInstance();
        Collection collection = new Collection(1, "collection", "c");
        GoodsEvent goodsEvent = new GoodsEvent(EventType.ADD_TO_CART,collection,1);
        StringEvent stringEvent = new StringEvent(EventType.LIST_CART,"");
        em.publish(goodsEvent);
        em.publish(stringEvent);
        String line1 = "================================================================================\n";
        String line2 = String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
        String line3 = "--------------------------------------------------------------------------------\n";
        String line4 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 1, "collection", "c", 0.0, 1);
        String line5 = "================================================================================\n";
        String line6 = "================================================================================\n";
        assertEquals(line1+line2+line3+line4+line5,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_add_merchandise_and_list(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        ShoppingCart shoppingCart = new ShoppingCart();
        EventManager em = EventManager.getInstance();
        Merchandise merchandise = new Merchandise(2, "merchandise", "m", 1.4);
        GoodsEvent goodsEvent = new GoodsEvent(EventType.ADD_TO_CART,merchandise,1);
        StringEvent stringEvent = new StringEvent(EventType.PRINT_RECEIPT,"");
        em.subscribe(EventType.PRINT_RECEIPT, this);
        em.subscribe(EventType.PURCHASE, this);
        em.publish(goodsEvent);
        em.publish(stringEvent);
        assertEquals(this.printReceiptCount,1);
        assertEquals(this.purchaseCount,1);
        String line1 = "================================================================================\n";
        String line2 = "Receipt:\n";
        String line3 = String.format("%-40s%-10s%-10s\n", "name","price", "count");
        String line4 = String.format("%-40s%-10s%-10s\n", "merchandise","$"+"1.4", 1);
        String line5 = "--------------------------------------------------------------------------------\n";
        String line6 = "Total Price: \n";
        String line7 = "================================================================================\n";
        assertEquals(line1+line2+line3+line4+line5+line6+line7,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
        this.printReceiptCount=0;
        this.purchaseCount=0;
    }

    @Test
    public void test_add_collection_containing_merchandise_collection_and_list(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        ShoppingCart shoppingCart = new ShoppingCart();
        EventManager em = EventManager.getInstance();
        Collection collection = new Collection(1, "collection", "c");
        Merchandise merchandise = new Merchandise(2, "merchandise", "m", 1.4);
        Collection collection2 = new Collection(3, "collection2", "c");
        collection.add(merchandise);
        collection2.add(merchandise);
        collection.add(collection2);
        GoodsEvent goodsEvent = new GoodsEvent(EventType.ADD_TO_CART,collection,1);
        StringEvent stringEvent = new StringEvent(EventType.LIST_CART,"");
        em.publish(goodsEvent);
        em.publish(stringEvent);
        String line1 = "================================================================================\n";
        String line2 = String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
        String line3 = "--------------------------------------------------------------------------------\n";
        String line4 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 1, "collection", "c", 2.80, 1);
        String line5 = "================================================================================\n";
        assertEquals(line1+line2+line3+line4+line5,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_pay_should_publish_calculate_event(){
        ShoppingCart shoppingCart = new ShoppingCart();
        EventManager em = EventManager.getInstance();
        StringEvent stringEvent = new StringEvent(EventType.PAY,"");
        em.subscribe(EventType.PAY, this);
        em.subscribe(EventType.CALCULATE, this);
        em.publish(stringEvent);
        assertEquals(this.calculateCount,1);
        assertEquals(this.payCount,1);
        em.reset();
        this.payCount=0;
        this.calculateCount=0;
    }

 }
