package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShopTest implements EventListener{
    private int addToCartCount=0;

    public void onEvent(Event event) {
        if(event.type() == EventType.ADD_TO_CART)
            this.addToCartCount +=1;
    }

    @Test
    public void test_check_stock_event_with_existent_goods(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        EventManager em = EventManager.getInstance();
        Shop shop = new Shop();
        em.subscribe(EventType.ADD_TO_CART, this);
        Collection collection = new Collection(1, "collection", "c");
        Merchandise merchandise = new Merchandise(2, "merchandise", "m", 1.4);
        Collection collection2 = new Collection(3, "collection2", "c");
        GoodsEvent goodsEvent = new GoodsEvent(EventType.REPLENISH,collection,1);
        GoodsEvent goodsEvent2 = new GoodsEvent(EventType.REPLENISH,merchandise,1);
        GoodsEvent goodsEvent3 = new GoodsEvent(EventType.REPLENISH,collection2,1);
        StringEvent stringEvent = new StringEvent(EventType.LIST_SHOP,"");
        em.publish(goodsEvent);
        em.publish(goodsEvent2);
        em.publish(goodsEvent3);
        em.publish(stringEvent);
        String line1 = "================================================================================\n";
        String line2 = String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
        String line3 = "--------------------------------------------------------------------------------\n";
        String line4 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 1 ,"collection", "c", 0.0, 1);
        String line5 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 2 ,"merchandise", "m", 1.4, 1);
        String line6 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 3 ,"collection2", "c", 0.0, 1);
        String line7 = "================================================================================\n";
        assertEquals(line1+line2+line3+line4+line5+line6+line7,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_check_stock_event_with_non_existent_goods(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        EventManager em = EventManager.getInstance();
        Shop shop = new Shop();
        em.subscribe(EventType.ADD_TO_CART, this);
        Merchandise merchandise = new Merchandise(1, "merchandise", "m", 1.4);
        GoodsEvent event = new GoodsEvent(EventType.CHECK_STOCK,merchandise,1);
        em.publish(event);
        assertEquals("The store doesn't have this goods.\n",stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_list_empty_shop(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        Shop shop = new Shop();
        EventManager em = EventManager.getInstance();
        StringEvent stringEvent = new StringEvent(EventType.LIST_SHOP,"");
        em.publish(stringEvent);
        String line1 = "This shop does not sell anything.\n";
        assertEquals(line1,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }

    @Test
    public void test_purchase_event_with_existent_goods(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        EventManager em = EventManager.getInstance();
        Shop shop = new Shop();
        em.subscribe(EventType.ADD_TO_CART, this);
        Merchandise merchandise = new Merchandise(1, "merchandise", "m", 1.4);
        GoodsEvent event = new GoodsEvent(EventType.REPLENISH,merchandise,2);
        GoodsEvent event2 = new GoodsEvent(EventType.PURCHASE,merchandise,1);
        StringEvent stringEvent = new StringEvent(EventType.LIST_SHOP,"");
        em.publish(event);
        em.publish(event2);
        em.publish(stringEvent);
        String line1 = "================================================================================\n";
        String line2 = String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
        String line3 = "--------------------------------------------------------------------------------\n";
        String line4 = String.format("%-4s%-22s%-40s%-8s%-6s\n", 1 ,"merchandise", "m", 1.4, 1);
        String line5 = "================================================================================\n";
        assertEquals(line1+line2+line3+line4+line5,stream.toString());
        System.setOut(originalOut);
        stream.reset();
        em.reset();
    }
 }
