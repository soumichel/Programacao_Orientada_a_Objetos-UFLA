import java.util.HashMap;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
public class Ambiente  {
    // descrição do ambiente
    private String descricao;
    // HashMap guarda os ambientes que são saídas do ambiente atual
    private HashMap<String, Ambiente> saidas;
    //atributo item
    private Item item;


    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao)  {
        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
    }


    /**      CONSTRUTOR CRIADO
     * Cria um ambiente com a "descricao" passada e um item. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao, Item item)  {
        this.descricao = descricao;
        this.item = item;
        saidas = new HashMap<String,Ambiente>();
    }


    /**
     * Define as saídas do ambiente. Cada direção ou leva a um outro ambiente ou é null 
     * (indicando que não tem nenhuma saída para lá).
     * @param norte A saída norte.
     * @param leste A saída leste.
     * @param sul A saída sul.
     * @param oeste A saída oeste.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente)  {
        saidas.put(direcao, ambiente);
    }


    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }


    /**
     * Retorna as saídas com a direção apontada
     * @param direcao
     * @return
     */
    public Ambiente getSaida (String direcao){
        return saidas.get(direcao);
    }


    /**
     * Retorna uma string com todas as saídas sem precisar digitar uma por uma
     * @return
     */
    public String getSaidas (){
        String textoSaidas = "";

        for (String direcao : saidas.keySet()){
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }


    /**
     * Exibe uma descrição longa do ambiente
     * @return
     */
    public String getDescricaoLonga(){
        if (item != null){
            return "Você está " + getDescricao() + "\nNesse ambiente há um(a): " + item.getNomeItem() + item.getDescricaoItem() +"\nSaídas: " + getSaidas();
        } else {
            return "Você está " + getDescricao() + "\nSaídas: " + getSaidas();
        }
    }


    /**
     * Retorna o nome do item
     * @return
     */
    public String getItem(){
        return item.getNomeItem();
    }


    /**
     * Verifica se possui um item e se ele não está nulo
     * @return
     */
    public Item consultaItem() {
        if (item != null){
            return item;
        } else {
            return null;
        }
    }


    /**
     * Coleta o item do ambiente e deixa o atributo item como nulo
     * @return
     */
    public Item coletaItem() {
        Item aux = item;
        item = null;

        return aux;
    }
} 
