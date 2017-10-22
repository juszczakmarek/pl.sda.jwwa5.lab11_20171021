package pl.sda.wwa5.lab11;

import pl.sda.wwa5.lab11.Polymorphism.Figure;
import pl.sda.wwa5.lab11.Polymorphism.Figures.FigureOval;
import pl.sda.wwa5.lab11.Polymorphism.Figures.FigureRectangle;
import pl.sda.wwa5.lab11.Polymorphism.Figures.FigureSquare;
import pl.sda.wwa5.lab11.Polymorphism.Figures.FigureTriangle;
import pl.sda.wwa5.lab11.Polymorphism.service.FigureService;
import pl.sda.wwa5.lab11.Recursion.Count;
import pl.sda.wwa5.lab11.points.DistanceFinder;
import pl.sda.wwa5.lab11.points.DistanceFinderException;
import pl.sda.wwa5.lab11.points.Point;
import pl.sda.wwa5.lab11.points.SearchMode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        surface.add(new Point(0,0));
        surface.add(new Point(0,1));
        surface.add(new Point(0,5));
        surface.add(new Point(10,10));

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
        Collection<Point> farthest = df.findFarthest(surface);
        Collection<Point> foundNearestPoints = df.find(surface, SearchMode.MIN_DISTANCE);
        Collection<Point> foundFarthestPoints = df.find(surface, SearchMode.MAX_DISTANCE);

        System.out.println("Dwa najbliższe punkty na płaszczyźnie to: " + nearest);
        System.out.println("Dwa najdalsze punkty na płaszczyźnie to: " + farthest);
        System.out.println("To samo, używając generycznej metody z wykorzystaniem flagi:");
        System.out.println("Dwa najbliższe punkty na płaszczyźnie to: " + foundNearestPoints);
        System.out.println("Dwa najdalsze punkty na płaszczyźnie to: " + foundFarthestPoints);

        //callSurface();
        //callRecursion();
    }

//    public static void callSurface() throws Exception, DistanceFinderException{
//        Set<Point> surface = new HashSet<>();
//        surface.add(new Point(0,0));
//        surface.add(new Point(0,1));
//        surface.add(new Point(0,5));
//        surface.add(new Point(10,10));
//
//        DistanceFinder df = new DistanceFinder();
//        Collection<Point> nearest = df.findNearest(surface);
//        Collection<Point> farthest = df.findFarthest(surface);
//
//        System.out.println("Dwa najbliższe punkty na płaszczyźnie to: " + nearest);
//        System.out.println("Dwa najdalsze punkty na płaszczyźnie to: " + farthest);
//    }

//    public void callPolymorphism() {
//        Set<Figure> figures = new HashSet<>();
//        Collection<Figure> biggestFigures = new HashSet<>();
//
//        figures.add(new FigureSquare(2.0));
//        figures.add(new FigureSquare(2.0));
//        figures.add(new FigureOval(2.0));
//        figures.add(new FigureOval(2.0));
//        figures.add(new FigureTriangle(0.5, 1));
//        figures.add(new FigureRectangle(2.0, 2.0));
//        figures.add(new FigureRectangle(2.0, 2.0));
//        figures.add(new FigureRectangle(2.0, 5.0));
//
//        FigureService figureService = new FigureService(figures);
//        System.out.println(figures);
//
//        System.out.println("Suma pól wszystkich figur to " + figureService.calculateSumOfFields(figures));
//
//
//        int howManyBiggestFigers = 2;
//        biggestFigures = figureService.findBiggestFigures(figures, howManyBiggestFigers);
//        System.out.println("Suma pól " + howManyBiggestFigers + " największych figur w kolekcji = " + figureService.calculateSumOfFields(biggestFigures));
//    }
//
//    public static void callRecursion() {
//        Count count = new Count(10);
//        System.out.println("fib("+count.getCountUntil()+") = "+count.fib(count.getCountUntil())+" (wersja bez rekurencji)");
//        System.out.println("fib("+count.getCountUntil()+") = "+count.fibWithRecursion(count.getCountUntil())+" (wersja z rekurencją)");
//        System.out.println(count.getCountUntil()+"! = "+count.countStrong(count.getCountUntil())+" (wersja bez rekurencji)");
//        System.out.println(count.getCountUntil()+"! = "+count.countStrongWithRecursion(count.getCountUntil())+" (wersja z rekurencją)");
//    }
}
