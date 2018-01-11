public class OutColor {
    private final String redSwitch = (char)27 + "[31m";
    private final String greenSwitch = (char)27 + "[32m";
    private final String yellowSwitch = (char)27 + "[33m";
    private final String blueSwitch = (char)27 + "[33m";
    private final String greySwitch = (char)27 + "[37m";
    private final String whiteSwitch = (char)27 + "[38m";

    public void switchTo(Color color) {
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