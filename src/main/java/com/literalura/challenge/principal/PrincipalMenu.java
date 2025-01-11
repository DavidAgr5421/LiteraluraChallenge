package com.literalura.challenge.principal;

import com.literalura.challenge.model.BookData;
import com.literalura.challenge.service.APIconsume;
import com.literalura.challenge.service.APIresponse;
import com.literalura.challenge.service.dataConverter;

import java.util.Scanner;

public class PrincipalMenu {
    private Scanner scan = new Scanner(System.in);
    private APIconsume api = new APIconsume();
    private dataConverter converter = new dataConverter();
    private final String BASE_URL = "https://gutendex.com/books";

    public void showMenu() {
//        System.out.println("Introduzca el nombre del libro a buscar: ");
//        String bookName = scan.nextLine().replace(" ", "+").toLowerCase();

        String url = BASE_URL + "?search=frankenstein";
        System.out.println(url);
        var json = api.getData(url);
        System.out.println(json);
        var data = converter.getData(json, APIresponse.class);
        System.out.println(data);

    }
}