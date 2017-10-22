package pl.sda.wwa5.lab11.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LifoTest {
    @Test
    public void testPush() throws Exception {
        Lifo lifo = new Lifo();
        Assert.assertEquals(lifo.size(),0);
        lifo.push(1);
        Assert.assertEquals(lifo.size(),1);
        Assert.assertTrue(lifo.contains(1));
    }

    @Test
    public void testPop() throws Exception {
        Lifo lifo = new Lifo();
        lifo.push(1);
        Object o = lifo.pop();
        Assert.assertTrue(lifo.size() == 0);
        Assert.assertFalse(lifo.contains(1));
        Assert.assertTrue(o.equals(1));
    }

    @Test
    public void testOrder() throws Exception {
        Lifo lifo = new Lifo();
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);

        Assert.assertEquals(3,lifo.pop());
        Assert.assertEquals(2,lifo.pop());
        Assert.assertEquals(1,lifo.pop());
    }

    @Test
    public void testPopEmpty() throws Exception {
        Lifo lifo = new Lifo();

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