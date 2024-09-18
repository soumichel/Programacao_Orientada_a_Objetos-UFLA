package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Camaro extends Carro {

    public Camaro(String cor) {
        super("Camaro", Marca.CHEVROLET, cor, 230000, Categoria.LUXO);
    }
    
    
}
