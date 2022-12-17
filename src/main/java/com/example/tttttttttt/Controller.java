package com.example.tttttttttt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableController {
    private ObservableList<User> shopList = FXCollections.observableArrayList();

    @FXML
    private TableView tableShop;
    @FXML
    private TableColumn<User, String> _name;
    @FXML
    private TableColumn<User, String> _data;
    @FXML
    private TableColumn<User, Integer> _number;
    @FXML
    private TableColumn<User, Double> _prise;
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        _name.setCellValueFactory(new PropertyValueFactory<User, String>("_name"));
        _data.setCellValueFactory(new PropertyValueFactory<User, String>("_data"));
        _number.setCellValueFactory(new PropertyValueFactory<User, Integer>("_number"));
        _prise.setCellValueFactory(new PropertyValueFactory<User, Double>("_prise"));

        // заполняем таблицу данными
        tableShop.setItems(shopList);
    }
    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        shopList.add(new User("Name1", "10.12.2022", 22, 44.56));
        shopList.add(new User("Name2", "10.12.2021", 67, 54.41));
        shopList.add(new User("Name3", "10.11.2022", 42, 67.43));
        shopList.add(new User("Name4", "9.10.2022", 87, 24.61));
    }

}