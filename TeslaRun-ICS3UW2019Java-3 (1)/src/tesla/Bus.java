package tesla;

import processing.sound.SoundFile;
import processing.core.PImage;

/**
 * {@code Bus} Class. Responsible for creating Bus objects.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */
public class Bus extends ElectricV{

    // Constructors
    /**
     * Constructor to intialize the {@link Bus}'s values to appropiate
     * parameters
     *	
	 * @param modelName	The model name of the {@link Bus} (String)
	 * @param wrldMan	The world manufacturer of the {@link Bus}
	 * @param year		The manufacturer year name of the {@link Bus} (Integer)
	 * @param numDoors	The number of doors of the {@link Bus} (Integer)
	 * @param numWheels	The number of wheels of the {@link Bus} (Integer)
	 *
	 * @param horsepowerThe horsepower of the {@link Bus} (Integer)
	 * @param price		The price of the {@link Bus} (Float)
	 * @param isSelfDriving	The self-driving capability of the {@link Bus} (Boolean)
	 * @param sound		The sound of the {@link Bus}
	 * @param image		The image of the {@link Bus}
	 * @param x		The x-coordinate of the image of the {@link Bus} (Float)
	 * @param y		The y-coordinate of the image of the {@link Bus} (Float)
	 * @param w		The width of the image of the {@link Bus} (Float)
	 * @param h		The height of the {@link Bus} (Float)
	 **/

    public Bus(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, float x, float y, float w, float h){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound,img,x,y,w,h);
    }

    /**
     * Constructor to intialize the {@link Bus}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Bus} (String)
     * @param wrldMan       The world manufacturer of the {@link Bus}
     * @param year          The manufacturer year name of the {@link Bus} (Integer)
     * @param numDoors      The number of doors of the {@link Bus} (Integer)
     * @param numWheels     The number of wheels of the {@link Bus} (Integer)
     *
     * @param horsepower	The horsepower of the {@link Bus} (Integer)
     * @param price         The price of the {@link Bus} (Float)
     * @param isSelfDriving The self-driving capability of the {@link Bus} (Boolean)
     * @param sound         The sound of the {@link Bus}
     */
    public Bus(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    /**
     * Constructor to intialize the {@link Bus}'s values to appropiate parameters
     * 
     * @param modelName     The model name of the {@link Bus} (String)
     * @param numDoors      The number of doors of the {@link Bus} (Integer)
     * @param numWheels     The number of wheels of the {@link Bus} (Integer)
     *
     * @param horsepower	The horsepower of the {@link Bus} (Integer)
     * @param price         The price of the {@link Bus} (Float)
     * @param sound         The sound of the {@link Bus}
     * @param image         The image of the {@link Bus}
     * @param x             The x-coordinate of the image of the {@link Bus} (Float)
     * @param y             The y-coordinate of the image of the {@link Bus} (Float)
     * @param w             The width of the image of the {@link Bus} (Float)
     * @param h             The height of the {@link Bus} (Float)
     */
    public Bus(String modelName, int numDoors, int numWheels, int horsePower, float price, SoundFile sound, PImage img, float x, float y, float w, float h){
        this(modelName, WorldManufacturer.US, 2013, numDoors, numWheels, horsePower, price, false, sound, img, x, y, w, h);
    }

    /**
     * Constructor to intialize the {@link Bus} given no parameters.
     */
	public Bus(){
		super("UNKNOWN", WorldManufacturer.US, 2013, 2, 4, 0, 0f, false, null);
	}

    /**
     * Compares the price of two Bus objects
     * 
     * @param other Explicit Bus object
     * @returns 0 if price is the same, 1 if implicit price is greater than explicit
     *          price and returns -1 if explicit price is greater than implicit
     *          price.
     */
	public int compareTo(Bus other){
		if(this.getPrice()==other.getPrice()){
			return 0;
		}else if(this.getPrice()>other.getPrice())
			return 1;
		else{
			return -1;
		}
	}

}