/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author José Renato
 */
public class MatrizAdjacencia implements Grafo {

    Vertice[][] matrizAdj;

    public MatrizAdjacencia(int numVertices) {
        matrizAdj = new Vertice[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdj[i][j] = new Vertice(0);
            }
        }
    }

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino) throws Exception {
        matrizAdj[origem.id()][destino.id()] = new Vertice(1);
    }

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino, double peso) throws Exception {
        matrizAdj[origem.id()][destino.id()] = new Vertice((int) peso);
    }

    @Override
    public boolean existeAresta(Vertice origem, Vertice destino) {
        if (matrizAdj[origem.id()][destino.id()].id() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int grauDoVertice(Vertice vertice) throws Exception {
        int i = 0;
        for (int j = 0; j < matrizAdj.length; j++) {
            if (matrizAdj[vertice.id()][j].id() != 0) {
                i++;
            }
        }
        return i;
    }

    @Override
    public int numeroDeVertices() {
        return matrizAdj.length;
    }

    @Override
    public int numeroDeArestas() {
        int count = 0;
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj.length; j++) {
                if (matrizAdj[i][j].id() != 0) {
                    i++;
                }
            }
        }
        return count;
    }

    @Override
    public Collection<Vertice> adjacentesDe(Vertice vertice) throws Exception {
        ArrayList<Vertice> verticesAdjacentes = new ArrayList<Vertice>();

        for (int i = 0; i < matrizAdj.length; i++) {
            if (matrizAdj[vertice.id()][i].id() != 0) {
                verticesAdjacentes.add(matrizAdj[vertice.id()][i]);
            }
        }

        return verticesAdjacentes;
    }

    @Override
    public void setarPeso(Vertice origem, Vertice destino, double peso) throws Exception {
        matrizAdj[origem.id()][destino.id()] = new Vertice((int) peso);
    }

    @Override
    public void setarCapacidade(Vertice origem, Vertice destino, double capacidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Aresta> arestasEntre(Vertice origem, Vertice destino) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vertice> vertices() {
        Collection<Vertice> vert = new ArrayList<Vertice>();
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj.length; j++) {
                vert.add(matrizAdj[i][j]);
            }
        }
        return vert;
    }

}
