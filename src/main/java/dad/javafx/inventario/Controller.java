package dad.javafx.inventario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
public class Controller implements Initializable{

	public Controller() throws IOException {
	 	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Vista.fxml"));
		loader.setController(this);
		loader.load();
	}

	//model
			private StringProperty seleccionados=new SimpleStringProperty();
			private StringProperty disponibles=new SimpleStringProperty();
			private ListProperty<String> selecion=new SimpleListProperty<>(FXCollections.observableArrayList());
			private ListProperty<String> disponible=new SimpleListProperty<>(FXCollections.observableArrayList());
	//view
	    @FXML
	    private GridPane gridpan;

	    @FXML
	    private ListView<String> disponibleList;

	    @FXML
	    private ListView<String> selecionadoList;

	    @FXML
	    private Button leftDoubleArrowButt;

	    @FXML
	    private Button leftArrowButt;

	    @FXML
	    private Button rightArrowButt;

	    @FXML
	    private Button rightDoubleArrowButt;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		selecionadoList.itemsProperty().bind(selecion);
		disponibleList.itemsProperty().bind(disponible);
		selecion.addAll("Tomates", "Lechuga","Melon","Zanahoria");
		disponible.addAll("Jamon","Chorizo","Queso amarillo");
		}
	    @FXML
	    void OnActionLeftArrowButt(ActionEvent event) {
	    	disponible.add(selecionadoList.getSelectionModel().getSelectedItem().toString());
	    	selecion.remove(selecionadoList.getSelectionModel().getSelectedItem().toString());
	    }

	    @FXML
	    void OnActionRightArrowButt(ActionEvent event) {
	    	selecion.add(disponibleList.getSelectionModel().getSelectedItem().toString());
	    	disponible.remove(disponibleList.getSelectionModel().getSelectedItem().toString());
	    }
	    
	    @FXML
	    void OnActionLeftDoubleArrowButt(ActionEvent event) {
	    disponible.addAll(selecion);
	    selecion.removeAll(selecion);
	    }
	    
	    @FXML
	    void OnActionRightDoubleArrowButt(ActionEvent event) {
	       selecion.addAll(disponible);
		   disponible.removeAll(disponible);
	    }
	    
	 public GridPane getGridpan() {
		return gridpan;
	    }

	}