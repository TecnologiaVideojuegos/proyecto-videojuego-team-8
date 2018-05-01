package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Habitacion3 extends BasicGameState {

     //Animation character, moveLeft, moveRight,moveUp,moveDown;
    Image conejo;
    private Image habitacion;
    //int[] duration = {200,200};
    private Input entrada;
    float characterPositionX = 580,  characterPositionY = 648;
    BasicGameState prevState = Principal.prevState;
    
    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.habitacion = new Image("res/interior.jpg");
       this.conejo = new Image("res/conejo.png");
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.habitacion.drawCentered(960,540);
        this.conejo.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 960, 540);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
         entrada = gc.getInput();
        
        //Building 1 entrance
        if ((characterPositionX > 1217 && characterPositionX < 1260)){
            if(entrada.isKeyDown(Input.KEY_J)){
                sbg.enterState(1);
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_I)){
            Principal.prevState2 = this;
            sbg.enterState(6);
        }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            characterPositionX += i * .1f;
            if (characterPositionX > 1307){
                    characterPositionX -= i *.1f;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            characterPositionX -= i * .1;
            if (characterPositionX < 557){
                    characterPositionX += i *.1f;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(2);
        }
    }
    
}
