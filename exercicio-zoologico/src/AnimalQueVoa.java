public class AnimalQueVoa extends Animal {
    // Atributo que retorna se o animal voa bem (true) ou não (false).
    private boolean voaBemOuNao;

    // Construtor inicializando os atributos.
    public AnimalQueVoa(String nome, String especie, int qntdPatas, String somCaracteristico, boolean voaBemOuNao) {
        super(nome, especie, qntdPatas, somCaracteristico);
        this.voaBemOuNao = voaBemOuNao;
    }

    /*
     * @return voaBemOuNao.
     */
    public boolean getVoaBemOuNao() {
        return voaBemOuNao;
    }

    /*
     * Retorna uma String com uma descrição completa do animal.
     * @return nome, espécie, som que emite
     */
    @Override
    public String getDescricaoLonga(){
        if (voaBemOuNao){
            return super.getDescricaoLonga() + " e voa bem";
        } else {
            return super.getDescricaoLonga() +" e voa mal";
        }
    }
      
}
