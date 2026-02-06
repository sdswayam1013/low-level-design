package chess.piece;

import chess.board.Board;
import chess.board.Position;
import chess.player.Color;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return from.row == to.row || from.col == to.col;
    }
}
