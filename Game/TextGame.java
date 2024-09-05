package game;

import java.util.HashMap;
import java.util.Map;

public class TextGame extends Game<PlayerImpl>{
    public TextGame(String gameName) {
        super(gameName, new HashMap<>());
    }

    @Override
    PlayerImpl createNewPlayer(String name) {
        return new PlayerImpl(name);
    }

    @Override
    Map<Character, GameAction> getGameActions(int playerIdx) {
        return super.getStdActions();
    }
}
