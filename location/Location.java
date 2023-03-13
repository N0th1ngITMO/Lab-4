package location;

import interfaces.Nameble;

import java.util.ArrayList;


public class Location implements Nameble {
    private final String locationName;
    private final Location partOfSomeOtherLocation;
    private ArrayList<String> partOfTheLocation = new ArrayList<>();

    public Location(String locationName, Location partOfSomeOtherLocation) {
        this.locationName = locationName;
        this.partOfSomeOtherLocation = partOfSomeOtherLocation;
        if(partOfSomeOtherLocation != null){
            partOfSomeOtherLocation.setPartOfTheLocation(locationName);
        }
    }


    public String getName() {
        return locationName;
    }


    public void setPartOfTheLocation(String partOfTheLocation) {
        this.partOfTheLocation.add(partOfTheLocation);
    }
    public String getLocation(int index){
        try {
            return this.partOfTheLocation.get(index);
        }catch (IndexOutOfBoundsException e){
            System.err.println("Hе может находиться в этой локации. Такой локации нет, проверьте правильность индекса");
        }
        return null;
    }

    public Location getPartOfSomeOtherLocation() {
        return partOfSomeOtherLocation;
    }
}
