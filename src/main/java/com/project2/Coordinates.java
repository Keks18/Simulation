package com.project2;

import java.util.Arrays;

public final class Coordinates {
    private final int [] row;
    private final int [] col;

    public Coordinates(int[] row, int[] col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Arrays.equals(row, that.row) && Arrays.equals(col, that.col);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(row);
        result = 31 * result + Arrays.hashCode(col);
        return result;
    }
}
