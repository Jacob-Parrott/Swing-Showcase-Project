package me.jp57.showcase;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {
        // "Oh boy! I sure wish there was a way to get custom typography in my java project!"
        // The humble Font Initializer:
        Font overpass = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("me/jp57/showcase/assets/Overpass/Overpass-Regular.ttf")));

        // Basic Initialization of a swing JFrame window
        JFrame frame = new JFrame("Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Making a Panel for the header (to properly center it and use better positioning)
        JPanel headerPanel = new JPanel();
        JPanel basePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        headerPanel.setLayout(new GridBagLayout());
        basePanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(basePanel);
        frame.add(buttonPanel, BorderLayout.SOUTH);

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

        // Biography (2-3 sentences about myself, includes favorite hobbies)
        JLabel biography = getBiographyLabel();
        basePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        basePanel.add(biography);


        // Images.. apparently...
        BufferedImage headshotPic = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("me/jp57/showcase/assets/Images/Nextech2025-129.jpg")));
        JLabel headshotLabel = new JLabel(new ImageIcon(headshotPic));
        BufferedImage topicPic = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("me/jp57/showcase/assets/Images/pexels-photo-546819.jpeg")));
        JLabel topicLabel = new JLabel(new ImageIcon(topicPic));
        basePanel.add(headshotLabel, BorderLayout.EAST);
        basePanel.add(topicLabel, BorderLayout.WEST);

        // Buttons to redirect you to the games
        JButton GTNButton = new JButton("Guess The Number");
        JButton MadLibsButton = new JButton("MadLibs");
        JButton SciFiButton = new JButton("Sci-Fi Name Generator");
        GTNButton.setSize(new Dimension(100,300));
        GTNButton.setMaximumSize(GTNButton.getSize());
        MadLibsButton.setMaximumSize(MadLibsButton.getSize());
        SciFiButton.setMaximumSize(SciFiButton.getSize());
        MadLibsButton.setSize(new Dimension(100,300));
        SciFiButton.setSize(new Dimension(100,300));
        buttonPanel.add(GTNButton);
        buttonPanel.add(MadLibsButton);
        buttonPanel.add(SciFiButton);

        // So lowkey its visible now
        frame.setVisible(true);
    }

    // This just simplifies the Label into a separate static area to make code easier to read (I guess)
    private static JLabel getBiographyLabel() {
        JLabel biography = new JLabel("<html><div style='text-align: center; padding: 5px;'>Hey, I'm Jacob!<br><br>I'm a student at SICTC studying computer science, and i've been a fan of computers for way longer.<br><br>I am very interested in building & repairing computers, as well as writing programs in Java.</div></html>", JLabel.CENTER);
        biography.setFont(new Font("overpass", Font.PLAIN, 18));
        biography.setPreferredSize(new Dimension(550,225));
        biography.setOpaque(true);
        biography.setBackground(new Color(225,225,225));
        return biography;
    }
}
