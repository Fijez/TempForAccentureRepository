package m05oopbasics;


/**
 * реализуйте программа в которой есть основной класс FigureFirstStep ( имеет метод draw,  поля x,y)
 * при этом имеееются три дочерних класса  - circle, rectangle,triangle
 * в каждом дочернем классе создать по два объекта и сравнить  их.
 */
public abstract class FigureFirstStep<T> {

    Point[] point;
    public abstract void draw();
    public abstract int isEqual(FigureFirstStep<? extends FigureFirstStep<T>> figure2);
    public static void isEqualForUser(int comparison) {
       if (comparison < 0) {
           System.out.println("Second figure is greater");
       } else if(comparison == 0) {
           System.out.println("The figures are the same");
       } else {
           System.out.println("First figure is greater");
       }
    }
}


class Circle<T> extends FigureFirstStep<T> {

    private final double rad;

    public Circle(Point p, double r) {
        if (r < 0) {
            throw new IllegalArgumentException("Ражиус не может быть отрицательным");
        }
        rad = r;
        point = new Point[1];
        point[0] = new Point(p.getX(),p.getY());
    }

    @Override
    public final int isEqual(FigureFirstStep<? extends FigureFirstStep<T>> figure2) {
        return Double.compare(this.getRad(), ((Circle) figure2).getRad());
    }


    @Override
    public final void draw() {
        System.out.println("Circle");
    }

    public final double getRad() {
        return rad;
    }

    public static void main(String[] args) {
        Point p = new Point(0,0);
        Point p2 = new Point(-2,-2);

        Circle c1 = new Circle(p, 10);
        Circle c2 = new Circle(p2, 10);
        int i = c1.isEqual(c2);
       FigureFirstStep.isEqualForUser(i);

        c2 = new Circle(p2, 11);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

        c2 = new Circle(p2, 9);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

    }

}


class Rectangle<T> extends FigureFirstStep<T> {

    private final double side1;
    private final double side2;

    public Rectangle(Point diagPoint1, Point diagPoint2) {
        point = new Point[4];
        point[0] = new Point(diagPoint1.getX(), diagPoint1.getY());
        point[1] = new Point(diagPoint2.getX(), diagPoint1.getY());
        point[2] = new Point(diagPoint1.getX(), diagPoint2.getY());
        point[3] = new Point(diagPoint2.getX(), diagPoint2.getY());
        side1 = Math.abs(diagPoint1.getX() - diagPoint2.getX());
        side2 = Math.abs(diagPoint1.getY() - diagPoint2.getY());
    }

    @Override
    public final int isEqual(FigureFirstStep<? extends FigureFirstStep<T>> figure2) {
        return Double.compare(this.getSide1() * this.getSide2(),
                            ((Rectangle) figure2).getSide1() * ((Rectangle) figure2).getSide2());
    }

    @Override
    public final void draw() {
        System.out.println("Rectangle");
    }

    public final double getSide1() {
        return side1;
    }

    public final double getSide2() {
        return side2;
    }

    public static void main(String[] args) {
        Point p11 = new Point(0,0);
        Point p12 = new Point(10,10);
        Point p21 = new Point(-1,-1);
        Point p22 = new Point(-10,-10);

        Rectangle c1 = new Rectangle(p11, p12);
        Rectangle c2 = new Rectangle(p21, p22);
        int i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

        p22 = new Point(-11,-11);
        c2 = new Rectangle(p21, p22);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

        p22 = new Point(-12,-12);
        c2 = new Rectangle(p21, p22);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

    }

}


class Triangle<T> extends FigureFirstStep<T> {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(Point p1, Point p2, Point p3) {
        point = new Point[3];
        point[0] = new Point(p1.getX(), p1.getY());
        point[1] = new Point(p2.getX(), p2.getY());
        point[2] = new Point(p3.getX(), p3.getY());
        sideA = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        sideB = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
        sideC = Math.sqrt(Math.pow(p1.getX() - p3.getX(), 2) + Math.pow(p1.getY() - p3.getY(), 2));
    }

    @Override
    public final int isEqual(FigureFirstStep<? extends FigureFirstStep<T>> figure2) {

        double perim1 = (this.getSideA() +this.getSideB() + this.getSideC())/2;

        double perim2 = (((Triangle)figure2).getSideA() +((Triangle)figure2).getSideB() +
                         ((Triangle)figure2).getSideC())/2;

        double square1 = Math.sqrt(perim1*(perim1 - this.getSideA()) *
                                          (perim1 - this.getSideB()) *
                                          (perim1 - this.getSideC()));

        double square2 = Math.sqrt(perim2*(perim2 - ((Triangle) figure2).getSideA()) *
                                          (perim2 - ((Triangle) figure2).getSideB()) *
                                          (perim2 - ((Triangle) figure2).getSideC()));

        return Double.compare(square1, square2);
    }

    @Override
    public final void draw() {
        System.out.println("Triangle");
    }

    public final double getSideA() {
        return sideA;
    }

    public final double getSideB() {
        return sideB;
    }

    public final double getSideC() {
        return sideC;
    }

    public static void main(String[] args) {
        Point p11 = new Point(0,0);
        Point p12 = new Point(0,10);
        Point p13 = new Point(10,0);
        Point p21 = new Point(0,0);
        Point p22 = new Point(9,0);
        Point p23 = new Point(0,9);

        Triangle c1 = new Triangle(p11, p12, p13);
        Triangle c2 = new Triangle(p21, p22, p23);
        int i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

        p22 = new Point(10,0);
        p23 = new Point(0,10);
        c2 = new Triangle(p21, p22, p23);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

        p22 = new Point(11,0);
        p23 = new Point(0,11);
        c2 = new Triangle(p21, p22, p23);
        i = c1.isEqual(c2);
        FigureFirstStep.isEqualForUser(i);

    }

}


class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public final double getY() {
        return y;
    }

    public final double getX() {
        return x;
    }
}
