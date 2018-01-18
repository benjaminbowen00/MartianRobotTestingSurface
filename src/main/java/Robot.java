import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.floorMod;

public class Robot {

    private ArrayList<Integer> position;
    private String orientation;
    private String routeDirections;
    private boolean lost;

    public Robot(Integer xStart, Integer yStart, String orientation, String routeDirections) {
        this.position = new ArrayList<>(Arrays.asList(xStart, yStart));

        this.orientation = orientation;
        this.routeDirections = routeDirections;
        this.lost = false;
    }


    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public ArrayList<Integer> getPosition() {
        return position;
    }

    public String getRouteDirections() {
        return routeDirections;
    }

    public void setPosition(ArrayList<Integer> position) {
        this.position = position;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }


    public void turnR(){
        List<String> compassPoints = Arrays.asList("N", "E", "S", "W");
        int currentOrientationIndex = compassPoints.indexOf(this.getOrientation());
        int newOrientationIndex = floorMod(currentOrientationIndex +1, 4);
        this.setOrientation(compassPoints.get(newOrientationIndex));
    }

    public void turnL(){
        List<String> compassPoints = Arrays.asList("N", "E", "S", "W");
        int currentOrientationIndex = compassPoints.indexOf(this.getOrientation());
        int newOrientationIndex = floorMod(currentOrientationIndex -1, 4);
        this.setOrientation(compassPoints.get(newOrientationIndex));
    }

    public void moveF(){
        switch(this.getOrientation()){
            case "N":{Integer newY = this.getPosition().get(1) +1 ;
                this.position.set(1, newY); }
            break;
            case "E": {Integer newX = this.getPosition().get(0) +1 ;
                this.position.set(0, newX); }
            break;
            case"S": {Integer newY = this.getPosition().get(1) -1 ;
                this.position.set(1, newY); }
            break;
            case "W": {Integer newX = this.getPosition().get(0) -1 ;
                this.position.set(0, newX); }
            break;
        }
    }


    public ArrayList<Integer> testF(ArrayList<Integer> currentPosition){
        ArrayList<Integer> currentPosition2 = new ArrayList<>(currentPosition);

        switch(this.getOrientation()){
            case "N":{Integer newY = currentPosition2.get(1) +1 ;
                currentPosition2.set(1, newY);
                return currentPosition2;}

            case "E": {Integer newX = currentPosition2.get(0) +1 ;
                currentPosition2.set(0, newX); return currentPosition2; }

            case"S": {Integer newY = currentPosition2.get(1) -1 ;
                currentPosition2.set(1, newY); return currentPosition2; }

            case "W": {Integer newX = currentPosition2.get(0) -1 ;
               currentPosition2.set(0, newX); return currentPosition2; }
        }
        return currentPosition2;
    }












}
