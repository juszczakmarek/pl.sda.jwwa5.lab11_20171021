package pl.sda.wwa5.lab11.points;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DistanceFinderTest {
    @Test
    public void findNearest() throws Exception {
        Set<Point> surface = new HashSet<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(0,5);


        surface.add(p1);
        surface.add(p2);
        surface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);

        Assert.assertTrue(nearest.contains(p1));
        Assert.assertTrue(nearest.contains(p2));
        Assert.assertFalse(nearest.contains(p3));
    }

    @Test
    public void findFarthest() throws Exception {
        Set<Point> surface = new HashSet<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(0,5);


        surface.add(p1);
        surface.add(p2);
        surface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findFarthest(surface);

        Assert.assertTrue(nearest.contains(p1));
        Assert.assertFalse(nearest.contains(p2));
        Assert.assertTrue(nearest.contains(p3));
    }



}