package environment.objects;

import environment.Landscape;

import java.util.List;

public interface TouchableObject {
    int beTouched();
    public List<Landscape> checkAvailability();
    
}
