package team4.tictactoe.backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author elkrnk 1
 */
public class GameRoom {
    int id;
    ClientHandler player1;
    ClientHandler player2;
    GameRoom(int id, ClientHandler p1, ClientHandler p2) {
        this.id = id;
        player1 = p1;
        player2 = p2;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ClientHandler getPlayer1() {
        return player1;
    }
    public void setPlayer1(ClientHandler player1) {
        this.player1 = player1;
    }
    public ClientHandler getPlayer2() {
        return player2;
    }
    public void setPlayer2(ClientHandler player2) {
        this.player2 = player2;
    }
}



