package hobby;

import person.Person;

public class Hobby {
    private final String name;

    public Hobby(String name) {
        this.name = name;
    }

    public void doHobby( Person person){
        try {
            System.out.println(person.getName() + " занимается " + name);
        }catch (NullPointerException e){
            System.err.println("Вы не указали того, кто занимается хобби");
        }

    }
}
