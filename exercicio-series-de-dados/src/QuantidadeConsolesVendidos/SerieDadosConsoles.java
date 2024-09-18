package QuantidadeConsolesVendidos;

import java.util.HashMap;

import series.SerieDados;

public class SerieDadosConsoles implements SerieDados{
    private HashMap<Integer, Integer> dados; // estrutura de dados que guarda os dados da série
    private String identificadorConsoles;
    private int diaInicial, diaFinal;

    public SerieDadosConsoles(String identificadorConsoles, int diaInicial, int diaFinal) {
        this.identificadorConsoles = identificadorConsoles;
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        dados = new HashMap<>();
    }

    /*
     * Método sobrescrito da interface
     */
    @Override
    public String obterIdentificacaoSerie() {
        return identificadorConsoles;
    }

    /*
     * Método sobrescrito da interface
     */
    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }

    /*
     * Método sobrescrito da interface
     */
    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    /*
     * Método sobrescrito da interface
     */
    @Override
    public int obterDado(int dia) {
        return dados.get(dia);
    }

    /*
     * Adiciona um dado para um determinado dia dentro do intervalo de dias escolhido
     */
    public boolean adicionaDado(int dia, int quantidadeConsolesVendidos){
        if (dia >= diaInicial && dia <= diaFinal){
            dados.put(dia, quantidadeConsolesVendidos);
            return true;
        } else {
            return false;
        }
        
    }
    
}
