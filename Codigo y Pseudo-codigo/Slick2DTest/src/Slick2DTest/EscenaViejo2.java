package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EscenaViejo2 extends BasicGameState{

    private Image hall2;
    private Input entrada;
    
    @Override
    public int getID() {
       return 23;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.hall2 = new Image ("res/hall2.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
       hall2.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        
        if(entrada.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            sbg.enterState(24);
       } 
    }
    
}
