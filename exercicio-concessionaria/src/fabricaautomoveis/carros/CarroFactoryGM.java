package fabricaautomoveis.carros;

import fabricaautomoveis.carros.carros.Camaro;
import fabricaautomoveis.carros.carros.Carro;
import fabricaautomoveis.carros.carros.Montana;
import fabricaautomoveis.carros.carros.Onix;
import fabricaautomoveis.carros.carros.Tracker;

public class CarroFactoryGM extends CarroFactory{

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Onix(cor);
        } 
        else if (categoria == Categoria.PICKUP) {
            carro = new Montana(cor);
        }
        else if (categoria == Categoria.LUXO){
            carro = new Camaro(cor);
        }
        else if (categoria == Categoria.SUV){
            carro = new Tracker(cor);
        }
        
        return carro;
    }
    
}
