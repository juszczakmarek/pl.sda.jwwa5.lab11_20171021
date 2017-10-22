package pl.sda.wwa5.lab11.polymorphism.service;

import pl.sda.wwa5.lab11.polymorphism.Figure;

import java.util.*;

public class FigureService {
    Set<Figure> figures = new HashSet<>();
    List<Figure> twoBiggestFigures = new ArrayList<>();

    public FigureService(Set<Figure> figures) {
        this.figures = figures;
    }

    public double calculateSumOfFields(Collection<Figure> figuresToCalculate) {
        double sumOfFields = 0;

        Iterator<Figure> iterator = figuresToCalculate.iterator();
        while (iterator.hasNext()) {
            Figure currentFigure = iterator.next();
            sumOfFields += currentFigure.calculateField();
        }
        return sumOfFields;

    }

    public Collection<Figure> findBiggestFigures(Collection<Figure> figures, int size) {
        List<Figure> listOfFigures = new ArrayList<Figure>(figures);
        Collections.sort(listOfFigures, (o1, o2) -> {
            return Double.valueOf(o2.calculateField()-o1.calculateField()).intValue();
        });

        Collection<Figure> finalResult = new HashSet<>();

        for(int i=0; i <size; i++) {
            finalResult.add(listOfFigures.get(i));
        }

        return finalResult;
    }

    public void printCollection(Collection<Figure> figures) {
        Iterator<Figure> figureIterator = figures.iterator();
        while (figureIterator.hasNext()) {
            Figure currentFigure = figureIterator.next();
            System.out.println(currentFigure.calculateField());
        }

    }
}
