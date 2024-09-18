public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal = new Leao("Simba", "laraja");
        System.out.println(animal.getNome());
        System.out.println(exibirDescricaoCompleta(animal));
        
        animal = new Arara("Blue");
        System.out.println(animal.getNome());
        System.out.println(exibirDescricaoCompleta(animal)); 


        animal = new Ema("Matilda");
        System.out.println(animal.getNome());
        System.out.println(exibirDescricaoCompleta(animal)); 
    }


    public static String exibirDescricaoCompleta (Animal animal) {
        String descricao = animal.getDescricaoLonga();
        return descricao;
    }
}