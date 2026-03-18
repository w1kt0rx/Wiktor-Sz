
package pd3;

import static java.lang.Math.abs;

public class Number {
    private final int number;
    private Size size;
    private Type type;
    private String divisibility;

    public Number(int number) {
        this.number = number;
        this.size = setSize();
        this.type = setType();
        this.divisibility = setDivisibility();
    }

    private Size setSize() {
        int absoluteNumber = abs(number);
        if(absoluteNumber > 0 && absoluteNumber < 11) {
            return Size.SMALL;
        } else if(absoluteNumber >= 11 && absoluteNumber < 101) {
            return Size.MEDIUM;
        } else {
            return Size.LARGE;
        }
    }

    private Type setType() {
        if(number < 0) {
            return Type.NEGATIVE;
        } else {
            return Type.POSITIVE;
        }
    }

    private String setDivisibility() {
        if(number % 2 == 0 && number % 3 == 0 ) {
            return "divisible by 2 and 3";
        } else if(number % 2 == 0) {
            return "divisible by 2";
        } else if(number % 3 == 0) {
            return "divisible by 3";
        } else{
            return "not divisible by 2 or 3";
        }
    }

    public String getInformation(){
        return String.format("Number: %d, Type: %s, Divisibility: %s, Size: %s", number, type.getDesc(), divisibility, size.getDesc());
    }

    public int getNumber() {
        return number;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDivisibility() {
        return divisibility;
    }

    public void setDivisibility(String divisibility) {
        this.divisibility = divisibility;
    }
}
