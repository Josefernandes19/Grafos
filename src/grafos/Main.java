/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author José Renato
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AlgoritmosGrafos a = new AlgoritmosGrafos();
        Grafo g = a.carregarGrafo("entrada1.txt", TipoDeRepresentacao.LISTA_DE_ADJACENCIA);
        System.out.println("O grafo foi carregado");
        System.out.println("");
        System.out.println("");
        
        if(a.existeCiclo(g)){
            System.out.println("O grafo tem ciclo");
        }else{
            System.out.println("Não há ciclos no grafo");
        }
        System.out.println("-------------");
        System.out.println("Arestas Arvore");
        System.out.println(a.arestasDeArvore(g).size());
        System.out.println("Arestas de Retorno");
        System.out.println(a.arestasDeRetorno(g).size());
        System.out.println("Aresta de avanço");
        System.out.println(a.arestasDeAvanco(g).size());
       
        
    }
}
