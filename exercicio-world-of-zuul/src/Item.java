public class Item {
    //nome do item
    private String nomeItem;
    //descrição do item
    private String descricaoItem;


    /*     MÉTODO CRIADO
     * Construtor inicializando os atributos
     */
    public Item(String nomeItem, String descricaoItem){
        this.nomeItem = nomeItem;
        this.descricaoItem = descricaoItem;
    }


    /**
     * Retorna o nome que foi passado para item
     * @return o nome do item.
     */
    public String getNomeItem(){
        return nomeItem;
    }

    
    /**
     * Retorna a descrição passada para item
     * @return a descrição do item.
     */
    public String getDescricaoItem(){
        return descricaoItem;
    }
}
