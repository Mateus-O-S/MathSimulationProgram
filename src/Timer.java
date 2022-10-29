public class Timer {
    public long nano;
    public double millis;
    public double seconds;
    private Thread thread;
    public boolean running = true;

    public Timer() {
        thread = new Thread(() -> {
            while(true) {
                if (running)
                    update();
            }
        });
        thread.start();
    }

    private void update() {
        nano++;
        millis += 0.001;
        seconds += 0.000001;
        delay();
    }

    private void delay() {
        try {
            Thread.sleep(0, 1);
        } catch (Exception ignored) {}
    }

    public void restart() {
        nano = 0;
        millis = 0;
        seconds = 0;
    }
}
