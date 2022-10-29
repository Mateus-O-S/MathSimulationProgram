import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL.*;

public class ProgramManager {
    long window;
    FiguresManagement manager = new FiguresManagement();
    InputLayout input = new InputLayout();

    void init() {
        startWindow();
        input.setManager(manager);
        while(!glfwWindowShouldClose(window))
            programLoop();
        System.exit(0);
    }

    void startWindow() {
        glfwInit();
        window = glfwCreateWindow(600, 600, "", 0, 0);
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