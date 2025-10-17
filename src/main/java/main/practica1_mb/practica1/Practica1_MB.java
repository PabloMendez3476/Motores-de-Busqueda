/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.practica1_mb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrServerException;
/**
 *
 * @author Pablo
 */
public class Practica1_MB {

    public static void main(String[] args) throws SolrServerException, IOException {
        String file = "..\\.\\corpus\\MED.ALL";
        //System.out.println("Working dir: " + System.getProperty("user.dir"));
        
        Parser parser = new Parser(file);
        
        try {
            parser.addCorpus();
        } catch (IOException ex) {
            System.out.println("An error occurred: ");
            ex.printStackTrace();
        }
    }
}
