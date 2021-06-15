package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class GoodsBuilderTest {
    @Test
    public void test_build_complex_collection(){
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.startBuildCollection(1, "collection", "c");
        goodsBuilder.buildMerchandise(2, "merchandise", "m", 1.4);
        goodsBuilder.startBuildCollection(3, "collection2", "c");
        goodsBuilder.buildMerchandise(2, "merchandise", "m", 1.4);
        goodsBuilder.endBuildCollection();
        goodsBuilder.endBuildCollection();
        Collection collection = (Collection)goodsBuilder.getResult();
        Iterator<Goods> it = collection.iterator();
        Merchandise merchandise = (Merchandise) it.next();
        Collection collection2 = (Collection) it.next();
        it = collection2.iterator();
        Merchandise merchandise2 = (Merchandise) it.next();
        assertEquals(collection.name(), "collection");
        assertEquals(merchandise.name(), "merchandise");
        assertEquals(collection2.name(), "collection2");
        assertEquals(merchandise2.name(), "merchandise");
        assertEquals(merchandise2.description(), "m");
        assertEquals(merchandise2.price(), 1.4, 2);
    }

    @Test
    public void test_build_merchandise(){
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.buildMerchandise(2, "merchandise", "m", 1.4);
        Merchandise merchandise = (Merchandise)goodsBuilder.getResult();
        assertEquals(merchandise.getClass(), Merchandise.class);
        assertEquals(merchandise.id(), 2);
        assertEquals(merchandise.name(), "merchandise");
        assertEquals(merchandise.description(), "m");
        assertEquals(merchandise.price(), 1.4, 2);
    }

    @Test
    public void test_build_collection(){
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.startBuildCollection(1, "collection", "c");
        goodsBuilder.endBuildCollection();
        Collection collection = (Collection)goodsBuilder.getResult();
        assertEquals(collection.getClass(), Collection.class);
        assertEquals(collection.id(), 1);
        assertEquals(collection.name(), "collection");
        assertEquals(collection.description(), "c");
        assertEquals(collection.price(), 0.0, 2);
    }
 }
