package m05oopbasics;


/**
 * ���������� ��������� � ������� ���� �������� ����� FigureFirstStep ( ����� ����� draw,  ���� x,y)
 * ��� ���� ��������� ��� �������� ������  - circle, rectangle,triangle
 * � ������ �������� ������ ������� �� ��� ������� � ��������  ��.
 */
public abstract class FigureFirstStep {
    Point point;
    public abstract void draw();
    public FigureFirstStep (int x, int y) {
        point = new Point (x, y);
    }
}
class Circle extends FigureFirstStep {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {

    }
}
class Rectangle extends FigureFirstStep {
    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {

    }
}
class Triangle extends FigureFirstStep {
    public Triangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {

    }
}
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
