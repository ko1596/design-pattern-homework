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
    public void test_build_collection() {
        GoodsBuilder goodsBuilder = new GoodsBuilder();
        goodsBuilder.startBuildCollection(1, "collection", "test");
        goodsBuilder.endBuildCollection();
        assertEquals(1, goodsBuilder.getResult().id());
        assertEquals("collection", goodsBuilder.getResult().name());
        assertEquals("test", goodsBuilder.getResult().description());
    }

}