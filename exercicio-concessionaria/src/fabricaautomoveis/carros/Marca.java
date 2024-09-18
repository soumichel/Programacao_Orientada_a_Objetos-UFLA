package fabricaautomoveis.carros;

/**
 * Enumerador para representar as possíveis marcas de carros
 */
public enum Marca {
    
    VW(1), 
    FIAT(2),
    CHEVROLET(3);

    private int id;
    
    private Marca(int id) {
        this.id = id;
    }
    
    public static Marca peloID(int id) {
        for (Marca m : Marca.values()) {
            if (m.id == id) {
                return m;
            }
        }
        throw new RuntimeException("Não existe categoria de id " + id);
    }
}
