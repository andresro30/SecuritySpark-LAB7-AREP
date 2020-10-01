package edu.escuelaing.arep.client;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Propiedades de la clase URLReader
 */
public class URLReader {

    /**
     * Método principal de la clase
     *
     * @param args de tipo String[]
     */
    public static void main(String[] args) {

        // Create a file and a password representation
        File trustStoreFile = new File("keyStores/myTrustStore");
        char[] trustStorePassword = "987654".toCharArray();
        // Load the trust store, the default type is "pkcs12", the alternative is "jks"
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        // Get the singleton instance of the TrustManagerFactory
        TrustManagerFactory tmf = null;
        try {
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Itit the TrustManagerFactory using the truststore object
        try {
            tmf.init(trustStore);
            //Set the default global SSLContext so all the connections will use it
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        readURL("https://localhost:4567/hellow");
    }

    /**
     * Método encargado de leer una url
     *
     * @param site de tipo String
     */
    public static void readURL(String site) {
        try {
            URL siteUrl = new URL(site);
            try {
                // Crea el objeto que representa una URL
                URL siteURL = new URL(site);
                // Crea el objeto que URLConnection
                URLConnection urlConnection = siteURL.openConnection();
                // Obtiene los campos del encabezado y los almacena en un estructura Map
                Map<String, List<String>> headers = urlConnection.getHeaderFields();
                // Obtiene una vista del mapa como conjunto de pares <K,V>
                // para poder navegarlo
                Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
                // Recorre la lista de campos e imprime los valores
                for (Map.Entry<String, List<String>> entry : entrySet) {
                    String headerName = entry.getKey();
                    //Si el nombre es nulo, significa que es la linea de estado
                    if (headerName != null) {
                        System.out.print(headerName + ":");
                    }
                    List<String> headerValues = entry.getValue();
                    for (String value : headerValues) {
                        System.out.print(value);
                    }
                    System.out.println("");
                    //System.out.println("");
                }
                System.out.println("-------message-body------");
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}