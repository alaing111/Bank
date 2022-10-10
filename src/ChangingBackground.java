
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

public class ChangingBackground extends JPanel implements ActionListener
{
    //Declares variables
    JFrame m = new JFrame("yes");
    static JPanel buttonPanel = new JPanel();
    private JButton greenButton = new JButton("Green");
    private JButton blueButton = new JButton("Blue");
    private JButton redButton = new JButton("Red");

    public ChangingBackground()
    {
        add(greenButton);
        add(blueButton);
        add(redButton);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        Object src = event.getSource();
        Color color = getBackground();
        if (src == greenButton)
            color = Color.green;
        else if (src == blueButton)
            color = Color.blue;
        else if (src == redButton)
            color = Color.red;
        setBackground(color);
        repaint();
    }
    //Main method
    public static void main(String[] args)
    {
        //Puts a title on the frame
        JFrame frame = new JFrame("Change the background Color");
        //Sets the size of the frame
        frame.setSize(500, 400);
        //Allows to close the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container m = null;
        Container contentPane = frame.getContentPane();
        contentPane.add(new ChangingBackground());
        //Makes the frame visible
        frame.setVisible(true);
    /**Component mainPanel = null;
	frame.add(mainPanel, BorderLayout.CENTER);
    Component bottomPanel = null;
	frame.add(bottomPanel, BorderLayout.SOUTH);
    JLabel r = new JLabel();
    m.setLayout(new BorderLayout());
    m.add(r, BorderLayout.CENTER);
    m.add(buttonPanel, BorderLayout.SOUTH);
    m.setSize(200, 200);
    frame.setVisible(true);**/

    }
}
           