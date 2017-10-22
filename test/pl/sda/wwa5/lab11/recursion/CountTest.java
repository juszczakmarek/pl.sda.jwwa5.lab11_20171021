package pl.sda.wwa5.lab11.recursion;

import org.junit.Assert;
import org.junit.Test;

public class CountTest {
    @Test
    public void countStrong() throws Exception {
        Count count = new Count(10);
        Assert.assertEquals(3628800.0,count.countStrong(count.getCountUntil()),0.000000001);
        Assert.assertEquals(1,count.countStrong(0),0.0);
        Assert.assertEquals(1,count.countStrong(1),0.0);
    }

    @Test
    public void countStrongWithRecursion() throws Exception {
        Count count = new Count(10);
        Assert.assertEquals(3628800.0,count.countStrong(count.getCountUntil()),0.000000001);
        Assert.assertEquals(1,count.countStrong(0),0.0);
        Assert.assertEquals(1,count.countStrong(1),0.0);
    }

    @Test
    public void fib() throws Exception {
        Count count = new Count(10);
        Assert.assertEquals(55,count.fib(count.getCountUntil()));
        Assert.assertEquals(0,count.fib(0));
        Assert.assertEquals(1,count.fib(1));
        Assert.assertEquals(1,count.fib(2));
    }

    @Test
    public void fibWithRecursion() throws Exception {
        Count count = new Count(10);
        Assert.assertEquals(55,count.fibWithRecursion(count.getCountUntil()));
        Assert.assertEquals(0,count.fib(0));
        Assert.assertEquals(1,count.fib(1));
        Assert.assertEquals(1,count.fib(2));
    }

}