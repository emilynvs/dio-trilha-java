package org.example.poo;

import java.util.Scanner;

public class MeuScanner {

    private static Scanner instancia;

    private MeuScanner(){

    }

    public static Scanner getInstance(){
       if(instancia == null){
           instancia = new Scanner(System.in);
       }
       return instancia;
    }
}
