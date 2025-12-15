package me.jp57.showcase;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Main {
    // Loading Inter font stuff
    public static Font inter = new Font( FlatInterFont.FAMILY, Font.PLAIN, 18);
    public static Font interBold = new Font (FlatInterFont.FAMILY, Font.BOLD, 18);
    public static Font interHeader = interBold.deriveFont(interBold.getStyle(), 28);
    public static Font interButton = inter.deriveFont(inter.getStyle(), 14);

    public static void main(String[] args) throws IOException, FontFormatException {

        // FlatLaF setup (I want this to look slightly good)
        FlatInterFont.install();
        FlatLaf.setPreferredFontFamily(FlatInterFont.FAMILY);
        FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());


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
        welcome.setFont(interHeader);
        headerPanel.add(welcome);

        // Biography (2-3 sentences about myself, includes favorite hobbies)
        JLabel biography = getBiographyLabel();
        basePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        biography.setPreferredSize(new Dimension(550,225));
        biography.setFont(inter);
        basePanel.add(biography);


        // Images.. apparently...
        BufferedImage headshotPic = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("assets/Images/headshot.jpg")));
        JLabel headshotLabel = new JLabel(new ImageIcon(headshotPic));
        BufferedImage topicPic = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("assets/Images/stock.jpeg")));
        JLabel topicLabel = new JLabel(new ImageIcon(topicPic));
        basePanel.add(headshotLabel, BorderLayout.EAST);
        basePanel.add(topicLabel, BorderLayout.WEST);

        // Buttons to redirect you to the games
        JButton GTNButton = new JButton("Number Game");
        JButton MadLibsButton = new JButton("MadLibs");
        JButton SciFiButton = new JButton("Sci-Fi Name");
        GTNButton.setPreferredSize(new Dimension(150,150));
        MadLibsButton.setPreferredSize(new Dimension(150,150));
        SciFiButton.setPreferredSize(new Dimension(150,150));
        GTNButton.setFont(interButton);
        MadLibsButton.setFont(interButton);
        SciFiButton.setFont(interButton);
        buttonPanel.add(GTNButton);
        buttonPanel.add(MadLibsButton);
        buttonPanel.add(SciFiButton);

        // Button Functionality
        GTNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GuessTheNumber.guessTheNumber(frame).setVisible(true);
            }
        });

        SciFiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SciFiNameGenerator.sciFiNameGenerator(frame).setVisible(true);
            }
        });

        // So lowkey its visible now
        frame.setVisible(true);
    }

    // This just simplifies the Label into a separate static area to make code easier to read (I guess)
    private static JLabel getBiographyLabel() {
        return new JLabel("<html><div style='text-align: center; padding: 5px;'>Hey, I'm Jacob!<br><br>I'm a student at SICTC studying computer science, and i've been a fan of computers for way longer.<br><br>I am very interested in building & repairing computers, as well as writing programs in Java.</div></html>", JLabel.CENTER);
    }
}
