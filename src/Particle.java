import java.util.function.Function;

import static org.lwjgl.opengl.GL11.*;

public class Particle {
    static float[] COLOR = {0.5f, 1, 1};
    static final float velocity = 0.1f;
    static final float size = 0.005f;
    private final float[] color = COLOR;
    public float radio = 1f;
    private double x = 0;
    private double y = 0;

    public void update(double time, Function<Double, Double> getVisualRadioFunction) {
        updatePosition(time, getVisualRadioFunction);
        dynamicRender();
    }

    public void updatePosition(double time, Function<Double, Double> getVisualRadioFunction) {
        double angle = (time * velocity * 360) / (2 * Math.PI * radio);
        x = getVisualRadioFunction.apply(time) * Math.cos(angle);
        y = getVisualRadioFunction.apply(time) * Math.sin(angle);
    }

    private void dynamicRender() {
        if (Math.abs(x) < 1 && Math.abs(y) < 1)
            render();
    }

    private void render() {
        glBegin(GL_POLYGON);
        glColor3f(color[0], color[1], color[2]);
        renderSquare();
        glEnd();
    }

    private void  renderSquare() {
        renderVertex(1, -1);
        renderVertex(1, 1);
        renderVertex(-1, 1);
        renderVertex(-1, -1);
    }

    private void renderVertex(double x, double y) {
        glVertex2d(this.x + size * x, this.y + size * y);
    }
}
