package enums;

import interfaces.Nameble;

public enum Gender implements Nameble {
    MALE("Мужчина"), FEMALE("Женщина");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
