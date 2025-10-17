/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.practica1_mb;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author Pablo
 */
public class SolrIndexador {
    
    private SolrClient cliente;
    private HttpSolrClient solr;
    
    
    
    public SolrIndexador(String coleccion) throws SolrServerException, IOException{
        
        cliente = new HttpSolrClient.Builder("http://localhost:8983/solr/" + coleccion).build();
        solr = new HttpSolrClient.Builder("http://localhost:8983/solr/" + coleccion).build();

    }
    
    public void añade(int idDoc, String texto) throws SolrServerException, IOException{
        

        SolrInputDocument docUpdate = new SolrInputDocument();
        docUpdate.addField("id", idDoc);
        docUpdate.addField("Texto", texto);

        cliente.add(docUpdate);
            
        cliente.commit();
    }
    
    
}
