package person;

import enums.Gender;
import enums.PartOfTheDay;
import interfaces.Movable;
import interfaces.Nameble;
import food.Food;

public abstract class Person implements Movable, Nameble {
    private final String name;
    private String location;
    private final Gender gender;
    private static PartOfTheDay time;

    public Person(String name, String location){
        this.name = name;
        this.location = location;
        this.gender = null;

    }

    public static PartOfTheDay getTime() {
        return time;
    }

    public static void setTime(PartOfTheDay time) {
        Person.time = time;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


    public Gender getGender() {
        return gender;
    }

    public void move(String location){
        System.out.print(getName() + " перешёл(-ла) из " + getLocation() + " в ");
        this.location = location;
        System.out.println(getLocation());
    }

    public void thinkAbout(Person person){
        System.out.println(getName() + " подумал(-а) о " + person.getName());
    }

    public void doSnack(Food food){
        System.out.println(getName() + " перекусывает " + food.getName());
    }

    public void getScared(Person person){
        try{
            if (person instanceof Adult.FlyingMan && !((Adult.FlyingMan) person).isOpportunityToScare()){
                System.out.println(getName() + " никто не пугал");
                System.out.println("План провалился.");
            }else{
                System.out.println(getName() + " испугался(-ась)");
                System.out.println("Шаласть удалась");
            }
        }catch (NullPointerException e){
            System.err.println(getName() + " никто не пугал");
            System.out.println("План провалился.");
        }

    }

    public void view(Person person, String time){
        if(person instanceof Adult.FlyingMan && !((Adult.FlyingMan) person).isOpportunityToScare()){
            System.out.println(getName() + " не видел(-а) " + person.getName());
        }else{
            switch (time){
                case "настоящее" -> System.out.println(getName() + " увидел(-а) " + person.getName());
                case "прошедшее" -> System.out.println(getName() + " видел(-а) " + person.getName());
                case "будущее" -> System.out.println(getName() + " увидит " + person.getName());
            }
        }
    }

    public void startCall(Person person, String a){
        System.out.println(getName() + " и позвонил " + person.getName() + " рассказал о " + a);
    }

    public void endCall(){
        System.out.println(getName() + " поспешил положить трубку");
    }
}
