package iu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import feed.FeedNoticias;
import feed.MensagemNaoEncontradaException;
import feed.Publicacao;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;

    // ATRIBUTO CRIADO
    // Botão para atualizar o feed
    private JButton botaoAtualizar;

    // ATRIBUTO CRIADO
    // Booleano utilizado para verificar se o feed está sendo atualizado
    private boolean carregando;

    // ATRIBUTO CRIADO 
    // Barra de rolagem do feed
    private JScrollPane barraDeRolagem;

    // ATRIBUTO CRIADO
    // Caixa de seleção de autores no feed
    private JComboBox<String> selecaoAutores;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar = new JButton("Atualizar");  // Criação do objeto
        barraDeRolagem = new JScrollPane(areaTextoFeed); // Criação do objeto
        selecaoAutores = new JComboBox<>(); // Criação do objeto
        
        // atualiza a caixa de seleção de autores
        recarregaCaixaSelecao();

        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        // troca a fonte do feed de noticias
        areaTextoFeed.setFont(new Font("Modern", Font.PLAIN, 14));
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });

        // MÉTODO IMPLEMENTADO
        // adiciona o método que tratará o evento de clique no botão Comentar
        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarMensagem();
            }
        });

        // MÉTODO IMPLEMENTADO
        // adiciona o método que tratará o evento de clique no botão Comentar
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarAreaTextoFeed();
            }
        });

        // MÉTODO IMPLEMENTADO
        // tratá o evento de clique no botão de seleção de autor
        selecaoAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carregando){
                    atualizarAreaTextoFeed();
                }
            }
        });
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);
        
        janela.setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Feed de Notícias"));
        painelSuperior.add(new JLabel(" "));
        painelSuperior.add(new JLabel("Filtro de autor:"));  // Rótulo criado
        painelSuperior.add(selecaoAutores);  // Adição da caixa de seleção no painel
        janela.add(painelSuperior, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(barraDeRolagem);  // Adiciona a barra de rolagem na janela
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);  // Chamada feita
        janela.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        // Se o usuário digitou algum autor e confirmou
        if(autor != null) {
            String mensagem = JOptionPane.showInputDialog("Texto da mensagem");
            // Se o usuário digitou alguma mensagem e confirmou
            if (mensagem != null) {
                feed.postarMensagemTexto(autor, mensagem);        
                atualizarAreaTextoFeed();

                recarregaCaixaSelecao();
            }   
        }
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        if (feed.nroMensagens() > 0){
            boolean deuCerto = false;  // variável booleana usada para controle

            do {
                try {
                    int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
                    feed.curtir(idMensagem);
                    atualizarAreaTextoFeed();
                    deuCerto = true;
                } catch (MensagemNaoEncontradaException e) {
                    JOptionPane.showMessageDialog(janela, "Identificador " + e.getID() + " inválido!" , "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } while (!deuCerto);
        } else {
            JOptionPane.showMessageDialog(janela, "Não há nenhuma publicação para curtir!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        
    }    


    // MÉTODO IMPLEMENTADO
    /**
     * Comenta uma mensagem. Solicita o identificador da mensagem ao usuário,
     * comenta a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void comentarMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));

        String comentario = JOptionPane.showInputDialog("Texto da mensagem");
        feed.comentar(idMensagem, comentario);

        atualizarAreaTextoFeed();
    }    


    /**
     * Atualiza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {  
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        // Obtém as publicações do feed de notícias
        List<Publicacao> publicacoes = feed.getPublicacoes();

        String opcaoSelecionada = selecaoAutores.getItemAt(selecaoAutores.getSelectedIndex());

        if (opcaoSelecionada.equals("Todos")){
            publicacoes = feed.getPublicacoes();
        } else {
            publicacoes = feed.getPublicacoes(opcaoSelecionada);
        }

        // Percorre a lista de publicações adicionando na área de texto o texto da publicação
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    }   

    // MÉTODO IMPLEMENTADO
    /**
     * Atualiza a caixa de seleção de autores de publicações do feed
     */
    private void recarregaCaixaSelecao(){
        carregando = true;
        
        selecaoAutores.removeAllItems();
        selecaoAutores.addItem("Todos");

        List<String> listaAutores = feed.getAutores();
        for (String autor : listaAutores){
            selecaoAutores.addItem(autor);
        }

        carregando = false;
    }
}
