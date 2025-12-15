package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static me.jp57.showcase.Main.*;

public class MadLibs {

    public static JFrame madLibs(JFrame main) {
        // Setting up the window
        JFrame frame = new JFrame("Mad Libs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(headerPanel, BorderLayout.NORTH);
        JLabel title =  new JLabel("Mad Libs", JLabel.CENTER);
        title.setFont(interBold);
        headerPanel.add(title);

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


        String[] stories = {
                "At the beach, I found a (adjective) (noun). It was (adjective)!",
                "For my birthday, I got a (adjective) (noun). It was great!",
                "On a (adjective) day, I went to (place) with my (noun). We played (verb) and ate (food)!"
        };

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setMaximumSize(new Dimension(600, 300));

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.setMaximumSize(new Dimension(600, 300));

        JLabel storyLabel = new JLabel("", JLabel.CENTER);
        storyLabel.setPreferredSize(new Dimension(600, 30));
        storyLabel.setFont(interButton);
        centerPanel.add(storyLabel);

        JComboBox<String> storySelectionBox = new JComboBox<>(new String[] {"Story A", "Story B", "Story C"});
        storySelectionBox.setPreferredSize(new Dimension(300, 30));
        storySelectionBox.setFont(interButton);
        centerPanel.add(storySelectionBox);

        JTextField firstWordField = new JTextField();
        firstWordField.setPreferredSize(new Dimension(300, 30));
        firstWordField.setFont(interButton);
        centerPanel.add(firstWordField);

        JTextField secondWordField = new JTextField();
        secondWordField.setPreferredSize(new Dimension(300, 30));
        secondWordField.setFont(interButton);
        centerPanel.add(secondWordField);

        JTextField thirdWordField = new JTextField();
        thirdWordField.setPreferredSize(new Dimension(300, 30));
        thirdWordField.setFont(interButton);
        centerPanel.add(thirdWordField);

        JTextField fourthWordField = new JTextField();
        fourthWordField.setPreferredSize(new Dimension(300, 30));
        fourthWordField.setFont(interButton);
        centerPanel.add(fourthWordField);

        JTextField fifthWordField = new JTextField();
        fifthWordField.setPreferredSize(new Dimension(300, 30));
        fifthWordField.setFont(interButton);
        centerPanel.add(fifthWordField);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 30));
        submitButton.setFont(interButton);
        southPanel.add(submitButton);

        JButton randomStoryButton = new JButton("Random Story");
        randomStoryButton.setPreferredSize(new Dimension(150, 30));
        randomStoryButton.setFont(interButton);
        southPanel.add(randomStoryButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected =  storySelectionBox.getSelectedIndex();
                String text = stories[selected];
                text = text.replaceFirst("\\(\\w+\\)", firstWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", secondWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", thirdWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", fourthWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", fifthWordField.getText());
                storyLabel.setText(text);
            }
        });

        randomStoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = stories[new Random().nextInt(stories.length)];
                text = text.replaceFirst("\\(\\w+\\)", firstWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", secondWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", thirdWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", fourthWordField.getText());
                text = text.replaceFirst("\\(\\w+\\)", fifthWordField.getText());
                storyLabel.setText(text);
            }
        });

        storySelectionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = storySelectionBox.getSelectedIndex();

                if (selected == 0) {
                    firstWordField.setText("adjective");
                    secondWordField.setText("noun");
                    thirdWordField.setText("adjective");
                    fourthWordField.setText("");
                    fifthWordField.setText("");
                } else if (selected == 1) {
                    firstWordField.setText("adjective");
                    secondWordField.setText("noun");
                    thirdWordField.setText("");
                    fourthWordField.setText("");
                    fifthWordField.setText("");
                } else if (selected == 2) {
                    firstWordField.setText("adjective");
                    secondWordField.setText("place");
                    thirdWordField.setText("noun");
                    fourthWordField.setText("verb");
                    fifthWordField.setText("food");
                }

                storyLabel.setText(stories[selected]);
            }
        });

        storySelectionBox.setSelectedIndex(0);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);

        return frame;
    }

}
