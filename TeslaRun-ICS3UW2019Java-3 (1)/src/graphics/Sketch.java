package graphics;

import tesla.*;
import java.io.*;
import processing.core.*;
import processing.sound.*;
import java.util.Calendar;
import java.io.*;

/**
 * Creates a GUI.
 *
 * @authors Swarnava Ghosh
 * @authors Vishrutha Gopa
 */
public class Sketch extends PApplet {

	public static PApplet pa;

    private static enum State{
        CAR_MENU, MANUFACTURER_MENU, SELF_DRIVING_MENU, YEAR_MENU, CONFIRM, SHOW_BUY_INFO, BUY_ANOTHER_VEHICLE;
    }

	PImage[] image = new PImage[5]; //Five different cars
	Vehicle[] car;
    List modelChoices;
    List wrldManChoices;
    List selfDriveChoices;
    List yearChoices;
    Button confirm;
    Button buy;
	Button buyAnother;
	Button quit;

    SoundFile file;
    PrintWriter receipt;
    public State state;
    ElectricV toBuy;

    /**
     * Creates the size of the GUI and intializes the <code>car</code> array.
     */
    @Override
	public void settings(){
		size(800, 400); //Keep this constant please
		pa = this;
		car = new Vehicle[5];
	}

    /**
     * Sets background, loads, images, soundfile, and calls button generating methods.
     */
    @Override
    public void setup(){
        background(128);

        Rectangle r = new Rectangle();

        state = State.CAR_MENU;
        SoundFile tmpSound;
        
        file = new SoundFile(this,"res/sounds/sound.wav");

        tmpSound = new SoundFile(this, "res/sounds/sound.wav");

        image[0] = loadImage("res/images/model3.png");
        car[0] = new Car("Model 3", 4, 4, 480, 44_999f, tmpSound, image[0], width+100,height/2-50,200,130);

        image[1] = loadImage("res/images/modelX.png");
        car[1] = new Car("Model X", 4, 4, 1021, 123_600f, tmpSound, image[1], width+100,height/2-50,200,100);

        image[2] = loadImage("res/images/cybertruck.png");
        car[2] = new Truck("Cybertruck", 4, 4, 690, 59_900f, tmpSound, image[2],width+100,height/2-50,250,170);

        image[3] = loadImage("res/images/semitruck-new.png");
        car[3] = new Truck("SemiTruck", 2, 6, 760, 165_000f, tmpSound,image[3],width+100,height/2-50,200,120);

        image[4] = loadImage("res/images/bus.png");
        car[4] = new Bus("Tesla Bus", 2, 4, 510, 374_999f, tmpSound, image[4],width+100,height/2-50,200,100);


    	textAlign(CENTER, CENTER);

        generateCarButtons();
        generateSelfDrivingButtons();
        generateWrldManButtons();
        generateYearButtons();

        generateBuyButton();
		generateBuyAnother();
		generateQuitButton();

        confirm = new Button("Confirm", 590, 50, 110, 50, 148, 232, 102, ()->{});

        try{
            FileWriter fw = new FileWriter("Receipt.txt", false);
            receipt = new PrintWriter(fw, true);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


    /**
     * Generates Car Buttons
     */
    private void generateCarButtons(){
        modelChoices = new List(car.length, 50, 50, 110, 50);
        for(int i = 0; i < car.length; i++){
            ElectricV ev = (ElectricV)car[i];
            modelChoices.setTitle(i, ev.getModelName());
        }
    }

    /**
     * Generates World Manufacturer Buttons
     */
    private void generateWrldManButtons(){
        wrldManChoices = new List(2, 185, 50, 110, 50);
        wrldManChoices.setTitle(0, WorldManufacturer.US.name());
        wrldManChoices.setTitle(1, WorldManufacturer.CHINA.name());
    }

    /**
     * Generates Self-Driving Buttons
     */
    private void generateSelfDrivingButtons(){
        selfDriveChoices = new List(2, 320, 50, 110, 50);
        selfDriveChoices.setTitle(0, "Self-Driving");
        selfDriveChoices.setTitle(1, "Not-Self-Driving");
    }

    /**
     * Generates Year Buttons
     */
    private void generateYearButtons(){
        int nYears = 1 + Calendar.getInstance().get(Calendar.YEAR) - 2013;
        yearChoices = new List(nYears, 455, 50, 110, 30);
        for(int i = 0; i < nYears; i++){
            yearChoices.setTitle(i, ""+(2013+i));
        }
    }

    /**
     * Generates Buy Button
     */
    private void generateBuyButton(){
        buy = new Button(
            "Buy",
            600, 50,
            110, 30,
            148, 232, 102,
            ()->{
                receipt.println(toBuy);
                state = State.BUY_ANOTHER_VEHICLE;
            }
        );
    }

    /**
     * Generates Buy Another Button
     */
    private void generateBuyAnother(){
        buyAnother = new Button(
            "Buy another Vehicle",
            600, 90,
            110, 30,
            148, 232, 102,
            ()->{}
        );
    }

    /**
     * Generates Quit Button
     */
	private void generateQuitButton(){
        quit = new Button(
            "Quit",
            600, 130,
            110, 30,
            148, 232, 102,
            ()->{
                exit();
            }
        );

	}

    /**
     * Exits.
     */
    @Override
    public void exit(){
        receipt.close();
        super.exit();
    }
	
	
	/**
     * Outputs the specs on the PApplet
     */
	private void outputDetailsScreen() {
		toBuy.show();
		toBuy.move();

		text(toBuy.toString(), 10f, 10f, 300f, 400f);
		fill(0, 102, 153);

	}

	/**
     * Output to the GUI when <code>state</code> is changed.
     */
    @Override
    public void draw(){
        
        background(128);

        switch(state){
		case BUY_ANOTHER_VEHICLE:
			outputDetailsScreen();
            buyAnother.show();
			quit.show();
            textSize(12);
            text("Bought!", 600, 50, 110, 30);
			break;
		case SHOW_BUY_INFO:
			outputDetailsScreen();
            buy.show();
            break;
        case CONFIRM:
            confirm.show();
		case YEAR_MENU:
            yearChoices.show();
        case SELF_DRIVING_MENU:
            selfDriveChoices.show();
        case MANUFACTURER_MENU:
            wrldManChoices.show();
        case CAR_MENU:
            modelChoices.show();
		}

        if(Button.active != null) cursor(HAND);
        else cursor(ARROW);

    }

    /**
     * Actions done after a mouse has clicked a button.
     */
    @Override
    public void mouseClicked()
    {
        boolean handled = true;

        if(state.ordinal() <= State.CONFIRM.ordinal()){
        
            if(modelChoices.mouseClicked()){

                toBuy = (ElectricV)car[modelChoices.getChoice()];
                state = State.MANUFACTURER_MENU;

                wrldManChoices.resetChoice();
                selfDriveChoices.resetChoice();
                yearChoices.resetChoice();

            }else if(wrldManChoices.mouseClicked()){

                switch(wrldManChoices.getChoice()){
                case 0:
                    toBuy.setWrldMan(WorldManufacturer.US);
                    break;
                case 1:
                    toBuy.setWrldMan(WorldManufacturer.CHINA);
                    break;
                }
                state = State.SELF_DRIVING_MENU;
                selfDriveChoices.resetChoice();
                yearChoices.resetChoice();
            
            }else if(selfDriveChoices.mouseClicked()){

                switch(selfDriveChoices.getChoice()){
                case 0:
                    toBuy.enableSelfDriving();
                    break;
                case 1:
                    toBuy.disableSelfDriving();
                    break;
                }
                state = State.YEAR_MENU;
                yearChoices.resetChoice();

            }else if(yearChoices.mouseClicked()){

                toBuy.setYear(yearChoices.getChoice()+2013);
                state = State.CONFIRM;
            
            }else if(confirm.mouseClicked()){

                state = State.SHOW_BUY_INFO;
                file.play();

            }else handled = false;
            
        }else if(buyAnother.mouseClicked() && state == State.BUY_ANOTHER_VEHICLE){
            state = State.CAR_MENU;
            toBuy.newSerial();
            toBuy.x = width+100;
            toBuy.y = height/2-50;
            toBuy = null;
            modelChoices.resetChoice();
        
        }else handled = false;
        
        if(!handled && Button.active != null) Button.active.mouseClick();

    }

}

