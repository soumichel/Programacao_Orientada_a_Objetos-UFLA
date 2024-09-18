import java.util.Scanner;

public class CaixaEletronico {  //Atributos do Caixa
    private ContaBancaria[] contas;
    private int nroContasCriadas;
    private Scanner entrada;

    public CaixaEletronico(){     //Construtor
        contas = new ContaBancaria[2];
        entrada = new Scanner(System.in);
        nroContasCriadas = 0;
    }

    public void exibeMenu(){   //Exibição do menu
            System.out.print ( "\n         ##--Menu de Opções--##     \n");
            System.out.print ("|=========================================|\n");
            System.out.print ("|          1 - Criar conta                |\n");
            System.out.print ("|          2 - Consultar saldo            |\n");
            System.out.print ("|          3 - Depositar                  |\n");
            System.out.print ("|          4 - Sacar                      |\n");
            System.out.print ("|          5 - Transferência              |\n");
            System.out.print ("|          6 - Sair                       |\n");
            System.out.print ("|=========================================|\n\n");
    }

    private void trataMenu(int opcaoUsuario){   //Chama o método escolhido pelo usuário
        switch (opcaoUsuario) {
            case 1:
                criaConta();
                break;

            case 2:
                consultaSaldo();
                break;

            case 3:
                depositar();
                break;

            case 4:
                sacar();
                break;

            case 5:
                transferir();
                break;

            case 6:
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public void executar() {  //Método que inicia o programa
        int opcaoUsuario;

        do {
           exibeMenu();

           System.out.println("\nDigite sua opção: ");
           opcaoUsuario = Integer.parseInt(entrada.nextLine());

           trataMenu(opcaoUsuario);
        } while (opcaoUsuario != 6);
        entrada.close();
    }

//====================================== MÉTODOS DO MENU ============================================== 
    public void criaConta(){
        menuConta();
        int opcaoContaUsuario = Integer.parseInt(entrada.nextLine());

        if (nroContasCriadas == contas.length){
            System.out.print ("Não é possível criar mais contas!");
        }

        if (nroContasCriadas == 0){
            if (opcaoContaUsuario == 1){   //Conta criada com saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limite = Double.parseDouble(entrada.nextLine());
    
                System.out.print ("Digite o saldo inicial da conta: ");
                double saldo = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                contas[0] = new ContaBancaria (cliente, limite, saldo);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + contas[0].getNumeroDaConta());

            } else if (opcaoContaUsuario == 2){  //Conta criada sem saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limit = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                contas[0] = new ContaBancaria(cliente, limit);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + contas[0].getNumeroDaConta());
            } else {
                System.out.println("Opção inválida!");
            }
            nroContasCriadas++;

        } else if (nroContasCriadas == 1) {
            if (opcaoContaUsuario == 1){   //Conta criada com saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limite = Double.parseDouble(entrada.nextLine());
    
                System.out.print ("Digite o saldo inicial da conta: ");
                double saldo = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                contas[1] = new ContaBancaria (cliente, limite, saldo);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + contas[1].getNumeroDaConta());

            } else if (opcaoContaUsuario == 2){  //Conta criada sem saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limit = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                contas[1] = new ContaBancaria(cliente, limit);
    
                System.out.print ("Número gerado para a conta é: " + contas[1].getNumeroDaConta());
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
            } else {
                System.out.println("Opção inválida!");
            }
            nroContasCriadas++;
        }

    }

//========================== MÉTODO PRA EXIBIR MENU DENTRO DA CRIAÇÃO DE CONTA =================
    public void menuConta() {
            System.out.print ("|=========================================|\n");
            System.out.print ("|          Qual opção você deseja?        |\n");
            System.out.print ("|          1 - Com saldo inicial          |\n");
            System.out.print ("|          2 - Sem saldo inicial          |\n");
            System.out.print ("|=========================================|\n");
    }
//==============================================================================================

    public void consultaSaldo(){   //Busca a conta e exibe o saldo
        System.out.print ("Digite o número da conta que você quer consultar o saldo: ");
        int nroContaConsulta = Integer.parseInt(entrada.nextLine());

        if (nroContasCriadas > 0){
            for (int i=0; i<contas.length; i++){
                if (contas[i] != null){
                    if (contas[i].getNumeroDaConta() == nroContaConsulta){
                        System.out.print ("O nome do titular da conta é: " + contas[i].getNomeCliente() + "\n" + "O saldo é de: " + contas[i].getSaldo());
                    } 
                }
            }
        } else {
            System.out.print ("Conta não criada!");
        }
    }

    private void depositar(){    //Busca a conta e realiza o depósito
        System.out.print ("Digite o número da conta que você quer depositar: ");
        int nroContaDeposito = Integer.parseInt(entrada.nextLine());

        if (nroContasCriadas > 0){
            for (int i=0; i<contas.length; i++){
                if (contas[i] != null){
                    if (contas[i].getNumeroDaConta() == nroContaDeposito){
                        System.out.print ("Qual o valor do depósito?\n");
                        System.out.print ("VALOR A SER DEPOSITADO: ");
                        double valorDeposito = Integer.parseInt(entrada.nextLine());
    
                        contas[i].deposito(valorDeposito);
                    }
                }
            }
        } else {
            System.out.print ("Conta não criada!");
        }
    }

    private void sacar(){     //Busca a conta pelo número digitado pelo usuário e faz o saque
        System.out.print ("Digite o número da conta que você quer sacar: ");
        int nroContaSaque = Integer.parseInt(entrada.nextLine());

        if (nroContasCriadas > 0){
            for (int i=0; i<contas.length; i++){
                if (contas[i] != null){
                    if (contas[i].getNumeroDaConta() == nroContaSaque){
                        System.out.print ("Qual o valor do saque?\n");
                        System.out.print ("VALOR A SER SACADO: ");
                        double valorSacado = Integer.parseInt(entrada.nextLine());
    
                        if (contas[i].saque(valorSacado) == true){
                            System.out.print ("Saque realizado com sucesso!");
                        } else {
                            System.out.print ("ERRO! Não há saldo o suficiente!");
                        }
                    }
                }
            }
        } else {
            System.out.print ("Conta não criada!");
        }
    }

    private void transferir(){      // Busca a conta origem pelo número, e transfere pra conta destino
        System.out.println("Digite o número da conta de origem: ");
        int origem = Integer.parseInt(entrada.nextLine());

        System.out.println("Digite o número da conta de destino: ");
        int destino = Integer.parseInt(entrada.nextLine());

        
        System.out.print ("Qual o valor da transferência?\n");
        System.out.print ("VALOR A SER TRANSFERIDO: ");
        double valorTransferencia = Double.parseDouble(entrada.nextLine());

        ContaBancaria aux = null;

        for(int i=0; i<contas.length; i++){
            if (contas[i] != null){
                if (contas[i].getNumeroDaConta() == destino){
                    aux = contas[i];
                }
            }
        }

        if (aux != null){
            for (int i=0; i<contas.length; i++){
                if (contas[i] != null){
                    if (contas[i].getNumeroDaConta() == origem){
                        contas[i].transferencia(valorTransferencia, aux);
                        
                        if (contas[i].transferencia(valorTransferencia, aux)){
                            System.out.print ("== TRANSFERÊNCIA CONCLUÍDA COM SUCESSO! ==");
                        }
                    }    
                 }
            }
        }
    }
}
