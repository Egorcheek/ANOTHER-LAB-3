package environment.objects;

public class Carpet implements TouchableObject {
    final int textureLevel = 2;
    public int beTouched() {
        return textureLevel;
    }
}
