/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author José Renato
 */
public class ListaAdjacencia implements Grafo {

    List<Aresta>[] vertices;

    int numVertices;

    public ListaAdjacencia(int numVertices) {
        vertices = new LinkedList[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertices[i] = new LinkedList<>();
        }

    }

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino) throws Exception {
        vertices[origem.id()].add(new Aresta(origem, destino));
    }

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino, double peso) throws Exception {
        vertices[origem.id()].add(new Aresta(origem, destino, peso));
    }

    @Override
    public boolean existeAresta(Vertice origem, Vertice destino) {
        return false;
    }

    @Override
    public int grauDoVertice(Vertice vertice) throws Exception {
        return vertices[vertice.id()].size();
    }

    @Override
    public int numeroDeVertices() {
        return vertices.length;
    }

    @Override
    public int numeroDeArestas() {
        int soma = 0;
        for (int i = 0; i < vertices.length; i++) {
            soma += vertices[i].size();
        }
        return soma;
    }

    public Collection<Vertice> adjacentesDe(Vertice vertice) throws Exception {
        Vertice[] vert;
//        return vertice[vertice.id()];
        vert = new Vertice[vertices[vertice.id()].size()];
        for (int i = 0; i < vertices[vertice.id()].size(); i++) {
            int dest = vertices[vertice.id()].get(i).destino().id();
            Vertice destino = new Vertice(dest);
            vert[i] = destino;
        }

        return new ArrayList<Vertice>(Arrays.asList(vert));

    }

    @Override
    public void setarPeso(Vertice origem, Vertice destino, double peso) throws Exception {
        if (vertices[origem.id()] == null) {
            throw new UnsupportedOperationException("Nao existe vertice de Origem"); //To change body of generated methods, choose Tools | Templates.
        }
        int ind = -1;
        Aresta compara = new Aresta(origem, destino);
        for (int i = 0; i < vertices[origem.id()].size(); i++) {
            if (compara == vertices[origem.id()].get(i)) {
                ind = i;
            }
        }
        if (ind == -1) {
            throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
        } else {
            vertices[origem.id()].get(ind).setarPeso(peso);
        }
    }

    @Override
    public void setarCapacidade(Vertice origem, Vertice destino, double capacidade) throws Exception {
        if (origem.id() > vertices.length) {
            System.out.println("Não existe esse vértice");

        } else {
            int ind = -1;
            Aresta compara = new Aresta(origem, destino);
            for (int i = 0; i < vertices[origem.id()].size(); i++) {
                if (compara == vertices[origem.id()].get(i)) {
                    ind = i;
                }
            }
            if (ind == -1) {
                throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
            } else {
                vertices[origem.id()].get(ind).setarCapacidade(capacidade);
            }
        }
    }

    @Override
    public Collection<Aresta> arestasEntre(Vertice origem, Vertice destino) throws Exception {
        throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vertice> vertices() {
        Vertice[] v = new Vertice[numeroDeVertices()];
        for (int i = 0; i < numeroDeVertices(); i++) {
            v[i] = new Vertice(i);
        }
        ArrayList<Vertice> colecaoVertices = new ArrayList<Vertice>(Arrays.asList(v));
        return colecaoVertices;
    }

}
