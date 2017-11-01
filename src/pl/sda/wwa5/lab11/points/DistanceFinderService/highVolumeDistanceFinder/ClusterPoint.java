package pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder;

import pl.sda.wwa5.lab11.points.Point;

public class ClusterPoint implements Comparable<ClusterPoint> {
    private int x;
    private int y;

    public ClusterPoint() {
    }

    public ClusterPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "K[" + x + "," + y + "]";
    }

    @Override
    public int hashCode() {
        return x-y;
    }

    @Override
    public boolean equals(Object obj) {
        ClusterPoint clusterPoint = (ClusterPoint) obj;
        return (this.x == clusterPoint.getX() && this.y == clusterPoint.getY());
    }

    @Override
    public int compareTo(ClusterPoint o) {
        ClusterPoint clusterPoint = (ClusterPoint) o;
        return (this.getX()+this.getY())-(clusterPoint.getX()+clusterPoint.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
