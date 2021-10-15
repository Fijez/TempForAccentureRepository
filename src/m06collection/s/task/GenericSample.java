package m06collection.s.task;

import java.util.LinkedList;
import java.util.List;

/**
 * Необходимо реализовать метод который принимает список с любыми типами данных
 * и выводить его содержимое в консоль
 *
 */

public class GenericSample<T> {
    public static void main(String[] args) {
        List<Point> pointList = new LinkedList<>();
        pointList.add(new Point(0,1));
        pointList.add(new Point(2,3));
        pointList.add(new Point(4,5));
        pointList.add(new Point(6,7));
        pointList.add(new Point(8,9));
        pointList.add(new Point(10,11));
        GenericSample output = new GenericSample();
        output.outputList(pointList);
    }

    public void outputList (List<T> list) {
        for (T i : list) {
            System.out.println(i.toString());
        }
    }
}

class Point {
    double x;
    double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
