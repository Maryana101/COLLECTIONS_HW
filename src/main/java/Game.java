import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
  
  private Map<String, Player> registered = new HashMap();
  
  public void register(Player newPlayer) {
    registered.put(newPlayer.getName(), newPlayer);
  }
  
  public Player findByName(String name) {
    if (registered.containsKey(name)) {
      return registered.get(name);
    }
    return null;
  }
  
  public int round(String playerName1, String playerName2) {
    
    if (!(registered.containsKey(playerName1) && registered.containsKey(playerName2))) {
      throw new NotRegisteredException("Один из игроков не зарегистрирован");
    }
    int strength1 = registered.get(playerName1).getStrength();
    int strength2 = registered.get(playerName2).getStrength();
    if (strength1 > strength2) {
      return 1;
    }
    if (strength1 < strength2) {
      return 2;
    }
    return 0;
  }
  
  public void removeById(int id) {
    for (String name : registered.keySet()) {
      if (registered.get(name).getId() == id) {
        registered.remove(name);
      }
    }
  }
  
  public Player[] getPlayers() {
    return registered.values().toArray(new Player[0]);
  }
  
}
