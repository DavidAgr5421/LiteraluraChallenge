package com.literalura.challenge.principal;

import com.literalura.challenge.model.Book;
import com.literalura.challenge.model.BookData;
import com.literalura.challenge.repository.BookRepository;
import com.literalura.challenge.service.APIconsume;
import com.literalura.challenge.service.APIresponse;
import com.literalura.challenge.service.dataConverter;

import java.util.Scanner;

public class PrincipalMenu {
    private Scanner scan = new Scanner(System.in);
    private APIconsume api = new APIconsume();
    private dataConverter converter = new dataConverter();
    private final String BASE_URL = "https://gutendex.com/books";
    private BookRepository repository;

    public void showMenu() {
        int userOption = -1;
        while (userOption != 0) {
            String menu = """
                    -------------------------------------
                    Introduce la opción que deseas: (1-5)
                    1 - Buscar libros por titulo.
                    2 - Mostrar libros registrados.
                    3 - Mostrar autores registrados.
                    4 - Mostrar autores vivos en cierto año.
                    5 - Mostrar libros por idioma.
                    
                    0- Salir.
                    -------------------------------------
                    """;

            System.out.println(menu);
            userOption = scan.nextInt();
            scan.nextLine();

            switch (userOption) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    showRegisteredBook();
                    break;
                case 3:
                    showRegisteredAuthors();
                    break;
                case 4:
                    showAuthorsByYear();
                    break;
                case 5:
                    showBooksByLanguage();
                    break;
                case 0:
                    System.out.println();
                    break;
            }
        }
    }

    private void searchByTitle(){
        System.out.println("Escribe el titulo del libro a buscar: ");
        String bookName = scan.nextLine().toLowerCase().replace(" ","+");
        String url = BASE_URL+"?search="+bookName;
        var json = APIconsume.getData(url);
        var data = converter.getData(json, APIresponse.class);
        System.out.println(data);
        System.out.println(json);
        if(data.count() != 0){
            var book = new Book(data.results().get(0));
            repository.save(book);
            System.out.println(book);
        } else{
            System.out.println("El libro no fue encontrado");
        }


    }
    private void showRegisteredBook(){

    }
    private void showRegisteredAuthors(){

    }
    private void showAuthorsByYear(){

    }
    private void showBooksByLanguage(){

    }
}