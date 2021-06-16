package graphics;

import processing.core.*;

// Rectangle class
public class Rectangle{

    
	private static PApplet pa = Sketch.pa;

	public float x; // X coordinate
	public float y; // Y coordinate
	public float w; // Width
	public float h; // Height

    /**
     * Constructs a {@link Rectangle} object at the origin with 0 width and height.
     */
	public Rectangle() {
		this(0,0,0,0);		
	}
    
    /**
     * Constructor to intialize the {@link Rectangle}'s values to appropiate
     * parameters
     * 
     * @param x The x-coordinate of the image of the {@link Rectangle} (Float)
     * @param y The y-coordinate of the image of the {@link Rectangle} (Float)
     * @param w The width of the image of the {@link Rectangle} (Float)
     * @param h The height of the {@link Rectangle} (Float)
     */
	public Rectangle(float x, float y, float w, float h) {
		this.x = x;		
		this.y = y;
		this.w = w;
		this.h = h;
	}

    /**
     * Moves image to the center if the screen.
     */
	public void move(){
		boolean notAtCenter = this.x>pa.width/2-this.w/2;
		if(notAtCenter)
			this.x = this.x-5; //Move left
	}
    
    /**
     * @return whether the mouse is hoverring over this rectangle or not
     */
    boolean mouseHover(){
        return pa.mouseX > x && pa.mouseX < x+w && pa.mouseY > y && pa.mouseY < y+h;
    }

    /**
     * Checks whether the mouse was clicked or not, and if it was, it runs the
     * mouseClick() method
     * 
     * @return whether the mouse was clicked or not
     */
    boolean mouseClicked(){
        if(mouseHover()){
            mouseClick();
            return true;
        }
        return false;
    }

	void mouseClick(){}

}