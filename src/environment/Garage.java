package environment;
import java.util.List;

public class Garage implements Landscape {
    private List<Landscape> neighbors;
    public List<Landscape> checkAvailablePath() {
        return neighbors;
    }
    public void setNeighbors(List<Landscape> neighbors) {
        this.neighbors = neighbors;
    }
}
