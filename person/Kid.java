package person;

import animal.Animal;
import enums.Gender;
import enums.PartOfTheDay;
import enums.Subject;

import java.util.ArrayList;

public class Kid extends Person{

    private final String name;
    private String location;
    private final Gender gender;
    private final int numberOfGrade;
    private String locationOfTheBell;
    private ArrayList<Kid> friend = new ArrayList<Kid>();
    private ArrayList<Adult> parent = new ArrayList<Adult>();
    public Kid(String name, String location, Gender gender, int numberOfGrade) {
        super(name, location);
        this.name = name;
        this.location = location;
        this.gender = gender;
        this.numberOfGrade = numberOfGrade;
    }

    public void playWith(Person person){
        if(person == null){
            System.out.println(getName() + " не играет не с кем");
        }else{
            System.out.println(getName() + " играет с " + person.getName());
        }
    }
    public void playWith(Animal animal){
        if(animal == null){
            System.out.println(getName() + " не играет не с кем");
        }else{
            System.out.println(getName() + " играет с " + animal.getName());
        }
    }

    public void study(Subject subject){
        System.out.println("Для того, чтобы не отстать от своих одноклассников " + getName() + " решил позаниматься " + subject.getName());
    }

    public void signal(Person person, String location){
        try {
            this.locationOfTheBell = location;
            System.out.println("Дёрнув за веревочку, " + getName() + " подал сигнал " +  person.getName());
            System.out.println("Колокольчик зазвонил на(в) " + location);
        }catch (NullPointerException e){
            if(person == null){
                System.err.println(getName() + " не смог никого уговорить на розыгрыш");
            }else{
                System.err.println("Сигнал не прозвучал");
            }
        }
    }

    public void wait(PartOfTheDay partOfTheDay){
        System.out.println(getName() + " с нетерпением ждал наступления " + partOfTheDay.getName());
    }
    public void wait(Person person){
        try {
            if(person instanceof Adult.FlyingMan){
                System.out.println(getName() + " ждал(-а) прилета " + person.getName() + " с нетерпением");
            }else{
                System.out.println(getName() + " ждал(-а) " + person.getName());
            }
        }catch (NullPointerException e){
            System.err.println(getName() + " никого не ждал");
        }

    }

    public void setFriend(Kid friend) {
        this.friend.add(friend);
    }

    public void getFriend(int a) {
        try {
            System.out.println(getName() + " дружит с " + friend.get(a).getName());
        }catch (IndexOutOfBoundsException e){
            System.err.println("Выход за границу массива");
        }
    }

    public void thinkAbout(Person person, Person person1){
        try {
            if((person1 instanceof Adult.FlyingMan || person instanceof Adult.FlyingMan) && (friend.contains(person) || friend.contains(person1))){
                System.out.println(getName() + " подумал о том, что его друзья могли видеть " + person1.getName());
            } else if ((person1 instanceof Adult.FlyingMan || person instanceof Adult.FlyingMan) && (parent.contains(person) || parent.contains(person1)) && (person instanceof Adult || person1 instanceof Adult)){
                System.out.println(getName() + " вспомнил, что " + ((Adult) person).isParent() + " запрещал(-а) говорить с незнакомцами");
            } else {
                System.out.println(getName() + " подумал о " + person.getName() + " и " + person1.getName());
            }
        }catch (NullPointerException e){
            System.err.println("Есть другой метод");
        }

    }

    public void setParent(Adult person) {

        if (person != null && person.getParent()){
            this.parent.add(person);
        }
    }

    public void lay(Animal animal){
        if(animal == null){
            System.out.println("У " + getName() + " нет домашних животных");
        }else{
            System.out.println(getName() + " лёг рядом с " + animal.getName());
        }
    }
    public void lay(Person person){
        if (person == null){
            System.out.println("У " + getName() + " нет желания ложиться с кем-то рядом");
        }else{
            System.out.println(getName() + " лег рядом с " + person.getName());
        }

    }

    public String getLocationOfTheBell() {
        return locationOfTheBell;
    }
}
