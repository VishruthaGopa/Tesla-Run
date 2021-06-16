package graphics;

import processing.core.PApplet;

class List extends Rectangle{
    
    private static PApplet pa = Sketch.pa;
    private Button[] buttons = null;
    private int choice = -1;

    /**
     * Default constructor
     */
    List(){
        super();
    }

    /**
     * Constructs a top-down list of {@code length} number of clickable choices
     * 
     * @param length is the number of choices
     * @param x is the x-coordinate of the left edge of the entire list
     * @param y is the y-coordinate of the very top of the list
     * @param w is the width of each button in the list
     * @param h is the height of each button in the list
     */
    List(int length, float x, float y, float w, float h){
        super(x,y,w,h);
        buttons = new Button[length];
        for(int i = 0; i < length; i++){
            buttons[i] = new Button("choice "+(i+1), x, y+(i*h), w, h, 148, 232, 102, ()->{});
        }
    }

    /**
     * @return If the user has picked a choice, it returns the 0-based index of that
     *         choice counting from the top, else return -1.
     */
    int getChoice(){return choice;}

    /**
     * @return the number of choices in this list
     */
    int length(){
        return buttons.length;
    }

    /**
     * Set the title of the {@code i}'th choice
     */
    void setTitle(int i, String title){
        buttons[i].setText(title);
    }

    /**
     * Manually set a choice
     * 
     * @param choice is the choice to be set
     */
    void setChoice(int choice){
        if(this.choice != -1)
            buttons[this.choice].setColor(148, 232, 102);
        if(choice >= 0 && choice < buttons.length){
            this.choice = choice;
            buttons[choice].setColor(227, 210, 123);
        }
    }

    /**
     * Resets the choice to -1
     */
    void resetChoice(){
        if(choice != -1){
            buttons[choice].setColor(148, 232, 102);
            choice = -1;
        }
    }

    @Override
    /**
     * @return Wether the mouse is hoverring over any button in the list
     */
    boolean mouseHover(){
        return 
            pa.mouseX > x && pa.mouseX < x+w &&
            pa.mouseY > y && pa.mouseY < y+(h*buttons.length);
    }

    /**
     * Method to run when mouse is clicked and over the list. Updates the choice
     * based on mouse position
     * 
     * @see List#getChoice()
     */
    @Override
    void mouseClick(){
        setChoice((int)((pa.mouseY - y) / h));
        buttons[choice].mouseClick();
    }

    /**
     * Draws the list on the screen
     */
    void show(){
        for(int i = 0; i < buttons.length; i++)
            buttons[i].show();
    }
    
}