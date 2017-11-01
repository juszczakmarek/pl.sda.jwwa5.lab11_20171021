package pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder;

public class ClusterSize1000 extends Cluster {

    private int cluserSize;

    public ClusterSize1000() {
        this.cluserSize = clusterSize();
    }

    @Override
    public int clusterSize() {
        return 1000;
    }

    public int getCluserSize() {
        return cluserSize;
    }
}
