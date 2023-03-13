package animal;

import person.Person;

import java.util.Objects;

public class Puppy extends Animal{
    private final String nickName;
    private String location;

    private boolean loveForTheOwner;

    public Puppy(String nickName, String location, boolean loveForTheOwner) {
        super(nickName, location);
        this.location = location;
        this.nickName = nickName;
        this.loveForTheOwner = loveForTheOwner;
    }

    public String getName() {
        return nickName;
    }

    @Override
    public void move(String location) {
        if(this.location.equals(location)){
            System.out.println(getName() + " находится в " + this.location);
        }else{
            System.out.println(getName() + " пришел в " + location);
            this.location = location;
        }
    }

    @Override
    public void makeASound() {
        System.out.println(toString() + " лает");
    }

    public void loveTheOwner(Person person){
        try {
            if (loveForTheOwner){
                System.out.println(getName() + " любил " + person.getName() + ", поэтому радостно велял хвостом и жаждал его(её) внимания");
            }else{
                System.out.println(getName() + " не любил " + person.getName() + ", поэтому поспешил спрятаться");
            }
        }catch (NullPointerException e){
            System.out.println(getName() + " любил одиночество, поэтому поспешил спрятаться");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puppy puppy = (Puppy) o;
        return Objects.equals(nickName, puppy.nickName) && Objects.equals(location, puppy.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, location);
    }

    @Override
    public String toString() {
        return "Щенок";
    }
}
