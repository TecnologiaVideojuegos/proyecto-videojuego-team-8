package Slick2DTest;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BotonesCocina1 extends BasicGameState{
    
    private Image cocinabotones;
    boolean sideright=true;
    int[] duration = {200,200,200,200};
    private Input entrada;
    BasicGameState prevState = Principal.prevState;

    @Override
    public int getID() {
       return 41;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.cocinabotones = new Image("res/cocina2bgrandes.jpg");
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.cocinabotones.drawCentered(683,384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();
        
       int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        if ((posX > 1016 && posX < 1211) && (posY > 269 && posY < 465)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(42);
            }
        }
        
        else if(((posX > 272 && posX < 468) && (posY > 269 && posY < 465)) ||  ((posX > 773 && posX < 968) && (posY > 269 && posY < 465)) || ((posX > 531 && posX < 726) && (posY > 269 && posY < 465))){
            if (Mouse.isButtonDown(0)){
                sbg.enterState(40);
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }