package pl.sda.wwa5.lab11;

import pl.sda.wwa5.lab11.points.DistanceFinder;
import pl.sda.wwa5.lab11.points.DistanceFinderException;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMaxDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.FindMinDistance;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterPoint;
import pl.sda.wwa5.lab11.points.DistanceFinderService.highVolumeDistanceFinder.ClusterSize1000;
import pl.sda.wwa5.lab11.points.Point;
import pl.sda.wwa5.lab11.polymorphism.Figure;
import pl.sda.wwa5.lab11.polymorphism.Figures.FigureOval;
import pl.sda.wwa5.lab11.polymorphism.Figures.FigureRectangle;
import pl.sda.wwa5.lab11.polymorphism.Figures.FigureSquare;
import pl.sda.wwa5.lab11.polymorphism.Figures.FigureTriangle;
import pl.sda.wwa5.lab11.polymorphism.service.FigureService;
import pl.sda.wwa5.lab11.recursion.Count;

import java.util.*;

public class Main {

    public static void main(String[] args) throws DistanceFinderException, Exception {

        callSurfaceWithOptimization();
        //callSurface();
        //callRecursion();
        //callPolymorphism();
    }

    public static void callSurfaceWithOptimization() throws Exception, DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        surface.add(new Point(0,1001));
        surface.add(new Point(1001,1001));
        surface.add(new Point(1002,1002));
        surface.add(new Point(3001,2000));
        surface.add(new Point(3999,2999));
        surface.add(new Point(10,10));

        DistanceFinder df = new DistanceFinder();

        Collection<Point> farthest = df.splitSurfaceToClustersAndFindBoundryPoints(surface,new ClusterSize1000(),new FindMaxDistance());

        System.out.println(surface);
        System.out.println(farthest);

    }

    public static void callSurface() throws Exception, DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        surface.add(new Point(0,0));
        surface.add(new Point(0,1));
        surface.add(new Point(0,5));
        surface.add(new Point(10,10));

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
        Collection<Point> farthest = df.findFarthest(surface);
        Collection<Point> foundNearestPoints = df.finderMoreGeneric(surface, new FindMinDistance());
        Collection<Point> foundFarthestPoints = df.finderMoreGeneric(surface, new FindMaxDistance());

        System.out.println("Dwa najbliższe punkty na płaszczyźnie to: " + nearest);
        System.out.println("Dwa najdalsze punkty na płaszczyźnie to: " + farthest);
        System.out.println("To samo, używając generycznej metody z wykorzystaniem flagi:");
        System.out.println("Dwa najbliższe punkty na płaszczyźnie to: " + foundNearestPoints);
        System.out.println("Dwa najdalsze punkty na płaszczyźnie to: " + foundFarthestPoints);
    }

    public void callPolymorphism() {
        Set<Figure> figures = new HashSet<>();
        Collection<Figure> biggestFigures = new HashSet<>();

        figures.add(new FigureSquare(2.0));
        figures.add(new FigureSquare(2.0));
        figures.add(new FigureOval(2.0));
        figures.add(new FigureOval(2.0));
        figures.add(new FigureTriangle(0.5, 1));
        figures.add(new FigureRectangle(2.0, 2.0));
        figures.add(new FigureRectangle(2.0, 2.0));
        figures.add(new FigureRectangle(2.0, 5.0));

        FigureService figureService = new FigureService(figures);
        System.out.println(figures);

        System.out.println("Suma pól wszystkich figur to " + figureService.calculateSumOfFields(figures));


        int howManyBiggestFigers = 2;
        biggestFigures = figureService.findBiggestFigures(figures, howManyBiggestFigers);
        System.out.println("Suma pól " + howManyBiggestFigers + " największych figur w kolekcji = " + figureService.calculateSumOfFields(biggestFigures));
    }

    public static void callRecursion() {
        Count count = new Count(10);
        System.out.println("fib("+count.getCountUntil()+") = "+count.fib(count.getCountUntil())+" (wersja bez rekurencji)");
        System.out.println("fib("+count.getCountUntil()+") = "+count.fibWithRecursion(count.getCountUntil())+" (wersja z rekurencją)");
        System.out.println(count.getCountUntil()+"! = "+count.countStrong(count.getCountUntil())+" (wersja bez rekurencji)");
        System.out.println(count.getCountUntil()+"! = "+count.countStrongWithRecursion(count.getCountUntil())+" (wersja z rekurencją)");
    }
}
