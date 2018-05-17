package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EscenaViejo5 extends BasicGameState{

    private Image hall5;
    private Input entrada;
    
    @Override
    public int getID() {
       return 26;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.hall5 = new Image ("res/hall5.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
       hall5.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        
        if(entrada.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            sbg.enterState(27);
       } 
    }
    
}
