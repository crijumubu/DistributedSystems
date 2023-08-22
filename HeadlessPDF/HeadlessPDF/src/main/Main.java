package main;

import services.FileConverter;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {

    public static <object> void main(String[] args) {

        System.out.println("Welcome to file converter distributed, we're working on your queries...\n");

        Dictionary<String, String> webpages = new Hashtable<>();

        /* 1) */ webpages.put("Youtube", "https://www.youtube.com/");
        /* 2) */ webpages.put("Amazon", "https://www.amazon.com/");
        /* 3) */ webpages.put("Mercadolibre", "https://www.mercadolibre.com.co/");
        /* 4) */ webpages.put("Spotify", "https://www.spotify.com/co-es/premium/");
        /* 5) */ webpages.put("DXY", "https://www.investing.com/indices/usdollar");
        /* 6) */ webpages.put("UsdToCop", "https://dolar.set-icap.com/");
        /* 7) */ webpages.put("Coinmarketcap", "https://coinmarketcap.com/");
        /* 8) */ webpages.put("Github", "https://github.com/");
        /* 9) */ webpages.put("Binance", "https://www.binance.com/en");
        /* 10) */ webpages.put("Buscalibre", "https://www.buscalibre.com.co/");
        /* 11) */ webpages.put("Whois", "https://www.dondominio.com/es/whois/");
        /* 12) */ webpages.put("Azure", "https://azure.microsoft.com/en-us");

        Enumeration<String> keys = webpages.keys();
        Dictionary<String, String> subwebpages = new Hashtable<>();
        int subDictionaryElements = 0, threads = 1;

        while (keys.hasMoreElements()) {

            String key = keys.nextElement();
            String value = webpages.get(key);

            subwebpages.put(key, value);

            subDictionaryElements++;

            if (subDictionaryElements == 3){ // 4 hilos -> (3 subelementos * 4 = 12 elementos totales)

                Runnable fileConverter = new FileConverter(subwebpages, threads);
                Thread thread = new Thread(fileConverter);
                thread.start();

                subwebpages = new Hashtable<>();
                subDictionaryElements = 0;
                threads++;
            }
        }
    }
}

/*

Java application execution times mesuared manually

*) 12 threads -> 28.75 seg
*) 6 threads -> 20.72 seg
*) 4 threads -> 19.19 seg
*) 3 threads -> 21.30 seg
*) 2 threads -> 23.94 seg
*) 1 thread -> 48.04 seg

*/