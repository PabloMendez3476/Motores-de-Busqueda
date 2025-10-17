/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.practica1_mb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.solr.client.solrj.SolrServerException;

/**
 *
 * @author Pablo
 */
public class Parser {
    
    private String ruta;
    private Set<String> excluidos;
    private SolrIndexador indexador;
    
    public Parser(String ruta) throws SolrServerException, IOException{
         if (ruta == null) {
            throw new IllegalArgumentException("Error: Ruta vacia");
          }
         
        indexador = new SolrIndexador("nuevaColeccion");
        this.ruta = ruta;
    }
    
    
    public void addCorpus() throws FileNotFoundException, IOException, SolrServerException{
        
        Set<String> indice = new HashSet();
        
        
        int numDoc = 1;
        String line, text;
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        
           
        line = br.readLine();

        while (line != null) {
            if(line.startsWith(".I")){
                text = "";
                System.out.println(numDoc);
                br.readLine();
                line = br.readLine();
                while(line != null && !line.startsWith(".I")){
                    line = br.readLine();
                    text += line;
                }
                
                indexador.añade(numDoc, text);
                //System.out.println(line);
                numDoc++;
            }
            
        }
    }
}
