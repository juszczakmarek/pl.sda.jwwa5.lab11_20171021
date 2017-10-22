package pl.sda.wwa5.lab11.queue;

import org.junit.Assert;
import org.junit.Test;

public class LifoArrayTest {

    @Test
    public void testPushArrayList() throws Exception {
        Lifo lifo = new LifoArrayList();
        Assert.assertEquals(lifo.size(),0);
        lifo.push(1);
        Assert.assertEquals(lifo.size(),1);
        Assert.assertTrue(lifo.contains(1));
    }

    @Test
    public void testPopArrayList() throws Exception {
        Lifo lifo = new LifoArrayList();
        lifo.push(1);
        Object o = lifo.pop();
        Assert.assertTrue(lifo.size() == 0);
        Assert.assertFalse(lifo.contains(1));
        Assert.assertTrue(o.equals(1));
    }

    @Test
    public void testOrderArrayList() throws Exception {
        Lifo lifo = new LifoArrayList();
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);

        Assert.assertEquals(3,lifo.pop());
        Assert.assertEquals(2,lifo.pop());
        Assert.assertEquals(1,lifo.pop());
    }

    @Test
    public void testOrderIntegerArrayList() throws Exception {
        Lifo<Integer> lifo = new LifoArrayList();
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);

        Assert.assertEquals(3,lifo.pop().intValue());
        Assert.assertEquals(2,lifo.pop().intValue());
        Assert.assertEquals(1,lifo.pop().intValue());
    }

    @Test
    public void testPopEmptyArrayList() throws Exception {
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
