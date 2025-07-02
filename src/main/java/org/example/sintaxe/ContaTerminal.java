package org.example.sintaxe;


import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        try {
            // Solicita número da conta ao usuário
            System.out.print("Digite o numero da conta: ");
            int numero = sc.nextInt();
            sc.nextLine(); // Consome quebra de linha pendente

            // Solicita número da agência
            System.out.print("Digite o número da agencia(Exemplo: 067-8)");
            String agencia = sc.nextLine();

            // Solicita nome do cliente
            System.out.print("Digite seu nome: ");
            String nomeCliente = sc.nextLine();

            // Solicita saldo inicial
            System.out.print("Digite seu saldo: R$ ");
            double saldo = sc.nextDouble();

            // Exibe mensagem de boas-vindas com os dados da conta
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nomeCliente, agencia, numero, saldo);
        } catch (Exception e) {
            // Relança a exceção capturada para tratamento externo
            throw new Exception(e);
        }
    }
}