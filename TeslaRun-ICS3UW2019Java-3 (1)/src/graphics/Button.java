package graphics;
import processing.sound.SoundFile;
import processing.core.PApplet;

/**
 * Class for using clickable buttons on PApplet window.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */
class Button extends Rectangle{
    
    private static PApplet pa = Sketch.pa;
    private final static SoundFile CLICK = new SoundFile(Sketch.pa, "res/sounds/buttonClick.wav");
    static Button active;
    int rgb;
    private String text;
    private Runnable callback;

	/**
     * Constructor to intialize the {@link Button}'s values to appropiate
     * parameters
     * 
     * @param x 			The x-coordinate of the image of the {@link Button} (Float)
     * @param y 			The y-coordinate of the image of the {@link Button} (Float)
     * @param w 			The width of the image of the {@link Button} (Float)
     * @param h 			The height of the {@link Button} (Float)
     */
    Button(float x, float y, float w, float h) {
        this("Button", x, y, w, h, 148, 232, 102, ()->{});
    }

	/**
     * Constructor to intialize the {@link Button}'s values to appropiate parameters
     * 
     * @param text     The text of the {@link Button} (String)
     * @param x        The x-coordinate of the image of the {@link Button} (Float)
     * @param y        The y-coordinate of the image of the {@link Button} (Float)
     * @param w        The width of the image of the {@link Button} (Float)
     * @param h        The height of the {@link Button} (Float)
     * @param r        The red color component of the {@link Button} (Integer)
     * @param g        The green colour component of the {@link Button} (Integer)
     * @param b        The blue colour component of the {@link Button} (Integer)
     * @param callback Instance of {@code Runnable} to be called upon when mouse is
     *                 clicked
     */
    Button(String text, float x, float y, float w, float h, int r, int g, int b, Runnable callback){
        super(x,y,w,h);
        this.text = text;
        this.callback = callback;
        setColor(r, g, b);
    }
    Button(Button other){
        super(other.x,other.y,other.w,other.h);
        this.text = other.text;
        this.callback = other.callback;
        this.rgb = other.rgb;
    }
    
    /**
     * Sets the color of the button to the specified rgb color
     * 
     * @param r is the red color component
     * @param g is the green color component
     * @param b is the blue color component
     */
    void setColor(int r, int g, int b){
        r &= 0xff;  // trancate any leading digits after 255
        g &= 0xff;
        b &= 0xff;
        rgb = 0xff000000 + (r<<16) + (g<<8) + b;
    }
    
    /**
     * Modify the text on the button
     * 
     * @param text is the text to be displayed
     */
    void setText(String text){this.text = text;}
    void setClallback(Runnable callback){this.callback = callback;}

    /**
     * @return Whether the mouse is hovering over the button or not
     */
    boolean mouseHover(){
        return pa.mouseX > x && pa.mouseX < x+w && pa.mouseY > y && pa.mouseY < y+h;
    }

    /**
     * Actions to do when mouse is clicked on the button
     */
    @Override
    void mouseClick(){
        CLICK.play();
        callback.run();
    }

    /**
     * Displays the button on the screen
     */
    void show(){
        boolean mouseHover = mouseHover();
        pa.stroke(0.3f);
        if(mouseHover){
            active = this;
            fillLighter(rgb);
        }else{
            if(active == this) active = null;
            pa.fill(rgb);
        }
        if(pa.mousePressed && mouseHover){
            pa.strokeWeight(2);
            pa.rect(x+1,y+1,w-2,h-2);
        }
        else{
            pa.strokeWeight(1);
            pa.rect(x,y,w,h);
        }
        pa.textSize(12);
        pa.fill(0,0,0);
        pa.text(text,x,y,w,h);
    }

    /**
     * Computes a lighter color for the button and fills it
     */
    private static void fillLighter(int rgb){
        pa.colorMode(pa.HSB, 360, 100, 100);
        pa.fill(pa.hue(rgb), 0.6f*pa.saturation(rgb), pa.brightness(rgb));
        pa.colorMode(pa.RGB, 255, 255, 255);
    }
}