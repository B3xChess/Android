package fr.snak.chess.Boards;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.Pieces.*;
import fr.snak.chess.Squares.SpecialSquare;
import fr.snak.chess.Squares.Square;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/04/2016.
 */
public class Boards {

    public static final int BOARD_DEFAULT = 0;
    public static final int BOARD_TEST_MOVES_PAWN = 1;
    public static final int BOARD_TEST_MOVES_BISHOP = 2;
    public static final int BOARD_TEST_MOVES_TOWER = 3;
    public static final int BOARD_TEST_MOVES_QUEEN = 4;
    public static final int BOARD_TEST_MOVES_KING = 5;
    public static final int BOARD_TEST_MOVES_KNIGHT = 6;

    public static final int BOARD_TEST_MOVES_GAME_ONE = 20;
    private int version;

    public Boards(int version) {
        this.version = version;
    }

    public Boards() {
        this.version = BOARD_DEFAULT;
    }

    public ArrayList<ISquare> getBoard(){
        switch(version){
            case BOARD_TEST_MOVES_PAWN:
                return boardPawnMoves();
            case BOARD_TEST_MOVES_BISHOP:
                return boardBishopMoves();
            case BOARD_TEST_MOVES_TOWER:
                return boardTowerMoves();
            case BOARD_TEST_MOVES_QUEEN:
                return boardQueenMoves();
            case BOARD_TEST_MOVES_KING:
                return boardKingMoves();
            case BOARD_TEST_MOVES_KNIGHT:
                return boardKnightMoves();
            case BOARD_TEST_MOVES_GAME_ONE:
                return boardGameOneMoves();
            default:
                return boardDefault();
        }
    }

