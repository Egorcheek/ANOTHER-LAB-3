package environment.objects;

public class Dew implements TouchableObject {
    final int textureLevel = 2;
    public int beTouched() {
        return textureLevel;
    }
}
