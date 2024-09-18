package fabricaautomoveis.carros;

import fabricaautomoveis.carros.carros.Carro;

public abstract class CarroFactory {
    public abstract Carro criarCarro(Categoria categoria, String cor);
}
