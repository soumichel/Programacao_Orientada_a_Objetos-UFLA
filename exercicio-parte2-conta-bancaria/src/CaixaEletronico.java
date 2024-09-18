import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {  //Atributos do Caixa
    private ArrayList<ContaBancaria> contas;
    private ContaBancaria conta;
    private int nroContasCriadas;
    private Scanner entrada;

    public CaixaEletronico(){     //Construtor
        contas = new ArrayList<>();
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
            System.out.print ("|          6 - Exibir contas criadas      |\n");
            System.out.print ("|          7 - Remover conta              |\n");
            System.out.print ("|          8 - Sair                       |\n");
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
                listarContas();
                break;

            case 7:
                removeConta();

            case 8:
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
        } while (opcaoUsuario != 8);
        entrada.close();
    }

//====================================== MÉTODOS DO MENU ============================================== 
    public void criaConta(){
        menuConta();
        int opcaoContaUsuario = Integer.parseInt(entrada.nextLine());

        if (nroContasCriadas == contas.size()){
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
    
                conta = new ContaBancaria (cliente, limite, saldo);
                contas.add(conta);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + conta.getNumeroDaConta());

            } else if (opcaoContaUsuario == 2){  //Conta criada sem saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limit = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                conta = new ContaBancaria(cliente, limit);
                contas.add(conta);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + conta.getNumeroDaConta());
            } else {
                System.out.println("Opção inválida!");
            }
            nroContasCriadas++;

        } else if (nroContasCriadas == contas.size()) {
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
    
                conta = new ContaBancaria(cliente, limite, saldo);
                contas.add(conta);
    
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + conta.getNumeroDaConta());

            } else if (opcaoContaUsuario == 2){  //Conta criada sem saldo
                System.out.print ("Digite o nome do cliente: ");
                String nomeContaUsuario = entrada.nextLine();
    
                System.out.print ("Digite o CPF do cliente: ");
                String cpf = entrada.nextLine();
    
                System.out.print ("Digite o limite da conta: ");
                double limit = Double.parseDouble(entrada.nextLine());
    
                Cliente cliente;
                cliente = new Cliente(nomeContaUsuario, cpf);
    
                conta = new ContaBancaria(cliente, limit);
                contas.add(conta);
                
                System.out.println("== CONTA CRIADA COM SUCESSO! ==");
                System.out.print ("Número gerado para a conta é: " + conta.getNumeroDaConta());
                
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
            for (ContaBancaria conta : contas){
                if (conta != null){
                    if (conta.getNumeroDaConta() == nroContaConsulta){
                        System.out.print ("O nome do titular da conta é: " + conta.getNomeCliente() + "\n" + "O saldo é de: " + conta.getSaldo());
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
            for (ContaBancaria conta : contas){
                if (conta != null){
                    if (conta.getNumeroDaConta() == nroContaDeposito){
                        System.out.print ("Qual o valor do depósito?\n");
                        System.out.print ("VALOR A SER DEPOSITADO: ");
                        double valorDeposito = Integer.parseInt(entrada.nextLine());
    
                        conta.deposito(valorDeposito);
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
            for (ContaBancaria conta : contas){
                if (contas != null){
                    if (conta.getNumeroDaConta() == nroContaSaque){
                        System.out.print ("Qual o valor do saque?\n");
                        System.out.print ("VALOR A SER SACADO: ");
                        double valorSacado = Integer.parseInt(entrada.nextLine());
    
                        if (conta.saque(valorSacado) == true){
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

        for (ContaBancaria conta : contas){
            if (conta != null){
                if (conta.getNumeroDaConta() == destino){
                    aux = conta;
                }
            }
        }

        if (aux != null){
            for (ContaBancaria conta : contas){
                if (conta != null){
                    if (conta.getNumeroDaConta() == origem){
                        conta.transferencia(valorTransferencia, aux);
                        System.out.print ("== TRANSFERÊNCIA CONCLUÍDA COM SUCESSO! ==");
                    }    
                 }
            }
        }
    }

    public void listarContas(){  //Lista as contas da ArrayList
        if (conta == null){
            System.out.print ("Não há contas criadas!");
        } else {
            for (ContaBancaria conta : contas){
                if (conta != null){
                    System.out.println("Nome do titular: " + conta.getNomeCliente() + "  " + "Número da conta: " + conta.getNumeroDaConta());
                }
            }
        }
    }

    private void removeConta(){    //Busca o numero da conta pra remover, aponta a variavel conta pra ArrayList e remove a conta digitada pelo usuário
        System.out.print ("Digite o número da conta que você quer remover: ");
        int nroContaRemoção = Integer.parseInt(entrada.nextLine());
        conta = null;

        for (int i=0; i<contas.size(); i++){
            if (contas.get(i).getNumeroDaConta() == nroContaRemoção){
                conta = contas.get(i);

                if (conta != null){
                    if (conta.getSaldo() > 0){
                         System.out.print ("Não é possível remover contas que contenham saldo positivo!");
                    } else if (conta.getSaldo() < 0){
                        System.out.print ("Não é possível remover contas que estejam com o saldo negativo!");
                    } else {
                        contas.remove(i);
                        System.out.print ("== CONTA REMOVIDA COM SUCESSO! ==");
                    }
                } else {
                    System.out.print ("Não há contas criadas!");
                }
            }
        }        
    }
}
