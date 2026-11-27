import javax.swing.*;
import java.awt.event.*;

public class BankBalanceGUI {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        JFrame frame = new JFrame("My Bank Account");
        JPanel panel = new JPanel();

        JLabel instructions = new JLabel(
                "Enter starting balance, then click Deposit.");

        JTextField amountField = new JTextField(10);
        JLabel balanceLabel = new JLabel("Balance: $0.00");

        JButton showButton = new JButton("Show Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        ActionListener buttons = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == exitButton) {
                    JOptionPane.showMessageDialog(
                            frame, "Final balance: $"
                            + account.getBalance());
                    frame.dispose();
                    return;
                }

                if (event.getSource() == showButton) {
                    balanceLabel.setText(
                            "Balance: $" + account.getBalance());
                    return;
                }

                try {
                    double amount = Double.parseDouble(
                            amountField.getText());

                    if (!Double.isFinite(amount) || amount <= 0) {
                        JOptionPane.showMessageDialog(
                                frame, "Enter a positive number.");
                        return;
                    }

                    if (event.getSource() == depositButton) {
                        account.deposit(amount);
                    } else if (amount <= account.getBalance()) {
                        account.withdrawal(amount);
                    } else {
                        JOptionPane.showMessageDialog(
                                frame, "Not enough money.");
                    }

                    balanceLabel.setText(
                            "Balance: $" + account.getBalance());

                    amountField.setText("");

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(
                            frame, "Please enter a number.");
                }
            }
        };

        showButton.addActionListener(buttons);
        depositButton.addActionListener(buttons);
        withdrawButton.addActionListener(buttons);
        exitButton.addActionListener(buttons);

        panel.add(instructions);
        panel.add(amountField);
        panel.add(showButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);
        panel.add(exitButton);

        frame.add(panel);
        frame.setSize(400, 200);

        // Use the Exit button so the final balance is displayed.
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setVisible(true);
    }
}