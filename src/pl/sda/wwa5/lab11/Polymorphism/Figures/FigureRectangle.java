package pl.sda.wwa5.lab11.Polymorphism.Figures;

import pl.sda.wwa5.lab11.Polymorphism.Figure;

public class FigureRectangle extends Figure{

    private double sideA;
    private double sideB;

    public FigureRectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateField() {
        return this.sideA*this.sideB;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FigureRectangle) {
            FigureRectangle otherRectangle = (FigureRectangle) obj;
            return (otherRectangle.sideA==this.sideA && otherRectangle.sideB==this.sideB);
        }
        if (obj instanceof FigureSquare) {
            FigureSquare otherSquare = (FigureSquare) obj;
            return (otherSquare.calculateField()==this.calculateField());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(this.sideA).intValue()+Double.valueOf(this.sideB).intValue();
    }

    @Override
    public String toString() {
        return "FigureRectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                "}\n";
    }
}
