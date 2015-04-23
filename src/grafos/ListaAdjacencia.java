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

    List<List<Aresta>> vertices = new ArrayList<List<Aresta>>();
    int numVertices;

    public ListaAdjacencia(int numVertices) {
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertices.add(null);
        }
        for (List<Aresta> v : vertices) {
            v = new ArrayList<Aresta>();
        }

    }

    public void adicionarAresta(Vertice origem, Vertice destino) throws Exception {
        vertices.get(origem.id()).add(new Aresta(origem, destino));
    }

    public void adicionarAresta(Vertice origem, Vertice destino, double peso) throws Exception {
        vertices.get(origem.id()).add(new Aresta(origem, destino, peso));
    }

    public boolean existeAresta(Vertice origem, Vertice destino) {
        Aresta aresta = new Aresta(origem, destino);
        List<Aresta> adjacentes = vertices.get(origem.id());
        for (Aresta a : adjacentes) {
            if (a == aresta) {
                return true;
            }
        }
        return false;
    }

    public int grauDoVertice(Vertice vertice) throws Exception {
        return vertices.get(vertice.id()).size();
    }

    public int numeroDeVertices() {
        return vertices.size();
    }

    public int numeroDeArestas() {
        int soma = 0;
        for (int i = 0; i < vertices.size(); i++) {
            soma += vertices.get(i).size();
        }
        return soma;
    }

    public Collection<Vertice> adjacentesDe(Vertice vertice) throws Exception {
        Vertice[] vert;
        vert = new Vertice[vertices.get(vertice.id()).size()];
        for (int i = 0; i < vertices.get(vertice.id()).size(); i++) {
            int dest = vertices.get(vertice.id()).get(i).destino().id();
            Vertice destino = new Vertice(dest);
            vert[i] = destino;
        }

        return new ArrayList<Vertice>(Arrays.asList(vert));

    }

    public void setarPeso(Vertice origem, Vertice destino, double peso) throws Exception {
        if (!vertices.contains(origem)) {
            throw new UnsupportedOperationException("Nao existe vertice de Origem"); //To change body of generated methods, choose Tools | Templates.
        }
        int ind = -1;
        Aresta compara = new Aresta(origem, destino);
        for (int i = 0; i < vertices.get(origem.id()).size(); i++) {
            if (compara == vertices.get(origem.id()).get(i)) {
                ind = i;
            }
        }
        if (ind == -1) {
            throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
        } else {
            vertices.get(origem.id()).get(ind).setarPeso(peso);
        }
    }

    public void setarCapacidade(Vertice origem, Vertice destino, double capacidade) throws Exception {
        if (origem.id() > vertices.size()) {
            System.out.println("Não existe esse vértice");

        } else {
            int ind = -1;
            Aresta compara = new Aresta(origem, destino);
            for (int i = 0; i < vertices.get(origem.id()).size(); i++) {
                if (compara == vertices.get(origem.id()).get(i)) {
                    ind = i;
                }
            }
            if (ind == -1) {
                throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
            } else {
                vertices.get(origem.id()).get(ind).setarCapacidade(capacidade);
            }
        }
    }

    public Collection<Aresta> arestasEntre(Vertice origem, Vertice destino) throws Exception {
        throw new UnsupportedOperationException("Não existe essa Aresta"); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Vertice> vertices() {
        Vertice[] v = new Vertice[numeroDeVertices()];
        for (int i = 0; i < numeroDeVertices(); i++) {
            v[i] = new Vertice(i);
        }
        ArrayList<Vertice> colecaoVertices = new ArrayList<Vertice>(Arrays.asList(v));
        return colecaoVertices;
    }

}
