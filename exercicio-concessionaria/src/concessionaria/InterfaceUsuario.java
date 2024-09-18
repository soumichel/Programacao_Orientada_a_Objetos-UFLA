/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", Marca.CHEVROLET);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    mudarFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("=== CONCESSIONÁRIA 1001 VEÍCULOS ===");
        System.out.println();
        System.out.println("Bem-vindo! O que você deseja?");
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar a marca da Franquia");
        System.out.println("3 - Sair");

        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup, 3: Luxo ou 4: SUV): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }

    private void mudarFranquia() {
        System.out.print("Escolha as seguintes franquias (1. Volkswagen, 2. Fiat, 3. Chevrolet): ");
        Marca marca = Marca.peloID(Integer.parseInt(entrada.nextLine()));

        ppooVeiculos.setMarcaFranquia(marca);

        System.out.println("Marca da franquia alterada com sucesso!");

        esperarTecla();
    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }
}

