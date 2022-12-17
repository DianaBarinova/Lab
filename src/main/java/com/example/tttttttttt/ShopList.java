package com.example.tttttttttt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopList {
    ArrayList<Shop> shopList;

    public ShopList(ArrayList<Shop> shelf) {
        this.shopList = shelf;
    }

    public ShopList() {
        this.shopList = new ArrayList<Shop>();
    }
    public void readJSON(String jsonFileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBookArray = "";
        Scanner sc = new Scanner(new FileReader(jsonFileName));
        while (sc.hasNextLine()){
            jsonBookArray += sc.nextLine();
        }
        List<Shop> list = objectMapper.readValue(jsonBookArray, new TypeReference<List<Shop>>(){});
        this.shopList = new ArrayList<Shop>(list);
    }
    public void showAll(){
        shopList.stream().forEach(System.out::println);
    }

    public ArrayList<Shop> getShopList() {
        return shopList;
    }


}
