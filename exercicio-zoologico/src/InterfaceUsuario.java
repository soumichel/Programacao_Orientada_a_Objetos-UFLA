import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    private Zoologico zoologico;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoologico = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        String nome = pedirString("Digite o nome do animal");
        String especie = pedirString("Digite a espécie do animal");

        String cadastroAve = pedirString("Você quer cadastrar uma ave? [S/N]");
        String cadastroMamifero = pedirString("Você quer cadastrar um mamífero? [S/N]");

        String corDoPelo = pedirString("Digite a cor do pelo do animal");

        if (cadastroAve.equals("S")){
            if (especie.equals("arara")){
                zoologico.cadastrarArara(nome);
            } else if (especie.equals("ema")){
                zoologico.cadastrarEma(nome);
            }
        } else if (cadastroMamifero.equals("S")){
            if (especie.equals("leao")){
                zoologico.cadastrarLeao(nome, corDoPelo);
            } else if (especie.equals("gorila")){
                zoologico.cadastrarGorila(nome, corDoPelo);
            }
        } else if (cadastroAve.equals("N")){
            System.out.println("Nenhum animal será cadastrado.");
        } else if (cadastroMamifero.equals("N")){
            System.out.println("Nenhum animal será cadastrado.");
        } else {
            System.out.println("Opção inválida!");
        }


       // zoologico = new Zoologico();
        
        // lê entrada de dados do usuário pra todos atributos (nome e especie)   OK
        // verifica se é pra cadastrar animal com pelo ou que voa
        // pergunta se voa bem e a cor do pelo e chama o método cadastro da classe zoologico
    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        String instrucao = pedirString("Digite o nome do animal que você deseja obsevar");

        System.out.println(zoologico.listarAnimais(instrucao));
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        System.out.println(zoologico.listarDescricaoResumida());
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {
        System.out.println(zoologico.listarDescricaoLonga());
    }
}