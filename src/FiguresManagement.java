import java.awt.*;

public class FiguresManagement {
    Effect effect = new Effect(0);
    static public Gradient color = new Gradient(new Color(0xffffff), new Color(0xffffff));
    static public float radioCorrection = 0;

    void start(int number) {
        effect.timer.restart();
        effect.radioCorrection = radioCorrection;
        effect.color = color;
        effect.start(number);
    }

    void update() {
        effect.update();
    }
}