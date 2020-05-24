package com.hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW3 {

    public static void main(String[] args) {
        // 1. Угадайка чисел.
        int answer = (int) (Math.random() * 10);
        int attempts = 3;
        String playAgain = "N";
        try {
            do {
                System.out.println("Попробуй угадай мое число 0 до 9:)");
                for (int i = 1; i <= attempts; i++) {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        int userAnswer = Integer.parseInt(reader.readLine());
                        if (userAnswer == answer) {
                            System.out.println("Огонь, ты угадал!");
                            break;
                        } else if (userAnswer > answer) {
                            if (i == 3) {
                                System.out.println("Ты проиграл(");
                                break;
                            }
                            System.out.println("Слишком много( У тебя осталось " + (3 - i) + " попытки.");
                        } else {
                            if (i == 3) {
                                System.out.println("Ты проиграл(");
                                break;
                            }
                            System.out.println("Слишком мало( У тебя осталось " + (3 - i) + " попытки.");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // Y больше понравился чем 1 и 0
                System.out.println("Хочешь сыграть еще? Если да, то введи Y, если нет, то любой другой символ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    playAgain = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while ("Y".equals(playAgain));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }
        //2. угадайка слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answerS = words[(int) (Math.random() * words.length)];
        System.out.println("Угадай слово, которое я загадал:)");
        String str = "";
        for (int i = 0; i < answerS.length(); i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String userAnswerS = reader.readLine();
                System.out.println(userAnswerS);
                if (userAnswerS.equals(answerS)) {
                    System.out.println("Вау! Такое вообще возможно?! Ты угадал!");
                    break;
                } else {
                    if (answerS.length() == i + 1) {
                        System.out.println("Ну комон! Сколько можно?! Не хочу больше играть!) Сам играй!" + "\n" + "Правильный ответ " + answerS);
                        break;
                    }
                    str += answerS.charAt(i);
                    System.out.println("Подсказка " + (i + 1) + " " + str + "###############" + "\n" + "Попробуй еще.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
