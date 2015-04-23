/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafos;

import java.util.*;


/**
 *
 * @author humberto
 */
public class RetornoFluxoMaximoDeCustoMinimo {
    private double valorDoFluxoMaximoDeCustoMinimo;
    private double custoDoFluxoMaximoDeCustoMinimo;
    private Collection<Aresta> fluxo;

    public double valorDoFluxoMaximoDeCustoMinimo() {
        return valorDoFluxoMaximoDeCustoMinimo;
    }

    public void setarValorDoFluxoMaximoDeCustoMinimo(double valorDoFluxoMaximoDeCustoMinimo) {
        this.valorDoFluxoMaximoDeCustoMinimo = valorDoFluxoMaximoDeCustoMinimo;
    }

    public Collection<Aresta> getFluxo() {
        return fluxo;
    }

    public void setarFluxo(Collection<Aresta> fluxo) {
        this.fluxo = fluxo;
    }

    public double custoDoFluxoMaximoDeCustoMinimo() {
        return custoDoFluxoMaximoDeCustoMinimo;
    }

    public void setarCustoDoFluxoMaximoDeCustoMinimo(double custoDoFluxoMaximoDeCustoMinimo) {
        this.custoDoFluxoMaximoDeCustoMinimo = custoDoFluxoMaximoDeCustoMinimo;
    }
}
