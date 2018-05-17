package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWinMinijuegoCuchillo extends BasicGameState{
    MinijuegoCuchillo minijuego;
    Input entrada;

   GameWinMinijuegoCuchillo(MinijuegoCuchillo minijuego) {
        this.minijuego = minijuego;
    }

   
    
    
    public void init(GameContainer arg0, StateBasedGame arg1){
         
    }
    
        public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){        
        g.drawString("Has ganado", 300, 300);
        g.drawString("Has conseguido un cuchillo", 300, 450);
        
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int arg2){
        entrada = gc.getInput();
        Principal.cuchillo = true;
              if (entrada.isKeyDown(Input.KEY_SPACE)){
                
                sbg.enterState (48);
            }  
            
           
    }
    

    
    public int getID() {
        return 66;
    }    
    
}
