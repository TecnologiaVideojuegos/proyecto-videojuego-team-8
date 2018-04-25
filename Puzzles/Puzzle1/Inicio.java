package minijuegos;

/**
 *
 * @author Luismi
 */
import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

public class Inicio extends StateBasedGame {
    
    public static int Puntuacion = 0;
    public static int Vidas = 3;
    
    public Inicio (String title) {

        super(title);
    } 
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app= new AppGameContainer (new Inicio ("Inicio test"));
        
        app.setDisplayMode(800, 600, false);
        app.setAlwaysRender(true);
        
        app.start();  
    }
    
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new GameState());
        this.addState(new GameOver());
    }
    
}
