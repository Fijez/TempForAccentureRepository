package m11pattern.tasks.home;

public class Foundation {
    private Foundation.FoundationEnum type;

    @Override
    public String toString() {
        return "Foundation{" +
                "type=" + type +
                '}';
    }

    public Foundation(FoundationEnum type) {
        this.type = type;
    }

    public enum FoundationEnum {
        PILE, WITHOUT_PILES
    }
}
