package person;

import enums.Gender;
import enums.PartOfTheBody;
import excetion.BrokenPropollerException;
import excetion.FlymanNotNearTheBellException;
import excetion.NoNegativeCaloriesException;
import interfaces.Nameble;

import javax.sound.midi.Soundbank;


public class Adult extends Person{
    private final String name;
    private String location;
    private final Gender gender;
    private final boolean parent;
    private final String jobTitel;

    public Adult(String name, String location, Gender gender, boolean parent, String jobTitel) {
        super(name, location);
        this.name = name;
        this.gender = gender;
        this.parent = parent;
        this.jobTitel = jobTitel;
    }

    public String isParent() {
        if (parent){
            switch (gender){
                case MALE -> {
                    return "Папа";
                }
                case FEMALE -> {return "Мама";}
            }
        }else{
            return "Не родитель";
        }
        return null;
    }

    public boolean getParent(){
        return parent;
    }

    public String getJobTitel() {
        return jobTitel;
    }

    public void takeABath(PartOfTheBody partOfTheBody){
        switch (partOfTheBody){
            case ARM -> System.out.println(getName() + " опустила руки в таз с водой и принимает ручные ванны");
            case FOOT, LEG -> System.out.println(getName() + " опустила ноги в таз с водой и принимает ножные ванны");
            case HEAD -> System.out.println(getName() + " моет голову");
            default -> System.out.println(getName() + " принимает ванну для " + partOfTheBody.getName());
        }
    }

    public void promise(Person person, String pledge){
        String a = pledge;

        class Pledge implements Nameble {
            private final String pledge;

            public Pledge(){
                this.pledge = a;
            }

            public String getName() {
                return pledge;
            }
        }
        Pledge pledge1 = new Pledge();
        try {
                System.out.println(getName() + " пообещал(-а) " + person.getName() + pledge1.getName());
        }catch (NullPointerException e) {
            if(pledge == null && person == null){
                System.out.println("Никто и никому ничего не обещал");
            }else if(pledge == null){
                System.out.println(getName() + " ничего " + person.getName() + " не обещал(-а)");
            }else{
                System.out.println(getName() + " никому не обещал(-а) " + pledge1.getName());
            }
        }

    }

    public static class FlyingMan extends Person{
        private final String name;
        private String location;
        private final Gender gender;
        private boolean  opportunityToScare;

        public FlyingMan(String name, String location, Gender gender) {
            super(name, location);
            this.name = name;
            this.gender = gender;
            this.location = location;
        }

        public void pretendAGoust(Person person, Kid kid){
            class Propeller{
                final boolean statusOfThePropeller;

                public Propeller() {
                    this.statusOfThePropeller = Math.random() <= 0.8;
                }

                public String fixingThePropeller(){
                    if(Math.random() <= 0.5){
                        return getName() + " предпринял попытку починить пропеллер. У него получилось.";
                    }else{
                        return getName() + " предпринял попытку починить пропеллер. У него не получилось.";
                    }
                }
            }
            Propeller propeller = new Propeller();
            try {
                if(propeller.statusOfThePropeller && getLocation().equals(kid.getLocationOfTheBell())){
                    opportunityToScare = true;
                    System.out.println(getName() + " прилетает в " + kid.getLocation() + ", притворяется приведением из Вазастана и пугает " + person.getName());
                }else if(!propeller.statusOfThePropeller && getLocation().equals(kid.getLocationOfTheBell())){
                    throw new BrokenPropollerException("Пропеллер сломался." + getName() + " никуда не летит.");
                }else{
                    throw new FlymanNotNearTheBellException(getName() + " был далеко от колокольчика, поэтому он(она) его не услышал(-а)");
                }
            }catch (BrokenPropollerException e){
                System.err.println(e.getMessage());
                opportunityToScare = false;
                System.out.println(getName() + " чинит пропеллер");
                double statusOfTheFixing = Math.random();
                while(statusOfTheFixing <= 0.5){
                    System.out.println(getName() + " предпринял попытку починить пропеллер. У него не получилось.");
                    statusOfTheFixing = Math.random();
                }
                System.out.println(getName() + " предпринял попытку починить пропеллер. У него получилось.");
            }catch (FlymanNotNearTheBellException e){
                opportunityToScare = false;
                System.err.println(e.getMessage());
            }

        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Gender getGender() {
            return gender;
        }

        @Override
        public String getLocation() {
            return location;
        }

        public boolean isOpportunityToScare() {
            return opportunityToScare;
        }
    }

    public class Dish implements Nameble {
        private final String name;
        private int calories;

        public Dish(String name) throws NoNegativeCaloriesException{
            this.name = name;
        }

        public void cook(){
                System.out.println(Adult.this.name + " приготовил(-а)" + name);
        }

        public String getName() {
            return name;
        }

        public void countCalories(int a) {
            if (a <= 0){
                try{
                    throw new NoNegativeCaloriesException("Калории не могу быть неположительными");
                }catch (NoNegativeCaloriesException e){
                    System.err.println(e.getMessage());
                }

            }
            this.calories = a;
        }

        public int getCalories() {
            return calories;
        }
    }
}
