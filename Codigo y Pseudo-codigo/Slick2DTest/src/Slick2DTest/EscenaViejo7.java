package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EscenaViejo7 extends BasicGameState{

    private Image hall7;
    private Input entrada;
    
    @Override
    public int getID() {
       return 28;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.hall7 = new Image ("res/hall7.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
       hall7.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        
        if(entrada.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            sbg.enterState(29);
       } 
    }
    
}
