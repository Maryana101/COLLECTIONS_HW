import java.util.ArrayList;
import java.util.List;

public class Game {
  
  private List<Player> registered = new ArrayList<>();
  
  public void register(Player newPlayer) {
    registered.add(newPlayer);
  }
  
  public Player findByName(String name) {
    for (Player player : registered) {
      if (player.getName().equals(name)) {
        return player;
      }
    }
    return null;
  }
  
  public int round(String playerName1, String playerName2) {
    Player player1 = findByName(playerName1);
    Player player2 = findByName(playerName2);
    
    if (!(registered.contains(player1) && registered.contains(player2))) {
      throw new NotRegisteredException("Один из игроков не зарегистрирован");
    }
    
    if (player1.getStrength() > player2.getStrength()) {
      return 1;
    }
    if (player1.getStrength() < player2.getStrength()) {
      return 2;
    }
    return 0;
  }
  
  public void removeById(int id) {
    registered.removeIf(element -> element.getId() == id);
  }
  
  public List<Player> getPlayers() {
    return registered;
  }
  
}
