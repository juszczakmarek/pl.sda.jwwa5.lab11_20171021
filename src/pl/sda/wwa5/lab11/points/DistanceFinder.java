package pl.sda.wwa5.lab11.points;

import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMaxDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMinDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FinderMoreGeneric;

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
                    if (boundaryDistance== -1) {
                        boundaryDistance=currentDistance;
                    }
                    boolean assign=false;
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

}
