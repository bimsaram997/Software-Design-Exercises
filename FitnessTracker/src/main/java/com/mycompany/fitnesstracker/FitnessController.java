/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author bimsa
 */
public class FitnessController {
    private FitnessModel model;
    private FitnessView view;
    private Stage stage;

    public FitnessController(FitnessModel model, FitnessView view, Stage stage) {
        this.model = model;
        this.view = view;
        this.stage = stage;
        attachEventHandlers();
    }

    private void attachEventHandlers() {
        view.getChangeDataButton().setOnAction(event -> handleFileUpload());
    }

    private void handleFileUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Data File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.csv"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            updateBarChartFromFile(file);
        }
    }

    private void updateBarChartFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String day = parts[0].trim();
                    int value = Integer.parseInt(parts[1].trim());
                    model.updateFootagePerDay(day, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + e.getMessage());
        }
    }
}
