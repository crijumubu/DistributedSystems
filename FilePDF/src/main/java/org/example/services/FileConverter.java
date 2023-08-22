package org.example.services;

import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.jodconverter.core.office.OfficeManager;

import java.io.File;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class FileConverter{

    private Dictionary<String, String> files;
    private OfficeManager officeManager;

    public FileConverter(Dictionary<String, String> files){

        this.files = files;

        this.officeManager = LocalOfficeManager.builder()
            .officeHome("C:\\Program Files\\LibreOffice")
            .install()
            .build();
    }

    public void ConvertFilesToPDF(){

        try {

            this.officeManager.start();

            Dictionary<String, File> subfiles = new Hashtable<>();
            Enumeration<String> keys = this.files.keys();
            Thread[] threads = new Thread[files.size()];
            int thread = 0;

            while (keys.hasMoreElements()) {

                String name = keys.nextElement();
                String path = files.get(name);
                File inputFile = new File(path);

                subfiles.put(name, inputFile);

                if (subfiles.size() == 3){ // 4 hilos -> (12 elementos / 3 subelementos = 4 hilos en total)

                    int finalThread = thread;
                    Dictionary<String, File> finalSubfiles = subfiles;

                    threads[thread] = new Thread(() -> ConvertFileToPdf(finalSubfiles, finalThread));
                    threads[thread].start();

                    thread++;
                    subfiles = new Hashtable<>();
                }
            }

            // Espera a que todos los hilos terminen
            for (Thread ethread : threads) {

                ethread.join();
            }

            this.officeManager.stop();

        } catch (Exception ignored) {}
    }

    private void ConvertFileToPdf(Dictionary<String, File> files, int thread) {

        Enumeration<String> keys = files.keys();
        while (keys.hasMoreElements()) {

            String name = keys.nextElement();
            File inputFile = files.get(name);

            File outputFile = new File(".\\src\\main\\outputs\\" + name + ".pdf");

            try{

                LocalConverter converter = LocalConverter.make(this.officeManager);
                converter.convert(inputFile).to(outputFile).execute();
                System.out.println("Name: " + name + ", status: done, thread: "+ (thread + 1) + ", path: ./src/main/outputs/" + name + ".pdf");

            }
            catch (Exception ignored) {}
        }
    }
}