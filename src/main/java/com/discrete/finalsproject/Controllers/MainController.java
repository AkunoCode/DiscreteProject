package com.discrete.finalsproject.Controllers;

import com.discrete.finalsproject.Models.Calculator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainController {
    // TODO: Table [Columns: Data, Data - Mean, (Data - Mean)^2] - Johann
    // TODO: Histogram/Graph - Leo
    @FXML
    private TextField inputField;

    @FXML
    private Button populationButton;

    @FXML
    private Button sampleButton;

    private ArrayList<Double> getInputData(){
        // Convert commas to spaces and split by spaces. If there is more than one space, convert it to one space.
        String[] inputString = inputField.getText().replaceAll(",", " ").replaceAll("\\s+", " ").split(" ");
        ArrayList<Double> inputData = new ArrayList<>();

        // Convert the string array to double array
        for (String s : inputString) {
            inputData.add(Double.parseDouble(s));
        }
        return inputData;
    }

    @FXML
    private void onSampleButtonClicked(){
        // check if text field has non-numeric characters
        if (!inputField.getText().matches("[0-9, ]+")) {
            System.out.println("Invalid input");
            inputField.clear();
            return;
        }
        Calculator.setData(getInputData());
        System.out.println(Calculator.getData());
    }

    @FXML
    private void onPopulationButtonClicked(){
        // check if text field has non-numeric characters
        if (!inputField.getText().matches("[0-9, ]+")) {
            System.out.println("Invalid input");
            inputField.clear();
            return;
        }
        Calculator.setData(getInputData());
        System.out.println(Calculator.getData());
    }

}
