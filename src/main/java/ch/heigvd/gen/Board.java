package ch.heigvd.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int squareCount = 40;
    private final ArrayList<Square> squares;

    public Board() {
        ArrayList<Square> labels = new ArrayList<>();

        labels.add(new Square("Go"));
        for (int i = 1; i < 40; ++i)
            labels.add(new Square(String.format("Square %d", i)));

        squares = labels;
    }

    public Board(List<String> labels) {
        if (labels != null && labels.size() != squareCount)
            throw new IllegalArgumentException();

        squares = new ArrayList<>(squareCount);

        for (int i = 0; i < squareCount; i++) {
            squares.add(new Square(labels.get(i)));
        }

    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        if (fvTot < 0)
            throw new IllegalArgumentException();

        return squares.get((squares.indexOf(oldLoc) + fvTot) % squareCount);
    }
}

