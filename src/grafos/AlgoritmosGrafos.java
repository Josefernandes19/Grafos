/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author José Renato
 */
public class AlgoritmosGrafos implements AlgoritmosEmGrafos {

    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception, IOException, FileNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Grafo grafo = null;
        int numVert;
        if (t == TipoDeRepresentacao.LISTA_DE_ADJACENCIA) {
            
        }
        File file = new File("entrada.txt");
        BufferedReader arq = new BufferedReader(new FileReader(file));
        String linha;

        String[] split;
        int numLinha = 0;
        while ((linha = arq.readLine()) != null) {

        }
        arq.close();
        return null;
    }

    public Grafo carregarCapacidadeDoGrafo(String path, TipoDeRepresentacao t, Grafo g) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existeCiclo(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Collection<Vertice>> componentesFortementeConectados(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ArrayList<Vertice>> ordenacaoTopologica(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> agmUsandoPrim(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> agmUsandoKruskall(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double custoDaArvoreGeradora(Grafo g, Collection<Aresta> arestas) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean ehArvoreGeradora(Grafo g, Collection<Aresta> arestas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Aresta> caminhoMaisCurto(Grafo g, Vertice origem, Vertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double custoDoCaminho(Grafo g, ArrayList<Aresta> arestas, Vertice origem, Vertice destino) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean ehCaminho(ArrayList<Aresta> arestas, Vertice origem, Vertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> arestasDeArvore(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> arestasDeRetorno(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> arestasDeAvanco(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Aresta> arestasDeCruzamento(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RetornoFluxoMaximoDeCustoMinimo fluxoMaximoDeCustoMinimo(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
