package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Game <T extends Player> {
    private String gameName;

    protected Map<Integer, Player> playerIdToPlayerMap;

    protected Map<Character, GameAction> stdActions = new HashMap<>(Map.of('P', new GameAction('P', "Play game", (playerId) -> printPlayer(playerId)),
            'Q', new GameAction('Q', "Quit game", this::quitGame)));

    public Game(String gameName, Map<Character, GameAction> newActions) {
        this.gameName = gameName;
        this.stdActions.putAll(newActions);
        playerIdToPlayerMap = new HashMap<>();
    }

    abstract T createNewPlayer(String name);

    abstract Map<Character, GameAction> getGameActions(int playerIdx);

    protected final int addPlayer(String name) {
        playerIdToPlayerMap.put(playerIdToPlayerMap.size(), createNewPlayer(name));
        return playerIdToPlayerMap.size()-1;
    }

    public final boolean executeGameAction(int player, GameAction gameAction) {
        if(!playerIdToPlayerMap.containsKey(player)) {
            System.out.printf("Player %d not playing the game%n", player);
            return false;
        }

        return gameAction.action().test(player);
    }

    protected boolean printPlayer(int playerId) {
        if(!playerIdToPlayerMap.containsKey(playerId)) {
            System.out.printf("Player %d not playing the game%n", playerId);
            return false;
        }
        System.out.println(playerIdToPlayerMap.get(playerId));
        return true;
    }

    protected final boolean quitGame(int player) {
        if(!playerIdToPlayerMap.containsKey(player)) {
            System.out.printf("Player %d not playing the game%n", player);
            return true;
        }

        String playerName = playerIdToPlayerMap.get(player).name();
        playerIdToPlayerMap.remove(player);
        System.out.printf("Player %s successfully quited the game%n", playerName);
        return false;
    }

    public String getGameName() {
        return gameName;
    }

    public List<Player> getPlayerIdToPlayerMap() {
        return List.copyOf(playerIdToPlayerMap.values());
    }

    public Map<Character, GameAction> getStdActions() {
        return Map.copyOf(stdActions);
    }
}
