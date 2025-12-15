package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static me.jp57.showcase.Main.*;

public class GuessTheNumber {
    public static JFrame guessTheNumber(JFrame main ) {

        AtomicInteger lives = new AtomicInteger(10);
        Random rand = new Random();
        AtomicInteger correctGuess = new AtomicInteger(rand.nextInt(0,9)+1);

        // Setting up the window
        JFrame frame = new JFrame("Guess the Number!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(headerPanel, BorderLayout.NORTH);
        JLabel welcome =  new JLabel("Welcome! Guess a number 1-10, You have "+ lives +" lives.", JLabel.CENTER);
        welcome.setFont(interBold);
        headerPanel.add(welcome);


        // Back Button
        JButton backButton = new JButton("◄");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                main.setVisible(true);
            }
        });
        backButton.setPreferredSize(new Dimension(35, 35));
        headerPanel.add(backButton);

        // Panel for button
        JPanel guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout());
        guessPanel.setMaximumSize(new Dimension(600,300));

        // The game (got you)
        JLabel hint =  new JLabel("What could the number be?", JLabel.CENTER);
        hint.setFont(inter.deriveFont(0,24));
        frame.add(hint);
        frame.add(guessPanel, BorderLayout.SOUTH);

        JTextField guessField = new JTextField();
        guessField.setFont(inter);
        guessField.setHorizontalAlignment(JFormattedTextField.CENTER);
        guessPanel.add(guessField, BorderLayout.NORTH);
        guessField.setPreferredSize(new Dimension(300, 30));

        JButton guessButton = new JButton("Guess!");
        guessButton.setFont(interButton);
        guessButton.setPreferredSize(new Dimension(400, 200));
        guessPanel.add(guessButton, BorderLayout.SOUTH);

        // Guess button function!
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guessButton.getText().equals("Guess!")) {
                    if (Integer.parseInt(guessField.getText()) != correctGuess.get()) {
                        if (lives.get() > 1){
                            lives.decrementAndGet();
                            welcome.setText("Welcome! Guess a number 1-10, You have " + lives + " lives.");
                            if (Integer.parseInt(guessField.getText()) > correctGuess.get()) {
                                hint.setText("Lower");
                            } else {
                                hint.setText("Higher");
                            }
                            guessField.setText("");
                        } else {
                            hint.setText("You lost the game!");
                            welcome.setText("Welcome! Guess a number 1-10, You have 0 lives.");
                            guessButton.setText("Play Again!");
                        }
                    } else {
                        hint.setText("You guessed it!");
                        guessButton.setText("Play Again!");
                    }
                } else {
                    lives.set(10);
                    correctGuess.set(rand.nextInt(0,9)+1);
                    welcome.setText("Welcome! Guess a number 1-10, You have " + lives + " lives.");
                    guessButton.setText("Guess!");
                    hint.setText("What could the number be?");
                    guessField.setText("");
                }
            }
        });

        guessField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String value =  guessField.getText();
                guessField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() < 32);

            }
        });

        return frame;
    }
}
