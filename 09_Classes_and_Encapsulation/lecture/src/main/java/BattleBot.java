public class BattleBot {

    /*
    * Constants
    *
    *
     */
    public static final String DEFAULT_NAME = "N/A "; // Make constants for use later for values
    public static final double DEFAULT_SPEED = 100.0;
    public static final double DEFAULT_WEIGHT = .75;
    public static final String DEFAULT_COLOR = "Flames";
    public static final boolean DEFAULT_HAS_LEGS = true;

    /*
    * Instance Variables
    *
    * Each instance of a BattleBot has these individual attributes:
    */
    private String name; // name of bot
    private double speed; // speed of bot
    private double weight; // weight of bot
    private String color; // color of bot
    private boolean hasLegs; // has legs true or false

    public BattleBot() {
        this(DEFAULT_NAME,DEFAULT_SPEED,DEFAULT_WEIGHT,DEFAULT_COLOR,DEFAULT_HAS_LEGS);
    }

    public BattleBot(String name, double speed, double weight, String color, boolean hasLegs) { // constructor containing all properties
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.color=color;
        this.hasLegs=hasLegs;
    }

    // GETTERS and SETTERS must be public, so they can be accessed
    //getters and setters for instance variables that you want to allow the user to change

    public String getName() { // Getter
        return name;
    }

    public void setName(String name) { // Setter
        this.name = name; // this name is coming in from the parameter of the method
    }

    public double getSpeed() { // Getter
        return speed;
    }

    public void setSpeed(double speed) { // Setter
        this.speed = speed;
    }

    public double getWeight() { // Getter
        return weight;
    }

    public void setWeight(double weight) { // Setter
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color=color;
    }

    public boolean getHasLegs() {
        return hasLegs;
    }

    public void setHasLegs(boolean hasLegs) {
        this.hasLegs = hasLegs;
    }

    //METHOD
    public double getPushPower() {
        double pushPower = 0; //set starting spot for push power
        double flamesAdvantage = 0; //flames double increases potential push power
        if (getColor().equals("Flames")) { //if it contains "flames" in the color
            flamesAdvantage = .25; // value of flames advantage
        }
        pushPower = getWeight() * (getSpeed() + flamesAdvantage); // push power is equal to the weight * (speed + flames)
        return pushPower;
    }
}
