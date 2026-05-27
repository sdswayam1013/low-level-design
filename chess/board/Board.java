package chess.board;

import chess.piece.Piece;

public class Board {

    private final Cell[][] cells = new Cell[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Piece getPiece(Position pos) {
        return cells[pos.row][pos.col].getPiece();
    }

    public void placePiece(Piece piece, Position pos) {
        cells[pos.row][pos.col].setPiece(piece);
    }
}
