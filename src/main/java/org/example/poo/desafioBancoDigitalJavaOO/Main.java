package org.example.poo.desafioBancoDigitalJavaOO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conta c = null;

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        Cliente cliente = new Cliente(nome);

        System.out.println("Selecione o tipo de conta: ");
        System.out.println("1 - Conta poupança");
        System.out.println("2 - Conta corrente");
        int tipoConta = sc.nextInt();

        if (tipoConta == 1) {
            c = new ContaPoupanca(cliente);
        } else if (tipoConta == 2) {
            c = new ContaCorrente(cliente);
        }
        int op = 0;
        while (op != 6) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Pagar conta");
            System.out.println("5 - Exibir informações sobre a conta");
            System.out.println("6 - Sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Digite um valor do saque: ");
                    double valorSaque = sc.nextDouble();
                    c.sacar(valorSaque);
                    break;
                case 2:
                    System.out.println("Digite um valor do deposito: ");
                    double valorDeposito = sc.nextDouble();
                    c.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite um valor para transferencia: ");
                    double valorTransferencia = sc.nextDouble();
                    System.out.println("Qual tipo de conta: ");
                    System.out.println("1 - poupança");
                    System.out.println("2 - corrente");
                    int tipoContaDestino = sc.nextInt();
                    System.out.println("Nome do titular da conta destino: ");
                    sc.nextLine();
                    String nomeDestino = sc.nextLine();

                    Cliente clienteDestino = new Cliente(nomeDestino);
                    Conta contaDestino = null;

                    if (tipoConta == 1) {
                        contaDestino = new ContaPoupanca(clienteDestino);
                    } else if (tipoConta == 2) {
                        contaDestino = new ContaCorrente(clienteDestino);
                    } else {
                        System.out.println("Tipo de conta inválido para transferência.");
                        break;
                    }

                    c.transferir(valorTransferencia, contaDestino);
                    break;
                case 4:
                    Pagamento pagamento = null;
                    Contas contas = null;
                    System.out.println("Digite qual conta quer pagar: ");
                    for (Contas contaEnum : Contas.values()) {
                        System.out.println(contaEnum.ordinal() + 1 + " - " + contaEnum);
                    }
                    int opcaoConta = sc.nextInt();

                    if (opcaoConta < 1 || opcaoConta > Contas.values().length) {
                        System.out.println("Opção inválida.");
                        break;
                    }
                    System.out.println("Digite o valor para pagar a conta: ");
                    double valorPagamento = sc.nextDouble();
                    Contas contaParaPagar = Contas.values()[opcaoConta - 1];
                    pagamento = new Pagamento(c);
                    pagamento.pagarConta(valorPagamento, contaParaPagar);
                    break;

                case 5:
                    c.imprimirInfosComuns();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
            }
        }

    }


}

