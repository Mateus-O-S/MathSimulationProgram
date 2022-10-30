import java.util.ArrayList;
import java.util.function.Function;

public class Effect {
    ArrayList<Particle> points = new ArrayList<>();
    public float radioCorrection = 0;
    public Gradient color = new Gradient(new float[]{1, 0, 0}, new float[]{0, 1, 0});
    Timer timer = new Timer();
    String updationName = "-";

    Effect(int number) {
        start(number);
    }

    void start(float number) {
        points.clear();
        for (int i = 0; i < number; i++) {
            Particle.COLOR = color.get(i / number);
            add(i / number + radioCorrection);
        }
    }


    void add(double radio) {
        Particle point = new Particle();
        point.radio = (float)radio;
        points.add(point);
    }

    void update() {
        for (int i=0; i < points.size(); i++) {
            points.get(i).update(timer.millis, getUpdaterFunctionByName(points.get(i)));
        }
    }

    Function<Double, Double> getUpdaterFunctionByName(Particle point) {
        return switch (updationName) {
            case "-" -> time -> {
                return point.radio - (time * point.velocity);
            };

            case "+" -> time -> {
                return point.radio + (time * point.velocity);
            };

            case "*" -> time -> {
                return point.radio * (time * point.velocity);
            };

            case "/" -> time -> {
                return point.radio / (time * point.velocity);
            };

            default -> time -> {
                return 0d;
            };
        };

    }
}
