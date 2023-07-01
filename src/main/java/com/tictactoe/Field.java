package com.tictactoe;

import java.util.*;
import java.util.stream.Collectors;

public class Field {
    private final Map<Integer, Sign> field;

    public Field() {
        field = new HashMap<>();
        field.put(0, Sign.EMPTY);
        field.put(1, Sign.EMPTY);
        field.put(2, Sign.EMPTY);
        field.put(3, Sign.EMPTY);
        field.put(4, Sign.EMPTY);
        field.put(5, Sign.EMPTY);
        field.put(6, Sign.EMPTY);
        field.put(7, Sign.EMPTY);
        field.put(8, Sign.EMPTY);
    }

    public Map<Integer, Sign> getField() {
        return field;
    }

    public int getEmptyFieldIndex() {
        // Выбираем лучшее пустое поле
        // Не используем умный алгоритм "Минимакс", используем логику обычного человека

        // Если центр свободен - сразу занимаем!!!
        if (field.get(4) == Sign.EMPTY) {
            return 4;
        }

        // Сколько уже крестиков на поле?
        long crossCount = field.entrySet().stream()
                .filter(e -> e.getValue() == Sign.CROSS).count();

        // Второй ход и крестик в центре - занимаем любой угол!
        if (crossCount == 1) {
            List<Integer> anglesList = Arrays.asList(0, 2, 6, 8);
            Random rand = new Random();
            return anglesList.get(rand.nextInt(anglesList.size()));
        }

        // Может сможем выиграть?
        // Проверим диагонали
        if (field.get(0) == Sign.EMPTY && field.get(4) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT) {
            return 0;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(4) == Sign.EMPTY && field.get(8) == Sign.NOUGHT) {
            return 4;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }
        if (field.get(2) == Sign.EMPTY && field.get(4) == Sign.NOUGHT && field.get(6) == Sign.NOUGHT) {
            return 2;
        }
        if (field.get(2) == Sign.NOUGHT && field.get(4) == Sign.EMPTY && field.get(6) == Sign.NOUGHT) {
            return 4;
        }
        if (field.get(2) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(6) == Sign.EMPTY) {
            return 6;
        }

        // Проверим вертикали
        if (field.get(0) == Sign.EMPTY && field.get(3) == Sign.NOUGHT && field.get(6) == Sign.NOUGHT) {
            return 0;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(3) == Sign.EMPTY && field.get(6) == Sign.NOUGHT) {
            return 3;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(3) == Sign.NOUGHT && field.get(6) == Sign.EMPTY) {
            return 6;
        }
        if (field.get(1) == Sign.EMPTY && field.get(4) == Sign.NOUGHT && field.get(7) == Sign.NOUGHT) {
            return 1;
        }
        if (field.get(1) == Sign.NOUGHT && field.get(4) == Sign.EMPTY && field.get(7) == Sign.NOUGHT) {
            return 4;
        }
        if (field.get(1) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(7) == Sign.EMPTY) {
            return 7;
        }
        if (field.get(2) == Sign.EMPTY && field.get(5) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT) {
            return 2;
        }
        if (field.get(2) == Sign.NOUGHT && field.get(5) == Sign.EMPTY && field.get(8) == Sign.NOUGHT) {
            return 5;
        }
        if (field.get(2) == Sign.NOUGHT && field.get(5) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }

        // Проверим горизонтали
        if (field.get(0) == Sign.EMPTY && field.get(1) == Sign.NOUGHT && field.get(2) == Sign.NOUGHT) {
            return 0;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(1) == Sign.EMPTY && field.get(2) == Sign.NOUGHT) {
            return 1;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(1) == Sign.NOUGHT && field.get(2) == Sign.EMPTY) {
            return 2;
        }
        if (field.get(3) == Sign.EMPTY && field.get(4) == Sign.NOUGHT && field.get(5) == Sign.NOUGHT) {
            return 3;
        }
        if (field.get(3) == Sign.NOUGHT && field.get(4) == Sign.EMPTY && field.get(5) == Sign.NOUGHT) {
            return 4;
        }
        if (field.get(3) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(5) == Sign.EMPTY) {
            return 5;
        }
        if (field.get(6) == Sign.EMPTY && field.get(7) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT) {
            return 6;
        }
        if (field.get(6) == Sign.NOUGHT && field.get(7) == Sign.EMPTY && field.get(8) == Sign.NOUGHT) {
            return 7;
        }
        if (field.get(6) == Sign.NOUGHT && field.get(7) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }

        // Если опасная ситуация - защищаемся!
        // Проверим диагонали
        if (field.get(0) == Sign.EMPTY && field.get(4) == Sign.CROSS && field.get(8) == Sign.CROSS) {
            return 0;
        }
        if (field.get(0) == Sign.CROSS && field.get(4) == Sign.EMPTY && field.get(8) == Sign.CROSS) {
            return 4;
        }
        if (field.get(0) == Sign.CROSS && field.get(4) == Sign.CROSS && field.get(8) == Sign.EMPTY) {
            return 8;
        }
        if (field.get(2) == Sign.EMPTY && field.get(4) == Sign.CROSS && field.get(6) == Sign.CROSS) {
            return 2;
        }
        if (field.get(2) == Sign.CROSS && field.get(4) == Sign.EMPTY && field.get(6) == Sign.CROSS) {
            return 4;
        }
        if (field.get(2) == Sign.CROSS && field.get(4) == Sign.CROSS && field.get(6) == Sign.EMPTY) {
            return 6;
        }

        // Проверим вертикали
        if (field.get(0) == Sign.EMPTY && field.get(3) == Sign.CROSS && field.get(6) == Sign.CROSS) {
            return 0;
        }
        if (field.get(0) == Sign.CROSS && field.get(3) == Sign.EMPTY && field.get(6) == Sign.CROSS) {
            return 3;
        }
        if (field.get(0) == Sign.CROSS && field.get(3) == Sign.CROSS && field.get(6) == Sign.EMPTY) {
            return 6;
        }
        if (field.get(1) == Sign.EMPTY && field.get(4) == Sign.CROSS && field.get(7) == Sign.CROSS) {
            return 1;
        }
        if (field.get(1) == Sign.CROSS && field.get(4) == Sign.EMPTY && field.get(7) == Sign.CROSS) {
            return 4;
        }
        if (field.get(1) == Sign.CROSS && field.get(4) == Sign.CROSS && field.get(7) == Sign.EMPTY) {
            return 7;
        }
        if (field.get(2) == Sign.EMPTY && field.get(5) == Sign.CROSS && field.get(8) == Sign.CROSS) {
            return 2;
        }
        if (field.get(2) == Sign.CROSS && field.get(5) == Sign.EMPTY && field.get(8) == Sign.CROSS) {
            return 5;
        }
        if (field.get(2) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(8) == Sign.EMPTY) {
            return 8;
        }

        // Проверим горизонтали
        if (field.get(0) == Sign.EMPTY && field.get(1) == Sign.CROSS && field.get(2) == Sign.CROSS) {
            return 0;
        }
        if (field.get(0) == Sign.CROSS && field.get(1) == Sign.EMPTY && field.get(2) == Sign.CROSS) {
            return 1;
        }
        if (field.get(0) == Sign.CROSS && field.get(1) == Sign.CROSS && field.get(2) == Sign.EMPTY) {
            return 2;
        }
        if (field.get(3) == Sign.EMPTY && field.get(4) == Sign.CROSS && field.get(5) == Sign.CROSS) {
            return 3;
        }
        if (field.get(3) == Sign.CROSS && field.get(4) == Sign.EMPTY && field.get(5) == Sign.CROSS) {
            return 4;
        }
        if (field.get(3) == Sign.CROSS && field.get(4) == Sign.CROSS && field.get(5) == Sign.EMPTY) {
            return 5;
        }
        if (field.get(6) == Sign.EMPTY && field.get(7) == Sign.CROSS && field.get(8) == Sign.CROSS) {
            return 6;
        }
        if (field.get(6) == Sign.CROSS && field.get(7) == Sign.EMPTY && field.get(8) == Sign.CROSS) {
            return 7;
        }
        if (field.get(6) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(8) == Sign.EMPTY) {
            return 8;
        }

        // Хм... займем еще один угол, если есть
        if (field.get(2) == Sign.NOUGHT && field.get(0) == Sign.EMPTY) {
            return 0;
        }
        if (field.get(6) == Sign.NOUGHT && field.get(0) == Sign.EMPTY) {
            return 0;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(2) == Sign.EMPTY) {
            return 2;
        }
        if (field.get(8) == Sign.NOUGHT && field.get(2) == Sign.EMPTY) {
            return 2;
        }
        if (field.get(0) == Sign.NOUGHT && field.get(6) == Sign.EMPTY) {
            return 6;
        }
        if (field.get(8) == Sign.NOUGHT && field.get(6) == Sign.EMPTY) {
            return 6;
        }
        if (field.get(6) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }
        if (field.get(2) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }
        int freeAngle = field.entrySet().stream()
                .filter(e -> (e.getValue() == Sign.EMPTY && Arrays.asList(0, 2, 6, 8).contains(e.getKey())))
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
        if (freeAngle != -1) {
            return freeAngle;
        }

        // Вряд ли до сюда дойдем, но если дошли - ставим в пустую по порядку
        return field.entrySet().stream()
                .filter(e -> e.getValue() == Sign.EMPTY)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    public List<Sign> getFieldData() {
        return field.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Sign checkWin() {
        List<List<Integer>> winPossibilities = List.of(
                List.of(0, 1, 2),
                List.of(3, 4, 5),
                List.of(6, 7, 8),
                List.of(0, 3, 6),
                List.of(1, 4, 7),
                List.of(2, 5, 8),
                List.of(0, 4, 8),
                List.of(2, 4, 6)
        );

        for (List<Integer> winPossibility : winPossibilities) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                && field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))) {
                return field.get(winPossibility.get(0));
            }
        }
        return Sign.EMPTY;
    }
}