import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HexFormat;

public class EffectDetailsController implements ActionListener {
    private final JFrame window = new JFrame();
    private final JButton button = new JButton("ok");
    private final JTextField startColor = new JTextField("color1");
    private final JTextField endColor = new JTextField("color2");
    private final JTextField effectTag = new JTextField("effect");
    private final JTextField radioCorrection = new JTextField("correction");
    private EffectManager parentManager = new EffectManager();

    EffectDetailsController() {
        startWindow();
        button.addActionListener(this);
    }

    private void startWindow() {
        window.setLayout(null);
        window.setSize(370, 150);
        window.setResizable(false);
        window.setVisible(true);
        initItems();
        showItems();
    }

    private void initItems() {
        button.setBounds(10, 90, 60, 20);
        startColor.setBounds(10, 45, 60, 40);
        endColor.setBounds(80, 45, 60, 40);
        effectTag.setBounds(220, 45, 60, 40);
        radioCorrection.setBounds(290, 45, 60, 40);
    }

    private void showItems() {
        window.add(button);
        window.add(startColor);
        window.add(endColor);
        window.add(effectTag);
        window.add(radioCorrection);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color color1 = new Color(HexFormat.fromHexDigits(this.startColor.getText()));
        Color color2 = new Color(HexFormat.fromHexDigits(this.endColor.getText()));
        EffectManager.color = new Gradient(color1, color2);
        EffectManager.radioCorrection = Integer.parseInt(this.radioCorrection.getText());
        parentManager.effect.updationName = effectTag.getText();
        parentManager.start(50000);
    }

    public void setParentEffectManager(EffectManager manager) {
        parentManager = manager;
    }
}
