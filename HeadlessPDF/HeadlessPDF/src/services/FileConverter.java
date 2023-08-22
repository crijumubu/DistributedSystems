package services;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class FileConverter implements Runnable{

    private Dictionary<String, String> webpages;
    private ChromeOptions options;
    private ChromeDriver chromeDriver;
    private int threadNumber;

    public FileConverter(Dictionary<String, String> webpages, int threadNumber){

        this.webpages = webpages;
        this.threadNumber = threadNumber;

        options = new ChromeOptions();
        options.addArguments("--headless", "--run-all-compositor-stages-before-draw","--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage", "--enable-automation");

        chromeDriver = new ChromeDriver(options);
    }

    @Override
    public void run() {

        //long startTime = System.nanoTime();

        Enumeration<String> keys = this.webpages.keys();

        while (keys.hasMoreElements()) {

            String name = keys.nextElement();
            String url = webpages.get(name);

            chromeDriver.get(url);

            Map<String, Object> params = new HashMap();
            params.put("credentials_enable_service", false);
            params.put("profile.password_manager_enabled", false);

            String command = "Page.printToPDF";
            Map<String, Object> output = chromeDriver.executeCdpCommand(command, params);

            try {

                FileOutputStream fileOutputStream = new FileOutputStream("./HeadlessPDF/src/outputs/" + name + ".pdf");
                byte[] byteArray = java.util.Base64.getDecoder().decode((String) output.get("data"));
                fileOutputStream.write(byteArray);
                fileOutputStream.close();
                System.out.println("Name: " + name + ", status: done, thread: "+ this.threadNumber + ", path: ./HeadlessPDF/src/outputs/" + name + ".pdf");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        /*long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000000;
        System.out.println("\nThread " + this.threadNumber + ", execution time: " + executionTime + " seconds");*/
    }
}