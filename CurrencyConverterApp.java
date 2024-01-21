import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {
    private JTextField amountTextField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        getContentPane().setBackground(Color.PINK); // Set background color

        add(new JLabel("Amount:"));
        amountTextField = new JTextField();
        add(amountTextField);

        add(new JLabel("From Currency:"));
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY"});
        add(fromCurrencyComboBox);

        add(new JLabel("To Currency:"));
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY"});
        add(toCurrencyComboBox);

        add(new JLabel("Converted Result:"));
        resultLabel = new JLabel();
        add(resultLabel);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        add(convertButton);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Call your currency conversion logic here, similar to the previous example
        // This could involve making an API call to get live exchange rates
        // For simplicity, we'll use a fixed conversion rate in this example
        double conversionRate = 0.85; // 1 USD to EUR
        return amount * conversionRate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterApp();
            }
        });
    }
}
