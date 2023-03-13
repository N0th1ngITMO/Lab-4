import animal.Puppy;
import enums.Gender;
import enums.PartOfTheBody;
import enums.PartOfTheDay;
import enums.Subject;
import excetion.NoNegativeCaloriesException;
import hobby.Hobby;
import interfaces.AbleToEatDish;
import location.Location;
import person.Adult;
import person.Kid;
import person.Person;

public class Main{
    public static void main(String[] args) throws NoNegativeCaloriesException{
        Location street = new Location("Улица", null);
        Location house = new Location("Дом", street);
        Location flat = new Location("Квартира", house);
        Location kitchen = new Location("Кухня", flat);
        Location parentsBedroom = new Location("Спальня родителей", flat);
        Location BossesRoom = new Location("Комната Боссe", flat);
        Location BetansRoom = new Location("Комната Бетан", flat);
        Location babysRoom = new Location("Комната малыша", flat);
        Location roofOfTheHouse = new Location("Крыша дома", house);
        Location school = new Location("Школа", street);
        Puppy puppy = new Puppy("Бимбо", flat.getLocation(4), true);
        Kid baby = new Kid("Малыш", flat.getLocation(4), Gender.MALE, 5);
        Kid Krister = new Kid("Кристер", street.getName(), Gender.MALE, 5);
        Kid Gunilla = new Kid("Гунилла", street.getLocation(1), Gender.FEMALE, 5);
        baby.setFriend(Krister);
        baby.setFriend(Gunilla);
        Kid Betan = new Kid("Бетан", street.getLocation(1), Gender.FEMALE, 9);
        Kid Bosse = new Kid("Боссе", street.getLocation(1), Gender.MALE, 9);
        Adult msBok = new Adult("Фрекен Бок", flat.getLocation(0), Gender.FEMALE, false, "Домработница");
        Adult mrSvanteson = new Adult("Мистер Свантесон", null, Gender.MALE, true, "Начальник фабрики");
        Adult mrsSvanteson = new Adult("Миccис Свантесон", null, Gender.FEMALE, true, "Учительница");
        baby.setParent(mrsSvanteson);
        baby.setParent(mrSvanteson);
        Adult.FlyingMan Karlson = new Adult.FlyingMan("Карлсон", house.getLocation(1), Gender.MALE);
        Person.setTime(PartOfTheDay.DAY);
        Hobby hobby = new Hobby("Собирание марок");
        Adult.Dish meatball = msBok.new Dish("Тефтеля рыбная");
        Adult.Dish appleCasserole = msBok.new Dish("Яблочная запеканка");
        meatball.countCalories(345);
        appleCasserole.countCalories(143);


        puppy.loveTheOwner(baby);
        baby.lay(puppy);
        baby.wait(PartOfTheDay.EVENING);
        baby.playWith(puppy);
        hobby.doHobby(null);
        baby.study(Subject.MATH);
        baby.startCall(Krister, "скарлатине");
        baby.thinkAbout(Krister, Karlson);
        baby.thinkAbout(mrsSvanteson, Karlson);
        baby.endCall();
        meatball.cook();
        appleCasserole.cook();
        AbleToEatDish meal = new AbleToEatDish() {
            @Override
            public void eat(Person... person) {
                    for (Person person1 : person) {
                            System.out.print(person1.getName() + " ");
                    }
                    switch (Person.getTime()){
                        case MORNING -> System.out.println("завтракают(-ет)");
                        case DAY -> System.out.println("обедают");
                        case EVENING -> System.out.println("ужинают");
                        case NIGHT -> System.out.println(" уже не едят, потому что поздно");
                    }
                }
            @Override
            public void whatEat(Adult.Dish ... dish){
                switch (Person.getTime()){
                    case MORNING -> System.out.print("На завтрак ");
                    case DAY -> System.out.print("На обед ");
                    case EVENING -> System.out.print("На ужин ");
                    case NIGHT -> System.out.print("Увы, уже поздно, поэтому на завтра остаются(-ётся)");
                }
                for(Adult.Dish dish1 : dish){
                    System.out.print(dish1.getName() + " ");
                }
                System.out.print("\n");
            }
        };
        meal.whatEat(meatball, appleCasserole);
        meal.eat(baby, msBok);
        baby.wait(PartOfTheDay.EVENING);
        baby.wait(Karlson);
        msBok.takeABath(PartOfTheBody.FOOT);
        msBok.promise(baby, "уложить спать");
        msBok.promise(baby, "уложить спать");
        baby.wait(msBok);
        baby.view(msBok, "настоящее");
        msBok.move(flat.getLocation(4));
        baby.signal(Karlson, house.getLocation(1));
        Karlson.pretendAGoust(msBok, baby);
        msBok.view(Karlson, "настоящее");
        msBok.getScared(Karlson);


    }
}