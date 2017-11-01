package pl.sda.wwa5.lab11.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.PortableInterceptor.DISCARDING;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMaxDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMinDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterPoint;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterSize1000;

import java.util.*;

public class DistanceFinderTest {

    private Set<Point> surface = new HashSet<>();
    private int howManyElements = 30000;

    @Before
    public void createSurfaceWithManyElements() {

        Set<Point> localSurface = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i< this.howManyElements; i ++){
            int randomX = 100 + (r.nextInt(1000) * 10);
            int randomY = 100 + (r.nextInt(1000) * 10);
            if (randomX==Integer.MAX_VALUE || randomY==Integer.MAX_VALUE) {
                --randomX;
                --randomY;
            }
            localSurface.add(new Point(randomX, randomY));
        }

        this.surface = localSurface;
    }


    @Test (expected = DistanceFinderException.class)
    public void findNearestTestEmptySurface() throws Exception,DistanceFinderException {
        Set<Point> localSurface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(localSurface);
    }

    @Test
    public void findNearestTestEmptySurface2() throws Exception,DistanceFinderException {
        Set<Point> localSurface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        boolean exceptionOccured = false;
        try {
            Collection<Point> nearest = df.findNearest(localSurface);
            Assert.fail("Nie wykonuje się ten blok kodu");
        } catch (DistanceFinderException e) {
            exceptionOccured=true;
        }
        Assert.assertTrue(exceptionOccured);
    }

    @Test
    public void findNearest() throws Exception,DistanceFinderException {

        Set<Point> localSurface = new HashSet<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(0,5);


        localSurface.add(p1);
        localSurface.add(p2);
        localSurface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(localSurface);

        Assert.assertTrue(nearest.contains(p1));
        Assert.assertTrue(nearest.contains(p2));
        Assert.assertFalse(nearest.contains(p3));

    }

    @Test
    public void findFarthest() throws DistanceFinderException {
        Set<Point> localSurface = new HashSet<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(0,5);


        localSurface.add(p1);
        localSurface.add(p2);
        localSurface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findFarthest(localSurface);

        Assert.assertTrue(nearest.contains(p1));
        Assert.assertFalse(nearest.contains(p2));
        Assert.assertTrue(nearest.contains(p3));
    }

    @Test
    public void clusterCreatorTest() throws DistanceFinderException {
        Set<Point> localSurface = new HashSet<>();

        DistanceFinder df = new DistanceFinder();
        ClusterSize1000 clusterSize = new ClusterSize1000();

        Point p1 = new Point(1,1);
        Point p2 = new Point(1 + clusterSize.getCluserSize(),1 + clusterSize.getCluserSize());
        Point p3 = new Point(1 + 2*clusterSize.getCluserSize(),1 + 2*clusterSize.getCluserSize());
        localSurface.add(p1);
        localSurface.add(p2);
        localSurface.add(p3);

        Map<ClusterPoint,ArrayList<Point>> clusteredSurface = df.clusterCreator(localSurface,clusterSize);

        ClusterPoint clusterPointP1 = new ClusterPoint(p1.getX()/clusterSize.getCluserSize(),p1.getY()/clusterSize.getCluserSize());
        ClusterPoint clusterPointP2 = new ClusterPoint(p2.getX()/clusterSize.getCluserSize(),p2.getY()/clusterSize.getCluserSize());
        ClusterPoint clusterPointP3 = new ClusterPoint(p3.getX()/clusterSize.getCluserSize(),p3.getY()/clusterSize.getCluserSize());

        Assert.assertTrue(clusteredSurface.containsKey(clusterPointP1));
        Assert.assertTrue(clusteredSurface.containsKey(clusterPointP2));
        Assert.assertTrue(clusteredSurface.containsKey(clusterPointP3));
    }


    @Test
    public void optimizedFindFarthestWithThousandsElements() throws Exception,DistanceFinderException {

        Set<Point> localSurface = this.surface;

        Point p1 = new Point(0,0);
        localSurface.add(p1);
        Point p2 = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
        localSurface.add(p2);
        DistanceFinder df = new DistanceFinder();

        Map<ClusterPoint,ArrayList<Point>> clusteredSurface = df.clusterCreator(localSurface,new ClusterSize1000());
        long startTimeStamp = new Date().getTime(); //time start
        Collection<Point> farthest = df.finderClustered(clusteredSurface, new FindMaxDistance());
        long finishTimeStamp = new Date().getTime(); //time stop
        System.out.println("Optimized find farthest execution time = " + (finishTimeStamp-startTimeStamp));

        Assert.assertTrue(farthest.contains(p1));
        Assert.assertTrue(farthest.contains(p2));
        Assert.assertTrue(farthest.size()==2);
    }

    @Test
    public void nonOptimizedFindFarthestWithThousandsElements() throws Exception,DistanceFinderException {

        Set<Point> localSurface = this.surface;

        Point p1 = new Point(0,0);
        localSurface.add(p1);
        Point p2 = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
        localSurface.add(p2);
        DistanceFinder df = new DistanceFinder();

        long startTimeStamp = new Date().getTime(); //time start
        Collection<Point> farthest = df.finderMoreGeneric(localSurface,new FindMaxDistance());
        long finishTimeStamp = new Date().getTime(); //time stop
        System.out.println("NON Optimized find farthest execution time = " + (finishTimeStamp-startTimeStamp));

        Assert.assertTrue(farthest.contains(p1));
        Assert.assertTrue(farthest.contains(p2));
        Assert.assertTrue(farthest.size()==2);
    }
}