package enums;

import interfaces.Nameble;

public enum PartOfTheBody implements Nameble {
    HEAD("Голова"), NECK("Шея"), SHOULDER("Плечо(-и)"), ARM("Рука(-и)"), BREAST("Грудь"), BACK("Спина"), HIP("Бедро(-а)"), LEG("Нога(-и)"), FOOT("Стопа(-ы)");

    private final String name;

    PartOfTheBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
