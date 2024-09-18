import java.util.ArrayList;

public class Sobrevivente {
    //identificação do sobrevivente
    private String idSobrevivente;
    //ArrayList com o nome de mochila usado para guardar os itens
    private ArrayList<Item> mochila;


    /**
     * Cria o sobrevivente com uma mochila.
     * 
     */
    public Sobrevivente(String idSobrevivente){
        this.idSobrevivente = idSobrevivente;
        mochila = new ArrayList<>();
    }


    /**
     * Retorna o nome do sobrevivente
     * @return o Id do sobrevivente.
     */
    public String getIDSobrevivente(){
        return idSobrevivente;
    }


    /**
     * Adiciona um item na mochila
     */
    public void adicionaItemMochila(Item item){
        mochila.add(item);
    }


    /**
     * Remove um item, a partir do nome dele, e o retorna
     * @param itemRemovido
     * @return nulo para o item removido.
     */
    public Item removeItemMochila(String itemRemovido){
        for (int i=0; i<mochila.size(); i++){
            if (mochila.get(i).getNomeItem().equals(itemRemovido)){
                Item aux = mochila.get(i);
                mochila.remove(i);
                return aux;
            }
        }
        return null;
    }

    
    /**
     * Retorna uma string com todos os itens que o sobrevivente possui
     * @return uma string com os itens.
     */
    public String itensNaMochila(){
        if (mochila.size() == 0){
            return "Não há nada na mochila!";
        } else {
            String itensMochila = "Você tem na mochila: ";

            for (Item item : mochila){
                itensMochila = itensMochila + "\n -> " + item.getNomeItem() + " ";
            }
            
            return itensMochila;
        }
    }
}
