import java.awt.*;

public class Gradient {
    float[] startColor;
    float[] endColor;

    Gradient(Color color1, Color color2) {
        this(new float[]{color1.getRed() / 255f, color1.getGreen() / 255f, color1.getBlue() / 255f},
             new float[]{color2.getRed() / 255f, color2.getGreen() / 255f, color2.getBlue() / 255f});
    }

    Gradient(float[] color1, float[] color2) {
        startColor = color1;
        endColor = color2;
    }

    float[] get(float position) {
        return new float[] {
            get(position, startColor[0], endColor[0]),
            get(position, startColor[1], endColor[1]),
            get(position, startColor[2], endColor[2])
        };
    }

    private float get(float position, float color1, float color2) {
        return color2 + (color1 - color2) * position;
    }
}
