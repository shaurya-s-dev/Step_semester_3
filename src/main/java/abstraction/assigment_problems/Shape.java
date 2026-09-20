package abstraction.assigment_problems;

public abstract class Shape {
    private static int counter = 1000;
    private final String shapeId;

    public Shape() {
        this.shapeId = "SHP-" + (++counter);
    }

    public abstract double calculateArea();

    protected abstract void applyScale(double factor);

    public void scale(double factor) {
        applyScale(factor);
    }

    public void scale(double xFactor, double yFactor) {
        scale(xFactor);
        scale(yFactor);
    }

    public String getShapeId() {
        return shapeId;
    }

    public static void printArea(Shape s) {
        if (s != null) {
            System.out.println(s.calculateArea());
        }
    }
}
