/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author José Renato
 */
public class BuscaEmLargura {

    Vertice[] pais;

    ArrayList<Aresta> caminho = new ArrayList<>();

    public BuscaEmLargura(Grafo l) throws Exception {

        ArrayList<Vertice> vertices = (ArrayList<Vertice>) l.vertices();
        char[] cor = new char[vertices.size()];
        int[] distancia = new int[vertices.size()];
        pais = new Vertice[vertices.size()];

        Vertice raiz = vertices.get(0);
        Queue<Vertice> fila = new LinkedList<>();

        for (int i = 0; i < cor.length; i++) {
            cor[i] = 'b';
            pais[i] = null;
        }
        cor[raiz.id()] = pintar(cor[raiz.id()]);
        distancia[raiz.id()] = 0;
        pais[raiz.id()] = null;
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Vertice pai = fila.remove();
            for (Vertice f : l.adjacentesDe(pai)) {
                if (cor[f.id()] == 'b') {
                    cor[f.id()] = 'c';
                    distancia[f.id()] = distancia[pai.id()] + 1;
                    pais[f.id()] = pai;
                    fila.add(f);
                }

            }
            cor[pai.id()] = 'p';
        }
    }

    private char pintar(char c) throws Exception {
        if (c == 'b') {
            return 'c';
        } else if (c == 'c') {
            return 'p';
        } else {
            throw new Exception("Já pintado");
        }
    }

    public ArrayList<Aresta> caminhoCurto(Grafo l, Vertice raiz, Vertice destino) throws Exception {
        if (destino.id() == raiz.id()) {

        } else if (pais[destino.id()] == null) {
            throw new Exception("Não existe caminho de " + raiz.id() + " para " + destino.id());
        } else {
            caminho.add(new Aresta(destino, pais[destino.id()]));
            caminhoCurto(l, raiz, pais[destino.id()]);
        }
        return caminho;
    }

}
