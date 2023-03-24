package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test
    public void WordCount () {
        WordCount wordCount = new WordCount();
        Map<String, Integer> wordMap = wordCount.getCount(new String[]{"ba", "ba", "black", "sheep"});
        Map<String, Integer> nullMap = wordCount.getCount(null);
        int ba = wordMap.get("ba");
        int black = wordMap.get("black");
        int sheep = wordMap.get("sheep");
        //System.out.println(wordMap.get("ba"));

        Assert.assertEquals(2, ba);
        Assert.assertEquals(1, black);
        Assert.assertEquals(1, sheep);
        Assert.assertEquals(true, nullMap.isEmpty());

    }
}