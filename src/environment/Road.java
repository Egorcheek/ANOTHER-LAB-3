package environment;

import storyline.Helper;

import java.util.List;
import java.util.Objects;

public class Road implements Landscape {
    private List<Landscape> neighbors;
    public List<Landscape> checkAvailablePath() {
        return neighbors;
    }
    public void setNeighbors(List<Landscape> neighbors) {
        this.neighbors = neighbors;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
