package enums;

import interfaces.Nameble;

public enum Subject implements Nameble {
    MATH("Математика"), RUSSIAN_LANGUAGE("Русский язык"), LITERATURE("Литература"), BIOLOGY("Биология"), CHEMISTRY("Химия"), GEOGRAPHY("География"), HISTORY("История");

    private final String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
