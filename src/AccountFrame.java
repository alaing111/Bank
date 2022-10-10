
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountFrame extends JFrame {

    private JTextField rateTextField;
    private JTextField balanceTextField;
    private JTextField yearTextField;
    private JButton button;
    private JPanel panel;
    private BankAccount account;
    private JLabel rateLabel;
    private JLabel balLabel;
    private JLabel yrLabel;
    private TextArea result;

    public AccountFrame() {

        account = new BankAccount();
        makeTextField();
        makeButton();
        makePanel();
        setSize(500, 300);
    }

    private void makeTextField() {
        rateLabel = new JLabel("Annual Rate: ");
        balLabel = new JLabel("Initial Balance:");
        yrLabel = new JLabel("Number of years:");
        balanceTextField = new JTextField(10);
        rateTextField = new JTextField(10);
        yearTextField = new JTextField(10);
        result = new TextArea();
    }
    //Creates the calculate button
    private void makeButton() {
        button = new JButton("Calculate");

        class AddCalculateListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                //Converts the doubles to String
                double bal = Double.parseDouble(balanceTextField.getText());
                double rate = Double.parseDouble(rateTextField.getText());
                double years = Double.parseDouble(yearTextField.getText());
                account = new BankAccount(bal);
                rate = rate / 100;
                for (int i = 0; i < years; i++) {
                    double newbalance = account.getBalance() * rate;
                    account.deposit(newbalance);
                    //String test = String.valueOf(account.getBalance()) + "\n";
                    String newAmount = account.getBalance() + "\n";
                    //Displays the result in the text area
                    result.append(newAmount);
                }
            }
        }
        //Creates an action lister
        ActionListener listener = new AddCalculateListener();
        //Adds the button to the action listener
        button.addActionListener(listener);
    }

    private void makePanel() {
        panel = new JPanel();
        panel.add(balLabel);
        panel.add(balanceTextField);
        panel.add(rateLabel);
        panel.add(rateTextField);
        panel.add(yrLabel);
        panel.add(yearTextField);
        panel.add(button);
        panel.add(result);
        add(panel);
    }
    // Main Method
    public static void main(String[] args){
        JFrame frame = new AccountFrame();
        //Allows the frame to be closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets the title of the frame
        frame.setTitle("Frame");
        //Makes the frame visible
        frame.setVisible(true);

    }
}
