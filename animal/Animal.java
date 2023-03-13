package animal;

import interfaces.Movable;
import interfaces.Nameble;

public abstract class Animal implements Movable, Nameble {
    private final String nickName;
    private String location;

    public Animal(String nickName, String location) {
        this.nickName = nickName;
        this.location = location;
    }

    @Override
    public String getName() {
        return nickName;
    }

    @Override
    public void move(String location) {
        this.location = location;
    }

    public abstract void makeASound();
}
