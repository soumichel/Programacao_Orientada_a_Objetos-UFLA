public class Cliente {     //Atributos do Cliente
    private String nomeTitular;
    private String cpf;

    public Cliente (String nomeTitular, String cpf){    //Construtor da classe
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
    }

    public String getNomeTitular() {    //Retorna o nome do titular da classe
        return nomeTitular;
    }

    public String getCPFTitular() {     //Retorna o cpf do titular da classe
        return cpf;
    }
}
