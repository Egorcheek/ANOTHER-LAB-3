package environment;
import environment.*;
import java.util.List;

public class Lawn implements Landscape {
    private List<Landscape> neighbors;
    public List<Landscape> checkAvailablePath() {
        return neighbors;
    }
    public void setNeighbors(List<Landscape> neighbors) {
        this.neighbors = neighbors;
    }
}
