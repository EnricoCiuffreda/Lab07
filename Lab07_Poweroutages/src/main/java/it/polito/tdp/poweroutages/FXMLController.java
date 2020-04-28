package it.polito.tdp.poweroutages;

import java.net.URL;

import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;
	private ObservableList<Nerc>nerc=FXCollections.observableArrayList();
	
	public void setModel(Model model) {
		this.model=model;
		nerc.addAll(model.getNercList());
		choicebox.setItems(nerc);
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Nerc> choicebox;

    @FXML
    private TextField txtyears;

    @FXML
    private TextField txthours;

    @FXML
    private Button btnricerca;

    @FXML
    private TextArea txtresult;
    
    
    @FXML
    void doRicerca(ActionEvent event) {
    String annostringa=txtyears.getText();
    Integer anno;
	try {
	anno=Integer.parseInt(annostringa);
	} catch(NumberFormatException e) {
		txtresult.setText("Devi inserire un numero\n");
		return;
	}
    String orestringa=txthours.getText();
    Integer ore;
	try {
	ore=Integer.parseInt(orestringa);
	} catch(NumberFormatException e) {
		txtresult.setText("Devi inserire un numero\n");
		return;
	}
	Nerc sceltanerc=choicebox.getValue();
	txtresult.appendText(model.getRicerca(sceltanerc, anno, ore));
    }

    @FXML
    void initialize() {
        assert choicebox != null : "fx:id=\"choicebox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtyears != null : "fx:id=\"txtyears\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txthours != null : "fx:id=\"txthours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnricerca != null : "fx:id=\"btnricerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtresult != null : "fx:id=\"txtresult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
