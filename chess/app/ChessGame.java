package chess.app;

import chess.board.Board;
import chess.board.Position;
import chess.piece.Rook;
import chess.player.Color;

public class ChessGame {

    public static void main(String[] args) {

        Board board = new Board();

        Rook whiteRook = new Rook(Color.WHITE);
        board.placePiece(whiteRook, new Position(0, 0));

        boolean valid = whiteRook.canMove(
                board,
                new Position(0, 0),
                new Position(0, 5)
        );

        System.out.println("Move valid: " + valid);
    }
}
