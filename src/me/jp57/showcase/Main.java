package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.io.File;
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
        frame.setLocationRelativeTo(null);

        // Making a Panel for the header (to properly center it and use better positioning)
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridBagLayout());
        frame.add(headerPanel, BorderLayout.NORTH);

        // Adding constraints to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Column
        gbc.gridy = 0; // Row
        gbc.weightx = 1.0; // Horizontal weight for centering
        gbc.weighty = 1.0; // Vertical weight for centering
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
        gbc.fill = GridBagConstraints.NONE; // Do not stretch

        // Adding Text
        Label welcome =  new Label("Welcome to my Showcase!", JLabel.CENTER);
        welcome.setFont(new Font("overpass", Font.PLAIN, 32));
        headerPanel.add(welcome);



        // So lowkey its visible now
        frame.setVisible(true);
    }
}
