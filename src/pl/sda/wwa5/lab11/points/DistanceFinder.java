package pl.sda.wwa5.lab11.points;

import java.util.*;

public class DistanceFinder {

    public Collection<Point> findFarthest(Collection<Point> surface) {
        List<Point> twoFarthestPoints = new ArrayList<>();
        double farthestDistance = Double.MIN_VALUE;

        for (Point point1 : surface){
            for (Point point2 : surface) {
                if (point1!=point2) {
                    double currentDistance=point1.distance(point2);
                    if (currentDistance>farthestDistance) {
                        farthestDistance=currentDistance;
                        twoFarthestPoints.clear();
                        twoFarthestPoints.add(0,point1);
                        twoFarthestPoints.add(1,point2);
                    }
                }
            }
        }
        return twoFarthestPoints;
    }

    public Collection<Point> findNearest(Collection<Point> surface) {
        List<Point> twoNearestPoints = new ArrayList<>();
        double nearestDistance = Double.MAX_VALUE;


        for (Point point1 : surface){
            for (Point point2 : surface) {
                if (point1!=point2) {
                    double currentDistance=point1.distance(point2);
                    if (currentDistance<nearestDistance) {
                        nearestDistance=currentDistance;
                        twoNearestPoints.clear();
                        twoNearestPoints.add(0,point1);
                        twoNearestPoints.add(1,point2);
                    }
                }
            }
        }

        return twoNearestPoints;
    }

}
