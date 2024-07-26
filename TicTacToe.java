import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] board = new String[8][8];
        boolean weiter = true;
        int moves = 0;

        //Feld
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board.length; i1++) {
                if (i1 % 2 != 0) {
                    board[i][i1] = "|";
                } else if (i % 2 != 0) {
                    board[i][i1] = "-";
                } else {
                    if (i == 0 && i1 == 0) {
                        board[i][i1] = "O";
                        board[i][i1 + 2] = "1";
                        board[i][i1 + 4] = "2";
                        board[i][i1 + 6] = "3";
                        board[i + 2][i1] = "A";
                        board[i + 4][i1] = "B";
                        board[i + 6][i1] = "C";
                    } else if (i != 0 && i1 != 0) {
                        board[i][i1] = " ";
                    }
                }
            }
        }

        //Gamestart
        while (weiter) {
            //Ausgabe des Feldes
            for (int i = 0; i < board.length; i++) {
                for (int i1 = 0; i1 < board.length; i1++) {
                    System.out.print(board[i][i1] + "\t");
                }
                System.out.println();
            }
            // Ende des Spiels nach dem 9. Zug
            if (moves == 9) {
                weiter = checkeBorad(board, moves);
                if (weiter) {
                    System.out.println("Unentschieden!");
                }
                weiter = false;
            }
            // Gewinnbedingungen
            if (weiter) {
                weiter = checkeBorad(board, moves);
            }
            //Zug
            if (weiter) {
                weiter = bewgung(board, moves);
                moves++;
            }
        }
    }

    //Spieler am Zug
    public static boolean bewgung(String[][] boeard, int moves) {
        Scanner scan = new Scanner(System.in);
        String eingabe = null;
        int i = 0;
        int i2 = 0;

        System.out.println("Geben Sie Ihren Zug ein:");
        String input = scan.next();
        switch (input) {
            case "1A":
                eingabe = "Move";
                i2 = 1;
                i = 1;
                break;
            case "1B":
                eingabe = "Move";
                i2 = 1;
                i = 2;
                break;
            case "1C":
                eingabe = "Move";
                i2 = 1;
                i = 3;
                break;
            case "2A":
                eingabe = "Move";
                i2 = 2;
                i = 1;
                break;
            case "2B":
                eingabe = "Move";
                i2 = 2;
                i = 2;
                break;
            case "2C":
                eingabe = "Move";
                i2 = 2;
                i = 3;
                break;
            case "3A":
                eingabe = "Move";
                i2 = 3;
                i = 1;
                break;
            case "3B":
                eingabe = "Move";
                i2 = 3;
                i = 2;
                break;
            case "3C":
                eingabe = "Move";
                i2 = 3;
                i = 3;
                break;
            case "end":
                eingabe = "end";
                break;
            default:
                eingabe = "New";
                System.out.println("Falsche Eingabe!");
                break;
        }
        if (eingabe != "New") {
            if (eingabe != "end") {
                if (eingabe == "Move") {
                    if (boeard[i+i][i2+i2] == " ") {
                        if (moves % 2 == 0) {
                            boeard[i+i][i2+i2] = "X";
                        } else {
                            boeard[i+i][i2+i2] = "O";
                        }
                    } else {
                        System.out.println("Bereits vergeben!");
                        bewgung(boeard, moves);
                    }
                }
            } else {
                System.out.println("Beende Spiel!");
                return false;
            }
        } else if (eingabe == "New") {
            bewgung(boeard, moves);
        } else {
            return false;
        }
        return true;
    }
    public static boolean checkeBorad(String[][] board, int moves) {
        String curPlyerChar = "X";
            if (moves >= 5) {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (board[2][2] == curPlyerChar && board[2][4] == curPlyerChar && board[2][6] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[4][2] == curPlyerChar && board[4][4] == curPlyerChar && board[4][6] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[6][2] == curPlyerChar && board[6][4] == curPlyerChar && board[6][6] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[2][2] == curPlyerChar && board[4][2] == curPlyerChar && board[6][2] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[2][4] == curPlyerChar && board[4][4] == curPlyerChar && board[6][4] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[2][6] == curPlyerChar && board[4][6] == curPlyerChar && board[6][6] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[2][2] == curPlyerChar && board[4][4] == curPlyerChar && board[6][6] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    } else if (board[2][6] == curPlyerChar && board[4][4] == curPlyerChar && board[6][2] == curPlyerChar) {
                        System.out.println("Spieler " + curPlyerChar + " hat gewonnen!");
                        return false;
                    }
                    curPlyerChar = "O";
                }
            } else {
                return true;
            }
        return true;
    }
}
