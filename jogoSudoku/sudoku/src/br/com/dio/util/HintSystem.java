package br.com.dio.util;

import br.com.dio.model.Board;
import java.util.ArrayList;
import java.util.List;


public class HintSystem {

    public static List<Integer> getPossibleValues(Board board, int col, int row) {
        List<Integer> possible = new ArrayList<>();
        for (int value = 1; value <= 9; value++) {
            if (board.isValidMove(col, row, value)) {
                possible.add(value);
            }
        }
        return possible;
    }

    public static void showHint(Board board, int col, int row) {
        var possibleValues = getPossibleValues(board, col, row);
        if (possibleValues.isEmpty()) {
            System.out.println("❌ Nenhum valor possível para esta posição!");
        } else {
            System.out.println("💡 Valores possíveis: " + possibleValues);
        }
    }
}

