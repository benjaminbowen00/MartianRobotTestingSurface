import java.util.ArrayList;
import java.util.Arrays;

public class Surface {

    private ArrayList<Integer> maxSize;
    private ArrayList<ArrayList<Integer>> offSurface;

    public Surface(Integer xMax, Integer yMax){
        this.maxSize = new ArrayList<>(Arrays.asList(xMax, yMax));
        this.offSurface = new ArrayList<>();
    }

    public ArrayList<Integer> getMaxSize() {
        return maxSize;
    }

    public ArrayList<ArrayList<Integer>> getOffSurfaceCoords() {
        return offSurface;
    }

    public void markPositionOffSurface(ArrayList<Integer> position){
        this.offSurface.add(position);

    }
}
