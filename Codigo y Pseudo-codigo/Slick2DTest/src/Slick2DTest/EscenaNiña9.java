package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EscenaNiña9 extends BasicGameState{

    private Image habitacion9;
    private Input entrada;
    
    @Override
    public int getID() {
       return 20;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.habitacion9 = new Image ("res/habitacion1-9.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
       habitacion9.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        
        if(entrada.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            sbg.enterState(21);
       } 
    }
    
}
