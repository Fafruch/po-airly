public class OutColor {
    private static final String redSwitch = (char)27 + "[31m";
    private static final String greenSwitch = (char)27 + "[32m";
    private static final String yellowSwitch = (char)27 + "[33m";
    private static final String blueSwitch = (char)27 + "[34m";
    private static final String greySwitch = (char)27 + "[37m";
    private static final String whiteSwitch = (char)27 + "[39m";

    public static void switchTo(Color color) {
        switch(color) {
            case RED: System.out.print(redSwitch);
                break;
            case GREEN: System.out.print(greenSwitch);
                break;
            case YELLOW: System.out.print(yellowSwitch);
                break;
            case BLUE: System.out.print(blueSwitch);
                break;
            case GREY: System.out.print(greySwitch);
                break;
            case WHITE: System.out.print(whiteSwitch);
        }
    }
}