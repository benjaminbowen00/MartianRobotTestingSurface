import java.util.ArrayList;

public class Explore {

    Surface surface;
    Robot robot;

    public Explore(Surface surface, Robot robot) {
        this.surface = surface;
        this.robot = robot;
    }

    public boolean onSurface(ArrayList<Integer> location){
        return (onSurfaceX(location) && onSurfaceY(location));
    }
    public boolean onSurfaceY(ArrayList<Integer> location){
        return (location.get(1) >= 0 && location.get(1) <= surface.getMaxSize().get(1));
    }

    public boolean onSurfaceX(ArrayList<Integer> location){
        return (location.get(0) >= 0 && location.get(0) <= surface.getMaxSize().get(0));
    }

    public boolean checkIfMarked(ArrayList<Integer> location){
        return surface.getOffSurfaceCoords().contains(location);
    }

    public void followDirections(){
        for(char letter : robot.getRouteDirections().toCharArray()){
            if (!robot.isLost()) {
                switch (letter) {
                    case 'R':
                        robot.turnR();
                        break;
                    case 'L':
                        robot.turnL();
                        break;
                    case 'F':
                        ArrayList<Integer> potentialPosition = robot.testF(robot.getPosition());
                        if (checkIfMarked(potentialPosition)){break;}
                        if (!onSurface(potentialPosition)){
                            surface.markPositionOffSurface(potentialPosition);
                            robot.setLost(true);
                            break;
                        }
                        robot.moveF();
                        break;
                        }

                }
            }
        }


    public String isLostString(){
        if(robot.isLost()){return "LOST";}
        return "";
    }

    public String outputStatement(){
        this.followDirections();
        String xFinal = robot.getPosition().get(0).toString();
        String yFinal = robot.getPosition().get(1).toString();
        String outputString = xFinal +" "+ yFinal +" "+ robot.getOrientation() +" "+ this.isLostString();
        return outputString.trim();
    }
}
