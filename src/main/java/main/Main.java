package main;
import java.io.File;
import model.Reader;

public class Main {
    public static void main(String[] args) {
        File file = Reader.lookFile("src/main/resources/FileToLook");
        System.out.println(file);

    }
}

