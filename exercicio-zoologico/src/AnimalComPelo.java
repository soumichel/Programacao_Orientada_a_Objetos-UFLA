public class AnimalComPelo extends Animal {
    // Atributo que diz qual a cor do pelo do animal.
    private String corDoPelo;

    // Construtor inicializando os atributos
    public AnimalComPelo(String nome, String especie, int qntdPatas, String somCaracteristico, String corDoPelo) {
        super(nome, especie, qntdPatas, somCaracteristico);
        this.corDoPelo = corDoPelo;
    }

    /*
     * @return corDoPelo.
     */
    public String getcorDoPelo() {
        return corDoPelo;
    }

    /*
     * Retorna uma String com uma descrição completa do animal.
     * @return nome, espécie, som que emite
     */
    @Override
    public String getDescricaoLonga(){
        return super.getDescricaoLonga() + " e tem pelo " + corDoPelo;
    }
}
