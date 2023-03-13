package interfaces;

import person.Adult;
import person.Person;

public interface AbleToEatDish {
    void eat(Person ... person);
    void whatEat(Adult.Dish ... food);
}
