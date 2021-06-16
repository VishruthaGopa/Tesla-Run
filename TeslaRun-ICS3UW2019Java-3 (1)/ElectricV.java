import processing.sound.SoundFile;

class ElectricV extends Vehicle{

    protected String modelName;
    protected String modelNum;
    protected int year;
    protected int numDoors;
    protected int numWheels;
    private int horsePower;
	private float price;
	private int serial;
	private boolean isSelfDriving;
	private String vin;
    public SoundFile sound;

	public String wrldManu;
	public String modlNum;
	public int serialNum=10000;

	
    ElectricV(String modelName,String modelNum,int year,int numDoors,int numWheels, int horsePower, float price, int serial, boolean isSelfDriving, String vin, SoundFile sound){
        this.modelName = modelName;
        this.modelNum = modelNum;
        this.year = year;
        this.numDoors = numDoors;
        this.numWheels = numWheels;
        this.horsePower = horsePower;
        this.price = price;
        this.serial = serial;
        this.isSelfDriving = isSelfDriving;
        this.sound = sound;
        this.vin = vin;
    }

    private String checkModelNum(){
        
    }
}