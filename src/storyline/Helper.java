package storyline;

import java.util.Objects;

public class Helper {
private int possibility;

    public int getPossibility() {
        return possibility;
    }
    public void setPossibility(int possibility) {
        this.possibility = possibility;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helper that = (Helper) o;
        if (possibility != that.possibility) return false;
        return Objects.equals(possibility, that.possibility);
    }
    @Override
    public int hashCode(){
        return possibility;
    }


}

