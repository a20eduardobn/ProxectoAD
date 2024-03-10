package com.example.proxectoadeduardobn.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class QueryDialogController {
    @FXML
    private TextArea customQueryTextArea;

    @FXML
    private TextArea queryOutputTextArea;

    public void writeToOutput(String s){
        queryOutputTextArea.setText(s);
    }

    public String obtainQuery(){
        return customQueryTextArea.getText();
    }
}
