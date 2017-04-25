package assignment2017;

import assignment2017.codeprovided.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

/**
 * @author Sammy Spiers
 * @version 1.0
 */
public class Connect4GraphicalDisplay extends JFrame implements Connect4Displayable {

    private MyGameState gameState;
    private KeyboardPlayer key;

    Connect4GraphicalDisplay(MyGameState gameState) {
        this.gameState = gameState;

        setTitle("Connect 4");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);

        addKeyListener(new KeyboardPlayer.Keys(gameState));

        Container contentPane = new Container();
        contentPane.setLayout(new BorderLayout());
    }

    private class Board extends JPanel {

        public void paint(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;

            g2.draw(new Rectangle2D.Double(0, 0, 420, 420));

            for (int i = 1; i <= Connect4GameState.NUM_COLS ; i++) {
                g2.draw(new Line2D.Double(i * 60, 0, i * 60, 420));
            }

            for (int i = 1; i <= Connect4GameState.NUM_ROWS; i++) {
                g2.draw(new Line2D.Double(0, i * 70, 420, i * 70));
            }
        }
    }

    private class Controls extends JPanel {

        Controls() {
            setLayout(new FlowLayout());

            for (int i = 0; i <= Connect4GameState.NUM_COLS - 1; i++){
                add(new JButton(String.valueOf(i)));
            }
        }
    }

    private class Stats extends JPanel {

        Stats(MyGameState gameState) {

        }
    }

    private class Settings extends JPanel {

        Settings() {
            setLayout(new GridLayout(0, 1));

            add(new JLabel("<html><center>Select who you would like<br>to play against:<center><html>"));

            JButton human = new JButton("Human");
            add(human);
            human.addActionListener(new humanHandler());

            JButton random = new JButton("Random");
            add(random);
            random.addActionListener(new randomHandler());

            JButton intelligent = new JButton("Intelligent");
            add(intelligent);
            intelligent.addActionListener(new intelligentHandler());
        }

        private class humanHandler implements ActionListener {

            public void actionPerformed(ActionEvent e) {

            }
        }

        private class randomHandler implements ActionListener {

            public void actionPerformed(ActionEvent e) {

            }
        }

        private class intelligentHandler implements ActionListener {

            public void actionPerformed(ActionEvent e) {

            }
        }
    }

    public void displayBoard() {

    }

    //private int drawLocation(MyGameState gameState) {
        //int row = gameState.
    //}

    public static void main(String[] args) {
        MyGameState gameState = new MyGameState();
        Connect4GraphicalDisplay gUI = new Connect4GraphicalDisplay(gameState);

        Container contentPane = gUI.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gUI.new Board(), BorderLayout.CENTER);
        contentPane.add(gUI.new Controls(), BorderLayout.NORTH);
        contentPane.add(gUI.new Settings(), BorderLayout.WEST);
        gUI.revalidate();
    }
}
