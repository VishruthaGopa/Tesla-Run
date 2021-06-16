import processing.sound.SoundFile;
import processing.core.PImage;

class Bus extends ElectricV{

    Bus(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, int x, int y, int w, int h){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound,img,x,y,w,h);
    }

    Bus(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    Bus(String modelName, int numDoors, int numWheels, int horsePower, float price, SoundFile sound, PImage img, int x, int y, int w, int h){
        this(modelName, WorldManufacturer.US, 2013, numDoors, numWheels, horsePower, price, false, sound, img, x, y, w, h);
    }

	Bus(){
		super("UNKNOWN", WorldManufacturer.US, 2013, 2, 4, 0, 0f, false, null);
	}

}