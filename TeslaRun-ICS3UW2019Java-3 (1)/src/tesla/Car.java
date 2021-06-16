package tesla;

import processing.sound.SoundFile;
import processing.core.PImage;
/**
 * {@code Car} Class. Responsible for creating Car objects.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */

public class Car extends ElectricV{

    // Constructors

    /**
     * Constructor to intialize the {@link Car}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Car} (String)
     * @param wrldMan       The world manufacturer of the {@link Car}
     * @param year          The manufacturer year name of the {@link Car} (Integer)
     * @param numDoors      The number of doors of the {@link Car} (Integer)
     * @param numWheels     The number of wheels of the {@link Car} (Integer)
     *
     * @param horsepower	The horsepower of the {@link Car} (Integer)
     * @param price         The price of the {@link Car} (Float)
     * @param isSelfDriving The self-driving capability of the {@link Car} (Boolean)
     * @param sound         The sound of the {@link Car}
     * @param image         The image of the {@link Car}
     * @param x             The x-coordinate of the image of the {@link Car} (Float)
     * @param y             The y-coordinate of the image of the {@link Car} (Float)
     * @param w             The width of the image of the {@link Car} (Float)
     * @param h             The height of the {@link Car} (Float)
     */
    public Car(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, float x, float y, float w, float h){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound,img,x,y,w,h);
    }

    /**
     * Constructor to intialize the {@link Car}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Car} (String)
     * @param wrldMan       The world manufacturer of the {@link Car}
     * @param year          The manufacturer year name of the {@link Car} (Integer)
     * @param numDoors      The number of doors of the {@link Car} (Integer)
     * @param numWheels     The number of wheels of the {@link Car} (Integer)
     *
     * @param horsepower	The horsepower of the {@link Car} (Integer)
     * @param price         The price of the {@link Car} (Float)
     * @param isSelfDriving The self-driving capability of the {@link Car} (Boolean)
     * @param sound         The sound of the {@link Car}
     */
    public Car(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    /**
     * Constructor to intialize the {@link Car}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Car} (String)
     * @param numDoors      The number of doors of the {@link Car} (Integer)
     * @param numWheels     The number of wheels of the {@link Car} (Integer)
     *
     * @param horsepower	The horsepower of the {@link Car} (Integer)
     * @param price         The price of the {@link Car} (Float)
     * @param sound         The sound of the {@link Car}
     * @param image         The image of the {@link Car}
     * @param x             The x-coordinate of the image of the {@link Car} (Float)
     * @param y             The y-coordinate of the image of the {@link Car} (Float)
     * @param w             The width of the image of the {@link Car} (Float)
     * @param h             The height of the {@link Car} (Float)
     */
    public Car(String modelName, int numDoors, int numWheels, int horsePower, float price, SoundFile sound, PImage img, float x, float y, float w, float h){
        this(modelName, WorldManufacturer.US, 2013, numDoors, numWheels, horsePower, price, false, sound, img, x, y, w, h);
    }

    /**
     * Constructor to intialize the {@link Car} given no parameters.
     */
	public Car(){
		super("UNKNOWN", WorldManufacturer.US, 2013, 4, 4, 0, 0f, false,null);
	}

    /**
     * Compares the price of two Car objects
     * 
     * @param other Explicit Car object
     * @returns 0 if price is the same, 1 if implicit price is greater than explicit
     *          price and returns -1 if explicit price is greater than implicit
     *          price.
     */
	public int compareTo(Car other){
		if(this.getPrice()==other.getPrice()){
			return 0;
		}else if(this.getPrice()>other.getPrice())
			return 1;
		else{
			return -1;
		}
	}
}