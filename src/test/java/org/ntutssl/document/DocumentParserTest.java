package org.ntutssl.document;

import static org.junit.Assert.*;

import org.junit.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DocumentParserTest {

    @Test
    public void test_parse_paragraph(){
        JsonObject jObj = JsonParser.parseString("{\"type\": \"paragraph\",\"text\": \"Paragraph\"}").getAsJsonObject();
        DocumentParser dParser = new DocumentParser();
        Document document= dParser.parse(jObj);
        assertEquals(document.getClass(),Paragraph.class);
        assertEquals(document.getText(),"Paragraph");
    }

    @Test
    public void test_parse_title(){
        JsonObject jObj = JsonParser.parseString("{\"type\": \"title\",\"text\": \"Title\", \"size\": 1}").getAsJsonObject();
        DocumentParser dParser = new DocumentParser();
        Document document= dParser.parse(jObj);
        assertEquals(document.getClass(),Title.class);
        assertEquals(document.getText(),"Title");
        assertEquals(document.getSize(),1);
    }

    @Test
    public void test_parse_article_having_contents(){
        JsonObject jObj = JsonParser.parseString("{\"type\": \"article\",\"text\": \"Article\",\"level\": 0,\"contents\": [{\"type\": \"title\",\"text\": \"Title\",\"size\": 2}]}").getAsJsonObject();
        DocumentParser dParser = new DocumentParser();
        Document document= dParser.parse(jObj);
        assertEquals(document.getClass(),Article.class);
        assertEquals(document.getText(),"Article");
        assertEquals(document.getLevel(),0);
        assertEquals(document.iterator().next().getClass(),Title.class);
        assertEquals(document.iterator().next().getText(),"Title");
        assertEquals(document.iterator().next().getSize(),2);
    }

    @Test
    public void test_parse_only_article(){
        JsonObject jObj = JsonParser.parseString("{\"type\": \"article\",\"text\": \"Article\",\"level\": 0,\"contents\": []}").getAsJsonObject();
        DocumentParser dParser = new DocumentParser();
        Document document= dParser.parse(jObj);
        assertEquals(document.getClass(),Article.class);
        assertEquals(document.getText(),"Article");
        assertEquals(document.getLevel(),0);
    }
 }