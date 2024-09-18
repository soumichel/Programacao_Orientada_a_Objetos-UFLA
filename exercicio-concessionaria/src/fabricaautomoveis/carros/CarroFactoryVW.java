package fabricaautomoveis.carros;

import fabricaautomoveis.carros.carros.Carro;
import fabricaautomoveis.carros.carros.Gol;
import fabricaautomoveis.carros.carros.Nivus;
import fabricaautomoveis.carros.carros.Saveiro;
import fabricaautomoveis.carros.carros.TCross;

public class CarroFactoryVW extends CarroFactory{

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        } 
        else if (categoria == Categoria.PICKUP) {
            carro = new Saveiro(cor);
        }
        else if (categoria == Categoria.LUXO){
            carro = new Nivus(cor);
        }
        else if (categoria == Categoria.SUV){
            carro = new TCross(cor);
        }

        return carro;
    }
    
}
