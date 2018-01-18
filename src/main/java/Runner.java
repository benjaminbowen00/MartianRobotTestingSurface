import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.println("Enter the dimensions of the top right hand corner in the form x y");
        String surfaceDimString = user_input.nextLine();

        String[] dimArray = surfaceDimString.split(" ");

        Surface surface = new Surface(Integer.parseInt(dimArray[0]), Integer.parseInt(dimArray[1]));

        String startPoint = "";
        String directions = "";

        while(true){

            System.out.println("Enter the starting point and direction in the form x y D");
            startPoint = user_input.nextLine();
            if(startPoint.equals("q")){break;}
            String[] robotStart = startPoint.split(" ");

            System.out.println("Enter the directions e.g. FFLRFLR");
            directions = user_input.nextLine();
            if(directions.equals("q")){break;}

            Robot robot = new Robot(Integer.parseInt(robotStart[0]), Integer.parseInt(robotStart[1]), robotStart[2], directions);
            Explore explore = new Explore(surface, robot);

            System.out.println("\nThe output is: " +explore.outputStatement()+"\n");

        };









    }
}
