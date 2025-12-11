package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {
        // "Oh boy! I sure wish there was a way to get custom typography in my java project!"
        // The humble Font Initializer:
        Font overpass = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("me/jp57/showcase/assets/Overpass/Overpass-Regular.ttf"));

        // Basic Initialization of a swing JFrame window
        JFrame frame = new JFrame("Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Making a Panel for the header (to properly center it and use better positioning)
        JPanel headerPanel = new JPanel();
        JPanel basePanel = new JPanel();
        headerPanel.setLayout(new GridBagLayout());
        basePanel.setLayout(new FlowLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(basePanel);

        // Adding constraints to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Column
        gbc.gridy = 0; // Row
        gbc.weightx = 1.0; // Horizontal weight for centering
        gbc.weighty = 1.0; // Vertical weight for centering
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
        gbc.fill = GridBagConstraints.NONE; // Do not stretch

        // Header
        JLabel welcome =  new JLabel("Welcome to my Showcase!", JLabel.CENTER);
        welcome.setFont(new Font("overpass", Font.BOLD, 32));
        headerPanel.add(welcome);

        // Biography
        JLabel biography = getBiographyLabel();
        basePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        basePanel.add(biography);


        // So lowkey its visible now
        frame.setVisible(true);
    }

    // This just simplifies the Label into a separate static area to make code easier to read (I guess)
    private static JLabel getBiographyLabel() {
        JLabel biography = new JLabel("<html><div style='text-align: center; padding: 5px;'>Hey, I'm Jacob!<br><br>I'm a student at SICTC studying computer science, and i've been a fan of computers for way longer.<br><br>I am very interested in building & repairing computers, as well as writing programs in Java.</div></html>", JLabel.CENTER);
        biography.setFont(new Font("overpass", Font.PLAIN, 18));
        biography.setPreferredSize(new Dimension(550,300));
        biography.setOpaque(true);
        biography.setBackground(new Color(225,225,225));
        return biography;
    }
}
