
public class ratioCalculator {

    public String calcGivenWater(int gramsOfWater, String[] ratio) {

        int waterRatio = Integer.parseInt(ratio[1]);

        int gramsOfCoffee = (gramsOfWater / waterRatio);
        String printString = ("\nFor your given ratio, use " + gramsOfCoffee + " grams of coffee, and " + gramsOfWater + " grams of water.\n");
        return printString;
    }

    public String calcGivenCoffee(int gramsOfCoffee, String[] ratio) {
        int coffeeRatio = Integer.parseInt(ratio[0]);
        int waterRatio = Integer.parseInt(ratio[1]);
        int totalRatio = (waterRatio/coffeeRatio);
        
        int gramsOfWater = (gramsOfCoffee * totalRatio);
        String printString = ("\nFor your given ratio, use " + gramsOfCoffee + " grams of coffee, and " + gramsOfWater + " grams of water.\n");
        return printString;
    }
}