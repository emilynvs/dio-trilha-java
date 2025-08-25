package org.example.streamAPI.jogoSudoku;

import org.example.streamAPI.jogoSudoku.custom.screen.StartScreen;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

public class UIMain {
    public static void main(String[] args) {

        Map<String, String> gameConfig;

        if(args.length == 0) {
            // Tabuleiro padrão caso nenhum argumento seja passado
            gameConfig = new HashMap<>();
            gameConfig.put("0,0", "4,false");
            gameConfig.put("1,0", "7,false");
            gameConfig.put("2,0", "9,true");
            gameConfig.put("3,0", "5,false");
            gameConfig.put("4,0", "8,true");
            gameConfig.put("5,0", "6,true");
            gameConfig.put("6,0", "2,true");
            gameConfig.put("7,0", "3,false");
            gameConfig.put("8,0", "1,false");
            // Adicione mais posições fixas do jeito que quiser
        } else {
            // Converte os argumentos passados em Map<String,String>
            gameConfig = Stream.of(args)
                    .map(s -> s.split(";"))
                    .collect(toMap(
                            arr -> arr[0],
                            arr -> arr[1]
                    ));
        }

        StartScreen startScrean = new StartScreen();
        startScrean.show();
    }
}
