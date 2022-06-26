
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

  Game game=new Game();
  Player player1= new Player (1, "Иван", 20);
  Player player2= new Player(2,"Виктор", 25);
  Player player3= new Player(3, "Петр", 20);
  Player player4=new Player(4,"Яна", 15);
  Player player5=new Player(5, "Анна", 15);
  
  @Test
  public void shouldRegisterNewPlayers(){
    game.register(player1);
    game.register(player2);
    
    Player[] expected ={player1, player2};
    Player[] actual=game.getPlayers().toArray(new Player[0]);
  
    assertArrayEquals(expected,actual);
  }
  
  @Test
  public void shouldRemovePlayerById(){
    game.register(player2);
    game.register(player3);
    game.register(player4);
    
    game.removeById(3);
    
    Player[] expected={player2,player4};
    Player[] actual=game.getPlayers().toArray(new Player[0]);
    
    assertArrayEquals(expected,actual);
  }
  
  @Test
  public void shouldWinFirstPlayer() {
  
    game.register(player2);
    game.register(player3);
  
    int actual = game.round(player2.getName(), player3.getName());
    int expected = 1;
  
    assertEquals(expected, actual);
  }
  
    @Test
    public void shouldWinSecondPlayer(){
    
      game.register(player2);
      game.register(player3);
    
      int actual=game.round(player3.getName(), player2.getName());
      int expected=2;
    
      assertEquals(expected,actual);
    
  }
  
  @Test
  public void shouldWinBothPlayers(){
    
    game.register(player4);
    game.register(player5);
    
    int actual=game.round(player4.getName(), player5.getName());
    int expected=0;
    
    assertEquals(expected,actual);
  }
  
  @Test
  public void shouldThrowExceptionThenFirstPlayerNotFound(){
    Player newPlayer=new Player(10,"Олег", 10);
    game.register(player3);
    
    assertThrows(NotRegisteredException.class, () -> {
      game.round("Олег",player3.getName());
    });
  }
  @Test
  public void shouldThrowExceptionThenSecondPlayerNotFound(){
    Player newPlayer=new Player(10,"Олег", 10);
    game.register(player3);
    
    assertThrows(NotRegisteredException.class, () -> {
      game.round(player3.getName(), "Олег");
    });
  }
  
  @Test
  public void shouldReturnNullThenPlayerNotFound(){
    Player actual=game.findByName("Олег");
    Player expected=null;
    
    assertEquals(expected,actual);
    
  }
  
}
