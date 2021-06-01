package org.ntutssl.shop;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;


public class GoodsBuilderTest { 
    @Test
    public void test_build_merchandise() {
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.buildMerchandise(1, "merchandise", "test", 1.0);
        assertEquals(1, goodsBuilder.getResult().id());
        assertEquals("merchandise", goodsBuilder.getResult().name());
        assertEquals("test", goodsBuilder.getResult().description());
        assertEquals(1, goodsBuilder.getResult().price(), 1);
        
    }


    @Test
    public void test_build_collection_contains_merchandises() {
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.buildMerchandise(1, "merchandise", "test", 1.0);
        goodsBuilder.startBuildCollection(1, "collection", "test");
        goodsBuilder.endBuildCollection();
        Iterator<Goods> ite = goodsBuilder.getResult().iterator();
        assertEquals(1, goodsBuilder.getResult().id());
        assertEquals("collection", goodsBuilder.getResult().name());
        assertEquals("test", goodsBuilder.getResult().description());
        Goods goods = ite.next();
        assertEquals(1, goods.id());
        assertEquals("merchandise", goods.name());
        assertEquals("test", goods.description());
        assertEquals(1, goods.price(), 1);
    }

    @Test
    public void test_build_collection() {
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.startBuildCollection(1, "collection", "test");
        goodsBuilder.endBuildCollection();
        assertEquals(1, goodsBuilder.getResult().id());
        assertEquals("collection", goodsBuilder.getResult().name());
        assertEquals("test", goodsBuilder.getResult().description());
    }

}