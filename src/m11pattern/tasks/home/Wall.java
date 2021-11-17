package m11pattern.tasks.home;

public class Wall {
    private int count;
    private Wall.WallEnum type;

    public Wall(int count, WallEnum type) {
        this.count = count;
        this.type = type;
    }

    public enum WallEnum {
        WOODEN, STONE
    }

    @Override
    public String toString() {
        return "Wall{" +
                "count=" + count +
                ", type=" + type +
                '}';
    }
}
