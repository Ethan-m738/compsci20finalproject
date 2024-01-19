import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TugOfWarGUI extends JFrame implements KeyListener {
    private JProgressBar upProgressBar;
    private JProgressBar wProgressBar;
    private JButton startButton;
    private JLabel countdownLabel;
    private Timer countdownTimer;
    private int countdownSeconds;

    public TugOfWarGUI() {
        // Set the layout manager to GridLayout with 4 rows and 1 column
        setLayout(new GridLayout(4, 1));

        // Create the start button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Disable the start button
                countdownTimer.stop(); // Stop the countdown timer
                // Reset the countdown timer to 3 seconds
                countdownSeconds = 3;
                countdownLabel.setText(Integer.toString(countdownSeconds));

                countdownTimer.start(); // Start the countdown timer again

                // Change button text to 'Restart'
                startButton.setText("Restart");

                countdownLabel.setVisible(true); // Show the countdown label

                // Reset the progress values of the progress bars
                upProgressBar.setValue(0);
                wProgressBar.setValue(0);
            }
        });

        // Create the title label
        JLabel titleLabel = new JLabel("MyGame");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground( Color.BLUE);

        // Create the countdown label
        countdownLabel = new JLabel("3");
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 36));
        countdownLabel.setVisible(false); // Hide the countdown label initially

        // Create panels for the progress bars
        JPanel upProgressBarPanel = new JPanel();
        upProgressBarPanel.setLayout(new GridLayout(1, 2));
        JPanel wProgressBarPanel = new JPanel();
        wProgressBarPanel.setLayout(new GridLayout(1, 2));

        // Create the instruction text
        JLabel upInstructionLabel = new JLabel("Player 1: press 'Up'");
        upInstructionLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel wInstructionLabel = new JLabel("Player 2: press 'w'");
        wInstructionLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the progress bars
        upProgressBar = new JProgressBar(0, 100);
        upProgressBar.setStringPainted(true); // Display the value as a string

        wProgressBar = new JProgressBar(0, 100);
        wProgressBar.setStringPainted(true); // Display the value as a string

        // Add the instruction label and progress bar panel to the progress panels
        upProgressBarPanel.add(upInstructionLabel);
        upProgressBarPanel.add(upProgressBar);
        wProgressBarPanel.add(wInstructionLabel);
        wProgressBarPanel.add(wProgressBar);

        // Create a panel for the title, start button and countdown label
        JPanel headerPanel = new JPanel();
        headerPanel.add(titleLabel);
        headerPanel.add(startButton);
        headerPanel.add(countdownLabel);

        // Add the header panel, up progress bar, and w progress bar to the frame
        add(headerPanel);
        add(upProgressBarPanel);
        add(wProgressBarPanel);

        // Set the frame properties
        setTitle("MyGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 350);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        // Initialize the countdown timer
        countdownSeconds = 3;
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownSeconds--;
                countdownLabel.setText(Integer.toString(countdownSeconds));

                if (countdownSeconds == 0) {
                    countdownTimer.stop(); // Stop the countdown timer
                    startButton.setEnabled(true); // Enable the start button
                    //Change text to go
                    countdownLabel.setText("Go!");
                    // Add key listener to the frame
                    addKeyListener(TugOfWarGUI.this);

                    // Request focus on the frame to receive key events
                    requestFocus();
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of the MyGame
        SwingUtilities.invokeLater(() -> new TugOfWarGUI());
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (!startButton.isEnabled()) {
            return; // Ignore key events if the start button is disabled
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // Increase the value of the upProgressBar by 5
            int upValue = upProgressBar.getValue() + 5;
            int wValue = wProgressBar.getValue();

            upProgressBar.setValue(upValue);

            // If the value reaches 100, display a message
            if (upValue == 100) {
                JOptionPane.showMessageDialog(this, "Player 1 wins!");
                resetGame();
            }

            if (upValue > wValue) {
                // Set the color of upProgressBar to green
                upProgressBar.setForeground(Color.GREEN);
                wProgressBar.setForeground(Color.RED);
            } else {
                // Set the color of wProgressBar to green
                wProgressBar.setForeground(Color.GREEN);
                upProgressBar.setForeground(Color.RED);
            }
        } else if (e.getKeyChar() == 'w') {
            // Increase the value of the wProgressBar by 5
            int wValue = wProgressBar.getValue() + 5;
            int upValue = upProgressBar.getValue();

            wProgressBar.setValue(wValue);

            // If the value reaches 100, display a message
            if (wValue == 100) {
                JOptionPane.showMessageDialog(this, "Player 2 wins!");
                resetGame();
            }

            if (wValue > upValue) {
                // Set the color of wProgressBar to green
                wProgressBar.setForeground(Color.GREEN);
                upProgressBar.setForeground(Color.RED);
            } else {
                // Set the color of upProgressBar to green
                upProgressBar.setForeground(Color.GREEN);
                wProgressBar.setForeground(Color.RED);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    private void resetGame() {
        upProgressBar.setValue(0);
        wProgressBar.setValue(0);
        countdownSeconds = 0;
        startButton.setEnabled(true); // Enable the start button
        removeKeyListener(this); // Stop listening for key events
    }
}