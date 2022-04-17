package team4.tictactoe.backend.models;



import team4.tictactoe.backend.enums.GameRequestStatus;

import java.time.LocalDateTime;

public class GameRequest {
    int gameRequestId;
    int playerId;
    int opponentId;
    GameRequestStatus requestStatus;
    LocalDateTime localDateTime;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public int getGameRequestId() {
        return gameRequestId;
    }

    public void setGameRequestId(int gameRequestId) {
        this.gameRequestId = gameRequestId;
    }

    public GameRequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(GameRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
