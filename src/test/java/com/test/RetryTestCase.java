package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTestCase {

    @Test()
    public void test1(){
        Assert.assertEquals("a", "1");
    }

    @Test()
    public void test2(){
        Assert.assertEquals("a", "1");
    }
}
