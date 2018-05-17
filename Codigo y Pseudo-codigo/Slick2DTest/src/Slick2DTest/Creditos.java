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
    
    @Override
    public int getID() {
        return 71;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        credits = new Image ("res/creditos.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.credits.draw();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
      entrada = gc.getInput();
      
      if(Principal.creditos){
          posY -= i* .05f;
          if(posY < 1336){
              posY += i;
          }
      }
    }
    
}
