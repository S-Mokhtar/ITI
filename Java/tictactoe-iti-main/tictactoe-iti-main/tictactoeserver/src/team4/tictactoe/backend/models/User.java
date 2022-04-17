package team4.tictactoe.backend.models;
import team4.tictactoe.backend.enums.PlayerStatus;
public class User {
    int id;
    String name;
    String username;
    int points;
    PlayerStatus status;
    public User() {
        name = "Anonymous";
        id = 0;
        username = "Anonymous";
        points = 0;
        status = PlayerStatus.ONLINE;
    }
    public User(int id, String name, String username, int points, PlayerStatus status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.points = points;
        this.status = status;
    }
    public PlayerStatus getStatus() {
        return status;
    }
    public void setStatus(PlayerStatus status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"name\":\"" + name + '\"' + ", \"username\":\"" + username + '\"' + ", \"points\":" + points + ", \"status\":\"" + status + "\"}";
    }
}
