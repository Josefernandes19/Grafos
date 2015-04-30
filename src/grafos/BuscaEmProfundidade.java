/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author José Renato
 */
public class BuscaEmProfundidade {

    char[] cor;
    int tempo;
    int[][] tempoVertice;
    Map<Aresta, TipoArvore> arvore;

    public BuscaEmProfundidade(Grafo l) throws Exception {

        ArrayList<Vertice> vertices = (ArrayList<Vertice>) l.vertices();
        cor = new char[vertices.size()];
        tempoVertice = new int[vertices.size()][2];
        arvore = new HashMap<>();

        for (int i = 0; i < cor.length; i++) {
            cor[i] = 'b';
        }

        tempo = 0;

        for (Vertice vertice : vertices) {
            if (cor[vertice.id()] == 'b') {
                visita(l, vertice);
            }
        }
    }

    private void visita(Grafo l, Vertice vertice) throws Exception {
        tempo = tempo + 1;
        tempoVertice[vertice.id()][0] = tempo;
        cor[vertice.id()] = 'c';
        for (Vertice verticeFilho : l.adjacentesDe(vertice)) {
            if (cor[verticeFilho.id()] == 'b') {
                visita(l, verticeFilho);
                arvore.put(new Aresta(vertice, verticeFilho), TipoArvore.ARESTA_DE_ARVORE);
            } else if (cor[verticeFilho.id()] == 'c') {
                arvore.put(new Aresta(vertice, verticeFilho), TipoArvore.ARESTA_DE_RETORNO);
            } else {
                if (tempoVertice[vertice.id()][0] < tempoVertice[verticeFilho.id()][0]) {
                    arvore.put(new Aresta(vertice, verticeFilho), TipoArvore.ARESTA_DE_AVANCO);
                } else if (tempoVertice[vertice.id()][0] > tempoVertice[verticeFilho.id()][0]) {
                    arvore.put(new Aresta(vertice, verticeFilho), TipoArvore.ARESTA_DE_CRUZAMENTO);
                }
            }
        }
        cor[vertice.id()] = 'p';
        tempo = tempo + 1;
        tempoVertice[vertice.id()][1] = tempo;
    }

    public Collection<Aresta> ArestaDeArvore() {
        Collection<Aresta> arestaDeArvore = new LinkedList<>();
        for (Map.Entry<Aresta, TipoArvore> t : arvore.entrySet()) {
            if (t.getValue() == TipoArvore.ARESTA_DE_ARVORE) {
                arestaDeArvore.add(t.getKey());
            }
        }
        return arestaDeArvore;
    }

    public Collection<Aresta> ArestaDeRetorno() {
        Collection<Aresta> arestaDeRetorno = new LinkedList<>();
        for (Map.Entry<Aresta, TipoArvore> t : arvore.entrySet()) {
            if (t.getValue() == TipoArvore.ARESTA_DE_ARVORE) {
                arestaDeRetorno.add(t.getKey());
            }
        }
        return arestaDeRetorno;
    }

    public Collection<Aresta> ArestaDeAvanco() {
        Collection<Aresta> arestaDeAvanco = new LinkedList<>();
        for (Aresta t : arvore.keySet()) {
            if (arvore.get(t) == TipoArvore.ARESTA_DE_AVANCO) {
                arestaDeAvanco.add(t);
            }
        }
        return arestaDeAvanco;
    }

    public Collection<Aresta> ArestaDeCruzamento() {
        Collection<Aresta> arestaDeCruzamento = new LinkedList<>();
        for (Aresta t : arvore.keySet()) {
            if (arvore.get(t) == TipoArvore.ARESTA_DE_CRUZAMENTO) {
                arestaDeCruzamento.add(t);
            }
        }
        return arestaDeCruzamento;
    }
}
