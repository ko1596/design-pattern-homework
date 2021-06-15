package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventTest {
    @Test
    public void test_good(){
        Collection collection = new Collection(1,"collection","good");
        GoodsEvent event = new GoodsEvent(EventType.ADD_TO_CART, collection, 1);
        assertEquals(event.type(),EventType.ADD_TO_CART);
        assertEquals(event.data(),collection);
        assertEquals(event.count(),1);
    }
    @Test 
    public void test_string(){
        StringEvent event = new StringEvent(EventType.ADD_TO_CART, "string");
        assertEquals(event.type(),EventType.ADD_TO_CART);
        assertEquals(event.data(),"string");
    }
 }
