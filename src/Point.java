import java.util.function.Function;

import static org.lwjgl.opengl.GL11.*;

public class Point {
    static float[] COLOR = {0.5f, 1, 1};
    private final float[] color = COLOR;
    float size = 0.005f;
    float radio = 1f;
    float velocity = 0.1f;
    double x = 0;
    double y = 0;

    void update(double time, Function<Double, Double> getVisualRadio) {
        double angle = (time * velocity * 360) / (2 * Math.PI * radio);
        double visualRadio = getVisualRadio.apply(time);
        x = visualRadio * Math.cos(angle);
        y = visualRadio * Math.sin(angle);
        dinamicRender();
    }

    private void dinamicRender() {
        if (isRenderable()) {
            render();
        }
    }

    boolean isRenderable() {
        return Math.abs(x) < 1 && Math.abs(y) < 1;
    }

    private void render() {
        glBegin(GL_POLYGON);
        glColor3f(color[0], color[1], color[2]);
        renderVertex(1, -1);
        renderVertex(1, 1);
        renderVertex(-1, 1);
        renderVertex(-1, -1);
        glEnd();
    }

    private void renderVertex(double x, double y) {
        glVertex2d(this.x + size * x, this.y + size * y);
    }
}
