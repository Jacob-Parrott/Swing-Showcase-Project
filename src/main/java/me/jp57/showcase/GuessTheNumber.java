package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static me.jp57.showcase.Main.*;

public class GuessTheNumber {
    public static JFrame guessTheNumber(JFrame main ) {

        int lives = 10;
        boolean isAlive = true;
        Random rand = new Random();
        int correctGuess = rand.nextInt(0,9)+1;

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

        return frame;
    }
}
