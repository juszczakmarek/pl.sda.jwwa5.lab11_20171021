package pl.sda.wwa5.lab11.points;

import java.util.*;

public class DistanceFinder {

    public Collection<Point> findFarthest(Collection<Point> surface) throws DistanceFinderException{
//        if (surface == null || surface.isEmpty()) {
//            throw new DistanceFinderException();
//        }
//
//        List<Point> twoFarthestPoints = new ArrayList<>();
//        double farthestDistance = 0;
//
//        for (Point point1 : surface){
//            for (Point point2 : surface) {
//                if (point1!=point2) {
//                    double currentDistance=point1.distance(point2);
//                    if (currentDistance>farthestDistance) {
//                        farthestDistance=currentDistance;
//                        twoFarthestPoints.clear();
//                        twoFarthestPoints.add(0,point1);
//                        twoFarthestPoints.add(1,point2);
//                    }
//                }
//            }
//        }
//        return twoFarthestPoints;
        return find(surface,SearchMode.MAX_DISTANCE);
    }

//    public Collection<Point> findNearestOptimized(Collection<Point> surface) {
//        List<Point> twoNearestPoints = new ArrayList<>();
//        double nearestDistance = Double.MAX_VALUE;
//
//
//        for (Point point1 : surface){
//            for (Point point2 : surface) {
//                if (point1!=point2) {
//                    double currentDistance=point1.distance(point2);
//                    if (currentDistance<nearestDistance) {
//                        nearestDistance=currentDistance;
//                        twoNearestPoints.clear();
//                        twoNearestPoints.add(0,point1);
//                        twoNearestPoints.add(1,point2);
//                    }
//                }
//            }
//        }
//
//        return twoNearestPoints;
//    }

    public Collection<Point> findNearest(Collection<Point> surface) throws DistanceFinderException {
//        if (surface == null || surface.isEmpty()) {
//            throw new DistanceFinderException();
//        }
//
//        List<Point> twoNearestPoints = new ArrayList<>();
//        double nearestDistance = Double.MAX_VALUE;
//
//
//        for (Point point1 : surface){
//            for (Point point2 : surface) {
//                if (point1!=point2) {
//                    double currentDistance=point1.distance(point2);
//                    if (currentDistance<nearestDistance) {
//                        nearestDistance=currentDistance;
//                        twoNearestPoints.clear();
//                        twoNearestPoints.add(0,point1);
//                        twoNearestPoints.add(1,point2);
//                    }
//                }
//            }
//        }
//
//        return twoNearestPoints;
        return find(surface,SearchMode.MIN_DISTANCE);
    }

    public Collection<Point> find(Collection<Point> surface, SearchMode mode) throws DistanceFinderException {
        if (surface == null || surface.isEmpty()) {
            throw new DistanceFinderException();
        }

        List<Point> found = new ArrayList<>();

        double boundaryDistance = -1;

        for (Point point1 : surface){
            for (Point point2 : surface) {
                if (point1!=point2) {
                    double currentDistance=point1.distance(point2);
                    boolean assign=false;
                    if (boundaryDistance== -1) {
                        boundaryDistance=currentDistance;
                    }
                    if (boundaryDistance<=currentDistance && mode==SearchMode.MAX_DISTANCE) {
                        assign=true;
                    }
                    if (boundaryDistance>=currentDistance && mode==SearchMode.MIN_DISTANCE) {
                        assign=true;
                    }
                    if (assign) {
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

}
