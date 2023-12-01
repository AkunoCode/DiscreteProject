package com.discrete.finalsproject.Controllers;

import com.discrete.finalsproject.Models.Calculator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // TODO: Table [Columns: Data, Data - Mean, (Data - Mean)^2] - Johann
    // TODO: Histogram/Graph - Leo
    @FXML
    private TextField inputField;

    @FXML
    private ImageView populationBtn;

    @FXML
    private ImageView sampleBtn;

    @FXML
    private AnchorPane scroll;

    // Buttons
    Image sampleBtnImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/SampleBtn.png")));
    Image sampleBtnImgClicked = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/SampleBtn_P.png")));

    Image populationBtnImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/PopulationBtn.png")));
    Image populationBtnImgClicked = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/discrete/finalsproject/Assets/PopulationBtn_P.png")));

    String clickedButton = "None";
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
        buttonChange("Sample");

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
        buttonChange("Population");

        // check if text field has non-numeric characters
        if (!inputField.getText().matches("[0-9, ]+")) {
            System.out.println("Invalid input");
            inputField.clear();
            return;
        }

        Calculator.setData(getInputData());
        System.out.println(Calculator.getData());
    }

    private void buttonChange(String button){
        if (Objects.equals(button, clickedButton)) return;

        if (button.equals("Population")){
            // change button images
            populationBtn.setImage(populationBtnImgClicked);
            sampleBtn.setImage(sampleBtnImg);

            // Move the population down by 10 and right by 10
            populationBtn.setLayoutX(populationBtn.getLayoutX() + 10);
            populationBtn.setLayoutY(populationBtn.getLayoutY() + 10);

            if (clickedButton.equals("Sample")) {
                // Move the sample down back to 0 and right back to 0
                sampleBtn.setLayoutX(sampleBtn.getLayoutX() - 10);
                sampleBtn.setLayoutY(sampleBtn.getLayoutY() - 10);
            }

            clickedButton = "Population";
        } else if (button.equals("Sample")){
            System.out.println("Sample");
            // change button images
            populationBtn.setImage(populationBtnImg);
            sampleBtn.setImage(sampleBtnImgClicked);

            // Move the sample down by 10 and right by 10
            sampleBtn.setLayoutX(sampleBtn.getLayoutX() + 10);
            sampleBtn.setLayoutY(sampleBtn.getLayoutY() + 10);

            if (clickedButton.equals("Population")) {
                // Move the population down back to 0 and right back to 0
                populationBtn.setLayoutX(populationBtn.getLayoutX() - 10);
                populationBtn.setLayoutY(populationBtn.getLayoutY() - 10);
            }

            clickedButton = "Sample";
        } else {
            // change button images
            populationBtn.setImage(populationBtnImg);
            sampleBtn.setImage(sampleBtnImg);

            if (clickedButton.equals("Population")) {
                // Move the population down back to 0 and right back to 0
                populationBtn.setLayoutX(populationBtn.getLayoutX() - 10);
                populationBtn.setLayoutY(populationBtn.getLayoutY() - 10);
            } else if (clickedButton.equals("Sample")) {
                // Move the sample down back to 0 and right back to 0
                sampleBtn.setLayoutX(sampleBtn.getLayoutX() - 10);
                sampleBtn.setLayoutY(sampleBtn.getLayoutY() - 10);
            }
            clickedButton = "None";
        }
    }

    @FXML
    private void onXButtonClicked(){
        // Clear the input field
        inputField.clear();

        // Clear the data
        Calculator.setData(new ArrayList<>());

        // Reset the buttons
        buttonChange("None");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Make the scroll pane scrollable
        Double yPosition = scroll.getLayoutY();
        scroll.setOnScroll(scrollEvent -> {
            if (scroll.getLayoutY() + scrollEvent.getDeltaY() > yPosition) return;
            scroll.setLayoutY(scroll.getLayoutY() + scrollEvent.getDeltaY());
        });
    }
}
