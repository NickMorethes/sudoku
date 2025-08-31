package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.GameStatusEnum.COMPLETE;
import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;
    private MoveHistory moveHistory = new MoveHistory();

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))) {
            return NON_STARTED;
        }

        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == NON_STARTED) {
            return false;
        }

        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }

    // MANTER APENAS ESTE MÉTODO changeValue:
    public boolean changeValue(final int col, final int row, final int value) {
        var space = spaces.get(col).get(row);
        if (space.isFixed()) {
            return false;
        }

        if (!isValidMove(col, row, value)) {
            System.out.println("❌ Movimento inválido! Número já existe na linha, coluna ou quadrante.");
            return false;
        }

        // Guardar movimento
        Integer previousValue = space.getActual();
        moveHistory.addMove(new MoveHistory.Move(col, row, previousValue, value));

        space.setActual(value);
        return true;
    }

    public boolean clearValue(final int col, final int row) {
        var space = spaces.get(col).get(row);
        if (space.isFixed()) {
            return false;
        }

        space.clearSpace();
        return true;
    }

    public void reset() {
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished() {
        return !hasErrors() && getStatus().equals(COMPLETE);
    }

    public boolean isValidMove(int col, int row, int value) {
        // Verificar linha
        for (int i = 0; i < 9; i++) {
            if (i != col && spaces.get(i).get(row).getActual() != null
                    && spaces.get(i).get(row).getActual() == value) {
                return false;
            }
        }

        // Verificar coluna
        for (int j = 0; j < 9; j++) {
            if (j != row && spaces.get(col).get(j).getActual() != null
                    && spaces.get(col).get(j).getActual() == value) {
                return false;
            }
        }

        // Verificar quadrante 3x3
        int startCol = (col / 3) * 3;
        int startRow = (row / 3) * 3;
        for (int i = startCol; i < startCol + 3; i++) {
            for (int j = startRow; j < startRow + 3; j++) {
                if (!(i == col && j == row) && spaces.get(i).get(j).getActual() != null && spaces.get(i).get(j).getActual() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean undoLastMove() {
        var lastMove = moveHistory.undo();
        if (lastMove == null) {
            return false;
        }

        spaces.get(lastMove.getCol()).get(lastMove.getRow()).setActual(lastMove.getPreviousValue());
        return true;
    }
}