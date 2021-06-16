import processing.sound.SoundFile;
import processing.core.PImage;

class Car extends ElectricV{

    Car(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound, PImage img, int x, int y, int w, int h){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound,img,x,y,w,h);
    }

    Car(String modelName, WorldManufacturer man, int year, int numDoors, int numWheels, int horsePower, float price, boolean isSelfDriving, SoundFile sound){
        super(modelName,man,year,numDoors,numWheels,horsePower,price,isSelfDriving,sound);
    }

    Car(String modelName, int numDoors, int numWheels, int horsePower, float price, SoundFile sound, PImage img, int x, int y, int w, int h){
        this(modelName, WorldManufacturer.US, 2013, numDoors, numWheels, horsePower, price, false, sound, img, x, y, w, h);
    }

	Car(){
		super("UNKNOWN", WorldManufacturer.US, 2013, 4, 4, 0, 0f, false,null);
	}

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