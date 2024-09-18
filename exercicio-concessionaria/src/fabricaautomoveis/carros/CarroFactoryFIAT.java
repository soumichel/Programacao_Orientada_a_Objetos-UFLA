package fabricaautomoveis.carros;

import fabricaautomoveis.carros.carros.Argo;
import fabricaautomoveis.carros.carros.Carro;
import fabricaautomoveis.carros.carros.Strada;
import fabricaautomoveis.carros.carros.Fastback;

public class CarroFactoryFIAT extends CarroFactory{

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Argo(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Fastback(cor);
        }

        return carro;
    }
    
}
