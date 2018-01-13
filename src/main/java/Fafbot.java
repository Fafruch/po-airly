public class Fafbot {
    public void happy () {
        OutColor outColor = new OutColor();

        outColor.switchTo(Color.BLUE);
        System.out.println("             ______");
        System.out.println("            /      \\");
        System.out.println("           /  ^  ^  \\");
        System.out.println("           \\  \\__/  /");
        System.out.println("            \\______/");
        System.out.println();
        outColor.switchTo(Color.WHITE);
    }

    public void satisfied () {
        OutColor outColor = new OutColor();

        outColor.switchTo(Color.GREEN);
        System.out.println("             ______");
        System.out.println("            /      \\");
        System.out.println("           /  o  o  \\");
        System.out.println("           \\  .__.  /");
        System.out.println("            \\______/");
        System.out.println();
        outColor.switchTo(Color.WHITE);
    }

    public void joyless () {
        OutColor outColor = new OutColor();

        outColor.switchTo(Color.YELLOW);
        System.out.println("             ______");
        System.out.println("            /      \\");
        System.out.println("           /  o  o  \\");
        System.out.println("           \\  ____  /");
        System.out.println("            \\______/");
        System.out.println();
        outColor.switchTo(Color.WHITE);
    }

    public void dying () {
        OutColor outColor = new OutColor();

        outColor.switchTo(Color.RED);
        System.out.println("             ______");
        System.out.println("            /      \\");
        System.out.println("           /  x  x  \\");
        System.out.println("           \\  .--.  /");
        System.out.println("            \\______/");
        System.out.println();
        outColor.switchTo(Color.WHITE);
    }


    public void confused () {
        OutColor outColor = new OutColor();

        outColor.switchTo(Color.GREY);
        System.out.println("             ______");
        System.out.println("            /      \\");
        System.out.println("           /  ?  ?  \\");
        System.out.println("           \\   --   /");
        System.out.println("            \\______/");
        System.out.println();
        outColor.switchTo(Color.WHITE);
    }
}
