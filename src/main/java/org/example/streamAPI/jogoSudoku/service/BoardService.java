package org.example.streamAPI.jogoSudoku.service;

import org.example.streamAPI.jogoSudoku.model.Board;
import org.example.streamAPI.jogoSudoku.model.GameStatusEnum;
import org.example.streamAPI.jogoSudoku.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BoardService {

    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, String> gameConfig, int numbersToPlace){
        this.board = new Board(initBoard(gameConfig, numbersToPlace));
    }

    public List<List<Space>> getSpaces(){
        return board.getSpaces();
    }

    public void reset(){
        board.reset();
    }

    public boolean hasErrors(){
        return board.hasErrors();
    }

    public GameStatusEnum getStatus(){
        return board.getStatus();
    }

    public boolean gameIsFinished(){
        return board.gameIsFinished();
    }

    private List<List<Space>> initBoard(final Map<String, String> gameConfig, int numbersToPlace){
        List<List<Space>> spaces = new ArrayList<>();

        // Cria o tabuleiro vazio
        for(int i = 0; i < BOARD_LIMIT; i++){
            spaces.add(new ArrayList<>());
            for(int j = 0; j < BOARD_LIMIT; j++){
                spaces.get(i).add(new Space(0, false));
            }
        }

        // Preenche números do gameConfig, se houver
        if(gameConfig != null){
            gameConfig.forEach((key, value) -> {
                int i = Integer.parseInt(key.split(",")[0]);
                int j = Integer.parseInt(key.split(",")[1]);
                int expected = Integer.parseInt(value.split(",")[0]);
                boolean fixed = Boolean.parseBoolean(value.split(",")[1]);
                spaces.get(i).set(j, new Space(expected, fixed));
            });
        }

        List<int[]> availablePositions = new ArrayList<>();
        for(int i = 0; i < BOARD_LIMIT; i++){
            for(int j = 0; j < BOARD_LIMIT; j++){
                if(spaces.get(i).get(j).getExpected() == 0){
                    availablePositions.add(new int[]{i,j});
                }
            }
        }

        Random random = new Random();

        // Preenche números fixos aleatórios
        while(numbersToPlace > 0 && !availablePositions.isEmpty()){
            // Escolhe uma posição aleatória
            int index = random.nextInt(availablePositions.size());
            int[] pos = availablePositions.remove(index);
            int row = pos[0];
            int col = pos[1];

            List<Integer> possibleNumbers = new ArrayList<>();
            for(int n = 1; n <= 9; n++){
                boolean valid = true;

                // Checa linha
                for(int c = 0; c < BOARD_LIMIT; c++){
                    if(spaces.get(row).get(c).getExpected() == n){
                        valid = false; break;
                    }
                }

                // Checa coluna
                if(valid){
                    for(int r = 0; r < BOARD_LIMIT; r++){
                        if(spaces.get(r).get(col).getExpected() == n){
                            valid = false; break;
                        }
                    }
                }

                // Checa quadrante 3x3
                if(valid){
                    int startRow = (row / 3) * 3;
                    int startCol = (col / 3) * 3;
                    outer:
                    for(int r = startRow; r < startRow + 3; r++){
                        for(int c = startCol; c < startCol + 3; c++){
                            if(spaces.get(r).get(c).getExpected() == n){
                                valid = false; break outer;
                            }
                        }
                    }
                }

                if(valid) possibleNumbers.add(n);
            }

            if(possibleNumbers.isEmpty()){
                continue; // nenhuma opção válida para essa posição, tenta outra
            }

            // Escolhe um número aleatório dentre os válidos
            int number = possibleNumbers.get(random.nextInt(possibleNumbers.size()));
            spaces.get(row).set(col, new Space(number, true));
            numbersToPlace--;
        }

        return spaces;

    }
}