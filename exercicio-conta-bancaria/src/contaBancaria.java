public class ContaBancaria {     //Atributos da conta bancária
    private Cliente cliente;
    private double saldo;
    private double limite;
    private int numeroDaConta;
    private static int conta = 100;

    public ContaBancaria(Cliente cliente, double limit){   //Inicializa a conta com saldo = 0
        saldo = 0;
        limite = limit;
        this.cliente = cliente;
        numeroDaConta = conta;
        conta++;
    }

    public ContaBancaria(Cliente cliente, double limite, double saldo){   //Inicializa a conta com o saldo digitado pelo usuário
        this.saldo = saldo;
        this.limite = limite;
        this.cliente = cliente;
        numeroDaConta = conta;
        conta++;
    }

    public double getSaldo (){   //Retorna o saldo da conta
        return saldo;
    }

    public String getNomeCliente (){    //Retorna o nome do cliente da Classe cliente
        return cliente.getNomeTitular();
    }
    
    public int getNumeroDaConta() {    //Retorna o número da conta
        return numeroDaConta;
    }

    public boolean deposito (double valorDepositado){    //Faz o depósito na conta
        saldo = saldo + valorDepositado;
        return true;
    }

    public boolean saque (double valorSacado){          //Faz o saque na conta
        if (saldo-valorSacado > (limite * -1)){
            saldo = saldo - valorSacado;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferencia (double valor, ContaBancaria destino){    //Saca o valor da conta passada e deposita na
        if (saque(valor) != false){                                        // conta destino
            destino.deposito(valor);
            return true;
        } else {
            return false;
        }
    }
}
