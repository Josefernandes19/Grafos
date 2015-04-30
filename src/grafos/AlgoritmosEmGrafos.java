/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author humberto
 */
public interface AlgoritmosEmGrafos {

    /**
     * Carrega grafo do arquivo texto. O formato será definido do site da
     * disciplina
     *
     * @param path
     * @return um objeto grafo com as informações representadas no arquivo.
     * @throws java.lang.Exception Caminho inválido ou árquivo fora do padrão.
     */
    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception;

    /**
     * Carrega a capacidade do grafo do arquivo texto. O formato será definido
     * do site da disciplina
     *
     * @param path caminho do arquivo
     * @param t tipo de representacao
     * @param g Grafo já instanciado que contem apenas os custos das arestas
     * @return um objeto grafo com as informações de custo e capacidade.
     * @throws java.lang.Exception Caminho inválido ou árquivo fora do padrão.
     */
    public Grafo carregarCapacidadeDoGrafo(String path, TipoDeRepresentacao t, Grafo g) throws Exception;

    /**
     * Verifica se existe ciclo no grafo.
     *
     * @param g Grafo.
     * @return True, se existe ciclo, False, em caso contrário.
     */
    public boolean existeCiclo(Grafo g);

    /**
     * Retorna todos os conjuntos de vértice fortemente conectados.
     *
     * @param g O grafo.
     * @return Retorna todos os conjuntos de vértice fortemente conectados.
     */
    public Collection<Collection<Vertice>> componentesFortementeConectados(Grafo g);

    /**
     * Retorna (em ordem) todos os conjuntos da ordenação topológica.
     *
     * @param g O grafo.
     * @return todos os conjuntos da ordenação topológica.
     */
    public ArrayList<ArrayList<Vertice>> ordenacaoTopologica(Grafo g);

    /**
     * Retorna a árvore geradora mínima utilizando o algoritmo Prim.
     *
     * @param g O grafo.
     * @return Retorna a árvore geradora mínima utilizando o algoritmo Prim.
     */
    public Collection<Aresta> agmUsandoPrim(Grafo g);

    /**
     * Retorna a árvore geradora mínima utilizando o algoritmo Kruskall.
     *
     * @param g O grafo.
     * @return Retorna a árvore geradora mínima utilizando o algoritmo Kruscall.
     */
    public Collection<Aresta> agmUsandoKruskall(Grafo g);

    /**
     * Calcula o custo de uma árvore geradora.
     *
     * @param arestas As arestas que compoem a árvore geradora.
     * @param g O grafo.
     * @return O custo da árvore geradora.
     * @throws java.lang.Exception Se a árvore apresentada não é geradora do
     * grafo.
     */
    public double custoDaArvoreGeradora(Grafo g, Collection<Aresta> arestas) throws Exception;

    /**
     * Testa se a árvore é geradora.
     *
     * @param g
     * @param arestas
     * @return True, se a árvore é árvore geradora, False, caso contrário.
     */
    public boolean ehArvoreGeradora(Grafo g, Collection<Aresta> arestas);

    /**
     * Retorna (em ordem) as arestas que compoem o caminho mais curto entre um
     * par de vértices.
     *
     * @param g
     * @param origem
     * @param destino
     * @return As arestas (em ordem) do caminho mais curto.
     */
    public ArrayList<Aresta> caminhoMaisCurto(Grafo g, Vertice origem, Vertice destino);

    /**
     * Dado um caminho, esta função calcula o custo do caminho.
     *
     * @param arestas
     * @param g
     * @param origem
     * @param destino
     * @return o custo da caminho.
     * @throws java.lang.Exception Se a sequencia apresentada não é um caminho
     * entre origem e destino.
     */
    public double custoDoCaminho(Grafo g, ArrayList<Aresta> arestas, Vertice origem, Vertice destino) throws Exception;

    /**
     * Verifica se a sequencia de arestas é caminho entre oriem e destino.
     *
     * @param arestas
     * @param origem
     * @param destino
     * @return True, se é caminho. False, caso contrário.
     */
    public boolean ehCaminho(ArrayList<Aresta> arestas, Vertice origem, Vertice destino);

    /**
     * Arestas de arvore.
     *
     * @param g
     * @return As arestas de arvore do grafo g.
     */
    public Collection<Aresta> arestasDeArvore(Grafo g);

    /**
     * Arestas de retorno.
     *
     * @param g
     * @return As arestas de retorno do grafo g.
     */
    public Collection<Aresta> arestasDeRetorno(Grafo g);

    /**
     * Arestas de avanço.
     *
     * @param g
     * @return As arestas de avanço do grafo g.
     */
    public Collection<Aresta> arestasDeAvanco(Grafo g);

    /**
     * Arestas de cruzamento.
     *
     * @param g
     * @return As arestas de cruzamento do grafo g.
     */
    public Collection<Aresta> arestasDeCruzamento(Grafo g);

    /**
     * Arestas de cruzamento.
     *
     * @param g
     * @return As arestas de cruzamento do grafo g.
     */
    public RetornoFluxoMaximoDeCustoMinimo fluxoMaximoDeCustoMinimo(Grafo g);

}
