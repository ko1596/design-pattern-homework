package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FixedDiscountDecoratorTest {
    @Test 
    public void test_decorate_complex_collection(){
        Collection collection = new Collection(1, "collection", "aa");
        Collection collection2 = new Collection(2, "collection2", "bb");
        Merchandise merchandise = new Merchandise(3, "merchandise", "cc", 1.4);        
        collection.add(merchandise);
        collection2.add(merchandise);
        collection.add(collection2);
        FixedDiscountDecorator discount = new FixedDiscountDecorator(collection,0.5);
        assertEquals(discount.id(),1);
        assertEquals(discount.price(), 2.3, 2);
        assertEquals(discount.description(),"aa");
        assertEquals(discount.name(),"collection");
    }

    @Test (expected = ShopException.class)
    public void test_decorate_complex_collection_exception(){
        Collection collection = new Collection(1, "collection", "c");
        Merchandise merchandise = new Merchandise(2, "merchandise", "m", 1.4);
        Collection collection2 = new Collection(3, "collection2", "c");
        collection.add(merchandise);
        collection2.add(merchandise);
        collection.add(collection2);
        FixedDiscountDecorator discount = new FixedDiscountDecorator(collection,3.0);
    }

    @Test 
    public void test_decorate_empty_collection(){
        Collection collection = new Collection(1, "collection", "c");
        FixedDiscountDecorator discount = new FixedDiscountDecorator(collection,0);
        assertEquals(discount.id(),1);
        assertEquals(discount.price(), 0, 2);
        assertEquals(discount.description(),"c");
        assertEquals(discount.name(),"collection");
    }

    @Test (expected = ShopException.class)
    public void test_decorate_empty_collection_exception(){
        Collection collection = new Collection(1, "collection", "c");
        FixedDiscountDecorator discount = new FixedDiscountDecorator(collection,1.0);
    }

    @Test
    public void test_decorate_single_merchandise(){
        Merchandise merchandise = new Merchandise(1, "merchandise", "m",1.0);
        FixedDiscountDecorator discount = new FixedDiscountDecorator(merchandise,0.1);
        assertEquals(discount.id(),1);
        assertEquals(discount.price(), 0.9, 2);
        assertEquals(discount.description(),"m");
        assertEquals(discount.name(),"merchandise");
    }

    @Test (expected = ShopException.class)
    public void test_decorate_single_merchandise_exception(){
        Merchandise merchandise = new Merchandise(1, "merchandise", "m",1.0);
        FixedDiscountDecorator discount = new FixedDiscountDecorator(merchandise,1.1);
    }
 }
