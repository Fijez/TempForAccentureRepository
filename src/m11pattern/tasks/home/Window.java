package m11pattern.tasks.home;

public class Window {
    private int count;
    private WindowEnum type;

    public Window(int count, WindowEnum type) {
        this.count = count;
        this.type = type;
    }

    public enum WindowEnum {
        PLASTIC, NOT_PLASTIC
    }

    @Override
    public String toString() {
        return "Window{" +
                "count=" + count +
                ", type=" + type +
                '}';
    }
}
