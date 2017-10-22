package pl.sda.wwa5.lab11.points;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
        long createStartTimeStamp = new Date().getTime(); //time start
        for (int i=0;i<howManyPoints;i++) {
            int randomX = (int) Math.random()*100;
            int randomY = (int) Math.random()*100;
            surface.add(new Point(randomX,randomY));
        }
        long createFinishTimeStamp = new Date().getTime(); //time stop

        DistanceFinder df = new DistanceFinder();

        long nonOptimizedTimeStart = new Date().getTime(); //time start
        Collection<Point> nearestNonOptimized = df.findNearest(surface);
        long nonOptimizedTimeStop = new Date().getTime(); //time stop

        double nonOptimizedSearchingTime = (nonOptimizedTimeStop-nonOptimizedTimeStart)/1000;
        double creatingTime = (createFinishTimeStamp-createStartTimeStamp)/1000;
        System.out.println("Tworzenie zajęło "+ creatingTime +" sekund");
        System.out.println("Wyszukiwanie bez optymalizacji zajęło "+ nonOptimizedSearchingTime +" sekund");
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

    @Test
    public void findTestFarthest() throws DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        Collection<Point> farhest = df.findFarthest(surface);
    }
}