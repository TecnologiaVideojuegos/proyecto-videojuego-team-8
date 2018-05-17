package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWinMinijuegoLlave extends BasicGameState{
    MinijuegoLlave minijuego;
    Input entrada;

    public GameWinMinijuegoLlave(MinijuegoLlave minijuego) {
        this.minijuego = minijuego;
    }
    
    
    
    public void init(GameContainer arg0, StateBasedGame arg1){
         
    }
    
        public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){        
        g.drawString("Has ganado", 600, 364);
        g.drawString("Has conseguido una llave", 540, 404);
        
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int arg2){
        entrada = gc.getInput();
        Principal.llave = true;
              if (entrada.isKeyDown(Input.KEY_SPACE)){
                
                sbg.enterState (2);
            }  
            
           
    }
    

    
    public int getID() {
        return 11;
    }    
    
}
