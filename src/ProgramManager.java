import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL.*;

public class ProgramManager {
    long window;
    EffectManager manager = new EffectManager();
    EffectDetailsController input = new EffectDetailsController();

    void init() {
        startWindow();
        input.setParentEffectManager(manager);
        while(!glfwWindowShouldClose(window))
            programLoop();
        System.exit(0);
    }

    void startWindow() {
        glfwInit();
        window = glfwCreateWindow(900, 900, "", 0, 0);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        createCapabilities();
    }

    void programLoop() {
        glClear(GL_COLOR_BUFFER_BIT);
        manager.update();
        glfwSwapBuffers(window);
        glfwPollEvents();
    }
}