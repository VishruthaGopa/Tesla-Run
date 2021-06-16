package tesla;

import java.io.*;
import processing.sound.SoundFile;
import processing.core.*;
import java.lang.StringBuilder;
import java.util.Calendar;
import processing.core.PImage;

/**
 * {@code ElectricV} Class. Responsible for creating ElectricV objects.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */
public class ElectricV extends Vehicle implements Comparable<ElectricV>{

	private static int activeSerialNum=100_000;

    protected String modelName;
    protected String modelNum;
    protected WorldManufacturer wrldMan;
    protected int year;
    protected int numDoors;
    protected int numWheels;
    private int horsePower;
	public float price;
	private int serial;
	private boolean isSelfDriving;
	private String vin;
    public SoundFile sound;

    // Constructors

    /**
     * Constructor to intialize the {@link ElectricV}'s values to appropiate
     * parameters
     * 
     * @param modelName     The model name of the {@link ElectricV} (String)
     * @param wrldMan       The world manufacturer of the {@link ElectricV}
     * @param year          The manufacturer year name of the {@link ElectricV}
     *                      (Integer)
     * @param numDoors      The number of doors of the {@link ElectricV} (Integer)
     * @param numWheels     The number of wheels of the {@link ElectricV} (Integer)
     * @param horsepower    The horsepower of the {@link ElectricV} (Integer)
     * @param price         The price of the {@link ElectricV} (Float)
     * @param isSelfDriving The self-driving capability of the {@link ElectricV}
     *                      (Boolean)
     * @param sound         The sound of the {@link ElectricV}
     * @param image         The image of the {@link ElectricV}
     * @param x             The x-coordinate of the image of the {@link ElectricV}
     *                      (Float)
     * @param y             The y-coordinate of the image of the {@link ElectricV}
     *                      (Float)
     * @param w             The width of the image of the {@link ElectricV} (Float)
     * @param h             The height of the {@link ElectricV} (Float)
     */
    public ElectricV(String modelName, WorldManufacturer wrldMan, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, float x, float y, float w, float h){

        super(img, x, y, w, h);

        construct(modelName,wrldMan,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
        
    }


    /**
     * Constructor to intialize the {@link ElectricV}'s values to appropiate
     * parameters
     *
     * @param modelName     The model name of the {@link ElectricV} (String)
     * @param wrldMan       The world manufacturer of the {@link ElectricV}
     * @param year          The manufacturer year name of the {@link ElectricV}
     *                      (Integer)
     * @param numDoors      The number of doors of the {@link ElectricV} (Integer)
     * @param numWheels     The number of wheels of the {@link ElectricV} (Integer)
     * @param horsepowerThe horsepower of the {@link ElectricV} (Integer)
     * @param price         The price of the {@link ElectricV} (Float)
     * @param isSelfDriving The self-driving capability of the {@link ElectricV}
     *                      (Boolean)
     * @param sound         The sound of the {@link ElectricV}
     */
    public ElectricV(String modelName, WorldManufacturer wrldMan, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){

        super();

        construct(modelName,wrldMan,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    /**
     * Constructor that copies {@link ElectricV}'s values to another object.
     */
    public ElectricV(ElectricV other){
        this.modelName = other.modelName;
        this.modelNum = other.modelNum;
        this.year = other.year;
        this.numDoors = other.numDoors;
        this.numWheels = other.numWheels;
        this.horsePower = other.horsePower;
        this.price = other.price;
        this.serial = other.serial;
        this.isSelfDriving = other.isSelfDriving;
        this.sound = other.sound;
        this.vin = other.vin;
        this.img = img;
        this.x = other.x;
        this.y = other.y;
        this.w = other.w;
        this.h = other.h;
    }
	
    /**
     * Constructor to intialize the {@link ElectricV} given no parameters.
     */
    public ElectricV(){
        this("UNKNOWN", WorldManufacturer.US, 2013, 0, 0, 0, 0f, false, null);
    }


    /**
     * @return returns an ElectricV object that is a clone of any currently produced
     *         vehicle and would maintain its specs.
     */
    public static ElectricV makeElectricV(Object o){
        if(o instanceof ElectricV) return new ElectricV((ElectricV)o);
        throw new IllegalArgumentException("parameter not an instance of ElectricV");
    }

    /**
     * @return a new ElectricV with the same specs but different serial number and
     *         VIN
     */
    public ElectricV produceNew(){
        ElectricV ev = new ElectricV(this);
        ev.newSerial();
        return ev;
    }

    /**
     * Instance Method Intializes the model name, world manufacturer, manufacturer
     * year, number of doors, number of wheels, horse power, price, its self-driving
     * capability, sound.
     *
     * @param modelName     The model name of the {@link ElectricV} (String)
     * @param wrldMan       The world manufacturer of the {@link ElectricV}
     * @param year          The manufacturer year name of the {@link ElectricV}
     *                      (Integer)
     * @param numDoors      The number of doors of the {@link ElectricV} (Integer)
     * @param numWheels     The number of wheels of the {@link ElectricV} (Integer)
     *
     * @param horsepowerThe horsepower of the {@link ElectricV} (Integer)
     * @param price         The price of the {@link ElectricV} (Float)
     * @param isSelfDriving The self-driving capability of the {@link ElectricV}
     *                      (Boolean)
     * @param sound         The sound of the {@link ElectricV}
     */
    private void construct(String modelName, WorldManufacturer wrldMan, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){

        setModelName(modelName);
        modelNum = randomAlphaNumeric();
        setYear(year);
        setNumDoors(numDoors);
        setNumWheels(numWheels);
        setHorsePower(horsePower);
        setPrice(price);
        serial = activeSerialNum++;
        setSelfDriving(isSelfDriving);
        setSound(sound);
        
        setWrldMan(wrldMan);
    }

    /**
     * Method that creates the VIN.
     */
    private void recreateVIN(){

        char yearChar = (char)((int)'D' + (year-2013));
        if(yearChar >= 'I') yearChar++;

        vin = wrldMan.id + modelNum + 'X' + yearChar + wrldMan.c + serial;
    }

    // Accessor methods

    public String getModelName(){return modelName;}
    public String getModelNum(){return modelNum;}
    public WorldManufacturer getWrldMan(){return wrldMan;}
    public int getYear(){return year;}
    public int getNumDooors(){return numDoors;}
    public int getNumWheels(){return numWheels;}
    public int getHorsePower(){return horsePower;}
    public float getPrice(){return price;}
    public int getSerial(){return serial;}
    public boolean isSelfDriving(){return isSelfDriving;}
    public String getVIN(){return vin;}
    public SoundFile getSound(){return sound;}


    // Mutator methods

    public void setModelName(String newModelName){
        modelName = newModelName.toUpperCase();
    }
    public void setYear(int newYear){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(newYear < 2013 || newYear > currentYear)
            throw new IllegalArgumentException("year must be at least 2013 and at most "+currentYear+"! Provided: "+newYear);
        this.year = newYear;
    }
    public void setNumDoors(int newNumDoors){
        assertPositive(newNumDoors, "Number of doors");
        numDoors = newNumDoors;
    }
    public void setNumWheels(int newNumWheels){
        assertPositive(newNumWheels, "Number of wheels");
        numWheels = newNumWheels;
    }
    public void setHorsePower(int newHorsePower){
        assertPositive(newHorsePower, "Horse power");
        horsePower = newHorsePower;
    }
    public void setPrice(float newPrice){
        assertPositive(newPrice, "Price");
        price = newPrice;
    }
    public void setSelfDriving(boolean isSelfDriving){
        this.isSelfDriving = isSelfDriving;
    }
    public void setSound(SoundFile newSound){
        sound = newSound;
    }
    public void setWrldMan(WorldManufacturer newWrldMan){
        wrldMan = newWrldMan;
        recreateVIN();
    }

    public void enableSelfDriving(){isSelfDriving = true;}
    public void disableSelfDriving(){isSelfDriving = false;}
    public void toggleSelfDriving(){isSelfDriving ^= true;}
    public void newSerial(){
        serial = activeSerialNum++;
        recreateVIN();
    }

    /**
     * @param provided is the value to check
     * @param label    is an name for the value which is going to be included in the
     *                 error message
     * @throws IllegalArgumentException If {@code provided} is negative.
     */
    private void assertPositive(int provided, String label){
        if(provided < 0)
            throw new IllegalArgumentException(label+" must be a positive integer! Provided: "+provided);
    }

    /**
     * @param provided is the value to check
     * @param label    is an name for the value which is going to be included in the
     *                 error message
     * @throws IllegalArgumentException If {@code provided} is negative.
     */
    private void assertPositive(float provided, String label){
        if(provided < 0f)
            throw new IllegalArgumentException(label+" must be a positive float! Provided: "+provided);
    }

    /**
     * Generates a random AlphaNumeric String
     * 
     * @return AlphaNumeric String
     */
	public static String randomAlphaNumeric(){
		final String ALPHA_NUMERIC_STRING= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder(5);
        for(int i = 0; i < 5; i++){
            int randIndex = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.insert(i, ALPHA_NUMERIC_STRING.charAt(randIndex));
        }
		return builder.toString();
	}
    
    /**
     * Instance method to output {@link ElectricV}'s values in a nicely formatted
     * String. The values output include the model name, the model number, world
     * manufacturer, the manufacturer year, the number of doors, the number of
     * wheels, horsepower, price, serial number, self driving capability, Vehicle
     * Identification Number.
     *
     * @return a String with the {@link ElevtricV}'s specifications into a single
     *         String
     */
    @Override
	public String toString(){
        
		String formatted="";
		formatted += "Model Name: "+ modelName;
		formatted += "\nModel Number: "+ modelNum;
		formatted += "\nManufacturer: "+ wrldMan;
		formatted += "\nManufacture Year: "+ year;
		formatted += "\nNumber of Doors: "+numDoors;
		formatted += "\nNumber of Wheels: "+numWheels;
		formatted += "\nHorsepower: "+ horsePower;
        formatted += String.format("%nPrice: $%,.2f", price);
		formatted += "\nSerial Number: "+ serial;
		formatted += "\nIs self-driving? "+ isSelfDriving;
		formatted += "\nVIN: "+ vin + '\n';

		return formatted;
	}

    /**
     * Checks Year of Manufacture to see if two Vehicle objects have the same year
     * of manufacture
     */
    @Override
	public int compareTo(ElectricV other){
		if(this.year==other.year) return 0;
		else if(this.year>other.year) return 1;
		else return -1;
	}

    /**
     * If argument is an instance of ElectricV, this method checks if all pertinent
     * details are exactly the same except for the VIN and Serial Numbers.
     * 
     * @return Whether the argument is an instance of ElectricV and the details are
     *         exactly the same
     */
    @Override
    public boolean equals(Object other){

        if(other instanceof ElectricV){

            ElectricV oth = (ElectricV)other;

            return 
                this.modelName.equals(oth.modelName)        &&
                this.year == oth.year                       &&
                this.numDoors == oth.numDoors               &&
                this.numWheels == oth.numWheels             &&
                this.horsePower == oth.horsePower           &&
                this.price == oth.price                     &&
                this.isSelfDriving == oth.isSelfDriving;
        }
        return false;
	}

}