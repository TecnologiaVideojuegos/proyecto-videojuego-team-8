package Slick2DTest;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState {

    MainMenu(int startMenu) {
    }

 
    public int getID() {
        return 0;
    }


    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Play", 500, 400);
        g.drawString("Exit", 500, 500);
    }


    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        //play button
        if ((posX > 496 && posX < 537) && (posY > 584 && posY < 598)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(1);
            }
        }
        //exit button
        if ((posX > 496 && posX < 537) && (posY > 485 && posY < 498)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
    
}
