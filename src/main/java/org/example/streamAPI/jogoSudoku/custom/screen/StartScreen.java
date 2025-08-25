package org.example.streamAPI.jogoSudoku.custom.screen;

import org.example.streamAPI.jogoSudoku.service.BoardService;

import javax.swing.*;
import java.awt.*;

public class StartScreen {
    private final Dimension dimension = new Dimension(400, 300);



    public void show(){
        JFrame frame = new JFrame("Sudoku - Escolha a dificuldade");
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        frame.add(panel);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;

        JLabel label = new JLabel("Escolha a dificuldade", SwingConstants.CENTER);
        label.setFont(new Font("Arial",Font.BOLD,18));
        gridBagConstraints.gridy = 0;
        panel.add(label, gridBagConstraints);

        JButton easyButton = new JButton("Easy");
        easyButton.addActionListener(e -> startGame(40));
        gridBagConstraints.gridy = 1;
        panel.add(easyButton, gridBagConstraints);

        JButton mediumButton = new JButton("Medium");
        mediumButton.addActionListener(e -> startGame(30));
        gridBagConstraints.gridy = 2;
        panel.add(mediumButton, gridBagConstraints);

        JButton hardButton = new JButton("Hard");
        hardButton.addActionListener(e -> startGame(20));
        gridBagConstraints.gridy = 3;
        panel.add(hardButton, gridBagConstraints);

        frame.setVisible(true);

    }

    private void startGame(int numbersToPlace){
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(new JPanel());
        if(topFrame != null){
            topFrame.dispose();
        }

        java.util.Map<String, String> emptyConfig = java.util.Collections.emptyMap();

        BoardService boardService = new BoardService(emptyConfig, numbersToPlace);

        MainScreen mainScreen = new MainScreen(boardService);
        mainScreen.buildMainScreen();
    }
}
