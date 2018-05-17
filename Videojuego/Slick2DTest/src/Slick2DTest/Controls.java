package Slick2DTest;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Controls extends BasicGameState {

    Image controles;
    Input entrada;
    
    @Override
    public int getID() {
       return 70;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        controles = new Image("res/Comandos.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.controles.drawCentered(683, 384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        entrada = gc.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        if ((posX > 1038 && posX < 1074) && (posY > 640 && posY < 670)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(3);
            }
        }
        
       
    }
    
}
