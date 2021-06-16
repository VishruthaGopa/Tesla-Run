package tesla;

import processing.sound.SoundFile;
import processing.core.PImage;

/**
 * {@code Truck} Class. Responsible for creating Truck objects.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */
public class Truck extends ElectricV{
	
    /**
     * Constructor to intialize the {@link Truck}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Truck} (String)
     * @param wrldMan       The world manufacturer of the {@link Truck}
     * @param year          The manufacturer year name of the {@link Truck}
     *                      (Integer)
     * @param numDoors      The number of doors of the {@link Truck} (Integer)
     * @param numWheels     The number of wheels of the {@link Truck} (Integer)
     * @param horsepower	The horsepower of the {@link Truck} (Integer)
     * @param price         The price of the {@link Truck} (Float)
     * @param isSelfDriving The self-driving capability of the {@link Truck}
     *                      (Boolean)
     * @param sound         The sound of the {@link Truck}
     * @param image         The image of the {@link Truck}
     * @param x             The x-coordinate of the image of the {@link Truck}
     *                      (Float)
     * @param y             The y-coordinate of the image of the {@link Truck}
     *                      (Float)
     * @param w             The width of the image of the {@link Truck} (Float)
     * @param h             The height of the {@link Truck} (Float)
     */
    public Truck(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, float x, float y, float w, float h){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound,img,x,y,w,h);
    }

	/**
     * Constructor to intialize the {@link Truck}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Truck} (String)
     * @param wrldMan       The world manufacturer of the {@link Truck}
     * @param year          The manufacturer year name of the {@link Truck}
     *                      (Integer)
     * @param numDoors      The number of doors of the {@link Truck} (Integer)
     * @param numWheels     The number of wheels of the {@link Truck} (Integer)
     * @param horsepower	The horsepower of the {@link Truck} (Integer)
     * @param price         The price of the {@link Truck} (Float)
     * @param isSelfDriving The self-driving capability of the {@link Truck}
     *                      (Boolean)
     * @param sound         The sound of the {@link Truck}
     */
    public Truck(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

	/**
     * Constructor to intialize the {@link Truck}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Truck} (String)
     * @param numDoors      The number of doors of the {@link Truck} (Integer)
     * @param numWheels     The number of wheels of the {@link Truck} (Integer)
     * @param horsepower	The horsepower of the {@link Truck} (Integer)
     * @param price         The price of the {@link Truck} (Float)
     * @param sound         The sound of the {@link Truck}
     * @param image         The image of the {@link Truck}
     * @param x             The x-coordinate of the image of the {@link Truck}
     *                      (Float)
     * @param y             The y-coordinate of the image of the {@link Truck}
     *                      (Float)
     * @param w             The width of the image of the {@link Truck} (Float)
     * @param h             The height of the {@link Truck} (Float)
     */
    public Truck(String modelName, int numDoors, int numWheels, int horsePower, float price, SoundFile sound, PImage img, float x, float y, float w, float h){
        this(modelName, WorldManufacturer.US, 2013, numDoors, numWheels, horsePower, price, false, sound, img, x, y, w, h);
    }

    /**
     * Constructor to intialize the {@link Truck} given no parameters.
     */
	public Truck(){
		super("UNKNOWN", WorldManufacturer.US, 2013, 4, 4, 0, 0f, false,null);
	}

    /**
     * Compares the price of two Truck objects
     * 
     * @param other Explicit Truck object
     * @returns 0 if price is the same, 1 if implicit price is greater than explicit
     *          price and returns -1 if explicit price is greater than implicit
     *          price.
     */
	public int compareTo(Truck other){
		if(this.getPrice()==other.getPrice()){
			return 0;
		}else if(this.getPrice()>other.getPrice())
			return 1;
		else{
			return -1;
		}
	}

}