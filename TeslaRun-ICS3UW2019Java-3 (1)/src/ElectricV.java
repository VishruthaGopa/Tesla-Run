import processing.sound.SoundFile;
import processing.core.*;
import java.lang.StringBuilder;
import java.util.Calendar;
import processing.core.PImage;

enum WorldManufacturer{
    US("5YJ", 'F'), CHINA("LRW", 'C');
    String id;
    char c;
    WorldManufacturer(String id, char c){
        this.id = id;
        this.c = c;
    }
}

class ElectricV extends Vehicle implements Comparable<ElectricV>{

	private static int activeSerialNum=10000;

    protected String modelName;
    protected String modelNum;
    protected WorldManufacturer wrldMan;
    protected int year;
    protected int numDoors;
    protected int numWheels;
    private int horsePower;
	private float price;
	private int serial;
	private boolean isSelfDriving;
	private String vin;
    public SoundFile sound;
	
    // private ElectricV(String modelName,String modelNum, int year,int numDoors,int numWheels, int horsePower, float price, int serial, boolean isSelfDriving, String vin, SoundFile sound){

    //     super();

    //     checkYear(year);
        
    //     this.modelName = modelName.toUpperCase();
    //     this.modelNum = modelNum;
    //     this.year = year;
    //     this.numDoors = numDoors;
    //     this.numWheels = numWheels;
    //     this.horsePower = horsePower;
    //     this.price = price;
    //     this.serial = serial;
    //     this.isSelfDriving = isSelfDriving;
    //     this.sound = sound;
    //     this.vin = vin;
    // }

    ElectricV(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, int x, int y, int w, int h){

        super(img, x, y, w, h);

        construct(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
        
    }

    ElectricV(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){

        super();

        construct(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    ElectricV(){
        this("UNKNOWN", WorldManufacturer.US, 2013, 0, 0, 0, 0f, false, null);
    }

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

    private void recreateVIN(){

        char yearChar = (char)((int)'D' + (year-2013));
        if(yearChar >= 'I') yearChar++;

        vin = wrldMan.id + modelNum + 'X' + yearChar + wrldMan.c + serial;
    }

    // Accessor methods

    String getModelName(){return modelName;}
    String getModelNum(){return modelNum;}
    WorldManufacturer getWrldMan(){return wrldMan;}
    int getYear(){return year;}
    int getNumDooors(){return numDoors;}
    int getNumWheels(){return numWheels;}
    int getHorsePower(){return horsePower;}
    float getPrice(){return price;}
    int getSerial(){return serial;}
    boolean isSelfDriving(){return isSelfDriving;}
    String getVIN(){return vin;}
    SoundFile getSound(){return sound;}

    // Mutator methods

    void setModelName(String newModelName){
        modelName = newModelName.toUpperCase();
    }
    void setYear(int newYear){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(newYear < 2013 || newYear > currentYear)
            throw new IllegalArgumentException("year must be at least 2013 and at most "+currentYear+"! Provided: "+newYear);
        this.year = newYear;
    }
    void setNumDoors(int newNumDoors){
        assertPositive(newNumDoors, "Number of doors");
        numDoors = newNumDoors;
    }
    void setNumWheels(int newNumWheels){
        assertPositive(newNumWheels, "Number of wheels");
        numWheels = newNumWheels;
    }
    void setHorsePower(int newHorsePower){
        assertPositive(newHorsePower, "Horse power");
        horsePower = newHorsePower;
    }
    void setPrice(float newPrice){
        assertPositive(newPrice, "Price");
        price = newPrice;
    }
    void setSelfDriving(boolean isSelfDriving){
        this.isSelfDriving = isSelfDriving;
    }
    void setSound(SoundFile newSound){
        sound = newSound;
    }
    void setWrldMan(WorldManufacturer newWrldMan){
        wrldMan = newWrldMan;
        recreateVIN();
    }

    void enableSelfDriving(){isSelfDriving = true;}
    void disableSelfDriving(){isSelfDriving = false;}
    void toggleSelfDriving(){isSelfDriving ^= true;}

    private void assertPositive(int provided, String label){
        if(provided < 0)
            throw new IllegalArgumentException(label+" must be a positive integer! Provided: "+provided);
    }
    private void assertPositive(float provided, String label){
        if(provided < 0f)
            throw new IllegalArgumentException(label+" must be a positive float! Provided: "+provided);
    }

	private static String randomAlphaNumeric(){
		final String ALPHA_NUMERIC_STRING= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder(5);
        for(int i = 0; i < builder.length(); i++){
            int randIndex = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.insert(i, ALPHA_NUMERIC_STRING.charAt(randIndex));
        }
		return builder.toString();
	}

    @Override
	public String toString(){
		String formatted="";
		formatted+= "Model Name: "+ modelName;
		formatted+= "\nModel Number"+ modelNum;
		formatted+= "\nManufacturer Year"+ year;
		formatted+= "\nNumber of Doors: "+numDoors;
		formatted+= "\nNumber of Wheels: "+numWheels;
		formatted+= "\nHorsepower: "+ horsePower;
		formatted+= "\nSerial Number: "+ serial;
		formatted+= "\nIs self-driving? "+ isSelfDriving;
		formatted+= "\nVIN: "+ vin;

		return formatted;
	}

    @Override
	public int compareTo(ElectricV other){
      //  return 1; // temporary

		// int nYear = this.year.compareTo(other.year);
     	
		// return nYear == 0 ? this.year.compareTo(other.year) : nYear;

		if(this.year==other.year){
			return 0;
		}else if(this.year>other.year)
			return 1;
		else{
			return -1;
		}

	}

	

}