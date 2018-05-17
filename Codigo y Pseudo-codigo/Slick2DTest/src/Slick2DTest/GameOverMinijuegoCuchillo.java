package Slick2DTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverMinijuegoCuchillo extends BasicGameState{
    MinijuegoCuchillo minijuego;
    Input entrada;
    Principal principal;

    GameOverMinijuegoCuchillo(MinijuegoCuchillo minijuego) {
        this.minijuego = minijuego;
    }

    
    
    public void init(GameContainer arg0, StateBasedGame arg1){
        try {
            principal = new Principal();
        } catch (SlickException ex) {
            Logger.getLogger(GameOverMinijuegoCuchillo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){        
        g.drawString("Has Perdido", 600, 364);
    }
    
    
    public void update(GameContainer gc, StateBasedGame sbg, int arg2){
        entrada = gc.getInput();
        principal.setVidasMinijuegoCuchillo(1);
              if (entrada.isKeyDown(Input.KEY_SPACE)){
                sbg.enterState (48);
           }
    }
    
 
    public int getID() {
        return 65;
    }    
    
}

