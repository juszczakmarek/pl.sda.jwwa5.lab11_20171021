package pl.sda.wwa5.lab11.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LifoLinkedTest {
    @Test
    public void testPushLinkedList() throws Exception {
        Lifo lifo = new LifoLinkedList();
        Assert.assertEquals(lifo.size(),0);
        lifo.push(1);
        Assert.assertEquals(lifo.size(),1);
        Assert.assertTrue(lifo.contains(1));
    }

    @Test
    public void testPopLinkedList() throws Exception {
        Lifo lifo = new LifoLinkedList();
        lifo.push(1);
        Object o = lifo.pop();
        Assert.assertTrue(lifo.size() == 0);
        Assert.assertFalse(lifo.contains(1));
        Assert.assertTrue(o.equals(1));
    }

    @Test
    public void testOrderLinkedList() throws Exception {
        Lifo lifo = new LifoLinkedList();
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);

        Assert.assertEquals(3,lifo.pop());
        Assert.assertEquals(2,lifo.pop());
        Assert.assertEquals(1,lifo.pop());
    }

    @Test
    public void testOrderIntegerLinkedList() throws Exception {
        Lifo<Integer> lifo = new LifoLinkedList();
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);

        Assert.assertEquals(3,lifo.pop().intValue());
        Assert.assertEquals(2,lifo.pop().intValue());
        Assert.assertEquals(1,lifo.pop().intValue());
    }

    @Test
    public void testPopEmptyLinkedList() throws Exception {
        Lifo lifo = new LifoLinkedList();

        boolean thrown=false;
        try {
            lifo.pop();
            Assert.fail("Should throw exception");
        } catch (IllegalStateException e) {
            thrown=true;
        }
        Assert.assertTrue(thrown);
    }

}