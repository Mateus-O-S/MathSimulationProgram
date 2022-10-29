import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HexFormat;
import java.util.function.Function;

public class InputLayout implements ActionListener {
    JFrame window = new JFrame();
    JButton button = new JButton("ok");
    JTextField startColor = new JTextField("color1");
    JTextField endColor = new JTextField("color2");
    JTextField effectTag = new JTextField("effect");
    JTextField radioCorrection = new JTextField("correction");
    FiguresManagement parentManager = new FiguresManagement();

    InputLayout() {
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
        FiguresManagement.color = new Gradient(color1, color2);
        FiguresManagement.radioCorrection = Integer.parseInt(this.radioCorrection.getText());
        parentManager.effect.updationName = effectTag.getText();
        parentManager.start(10000);
    }

    public void setManager(FiguresManagement manager) {
        parentManager = manager;
    }
}
