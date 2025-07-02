package org.example.poo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        Scanner sc = MeuScanner.getInstance();
        int op = -1;
        while(true){
            if (op == 0){
                break;
            }
            op= menu();
            switch (op) {
                case 1:
                    iPhone.tocar();
                    break;
                case 2:
                    iPhone.pausar();
                    break;
                case 3:
                    System.out.println("Digite uma música: ");
                    String musica = sc.nextLine();
                    iPhone.selecionarMusica(musica);
                    break;
                case 4:
                    System.out.println("Digite a url da pagina: ");
                    String url = sc.nextLine();
                    iPhone.exibirPagina(url);
                    break;
                case 5:
                    iPhone.adicionarPagina();
                    break;
                case 6:
                    iPhone.atualizarPagina();
                    break;
                case 7:
                    System.out.println("Digite o número de telefone");
                    String numero = sc.nextLine();
                    iPhone.ligar(numero);
                    break;
                case 8:
                    iPhone.atender();
                    break;
                case 9:
                    iPhone.iniciarCorreioVoz();
                    break;
                default:
                    System.out.println("Celular encerrado.");
                    break;

            }
        }
    }

    private static int menu() {
            
            Scanner sc = MeuScanner.getInstance();
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - Tocar música");
            System.out.println("2 - pausar");
            System.out.println("3 - Selecionar música");
            System.out.println("4 - Exibir página");
            System.out.println("5 - Adicionar página");
            System.out.println("6 - Atualizar página");
            System.out.println("7 - Realizar uma ligação");
            System.out.println("8 - Atender uma ligação");
            System.out.println("9 - Iniciar correio de voz");
            System.out.println("0 - Desligar");

            int op = sc.nextInt();
            sc.nextLine();
            return op; 
    }

}