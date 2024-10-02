/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstracker;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author bimsa
 */
public class FitnessModel {
    private ObservableList<PieChart.Data> pieChartData;
    private ObservableList<XYChart.Series<Number, String>> barChartData;
    private Map<String, SimpleIntegerProperty> footagePerDay;

    public FitnessModel() {
        pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Steps", 25),
            new PieChart.Data("Exercises", 15),
            new PieChart.Data("Calories", 35),
            new PieChart.Data("Activity", 25)
        );

        footagePerDay = new HashMap<>();
        footagePerDay.put("Monday", new SimpleIntegerProperty(20));
        footagePerDay.put("Tuesday", new SimpleIntegerProperty(50));
        footagePerDay.put("Wednesday", new SimpleIntegerProperty(80));
        footagePerDay.put("Thursday", new SimpleIntegerProperty(90));
        footagePerDay.put("Friday", new SimpleIntegerProperty(100));
        footagePerDay.put("Saturday", new SimpleIntegerProperty(50));
        footagePerDay.put("Sunday", new SimpleIntegerProperty(70));

        barChartData = FXCollections.observableArrayList();
        updateBarChartSeries();
    }
    
    public ObservableList<PieChart.Data> getPieChartData() {
        return pieChartData;
    }


    public ObservableList<XYChart.Series<Number, String>> getBarChartData() {
        return barChartData;
    }

    public void updateFootagePerDay(String day, int footage) {
        footagePerDay.get(day).set(footage);
        updateBarChartSeries();
    }

    private void updateBarChartSeries() {
        XYChart.Series<Number, String> series = new XYChart.Series<>();
        for (Map.Entry<String, SimpleIntegerProperty> entry : footagePerDay.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getValue().get(), entry.getKey()));
        }
        barChartData.clear();
        barChartData.add(series);
    }

    


    
}