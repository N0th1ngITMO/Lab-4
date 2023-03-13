package food;

import interfaces.Nameble;

public class Food implements Nameble {
    private final String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
