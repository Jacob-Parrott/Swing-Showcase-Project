package me.jp57.showcase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static me.jp57.showcase.Main.*;

public class SciFiNameGenerator {

    public static JFrame sciFiNameGenerator(JFrame main) {
        // Setting up the window
        JFrame frame = new JFrame("SciFi Name Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(headerPanel, BorderLayout.NORTH);
        JLabel title =  new JLabel("SciFi Name Generator", JLabel.CENTER);
        title.setFont(interBold);
        headerPanel.add(title);

        // Panels for inputs (left side)
        JPanel leftInputPanel = new JPanel();
        leftInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftInputPanel.setSize(new Dimension(300,300));
        leftInputPanel.setMaximumSize(new Dimension(300,300));

        // Panels for inputs (right side)
        JPanel rightInputPanel = new JPanel();
        rightInputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightInputPanel.setSize(new Dimension(300,300));
        rightInputPanel.setMaximumSize(new Dimension(300,300));

        // Panel for combining the two
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setSize(new Dimension(600,300));
        inputPanel.setMaximumSize(new Dimension(600,300));

        JLabel nameHintLabel = new JLabel("Generated name:", JLabel.LEFT);
        leftInputPanel.add(nameHintLabel);
        nameHintLabel.setPreferredSize(new Dimension(300, 30));

        JLabel nameLabel = new JLabel("", JLabel.CENTER);
        rightInputPanel.add(nameLabel);
        nameLabel.setPreferredSize(new Dimension(300, 30));

        JLabel firstNameLabel =  new JLabel("First name:", JLabel.LEFT);
        firstNameLabel.setFont(inter);
        JTextField firstNameField = new JTextField();
        firstNameField.setFont(inter);
        firstNameField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(firstNameLabel);
        rightInputPanel.add(firstNameField);
        firstNameLabel.setPreferredSize(new Dimension(300, 30));
        firstNameField.setPreferredSize(new Dimension(300, 30));

        JLabel lastNameLabel =  new JLabel("Last name:", JLabel.LEFT);
        lastNameLabel.setFont(inter);
        JTextField lastNameField = new JTextField();
        lastNameField.setFont(inter);
        lastNameField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(lastNameLabel);
        rightInputPanel.add(lastNameField);
        lastNameLabel.setPreferredSize(new Dimension(300, 30));
        lastNameField.setPreferredSize(new Dimension(300, 30));

        JLabel cityOfBirthLabel =  new JLabel("City of birth:", JLabel.LEFT);
        cityOfBirthLabel.setFont(inter);
        JTextField cityOfBirthField = new JTextField();
        cityOfBirthField.setFont(inter);
        cityOfBirthField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(cityOfBirthLabel);
        rightInputPanel.add(cityOfBirthField);
        cityOfBirthLabel.setPreferredSize(new Dimension(300, 30));
        cityOfBirthField.setPreferredSize(new Dimension(300, 30));

        JLabel schoolLabel =  new JLabel("School:", JLabel.LEFT);
        schoolLabel.setFont(inter);
        JTextField schoolField = new JTextField();
        schoolField.setFont(inter);
        schoolField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(schoolLabel);
        rightInputPanel.add(schoolField);
        schoolField.setPreferredSize(new Dimension(300, 30));
        schoolLabel.setPreferredSize(new Dimension(300, 30));
        schoolLabel.setPreferredSize(new Dimension(300, 30));

        JLabel favPetOrFoodLabel =  new JLabel("Favorite pet or food:", JLabel.LEFT);
        favPetOrFoodLabel.setFont(inter);
        JTextField favPetOrFoodField = new JTextField();
        favPetOrFoodField.setFont(inter);
        favPetOrFoodField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(favPetOrFoodLabel);
        rightInputPanel.add(favPetOrFoodField);
        favPetOrFoodLabel.setPreferredSize(new Dimension(300, 30));
        favPetOrFoodField.setPreferredSize(new Dimension(300, 30));

        JLabel favSiblingOrMythicalLabel =  new JLabel("Favorite sibling or mythical character:", JLabel.LEFT);
        favSiblingOrMythicalLabel.setFont(inter);
        JTextField favSiblingOrMythicalField = new JTextField();
        favSiblingOrMythicalField.setFont(inter);
        favSiblingOrMythicalField.setHorizontalAlignment(JFormattedTextField.CENTER);
        leftInputPanel.add(favSiblingOrMythicalLabel);
        rightInputPanel.add(favSiblingOrMythicalField);
        favSiblingOrMythicalLabel.setPreferredSize(new Dimension(300, 30));
        favSiblingOrMythicalField.setPreferredSize(new Dimension(300, 30));

        JButton generateButton = new JButton("Generate!");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String cityOfBirth = cityOfBirthField.getText();
                String school = schoolField.getText();
                String favPetOrFood = favPetOrFoodField.getText();
                String favSiblingOrMythicalChar = favSiblingOrMythicalField.getText();

                String sciFiFirstName = firstName.substring(0, 2) + lastName.substring(0, 3);
                String sciFILastName = cityOfBirth.substring(0, 2) + school.substring(0, 3);
                String sciFiOrigin = favPetOrFood + " " + favSiblingOrMythicalChar;

                nameLabel.setText(sciFiFirstName + " " + sciFILastName + " from the planet " + sciFiOrigin);
            }
        });
        generateButton.setFont(interButton);
        generateButton.setSize(new Dimension(400, 200));

        inputPanel.add(leftInputPanel);
        inputPanel.add(rightInputPanel);

        frame.add(generateButton, BorderLayout.SOUTH);
        frame.add(inputPanel, BorderLayout.CENTER);

        return frame;
    }

}
