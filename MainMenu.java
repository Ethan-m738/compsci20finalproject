// package compsci20finalproject;

//import com.phidget22.*;
//import java.util.*;
import javax.swing.*;

import Blackjack.BlackjackGame;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMenu extends JFrame implements KeyListener {

    private JButton exitButton;
    private JButton toTugofWar;
    private JButton toBlackjack;
    private JLabel title;
    private JLabel welcome;
    private JLabel exitMessage;
    // private javax.swing.Timer exitTimer;
    private JButton aboutButton;
    private JLabel instructionLabel;

    public static void main(String[] args) throws Exception {
        // DigitalInput redBtn = new DigitalInput();
        // DigitalInput grnBtn = new DigitalInput();
        // DigitalOutput redLED = new DigitalOutput();
        // DigitalOutput grnLED = new DigitalOutput();

        // initialize(redBtn, 1);
        // initialize(grnBtn, 4);
        // initialize(redLED, 2);
        // initialize(grnLED, 3);
        
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable callExit = () -> exitConsole();

        //executor.execute(callExit);

        SwingUtilities.invokeLater(() -> new MainMenu());

        // SwingUtilities.invokeLater(() -> new MyGame());

        // Game tugOfWar = new TugOfWar();

        // tugOfWar.run(/*redBtn, grnBtn, redLED, grnLED*/);

    }

    /*
     * public static void initialize(Phidget p, int port) throws PhidgetException {
     * p.setIsHubPortDevice(true);
     * p.setHubPort(port);
     * p.open(1000);
     * }
     */

    public MainMenu() {

        setLayout(new GridLayout(6, 1));
        title = new JLabel("Home Page");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.black);
        welcome = new JLabel("Welcome to the home page!");
        welcome.setFont(new Font("Arial", Font.BOLD, 32));
        welcome.setForeground(Color.gray);
        exitMessage = new JLabel("Thank you for using the application!");
        exitMessage.setFont(new Font("Arial", Font.BOLD, 50));
        exitMessage.setForeground(Color.green);
        toTugofWar = new JButton("Tug of War");
        toBlackjack = new JButton("Blackjack");
        exitButton = new JButton("Exit");
        aboutButton = new JButton("About/Resources");
        instructionLabel = new JLabel(
                "Navigate the GUI using the mouse and follow the instructions in each game, typing 'exit' in the console will exit the program.");

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        toTugofWar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> new TugOfWarGUI());
                // Dispose the current JFrame (main menu)
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
            }

        });

        toBlackjack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Requires JFrame, not yet implemented
                BlackjackGame game = new BlackjackGame();
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
                game.play();
                
            }

        });

        JPanel headPanel = new JPanel();
        headPanel.add(title);
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(welcome);
        JPanel tugOfWarPanel = new JPanel();
        tugOfWarPanel.add(toTugofWar);
        JPanel blackjackPanel = new JPanel();
        blackjackPanel.add(toBlackjack);
        JPanel aboutPanel = new JPanel();
        aboutPanel.add(aboutButton);
        JPanel instructionPanel = new JPanel();
        instructionPanel.add(instructionLabel);
        // JPanel exitPanel = new JPanel();
        // exitPanel.add(exitButton);
        // JPanel exitMessagPanel = new JPanel();
        // exitMessagPanel.add(exitMessage);

        add(headPanel);
        add(welcomePanel);
        add(tugOfWarPanel);
        add(blackjackPanel);
        add(aboutPanel);
        add(instructionPanel);
        // add(exitPanel);
        // add(exitMessagPanel);

        setTitle("MainMenu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 750);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void exitConsole() {

        Reader inputReader = new Reader();

        while (true) {
            String enterString = inputReader.nextLine();
            if (enterString.equals("exit")) {
                System.out.println("exiting...");
                StopWatch stopWatchExiting = new StopWatch();
                while (stopWatchExiting.getTime() < 1000) {

                }
                System.out.println("Thank you for using the application!");
                System.exit(0);
                break;
            } else {
                System.out.println("Please input one of the options provided");
            }
        }

    }

}