package com.example.tttttttttt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Comparator;



public class Controller {

    private ObservableList<Shop> shopList = FXCollections.observableArrayList();
ShopList s=new ShopList();

    @FXML
    private TableView<Shop> tableShop;

    @FXML
    private TableColumn<Shop, String> nameColumn;

    @FXML
    private TableColumn<Shop, String> dataColumn;

    @FXML
    private TableColumn<Shop, Integer> numberColumn;

    @FXML
    private TableColumn<Shop, Double> priseColumn;

    @FXML
    private Button addDate;
    @FXML
    private TextField dateV;
    @FXML
    private TextField nameV;
    @FXML
    private TextField numberV;
    @FXML
    private TextField priseV;
    @FXML
    private TextField sV;

    @FXML
    private Button search;

    @FXML
    private TextField searchTwxt;

    @FXML
    private Button sortName;

    @FXML
    private Button sortPrise;


    // инициализируем форму данными
    @FXML
    private void initialize() throws IOException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        nameColumn.setCellValueFactory(new PropertyValueFactory<Shop, String>("name"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<Shop, String>("data"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("number"));
        priseColumn.setCellValueFactory(new PropertyValueFactory<Shop, Double>("prise"));

        // заполняем таблицу данными
        tableShop.setItems(shopList);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() throws IOException {
        s.readJSON("input.json");
       for(int i=0; i<s.getShopList().size(); ++i) {
           shopList.add(s.getShopList().get(i));
       }
    }
    @FXML
    void add(ActionEvent event) {
        shopList.add(new Shop(nameV.getText(), dateV.getText(), Integer.parseInt(numberV.getText()), Double.parseDouble(priseV.getText())));
        nameV.clear();
        dateV.clear();
        numberV.clear();
        priseV.clear();
    }


    public void sort(Comparator<Shop> compere) {
        shopList.sort(compere);
    }
    @FXML
    void sortNameAction(ActionEvent event) {
        Comparator<Shop> compare=new Shop.ShopComparatorName();
        shopList.sort(compare);
    }

    @FXML
    void sortPriseAction(ActionEvent event) {
        Comparator<Shop> compare=new Shop.ShopComparatorPrise();
        shopList.sort(compare);
    }

    @FXML
    void serchAction(ActionEvent event) {
        // sV.setText(shopList.searchByName(searchTwxt.getText()));
        String poisk = searchTwxt.getText();
        String res = "";
        for (int i = 0; i < shopList.size(); ++i) {

            if (poisk.equals(shopList.get(i).getName())) {
                if (res.equals("")) {
                    res = shopList.get(i).toString();
                } else {
                    res = res + "    " + shopList.get(i).toString();
                }
            }
            sV.setText(res);
        }

    }

}