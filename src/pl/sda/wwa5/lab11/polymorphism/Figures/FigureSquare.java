package pl.sda.wwa5.lab11.polymorphism.Figures;

import pl.sda.wwa5.lab11.polymorphism.Figure;

public class FigureSquare extends Figure{

    private double sideA;
    private double sideB;

    public FigureSquare(double sideA) {
        this.sideA = sideA;
        this.sideB = sideA;
    }

    @Override
    public double calculateField() {
        return this.sideA *this.sideB;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FigureSquare) {
            FigureSquare otherSquare = (FigureSquare) obj;
            if (otherSquare.sideA==this.sideA && otherSquare.sideB==this.sideB) {
                return true;
            }
            if (obj instanceof FigureRectangle) {
                FigureRectangle otherRectangle = (FigureRectangle) obj;
                return (otherRectangle.calculateField()==this.calculateField());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(this.sideA).intValue()+Double.valueOf(this.sideB).intValue();
    }

    @Override
    public String toString() {
        return "FigureSquare{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                "}\n";
    }
}
