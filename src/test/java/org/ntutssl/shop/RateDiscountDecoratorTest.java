package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RateDiscountDecoratorTest {
    @Test
    public void test_decorate_complex_collection(){
        Collection collection = new Collection(1, "collection", "good");
        Merchandise merchandise = new Merchandise(2, "merchandise", "script", 1.4);
        Collection collection2 = new Collection(3, "collection2", "good");
        collection.add(merchandise);
        collection2.add(merchandise);
        collection.add(collection2);
        RateDiscountDecorator discount = new RateDiscountDecorator(collection,0.5);
        assertEquals(discount.id(),1);
        assertEquals(discount.price(), 0.7, 2);
        assertEquals(discount.description(),"c");
        assertEquals(discount.name(),"collection");
    }

    @Test (expected = ShopException.class)
    public void test_decorate_complex_collection_exception_rate_greater_than_1(){
        Collection collection = new Collection(1, "collection", "c");
        Merchandise merchandise = new Merchandise(2, "merchandise", "m", 2.5);
        collection.add(merchandise);
        RateDiscountDecorator discount = new RateDiscountDecorator(collection,1.0);
    }
 }
