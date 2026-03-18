package pd3;

public enum Type {
    POSITIVE("positive"), NEGATIVE("negative");

    private final String desc;

    Type(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
