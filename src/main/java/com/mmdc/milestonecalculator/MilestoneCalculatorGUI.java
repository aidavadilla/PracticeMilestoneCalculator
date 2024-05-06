/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mmdc.milestonecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MilestoneCalculatorGUI extends JFrame implements ActionListener {
    private JTextField milestone1Field, milestone2Field, terminalAssessmentField;
    private JLabel milestone1Label, milestone2Label, terminalAssessmentLabel, resultLabel;
    private JButton calculateButton;

    public MilestoneCalculatorGUI() {
        super("Milestone Calculator");

        // Create GUI components
        milestone1Label = new JLabel("Milestone 1:");
        milestone1Field = new JTextField(10);
        milestone2Label = new JLabel("Milestone 2:");
        milestone2Field = new JTextField(10);
        terminalAssessmentLabel = new JLabel("Terminal Assessment:");
        terminalAssessmentField = new JTextField(10);
        resultLabel = new JLabel("Result:");
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Add components to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(milestone1Label);
        contentPane.add(milestone1Field);
        contentPane.add(milestone2Label);
        contentPane.add(milestone2Field);
        contentPane.add(terminalAssessmentLabel);
        contentPane.add(terminalAssessmentField);
        contentPane.add(resultLabel);
        contentPane.add(calculateButton);

        // Set window properties
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double milestone1 = Double.parseDouble(milestone1Field.getText());
                double milestone2 = Double.parseDouble(milestone2Field.getText());
                double terminalAssessment = Double.parseDouble(terminalAssessmentField.getText());

                // Check if scores are within valid range
                if (milestone1 < 0 || milestone1 > 25 ||
                        milestone2 < 0 || milestone2 > 40 ||
                        terminalAssessment < 0 || terminalAssessment > 35) {
                    throw new IllegalArgumentException("Scores must be between 0 and maximum points per milestone.");
                }

                // Calculate total grade based on distribution
                double totalGrade = milestone1 + milestone2 + terminalAssessment;

                // Display result
                resultLabel.setText("Total Grade: " + totalGrade);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Invalid input. Please enter numeric values.");
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MilestoneCalculatorGUI());
    }
}
