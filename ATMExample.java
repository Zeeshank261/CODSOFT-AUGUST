import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMExample 
{
    private static int balance = 100000;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ATM Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Welcome to the ATM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel balanceLabel = new JLabel("Balance: $" + balance);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton exitButton = new JButton("Exit");

        // Styling for buttons
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 14));
        depositButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        withdrawButton.setPreferredSize(new Dimension(150, 40));
        depositButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setPreferredSize(new Dimension(150, 40));

        // ActionListener for Withdraw button
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String withdrawAmount = JOptionPane.showInputDialog("Enter amount to withdraw:");
                int withdraw = Integer.parseInt(withdrawAmount);
                if (withdraw > 0 && withdraw <= balance) {
                    balance -= withdraw;
                    balanceLabel.setText("Balance: $" + balance);
                    JOptionPane.showMessageDialog(null, "Please collect your money.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid amount or insufficient balance.");
                }
            }
        });

        // ActionListener for Deposit button
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositAmount = JOptionPane.showInputDialog("Enter amount to deposit:");
                int deposit = Integer.parseInt(depositAmount);
                if (deposit > 0) {
                    balance += deposit;
                    balanceLabel.setText("Balance: $" + balance);
                    JOptionPane.showMessageDialog(null, "Your money has been successfully deposited.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid amount.");
                }
            }
        });

        // ActionListener for Exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for using the ATM. Goodbye!");
                System.exit(0);
            }
        });
        panel.add(titleLabel, gbc);
        panel.add(balanceLabel, gbc);
        panel.add(withdrawButton, gbc);
        panel.add(depositButton, gbc);
        panel.add(exitButton, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}