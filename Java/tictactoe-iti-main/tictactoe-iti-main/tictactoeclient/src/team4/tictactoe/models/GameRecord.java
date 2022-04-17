package team4.tictactoe.models;


import team4.tictactoe.enums.GamePosition;

import java.time.LocalDateTime;

public class GameRecord {
    int gameRecordId;
    int gameId;
    GamePosition position;
    LocalDateTime localDateTime;
    int playerId;

    public int getGameRecordId() {
        return gameRecordId;
    }

    public void setGameRecordId(int gameRecordId) {
        this.gameRecordId = gameRecordId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public GamePosition getPosition() {
        return position;
    }

    public void setPosition(GamePosition position) {
        this.position = position;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
