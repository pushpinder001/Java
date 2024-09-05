package game;

import java.util.*;

public class GameConsole<T extends Game<? extends Player>>{
    private static Scanner sc;

    private T game;

    public GameConsole(T game) {
        this.game = game;
        sc = new Scanner(System.in);
    }

    public int addPlayer() {
        System.out.println("Enter the player name : ");
        String name = sc.nextLine();
        return game.addPlayer(name);
    }

    public boolean playGame(int playerIdx) {
        Map<Character, GameAction> keyToGameActionMap = game.getGameActions(playerIdx);
        if(keyToGameActionMap == null) {
            System.out.println("Unable to get game actions for player " + playerIdx);
            return false;
        }

        String ch;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Select any one of the game action for player " + playerIdx);
            keyToGameActionMap.forEach((k, v) -> {
                System.out.printf("Enter key %c for action %s%n", k, v.prompt());
            });
            ch = sc.nextLine();
            if(ch.length() != 1 || keyToGameActionMap.get(ch.charAt(0)) == null) {
                System.out.println("Invalid key entered");
                continue;
            }
            break;
        } while(true);

        return game.executeGameAction(playerIdx,  keyToGameActionMap.get(ch.charAt(0)));
    }

    public static void main(String[] args) {
        GameConsole<Game<? extends Player>> gameGameConsole = new GameConsole<>(new TextGame("test"));
        Set<Integer> curPlayersIds = new TreeSet<>();

        curPlayersIds.add(gameGameConsole.addPlayer());
        curPlayersIds.add(gameGameConsole.addPlayer());

        while(curPlayersIds.size() >0) {
            var it = curPlayersIds.iterator();

            while (it.hasNext()) {
                boolean val = gameGameConsole.playGame(it.next());
                if (!val) {
                    it.remove();
                }

            }
        }
    }
}
