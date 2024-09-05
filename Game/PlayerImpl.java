package game;

public record PlayerImpl(String name) implements Player {

    @Override
    public String toString() {
        return "Player name:" + name;
    }
}
