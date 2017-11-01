package pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder;

import java.util.Comparator;

public class ClusterCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ClusterPoint clusterPoint1 = (ClusterPoint) o1;
        ClusterPoint clusterPoint2 = (ClusterPoint) o2;

        return (clusterPoint1.getX()+clusterPoint1.getY())-(clusterPoint2.getX()+clusterPoint2.getY());
    }
}
