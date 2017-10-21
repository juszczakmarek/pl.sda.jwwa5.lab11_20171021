package pl.sda.wwa5.lab11.Polymorphism.Figures;

import pl.sda.wwa5.lab11.Polymorphism.Figure;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class FigureOval extends Figure {

    private double radius;

    public FigureOval(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateField() {
        return PI*pow(radius,2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FigureOval) {
            FigureOval otherOval = (FigureOval) obj;
            return otherOval.radius == this.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(this.radius).intValue();
    }

    @Override
    public String toString() {
        return "FigureOval{" +
                "radius=" + radius +
                "}\n";
    }
}
