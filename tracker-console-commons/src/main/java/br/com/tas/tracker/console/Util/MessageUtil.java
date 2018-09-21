package br.com.tas.tracker.console.Util;


import br.com.tas.tracker.console.enums.ResourceBundles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.*;

public class MessageUtil {

    /**
     * Instance
     */
    private static final MessageUtil instance = new MessageUtil();

    /**
     * Singleton para recuperar arquivos Bundle
     */
    public static MessageUtil getInstance() {
        return instance;
    }

    /**
     * Map com todos so bundles
     */
    private final Map<String, ResourceBundle> resources = new HashMap<String, ResourceBundle>();

    private MessageUtil() {

    }

    /**
     * Retorna a string formatada, de acordo com os parametros passados. <br/>
     * <strong>O Locale padrão é pt_BR, logo só encontrará arquivos que contiverem o mesmo.</strong>
     *
     * @param arquivo
     * @param chave
     * @param params
     * @return
     */
    public String getString(String arquivo, String chave, String... params) {
        loadBundleFile(arquivo);
        ResourceBundle bundle = resources.get(arquivo);
        if (bundle == null) {
            throw new RuntimeException("Arquivo properties não encontrado: " + arquivo);
        }
        MessageFormat formatter = new MessageFormat("");
        formatter.applyPattern(bundle.getString(chave));
        String output = formatter.format(params);
        return output;
    }

    /**
     * Carrega o arquivo
     *
     * @param arquivo
     */
    private void loadBundleFile(String arquivo) {
        if (resources.get(arquivo) != null) {
            return;
        }
        ResourceBundle bundle;
        if (ResourceBundles.HIBERNATE_CONSOLE.getDesc().equals(arquivo)) {
            FileInputStream fis = null;
            try {
//                fis = new FileInputStream(PATH_PROPERTIES_WORKSPACE + arquivo);
                fis = new FileInputStream(System.getProperty("tracker.propertiesDir") + arquivo);
                bundle = new PropertyResourceBundle(fis);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Properties file not found: " + arquivo);
            } catch (IOException e) {
                throw new RuntimeException("Properties file not found: " + arquivo);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        // ignored.
                    }
                }
            }

        } else {
            bundle = ResourceBundle.getBundle(arquivo);
            bundle.getLocale().setDefault(new Locale("pt"));

        }
        if (bundle == null) throw new RuntimeException("Properties file not found: " + arquivo);
        resources.put(arquivo, bundle);
    }

    /**
     * Verifica se esta chave está no arquivo especificado
     *
     * @param arquivo
     * @param key
     * @return
     */
    public boolean containsKey(String arquivo, String key) {
        loadBundleFile(arquivo);
        ResourceBundle bundle = resources.get(arquivo);
        return bundle.containsKey(key);
    }

    /**
     * Retorna o valor verdadeiro ou falso de acordo com a chave
     *
     * @param arquivo
     * @param key
     * @return
     */
    public boolean getBoolean(String arquivo, String key) {
        loadBundleFile(arquivo);
        ResourceBundle bundle = resources.get(arquivo);
        return Boolean.parseBoolean(bundle.getString(key));
    }

    /**
     * Should load a .properties file (SSH Machine)
     *
     * @param nomeArquivo
     * @return
     */
    public static Properties loadProperties(String nomeArquivo) {
        Properties properties = new Properties();

        try {
            FileInputStream input = new FileInputStream(System.getProperty("tracker.propertiesDir") + nomeArquivo);
            properties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }


}
