package pl.sda.wwa5.lab11.points;

import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMaxDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMinDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FinderMoreGeneric;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.Cluster;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterPoint;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterSize1000;

import java.util.*;

public class DistanceFinder {


    public Collection<Point> findFarthest(Collection<Point> surface) throws DistanceFinderException{

        //return find(surface,SearchMode.MAX_DISTANCE);
        return finderMoreGeneric(surface, new FindMaxDistance());
    }


    public Collection<Point> findNearest(Collection<Point> surface) throws DistanceFinderException {

        //return find(surface,SearchMode.MIN_DISTANCE);
        return finderMoreGeneric(surface, new FindMinDistance());
    }

    public Collection<Point> finderMoreGeneric(Collection<Point> surface, FinderMoreGeneric finderMoreGeneric) throws DistanceFinderException {
        if (surface == null || surface.isEmpty()) {
            throw new DistanceFinderException();
        }

        List<Point> found = new ArrayList<>();

        double boundaryDistance = -1;

        for (Point point1 : surface){
            for (Point point2 : surface) {
                if (point1!=point2) {
                    double currentDistance=point1.distance(point2);
                    if (boundaryDistance==-1) {
                        boundaryDistance=currentDistance;
                    }

                    if(finderMoreGeneric.isBoundry(currentDistance,boundaryDistance)) {
                        boundaryDistance=currentDistance;
                        found.clear();
                        found.add(0,point1);
                        found.add(1,point2);
                    }
                }
            }
        }

        return found;
    }

    public Collection<Point> splitSurfaceToClustersAndFindBoundryPoints(Collection<Point> surfaceCollection, Cluster cluster, FinderMoreGeneric finderMoreGeneric) throws DistanceFinderException {

        Map<ClusterPoint,ArrayList<Point>> clusteredSurface = clusterCreator(surfaceCollection,cluster);
        Collection<Point> found = finderClustered(clusteredSurface,finderMoreGeneric);
        return found;
    }

    public Map<ClusterPoint,ArrayList<Point>> clusterCreator(Collection<Point> surfaceCollection, Cluster cluster) throws DistanceFinderException {
        if (surfaceCollection == null || surfaceCollection.isEmpty()) {
            throw new DistanceFinderException();
        }

        Map<ClusterPoint,ArrayList<Point>> clusteredSurface = new TreeMap<>();
        ArrayList<Point> surface = new ArrayList<>(surfaceCollection);

        for (Point point1 : surface){

            int tempX = point1.getX()/cluster.clusterSize();
            int tempY = point1.getY()/cluster.clusterSize();
            ClusterPoint currentClusterKey = new ClusterPoint(tempX,tempY);
            if (clusteredSurface.containsKey(currentClusterKey)) {
                ArrayList<Point> pointsInThisCluster;
                pointsInThisCluster = clusteredSurface.get(currentClusterKey);
                pointsInThisCluster.add(point1);
                clusteredSurface.put(currentClusterKey,pointsInThisCluster);
            } else {
                ArrayList<Point> pointsInThisCluster = new ArrayList<>();
                pointsInThisCluster.add(point1);
                clusteredSurface.put(currentClusterKey,pointsInThisCluster);
            }

        }
        return clusteredSurface;
    }

    public Collection<Point> finderClustered (Map<ClusterPoint,ArrayList<Point>> clusteredSurface, FinderMoreGeneric finderMoreGeneric) throws DistanceFinderException {
        if (clusteredSurface== null || clusteredSurface.isEmpty()) {
            throw new DistanceFinderException();
        }

        TreeMap<ClusterPoint,ArrayList<Point>> surface = (TreeMap<ClusterPoint, ArrayList<Point>>) clusteredSurface;
        ClusterPoint firstKey = surface.firstKey();
        ClusterPoint lastKey = surface.lastKey();

        ArrayList<Point> precedingCluster = (ArrayList<Point>) surface.get(firstKey);
        ArrayList<Point> subsequentCluster = (ArrayList<Point>) surface.get(lastKey);

        List<Point> found = new ArrayList<>();

        double boundaryDistance = -1;

        for (Point point1 : precedingCluster) {
            for (Point point2 : subsequentCluster) {
                double currentDistance=point1.distance(point2);
                if (boundaryDistance==-1) {
                    boundaryDistance=currentDistance;
                }

                if(finderMoreGeneric.isBoundry(currentDistance,boundaryDistance)) {
                    boundaryDistance=currentDistance;
                    found.clear();
                    found.add(0,point1);
                    found.add(1,point2);
                }
            }
        }

        return found;
    }

}
