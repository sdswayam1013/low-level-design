package chess.move;

import chess.board.Position;
import chess.piece.Piece;

public class Move {
    private final Position from;
    private final Position to;
    private final Piece piece;

    public Move(Piece piece, Position from, Position to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }
}
