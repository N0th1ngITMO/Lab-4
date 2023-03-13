package enums;

import interfaces.Nameble;

public enum PartOfTheDay implements Nameble {
    NIGHT("Ночь"), MORNING("Утро"), DAY("День"), EVENING("Вечер");

    private final String name;

    PartOfTheDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
