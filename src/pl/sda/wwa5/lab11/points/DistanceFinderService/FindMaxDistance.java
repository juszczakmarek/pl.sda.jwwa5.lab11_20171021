package pl.sda.wwa5.lab11.points.DistanceFinderService;

public class FindMaxDistance extends FinderMoreGeneric {
    @Override
    public boolean isBoundry(double currentDistance, double boundaryDistance) {
        return currentDistance>= boundaryDistance;
    }
}
