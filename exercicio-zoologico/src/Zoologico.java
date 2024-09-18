import java.util.ArrayList;

public class Zoologico {
    // ArrayList's declarados para todos os animais do zoologico
    private ArrayList <Animal> animais;

    
    public Zoologico() {
        animais = new ArrayList<>();
    }

    public void cadastrarLeao(String nome, String corDoPelo) {
        Leao leao = new Leao(nome, corDoPelo);
        animais.add(leao);
    }

    public void cadastrarGorila(String nome, String corDoPelo) {
        Gorila gorila = new Gorila(nome, corDoPelo);
        animais.add(gorila);
    }

    public void cadastrarArara(String nome) {
        Arara arara = new Arara(nome);
        animais.add(arara);
    }

    public void cadastrarEma(String nome) {
        Ema ema = new Ema(nome);
        animais.add(ema);
    }


    /**
     * Recebe o nome do animal, e de acordo com seu nome retorna a sua descrição.
     * @param nome
     * @return getDescricaoLonga.
     */
    public String listarAnimais(String nome) {
        for (Animal animal : animais){
            if (animal.getNome().equals(nome)){
                return animal.getDescricaoLonga();
            }
        }

        return null;
    }

    /*
     * Lista uma descrição resumida de todos os animais do zoológico.
     * @return descricao
     */
    public String listarDescricaoResumida() {
        String descricao = "";

        for (Animal animal : animais){
            descricao = descricao + animal.getDescricao() + "\n";
        }

        return descricao;
    }

    /*
     * Lista uma descrição completa de todos os animais do zoológico.
     * @return descricaoLonga
     */
    public String listarDescricaoLonga() {
        String descricaoLonga = "";

        for (Animal animal : animais){
            descricaoLonga = descricaoLonga + animal.getDescricaoLonga() + "\n";
        }

        return descricaoLonga;
    }
}