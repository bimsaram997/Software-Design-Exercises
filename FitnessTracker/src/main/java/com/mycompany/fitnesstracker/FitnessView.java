/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bimsa
 */
public class FitnessView {
    public FitnessModel model;
    private BarChart<Number, String> barChart;
    private PieChart pieChart;
    private Button changeDataButton;
    private VBox chartContainer;

    public FitnessView(FitnessModel model) {
        this.model = model;
    }

    public void initialize(Stage stage) {
        stage.setTitle("Fitness Tracker");

        // Create BarChart
        NumberAxis xAxisBarChart = new NumberAxis();
        xAxisBarChart.setLabel("Footage per week");
        CategoryAxis yAxisBarChart = new CategoryAxis();
        yAxisBarChart.setLabel("Day");
        barChart = new BarChart<>(xAxisBarChart, yAxisBarChart);
        barChart.setTitle("Footage per Day");
        barChart.setData(model.getBarChartData());

        // Create Button
        changeDataButton = new Button("Change data");

        // Create PieChart
        pieChart = new PieChart(model.getPieChartData());
        pieChart.setTitle("Daily Activity");

        // Add tooltips to PieChart
        model.getPieChartData().forEach(data -> {
            double totalValue = model.getPieChartData().stream().mapToDouble(PieChart.Data::getPieValue).sum();
            double percentage = (data.getPieValue() / totalValue) * 100;
            Tooltip.install(data.getNode(), new Tooltip(String.format("%.2f%%", percentage)));
        });

        // Layout setup
        HBox buttonContainer = new HBox(changeDataButton);
        buttonContainer.setAlignment(Pos.TOP_LEFT);
        buttonContainer.setPadding(new Insets(10));

        chartContainer = new VBox(10, buttonContainer, barChart);
        chartContainer.setPadding(new Insets(10));

        VBox pieChartContainer = new VBox(pieChart);
        pieChartContainer.setPadding(new Insets(10));

        // GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(pieChartContainer, 0, 0);
        gridPane.add(chartContainer, 1, 0);

        // Create a scene with the layout
        Scene scene = new Scene(gridPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public Button getChangeDataButton() {
        return changeDataButton;
    }
}