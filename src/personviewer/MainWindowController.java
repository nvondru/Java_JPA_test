/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personviewer;

import db_query.PlayerQuery;
import Model.Players;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nicolas Vondru
 */
public class MainWindowController implements Initializable {

    private List<Players> listPlayers;
    Players selectedPlayer;
    private PlayerQuery query = new PlayerQuery();
    @FXML
    private TableView<Players> playerCollection;
    @FXML
    private TableColumn<Players, String> gameTag;
    @FXML
    private TableColumn<Players, String> name;
    @FXML
    private TableColumn<Players, String> prename;
    @FXML
    private TableColumn<Players, String> position;
    @FXML
    private TextField displayGameTag;
    @FXML
    private TextField displayName;
    @FXML
    private TextField displayPrename;
    @FXML
    private TextField displayPosition;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        initTableFunctionality();
        updatePlayersCollection();        
    }    

    private void initTableFunctionality() {
        gameTag.setCellValueFactory(new PropertyValueFactory<>("gameTag"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        prename.setCellValueFactory(new PropertyValueFactory<>("prename"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        
        playerCollection.setOnMouseReleased((event) -> {
            selectedPlayer = (Players)playerCollection.getSelectionModel().getSelectedItem();
            displayGameTag.setText(selectedPlayer.getGameTag());
            displayName.setText(selectedPlayer.getName());
            displayPrename.setText(selectedPlayer.getPrename());
            displayPosition.setText(selectedPlayer.getPosition());
        });
    }

    @FXML
    private void savePlayerData(ActionEvent event) {        
        if(selectedPlayer != null){     
            System.out.println("Player " + selectedPlayer.getGameTag() + " is seleceted");
            query.beginTransaction();
            selectedPlayer.setGameTag(displayGameTag.getText());
            selectedPlayer.setName(displayName.getText());
            selectedPlayer.setPrename(displayPrename.getText());
            selectedPlayer.setPosition(displayPosition.getText());  
            query.commitTransaction();            
        }   
//        else{
//            System.out.println("No PLayer selected");
//        }
        
        updatePlayersCollection();
    }

    private void updatePlayersCollection() {
//        playerCollection.setItems(null);
        listPlayers = query.listPlayers();        
        playerCollection.setItems(FXCollections.observableArrayList(listPlayers));
//        selectedPlayer = null;
    }

    @FXML
    private void deletePlayer(ActionEvent event) {
//        playerCollection.setItems(null);
        listPlayers.clear();
    }

    
    
}
