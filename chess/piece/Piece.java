package chess.piece;

import chess.board.Board;
import chess.board.Position;
import chess.player.Color;

public abstract class Piece {

    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean canMove(Board board, Position from, Position to);
}
