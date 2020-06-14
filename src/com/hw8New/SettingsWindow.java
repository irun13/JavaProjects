package hw8New;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsWindow extends JFrame {
    // атрибуты окна
    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FILD_SIZE = 3;
    private static final int MAX_FILD_SIZE = 10;

    static final int MODE_H_VS_A = 0;
    static final int MODE_H_VS_H = 1;

    private GameWindow gameWindow;

    private JRadioButton radioButtonHvsAi = new JRadioButton("игра против компьютера");
    private JRadioButton radioButtonHvsH = new JRadioButton("2 игрока");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider sliderFieldSize = new JSlider(MIN_FILD_SIZE, MAX_FILD_SIZE, 9);
    private JSlider sliderDotsToWin = new JSlider(MIN_FILD_SIZE, MIN_FILD_SIZE, MIN_FILD_SIZE ); //

    public SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настройки");

        setLayout(new GridLayout(8, 1));
        add(new JLabel("Режим игры:"));
        add(radioButtonHvsAi);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAi);
        gameMode.add(radioButtonHvsH);

        add(new JLabel("Размер поля"));
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);

        add(sliderFieldSize);
        add(new JLabel("Победная линия"));
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
            }
        });
        JButton buttonStartNewGame = new JButton("Начать игру");
        buttonStartNewGame.setBackground(Color.cyan);
        add(buttonStartNewGame);

        buttonStartNewGame.addActionListener(e ->{
            setVisible(false);

            int mode;
            if(radioButtonHvsAi.isSelected()){
                mode = MODE_H_VS_A;
            } else {
                mode = MODE_H_VS_H;
            }

            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(mode,fieldSize,fieldSize,dotsToWin);
        });

        setVisible(false);
    }
}
