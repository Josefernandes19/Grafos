/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author humberto
 */
public class Aresta {

    private Vertice origem;
    private Vertice destino;
    private double peso;
    private double capacidade;

    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
        this.peso = 1;
    }

    public Aresta(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Aresta(Vertice origem, Vertice destino, double peso, double capacidade) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.capacidade = capacidade;
    }

    public Vertice origem() {
        return origem;
    }

    public void setarOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice destino() {
        return destino;
    }

    public void setarDestino(Vertice destino) {
        this.destino = destino;
    }

    public double peso() {
        return peso;
    }

    public void setarPeso(double peso) {
        this.peso = peso;
    }

    public double capacidade() {
        return capacidade;
    }

    public void setarCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

}
