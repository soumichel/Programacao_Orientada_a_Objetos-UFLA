package concessionaria;

import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.CarroFactoryFIAT;
import fabricaautomoveis.carros.CarroFactoryGM;
import fabricaautomoveis.carros.CarroFactoryVW;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.carros.Carro;

import java.util.ArrayList;
import java.util.List;

import detran.GeradorDePlaca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;

    // Fabricante do carro
    private CarroFactory fabricante;  // ATRIBUTO CRIADO
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new ArrayList<>();

        if (marca == Marca.FIAT){
            fabricante = new CarroFactoryFIAT();
        } else if (marca == Marca.VW){
            fabricante = new CarroFactoryVW();
        } else if (marca == Marca.CHEVROLET){
            fabricante = new CarroFactoryGM();
        }
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }

    /**
     * Define a nova marca da franquia
     * @param marca Marca do carro a ser alterada
     */
    public void setMarcaFranquia(Marca marca) {
        marcaFranquia = marca;

        if (marca == Marca.FIAT){
            fabricante = new CarroFactoryFIAT();
        } else if (marca == Marca.VW){
            fabricante = new CarroFactoryVW();
        } else if (marca == Marca.CHEVROLET){
            fabricante = new CarroFactoryGM();
        }
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = fabricante.criarCarro(categoria, cor);
        
        if (carro != null) {
            carro.emplacar(GeradorDePlaca.gerarPlaca());
            carro.prepararParaEntrega();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
