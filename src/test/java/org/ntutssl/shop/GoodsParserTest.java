package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GoodsParserTest implements EventListener{
    private int checkStockEvent=0;
    private int importReplenishListEvent=0;
    private int importShoppingListEvent=0;
    private int replenishEvent=0;
    private int sortCartEvent=0;
    private int sortShopEvent=0;

    public void onEvent(Event event) {
        if(event.type() == EventType.CHECK_STOCK)
            this.checkStockEvent +=1;
        if(event.type() == EventType.IMPORT_REPLENISH_LIST)
            this.importReplenishListEvent +=1;
        if(event.type() == EventType.IMPORT_SHOPPING_LIST)
            this.importShoppingListEvent +=1;
        if(event.type() == EventType.REPLENISH)
            this.replenishEvent +=1;
        if(event.type() == EventType.SORT_CART)
            this.sortCartEvent +=1;
        if(event.type() == EventType.SORT_SHOP)
            this.sortShopEvent +=1;
    }

    @Test
    public void test_import_replenishment_list_should_publish_replenish_event(){
        EventManager em = EventManager.getInstance();
        GoodsParser gp = new GoodsParser();
        em.subscribe(EventType.IMPORT_REPLENISH_LIST, this);
        em.subscribe(EventType.SORT_SHOP, this);
        em.publish(new StringEvent(EventType.IMPORT_REPLENISH_LIST,"input/replenish_list.json"));
        assertEquals(this.importReplenishListEvent,1);
        em.reset();
    }

    @Test
    public void test_import_shopping_list_should_publish_check_stock_event(){
        EventManager em = EventManager.getInstance();
        GoodsParser gp = new GoodsParser();
        em.subscribe(EventType.IMPORT_SHOPPING_LIST, this);
        em.subscribe(EventType.CHECK_STOCK, this);
        em.publish(new StringEvent(EventType.IMPORT_SHOPPING_LIST,"input/shopping_list.json"));
        assertEquals(this.importShoppingListEvent,1);
        assertEquals(this.checkStockEvent,0);
        em.reset();
    }
 }
