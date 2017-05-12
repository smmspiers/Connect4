package assignment2017;

import assignment2017.codeprovided.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.Graphics;

/**
 * A class that implements Connect4Displayable to display the game
 * in a GUI.
 * @author Sammy Spiers (aca16sms)
 * @version 1.0
 */
public class Connect4GraphicalDisplay extends JFrame implements Connect4Displayable {

    private static final int SETTINGS_WINDOW_WIDTH = 300;
    private static final int SETTINGS_WINDOW_HEIGHT = 200;
    private static final int BOARD_HEIGHT = 440;
    private static final int BOARD_WIDTH = 420;
    private static final int BOARD_SQUARE_WIDTH = 60;
    private static final int BOARD_SQUARE_HEIGHT = 70;
    private static final int VERTICAL_COUNTER_ALIGNMENT = 355;
    private static final int[] BLUE = {20, 117, 227};
    private static final int[] RED = {239, 44, 33};
    private static final int[] YELLOW = {249, 191, 10};
    private static final int FONT_SIZE = 48;
    private static final int VERTICAL_FONT_ALIGNMENT = 225;
    private static final int HORIZONTAL_FONT_ALIGNMENT = 62;

    private MyGameState gameState;
    private Board board;

    Connect4GraphicalDisplay(MyGameState gameState) {
        this.gameState = gameState;

        setTitle("Select Opponent");
        setSize(SETTINGS_WINDOW_WIDTH, SETTINGS_WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new Settings());

        setVisible(true);
        revalidate();
    }

    private class Settings extends JPanel {

        private static final int SETTINGS_PANEL_HEIGHT_WIDTH = 100;

        Settings() {
            setLayout(new GridLayout(0, 1));
            setSize(SETTINGS_PANEL_HEIGHT_WIDTH, SETTINGS_PANEL_HEIGHT_WIDTH);

            JLabel ask = new JLabel("Select who you would like to play against:");
            ask.setHorizontalAlignment(JLabel.CENTER);
            add(ask);

            JButton human = new JButton("Human");
            human.addActionListener(new HumanHandler());
            add(human);

            JButton random = new JButton("Random");
            random.addActionListener(new RandomHandler());
            add(random);

            JButton intelligent = new JButton("Intelligent (NOT IMPLEMENTED)");
            add(intelligent);

            JLabel instructions = new JLabel("<html><b>Use keys from 0-6 to input a column.</b></html>");
            instructions.setHorizontalAlignment(JLabel.CENTER);
            add(instructions);
        }

        private class HumanHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.opponent = MyGameState.HUMAN;
                board = new Board();
            }
        }

        private class RandomHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.opponent = MyGameState.RANDOM;
                board = new Board();
            }
        }
    }

    private class Board extends JFrame {

        Board() {
            setTitle("Connect 4");
            setSize(BOARD_WIDTH, BOARD_HEIGHT);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);

            addKeyListener(new KeyListenerPlayer(gameState));
            setVisible(true);
        }
    }

    private class Painter extends JComponent {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            drawBoard(g2);
            if (gameState.gameOver()) {
                drawWinner(g2);
            }
        }

        private void drawBoard(Graphics2D g2) {
            g2.setPaint(new Color(BLUE[0], BLUE[1], BLUE[2]));
            g2.fill(new Rectangle2D.Double(0, 0, BOARD_WIDTH, BOARD_WIDTH));

            g2.setPaint(new Color(0, 0, 0));
            for (int i = 1; i <= Connect4GameState.NUM_COLS; i++) {
                g2.draw(new Line2D.Double(i * BOARD_SQUARE_WIDTH, 0,
                        i * BOARD_SQUARE_WIDTH, BOARD_SQUARE_HEIGHT * BOARD_SQUARE_WIDTH));
            }

            for (int i = 1; i <= Connect4GameState.NUM_ROWS; i++) {
                g2.draw(new Line2D.Double(0, i * BOARD_SQUARE_HEIGHT,
                        BOARD_SQUARE_HEIGHT * BOARD_SQUARE_WIDTH, i * BOARD_SQUARE_HEIGHT));
            }

            for (int i = 0; i < Connect4GameState.NUM_ROWS; i++) {
                for (int j = 0; j < Connect4GameState.NUM_COLS; j++) {

                    if (gameState.board[i][j] == Connect4GameState.EMPTY) {
                        g2.setPaint(new Color(255, 255, 255));
                        g2.fill(new Ellipse2D.Double(BOARD_SQUARE_WIDTH * j,
                                VERTICAL_COUNTER_ALIGNMENT + BOARD_SQUARE_HEIGHT * -i, BOARD_SQUARE_WIDTH, BOARD_SQUARE_WIDTH));
                    } else {
                        if (gameState.board[i][j] == Connect4GameState.RED) {
                            g2.setPaint(new Color(RED[0], RED[1], RED[2]));
                        } else if (gameState.board[i][j] == Connect4GameState.YELLOW) {
                            g2.setPaint(new Color(YELLOW[0], YELLOW[1], YELLOW[2]));
                        }
                        g2.fill(new Ellipse2D.Double(BOARD_SQUARE_WIDTH * j,
                                VERTICAL_COUNTER_ALIGNMENT + BOARD_SQUARE_HEIGHT * -i, BOARD_SQUARE_WIDTH, BOARD_SQUARE_WIDTH));
                    }
                }
            }
        }

        private void drawWinner(Graphics2D g2) {
            g2.setPaint(new Color(0, 0, 0));
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE);
            g2.setFont(font);

            if (gameState.getWinner() == Connect4GameState.YELLOW) {
                g2.drawString("Yellow wins", HORIZONTAL_FONT_ALIGNMENT, VERTICAL_FONT_ALIGNMENT);
            } else if (gameState.getWinner() == Connect4GameState.RED) {
                g2.drawString("Red wins", HORIZONTAL_FONT_ALIGNMENT, VERTICAL_FONT_ALIGNMENT);
            } else {
                g2.drawString("Draw.", HORIZONTAL_FONT_ALIGNMENT, VERTICAL_FONT_ALIGNMENT);
            }
        }
    }

    /**
     * Displays board in a GUI.
     */
    public void displayBoard() {
        Painter paint = new Painter();

        /* Until the board is not null, so until the user selects an opponent,
           nothing can be added to the board. This is because a NullPointerException
           will be passed.
        */
        if (board != null) {
            Container contentPane = board.getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(paint, BorderLayout.CENTER);
            board.repaint();
            board.revalidate();
        }
    }
}
