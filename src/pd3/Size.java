package pd3;

public enum Size {
    SMALL("small"), MEDIUM("medium"), LARGE("large");

    private final String desc;

    private Size(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
