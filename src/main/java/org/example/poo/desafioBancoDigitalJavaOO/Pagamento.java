package org.example.poo.desafioBancoDigitalJavaOO;

public class Pagamento {
    private Conta conta;

    public Pagamento(Conta conta) {
        this.conta = conta;
    }

    public void pagarConta(double valor, Contas contas){
        conta.sacar(valor);
        System.out.println("Conta de " + contas + " paga com sucesso");
    }
}
