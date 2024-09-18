package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Saveiro extends Carro {

    public Saveiro(String cor) {
        super("Saveiro", Marca.VW, cor, 85000, Categoria.PICKUP);
    }
    
}
