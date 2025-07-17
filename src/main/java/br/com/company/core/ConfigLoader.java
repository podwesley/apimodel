package br.com.company.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Carrega propriedades do arquivo application.properties.
 */
public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.err.println("Arquivo de propriedades 'application.properties' não encontrado no classpath.");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível carregar as propriedades.", ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}