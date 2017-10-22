package pl.sda.wwa5.lab11.points;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMinDistance;

import java.util.*;

public class DistanceFinderTest {

    @Test (expected = DistanceFinderException.class)
    public void findNearestTestEmptySurface() throws Exception,DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
    }

    @Test
    public void findNearestTestEmptySurface2() throws Exception,DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        boolean exceptionOccured = false;
        try {
            Collection<Point> nearest = df.findNearest(surface);
            Assert.fail("Nie wykonuje się ten blok kodu");
        } catch (DistanceFinderException e) {
            exceptionOccured=true;
        }
        Assert.assertTrue(exceptionOccured);
    }

    @Test
    public void findNearest() throws Exception,DistanceFinderException {

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
    public void findNearestWithThousandsElements() throws Exception,DistanceFinderException {

        Set<Point> surface = new HashSet<>();

        int howManyPoints=10000;
        Random random = new Random();

        for (int i=0;i<howManyPoints;i++) {
            surface.add(new Point(100 + (random.nextInt(1000) * 10),
                    100 + (random.nextInt(1000) * 10)));
        }
        Point testPoint1 = new Point(0,0);
        Point testPoint2 = new Point(1,1);
        surface.add(testPoint1);
        surface.add(testPoint2);

        DistanceFinder df = new DistanceFinder();

//        long nonOptimizedTimeStart = new Date().getTime(); //time start

        Collection<Point> nearest = df.finderMoreGeneric(surface,new FindMinDistance());

//        long nonOptimizedTimeStop = new Date().getTime(); //time stop

//        double nonOptimizedSearchingTime = (nonOptimizedTimeStop-nonOptimizedTimeStart)/1000;
//        System.out.println("Wyszukiwanie bez optymalizacji zajęło "+ nonOptimizedSearchingTime +" sekund");

        Assert.assertTrue(nearest.contains(testPoint1));
        Assert.assertTrue(nearest.contains(testPoint2));
        Assert.assertEquals(nearest.size(),2);
    }

    @Test
    public void findFarthest() throws DistanceFinderException {
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