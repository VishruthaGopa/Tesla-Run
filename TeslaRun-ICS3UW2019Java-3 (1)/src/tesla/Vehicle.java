package tesla;

import processing.core.*;
import graphics.*;

public class Vehicle extends Rectangle{

	PImage img;
	private static PApplet pa = Sketch.pa;

    /**
     * Constructor to intialize the {@link Vehicle}'s values to appropiate
     * parameters
     * 
     * @param image         The image of the {@link Vehicle}
     * @param x 			The x-coordinate of the image of the {@link Vehicle} (Float)
     * @param y 			The y-coordinate of the image of the {@link Vehicle} (Float)
     * @param w 			The width of the image of the {@link Vehicle} (Float)
     * @param h 			The height of the {@link Vehicle} (Float)
     */

	public Vehicle(PImage img, float x, float y, float w, float h){
		super(x,y,w,h); //Creating the rectangle
		this.img = img;
	}

	//Functionality to show
    
	/**
     * Displays image.
     */
	public void show(){
		pa.image(img,x,y,w,h);
	}

    /**
     * Default constructor
     */
	public Vehicle(){
    	super();
  	}


}