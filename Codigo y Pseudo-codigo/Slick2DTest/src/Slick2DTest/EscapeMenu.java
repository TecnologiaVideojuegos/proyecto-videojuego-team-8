
package Slick2DTest;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EscapeMenu extends BasicGameState {
    
     
     Input entrada;
    
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
     
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        g.setColor(Color.white);
        g.drawString("Resume (R)", 960, 440);
        g.drawString("Main Menu (M)", 960, 540);
        g.drawString("Quit (Q)", 960, 640);
        
        
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
         
            entrada = gc.getInput();
            
        
           if(entrada.isKeyDown(Input.KEY_R)){
                BasicGameState prevState = Principal.prevState;
                Principal.prevState = this;
                sbg.enterState (prevState.getID());
           }
           
           if (entrada.isKeyDown(Input.KEY_M)){
               sbg.enterState(0);
           }
           if (entrada.isKeyDown(Input.KEY_Q)){
               System.exit(0);
           }
           
    }
    
}
   
