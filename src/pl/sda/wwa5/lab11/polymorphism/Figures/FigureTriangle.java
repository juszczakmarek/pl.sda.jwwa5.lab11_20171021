package pl.sda.wwa5.lab11.polymorphism.Figures;

import pl.sda.wwa5.lab11.polymorphism.Figure;

public class FigureTriangle extends Figure {

    private double sideBottom;
    private double height;

    public FigureTriangle(double sideBottom, double height) {
        this.sideBottom = sideBottom;
        this.height = height;
    }

    @Override
    public double calculateField() {
        return 0.5*this.sideBottom*this.height;
    }

    @Override
    public String toString() {
        return "FigureTriangle{" +
                "sideBottom=" + sideBottom +
                ", height=" + height +
                "}\n";
    }
}
