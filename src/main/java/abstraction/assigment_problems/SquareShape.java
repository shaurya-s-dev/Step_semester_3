package abstraction.assigment_problems;

public class SquareShape extends Shape {
    private double side;

    public SquareShape(double side) {
        super();
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    protected void applyScale(double factor) {
        this.side *= factor;
    }
}
