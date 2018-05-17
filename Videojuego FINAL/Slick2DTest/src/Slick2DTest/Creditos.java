package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Creditos extends BasicGameState {
    
    float posX, posY;
    Input entrada;
    Image credits;
    private int timePassed; 
    
    @Override
    public int getID() {
        return 71;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        credits = new Image ("res/creditos.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.credits.draw(posX,posY);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
      entrada = gc.getInput();
      
      timePassed += i;
        if (timePassed > 15000) {
            System.exit(0);
        }
            
      if(Principal.creditos){
          posY-= i/10f;
 
      }
    }
    
}
