public class Animal {
    // Atributos que todo animal tem
    private String nome;
    private String especie;
    private int qntdPatas;
    private String somCaracteristico;


    // Construtor inicializando os atributos
    public Animal(String nome, String especie, int qntdPatas, String somCaracteristico) {
        this.nome = nome;
        this.especie = especie;
        this.qntdPatas = qntdPatas;
        this.somCaracteristico = somCaracteristico;
    }

    /*
     * Retorna o nome do animal.
     * @return nome
     */
    public String getNome(){
        return nome;
    }

    /*
     * Retorna a espécie do animal.
     * @return espécie
     */
    public String getEspecie(){
        return especie;
    }

    /*
     * Retorna a quantidade de patas do animal.
     * @return qntdPatas
     */
    public int getQntdPatas(){
        return qntdPatas;
    }

    /*
     * Retorna o som que o animal emite em forma de texto.
     * @return somCaracteristico
     */
    public String getSom(){
        return somCaracteristico;
    }


    /*
     * Retorna uma String com uma descrição resumida do animal.
     * @return nome e espécie
     */
    public String getDescricao(){
        return nome + " é um(a) " + especie;
    }

    /*
     * Retorna uma String com uma descrição completa do animal.
     * @return nome e espécie
     */
    public String getDescricaoLonga(){
        return nome + " é um(a) " + especie + " que faz " + getSom();
    }
}

