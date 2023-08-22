package org.example;

import org.example.services.FileConverter;

import java.util.Dictionary;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to file converter distributed, we're working on your queries...\n");

        Dictionary<String, String> files = new Hashtable<>();

        /* 1) */ files.put("Docx0", ".\\src\\main\\inputs\\docx0.docx");
        /* 2) */ files.put("Png0", ".\\src\\main\\inputs\\png0.png");
        /* 3) */ files.put("Pptx0", ".\\src\\main\\inputs\\pptx0.pptx");
        /* 4) */ files.put("Xlsx0", ".\\src\\main\\inputs\\xlsx0.xlsx");
        /* 5) */ files.put("Docx1", ".\\src\\main\\inputs\\docx1.docx");
        /* 6) */ files.put("Png1", ".\\src\\main\\inputs\\png1.png");
        /* 7) */ files.put("Pptx1", ".\\src\\main\\inputs\\pptx1.pptx");
        /* 8) */ files.put("Xlsx1", ".\\src\\main\\inputs\\xlsx1.xlsx");
        /* 9) */ files.put("Docx2", ".\\src\\main\\inputs\\docx2.docx");
        /* 10) */ files.put("Png2", ".\\src\\main\\inputs\\png2.png");
        /* 11) */ files.put("Pptx2", ".\\src\\main\\inputs\\pptx2.pptx");
        /* 12) */ files.put("Xlsx2", ".\\src\\main\\inputs\\xlsx2.xlsx");

        FileConverter fileConverter = new FileConverter(files);
        fileConverter.ConvertFilesToPDF();
    }
}