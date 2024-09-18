package corredores;

public class Corredor implements Competidor {
    private String nome;
    private int velocidade; // em metros por segundo
    private int distanciaDaCorrida; // distância da corrida em metros
    private int distanciaPercorrida; // distâcia já percorrida
    private boolean corredorEstaCorrendo;

    public Corredor(String nome, int velocidade) {
        this.nome = nome;
        this.velocidade = velocidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return corredorEstaCorrendo;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        this.distanciaDaCorrida = distanciaDaCorrida;
        distanciaPercorrida = 0;
        corredorEstaCorrendo = false;
    }

    @Override
    public void run() {
        corredorEstaCorrendo = true;
        int suspendeThread = 1000 / velocidade;

        try {
            for (distanciaPercorrida = 0; distanciaPercorrida < distanciaDaCorrida; distanciaPercorrida++){
                Thread.sleep(suspendeThread);
            }
        } catch (InterruptedException e) {
            System.out.println("Execução suspendida!");
            corredorEstaCorrendo = false;
        }
        
        corredorEstaCorrendo = false;
    }

}
