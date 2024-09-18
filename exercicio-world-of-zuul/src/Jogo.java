/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    //A última pessoa a sobreviver do apocalipse
    private Sobrevivente sobrevivente;
        

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
    }


    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente reitoria, pavilhao, cantina, departamento, laboratorio;
        Item faca, tacoDeBeisebol;
      
        //cria os itens
        faca = new Item("faca", ", um objeto cortante capaz de salvar sua vida e matar os zumbis");
        tacoDeBeisebol = new Item("taco", ", bastão feito de madeira com pregos na ponta");


        // cria os ambientes
        reitoria = new Ambiente("em um espaço aberto, gramado, em frente aos destroços do prédio da reitoria");
        pavilhao = new Ambiente("no pavilhao de aulas", faca);
        cantina = new Ambiente("na cantina da universidade");
        departamento = new Ambiente("no departamento de computacao");
        laboratorio = new Ambiente("na laboratorio de aulas de programacao", tacoDeBeisebol);
        

        
        // inicializa as saidas dos ambientes
        reitoria.ajustarSaida("leste", pavilhao);
        reitoria.ajustarSaida("sul", departamento);
        reitoria.ajustarSaida("oeste", cantina);

        pavilhao.ajustarSaida("oeste", reitoria);

        cantina.ajustarSaida("leste", reitoria);

        departamento.ajustarSaida("norte", reitoria);
        departamento.ajustarSaida("leste", laboratorio);

        laboratorio.ajustarSaida("oeste", departamento);

        ambienteAtual = reitoria;  // o jogo comeca em frente à reitoria
        sobrevivente = new Sobrevivente("Survivor");  //cria o sobrevivente
    }


    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }


    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("☣ Bem-vindo ao Guerra Uflaniana Z! ☣");
        System.out.println("Um vírus letal que transforma as pessoas em zumbi surgiu de maneira incerta\nno Campus da UFLA e você é o único sobrevivente e responsável por buscar a cura!");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        exibeLocalAtual();
    }


    private void exibeLocalAtual() {
        System.out.println("Voce esta " + ambienteAtual.getDescricao());
        System.out.print("Saídas: " + ambienteAtual.getSaidas());
    }


    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")){
            observar(comando);
        } else if (palavraDeComando.equals("pegar")){
            pegarItem(comando);
        } else if (palavraDeComando.equals("inventario")){
            inventario(comando);
        }

        return querSair;
    }


    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela universidade, ou pelo o que sobrou dela.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");

        // Exibe os comandos
        System.out.println(analisador.getComando());
    }


    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        //Sai do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            exibeLocalAtual();
        }
    }


    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }


    /**       MÉTODO CRIADO
     * Retorna o ambiente que o usuário está.
     * 
    */
    private void observar(Comando comando){
        System.out.print(ambienteAtual.getDescricaoLonga());
    }


    /**        MÉTODO CRIADO
     * Tenta pegar um item. Se existe esse item ali ele coleta, 
     * caso contrário imprime mensagem de erro.
     */
    private void pegarItem(Comando comando) {
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que?");
            return;
        }

        String nomeItem = comando.getSegundaPalavra();

        if (ambienteAtual.consultaItem() != null){
            if (ambienteAtual.getItem().equals(nomeItem)){
                sobrevivente.adicionaItemMochila(ambienteAtual.coletaItem());
                System.out.println("Item coletado com sucesso!");
            } else {
                System.out.println("Não há esse item no local!");
            }

            exibeLocalAtual();
        } else {
            System.out.println("Não há nenhum item aqui!");
            exibeLocalAtual();
        }
    }

    
    /**      MÉTODO CRIADO
     * Exibe todos os itens que o usuário tem na mochila
     * @param comando
     */
    private void inventario(Comando comando){
        System.out.print(sobrevivente.itensNaMochila());
    }
}
