public class Main { // Main method
    public static void main(String[] args) { // Class called main
        BattleBot sumoOne = new BattleBot("Sumo1", 100.0, .75, "Flames", true);
        BattleBot sumoTwo = new BattleBot();

//        sumoOne.setColor("Flames");
//        sumoOne.setName("Sumo1");
//        sumoOne.setHasLegs(true); // dont need these as it is in the header
//        sumoOne.setSpeed(100.0);
//        sumoOne.setWeight(.75);

        System.out.println("Push power of " + sumoOne.getName()+ "equals: " + sumoOne.getPushPower());
        System.out.println("Push power of " + sumoTwo.getName()+ "equals: " + sumoTwo.getPushPower());
    }
}
