package org.example;


import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Digite o numero da conta: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o número da agencia(Exemplo: 067-8)");
        String agencia = sc.nextLine();

        System.out.print("Digite seu nome: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Digite seu saldo: R$ ");
        double saldo = sc.nextDouble();


        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nomeCliente, agencia, numero, saldo);






    }
}