    private ArrayList<ISquare> boardPawnMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1"));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8"));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6"));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("d4"));
        squares.add(new Square("d5"));
        squares.add(new Square("d6"));
        squares.add(new Square("d7",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("e2",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("e3"));
        squares.add(new Square("e4",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("e5",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("e6",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("e7"));
        squares.add(new Square("e8",new Pawn(IPiece.BACK_PIECE)));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("f4",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("f5",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3"));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g7",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8",new Pawn(IPiece.FRONT_PIECE)));
        // H
        squares.add(new SpecialSquare("h1"));
        squares.add(new SpecialSquare("h2"));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5"));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8"));

        return squares;
    }

    private ArrayList<ISquare> boardBishopMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1"));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8"));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6"));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8",new Bishop(IPiece.BACK_PIECE)));
        // D
        squares.add(new Square("d1",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("d5",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("d6",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6"));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new Square("f4"));
        squares.add(new Square("f5",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3"));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8"));
        // H
        squares.add(new SpecialSquare("h1"));
        squares.add(new SpecialSquare("h2",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8"));

        return squares;
    }

    private ArrayList<ISquare> boardTowerMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1",new Tower(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8"));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6"));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8",new Tower(IPiece.BACK_PIECE)));
        // D
        squares.add(new Square("d1",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("d5",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("d6",new Tower(IPiece.BACK_PIECE)));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6"));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new Square("f4"));
        squares.add(new Square("f5",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3"));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8"));
        // H
        squares.add(new SpecialSquare("h1"));
        squares.add(new SpecialSquare("h2",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8",new Tower(IPiece.BACK_PIECE)));

        return squares;
    }

    private ArrayList<ISquare> boardQueenMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1",new Qween(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8"));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6"));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8",new Qween(IPiece.BACK_PIECE)));
        // D
        squares.add(new Square("d1",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("d5",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("d6",new Qween(IPiece.BACK_PIECE)));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6"));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new Square("f4"));
        squares.add(new Square("f5",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3"));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8"));
        // H
        squares.add(new SpecialSquare("h1"));
        squares.add(new SpecialSquare("h2",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8",new Qween(IPiece.BACK_PIECE)));

        return squares;
    }

    private ArrayList<ISquare> boardKingMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1", new King(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8"));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2", new King(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6"));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2", new King(IPiece.BACK_PIECE)));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1", new King(IPiece.FRONT_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3", new King(IPiece.FRONT_PIECE)));
        squares.add(new Square("d4"));
        squares.add(new Square("d5"));
        squares.add(new Square("d6", new King(IPiece.BACK_PIECE)));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6", new King(IPiece.FRONT_PIECE)));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3"));
        squares.add(new Square("f4"));
        squares.add(new Square("f5"));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3", new King(IPiece.FRONT_PIECE)));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7"));
        squares.add(new Square("g8"));
        // H
        squares.add(new SpecialSquare("h1"));
        squares.add(new SpecialSquare("h2"));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5"));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8", new King(IPiece.BACK_PIECE)));

        return squares;
    }

    private ArrayList<ISquare> boardKnightMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1", new Knight(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4"));
        squares.add(new SpecialSquare("a5"));
        squares.add(new SpecialSquare("a6"));
        squares.add(new SpecialSquare("a7"));
        squares.add(new SpecialSquare("a8", new Knight(IPiece.BACK_PIECE)));
        // B
        squares.add(new Square("b1"));
        squares.add(new Square("b2", new Knight(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4"));
        squares.add(new Square("b5"));
        squares.add(new Square("b6", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("b7"));
        squares.add(new Square("b8"));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2", new Knight(IPiece.BACK_PIECE)));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("d2"));
        squares.add(new Square("d3", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("d4"));
        squares.add(new Square("d5"));
        squares.add(new Square("d6", new Knight(IPiece.BACK_PIECE)));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3"));
        squares.add(new Square("f4"));
        squares.add(new Square("f5"));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1"));
        squares.add(new Square("g2"));
        squares.add(new Square("g3", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("g4"));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7"));
        squares.add(new Square("g8"));
        // H
        squares.add(new SpecialSquare("h1", new Knight(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h2"));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4"));
        squares.add(new SpecialSquare("h5"));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7"));
        squares.add(new SpecialSquare("h8", new Knight(IPiece.BACK_PIECE)));

        return squares;
    }

    public ArrayList<ISquare> boardGameOneMoves(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1",new Tower(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2"));
        squares.add(new SpecialSquare("a3"));
        squares.add(new SpecialSquare("a4",new Qween(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a5",new King(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a6",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a7",new Knight(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a8",new Tower(IPiece.BACK_PIECE)));
        // B
        squares.add(new Square("b1",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b2",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b3"));
        squares.add(new Square("b4",new Knight(IPiece.BACK_PIECE)));
        squares.add(new Square("b5",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b6",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b7",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b8",new Pawn(IPiece.BACK_PIECE)));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2"));
        squares.add(new Square("c3",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1"));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("d5",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("d6"));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new Square("e5"));
        squares.add(new Square("e6",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3",new Knight(IPiece.FRONT_PIECE)));
        squares.add(new Square("f4",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("f5"));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g2",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g3"));
        squares.add(new Square("g4",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new Square("g5"));
        squares.add(new Square("g6"));
        squares.add(new Square("g7",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8",new Pawn(IPiece.FRONT_PIECE)));
        // H
        squares.add(new SpecialSquare("h1",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h2"));
        squares.add(new SpecialSquare("h3"));
        squares.add(new SpecialSquare("h4",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h5",new King(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h6"));
        squares.add(new SpecialSquare("h7",new Knight(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h8",new Tower(IPiece.FRONT_PIECE)));

        return squares;
    }

    public ArrayList<ISquare> boardDefault(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1",new Tower(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a2",new Knight(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a3",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a4",new Qween(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a5",new King(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a6",new Bishop(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a7",new Knight(IPiece.BACK_PIECE)));
        squares.add(new SpecialSquare("a8",new Tower(IPiece.BACK_PIECE)));
        // B
        squares.add(new Square("b1",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b2",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b3",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b4",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b5",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b6",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b7",new Pawn(IPiece.BACK_PIECE)));
        squares.add(new Square("b8",new Pawn(IPiece.BACK_PIECE)));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1"));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4"));
        squares.add(new Square("d5"));
        squares.add(new Square("d6"));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6"));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3"));
        squares.add(new Square("f4"));
        squares.add(new Square("f5"));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g2",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g3",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g4",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g5",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g6",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g7",new Pawn(IPiece.FRONT_PIECE)));
        squares.add(new Square("g8",new Pawn(IPiece.FRONT_PIECE)));
        // H
        squares.add(new SpecialSquare("h1",new Tower(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h2",new Knight(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h3",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h4",new Qween(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h5",new King(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h6",new Bishop(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h7",new Knight(IPiece.FRONT_PIECE)));
        squares.add(new SpecialSquare("h8",new Tower(IPiece.FRONT_PIECE)));

        return squares;
    }
}
