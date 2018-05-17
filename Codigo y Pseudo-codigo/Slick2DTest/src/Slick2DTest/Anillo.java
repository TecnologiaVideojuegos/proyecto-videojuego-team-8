package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Anillo extends BasicGameState {

    Image anillo;
    Input entrada;
    
    @Override
    public int getID() {
       return 69;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        anillo = new Image("res/anillo.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.anillo.drawCentered(683, 384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        
         if(entrada.isKeyDown(Input.KEY_SPACE)){
             Principal.creditos= true;
             sbg.enterState(71);
         }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
    }
    
}
