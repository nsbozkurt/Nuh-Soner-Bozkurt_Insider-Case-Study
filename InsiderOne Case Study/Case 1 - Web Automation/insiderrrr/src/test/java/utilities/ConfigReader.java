package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        // Okunacak dosyanın yolu (Projenin ana dizininde olmalı)
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Konfigürasyon dosyası okunamadı! Lütfen 'configuration.properties' dosyasını kontrol edin.");
            e.printStackTrace();
        }
    }

    // İstenen key'in değerini getiren metod
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}