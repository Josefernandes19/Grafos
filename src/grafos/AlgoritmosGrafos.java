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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Renato
 */
public class AlgoritmosGrafos implements AlgoritmosEmGrafos {

    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception, IOException, FileNotFoundException {
        
        Grafo grafo = null;

        int numeroDeVertices;
        File arquivoCarregado;
        FileReader arq;
        Scanner read;

        try {
            arquivoCarregado = new File(path);
            arq = new FileReader(arquivoCarregado);
            read = new Scanner(arq);

            numeroDeVertices = read.nextInt();
            if (t == TipoDeRepresentacao.LISTA_DE_ADJACENCIA) {
                grafo = new ListaAdjacencia(numeroDeVertices);

            } else if (t == TipoDeRepresentacao.MATRIZ_DE_ADJACENCIA) {
                grafo = new MatrizAdjacencia(numeroDeVertices);
            } else {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            read.nextLine();
            while (read.hasNextLine()) {
                
                String linha = read.nextLine();
                if (linha != "") {
                    String splitVert[] = linha.split(" ", 2);
                    int v = Integer.parseInt(String.valueOf(splitVert[0]));
                    if (splitVert.length != 1 && splitVert[1] != null) {
                        Vertice verticeOrigem = new Vertice(v);
                        String[] val = splitVert[1].split("; |;");
                        for (int i = 0; i < val.length; i++) {
                            String[] splitT = val[i].split("-");

                            int indVertDestino = Integer.parseInt(splitT[0]);
                            Vertice verticeDestino = new Vertice(indVertDestino);
                            double peso = Double.parseDouble(splitT[1]);
                            grafo.adicionarAresta(verticeOrigem, verticeDestino, peso);

                        }
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("Não foi possível carregar o arquivo");
            System.out.println(e.toString());
        } catch (NumberFormatException n) {
        }
        return grafo;
    }

    public Grafo carregarCapacidadeDoGrafo(String path, TipoDeRepresentacao t, Grafo g) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeCiclo(Grafo g) {
        Collection<Aresta> c = arestasDeRetorno(g);
        if (c == null || c.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Collection<Collection<Vertice>> componentesFortementeConectados(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ArrayList<Vertice>> ordenacaoTopologica(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Aresta> agmUsandoPrim(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Aresta> agmUsandoKruskall(Grafo g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double custoDaArvoreGeradora(Grafo g, Collection<Aresta> arestas) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ehArvoreGeradora(Grafo g, Collection<Aresta> arestas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Aresta> caminhoMaisCurto(Grafo g, Vertice origem, Vertice destino) {
        BuscaEmLargura busca;
        try {
            busca = new BuscaEmLargura(g);
            ArrayList<Aresta> p = busca.caminhoCurto(g, origem, destino);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double custoDoCaminho(Grafo g, ArrayList<Aresta> arestas, Vertice origem, Vertice destino) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ehCaminho(ArrayList<Aresta> arestas, Vertice origem, Vertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Aresta> arestasDeArvore(Grafo g) {
        try {
            BuscaEmProfundidade busca = new BuscaEmProfundidade(g);
            return busca.ArestaDeArvore();
        } catch (Exception ex) {
            Logger.getLogger(AlgoritmosGrafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Collection<Aresta> arestasDeRetorno(Grafo g) {
        try {
            BuscaEmProfundidade busca = new BuscaEmProfundidade(g);
            return busca.ArestaDeRetorno();
        } catch (Exception ex) {
            Logger.getLogger(AlgoritmosGrafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Collection<Aresta> arestasDeAvanco(Grafo g) {
        try {
            BuscaEmProfundidade busca = new BuscaEmProfundidade(g);
            return busca.ArestaDeAvanco();
        } catch (Exception ex) {
            Logger.getLogger(AlgoritmosGrafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Collection<Aresta> arestasDeCruzamento(Grafo g) {
        try {
            BuscaEmProfundidade busca = new BuscaEmProfundidade(g);
            return busca.ArestaDeCruzamento();
        } catch (Exception ex) {
            Logger.getLogger(AlgoritmosGrafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RetornoFluxoMaximoDeCustoMinimo fluxoMaximoDeCustoMinimo(Grafo g
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
