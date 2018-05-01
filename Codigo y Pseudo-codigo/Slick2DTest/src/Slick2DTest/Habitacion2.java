package Slick2DTest;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Habitacion2 extends BasicGameState {

     //Animation character, moveLeft, moveRight,moveUp,moveDown;
    private Image conejo;
    private Image habitacion;
    private Image tuberia;
    private Inventario inventario ;
    
    //int[] duration = {200,200};
    private Input entrada;
    float characterPositionX = 580,  characterPositionY = 648;
    BasicGameState prevState = Principal.prevState;

    public Habitacion2(Inventario inventario) {
        this.inventario = inventario;
    }
    
    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.conejo = new Image("res/conejo.png");
       this.habitacion = new Image("res/interior.jpg");
       this.tuberia = new Image("res/tuberia2.png");
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.habitacion.drawCentered(960,540);
        this.conejo.draw(characterPositionX,characterPositionY);
        this.tuberia.draw(750,648);
        
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
        
        if ((characterPositionX > 730 && characterPositionX < 830)){
            if(entrada.isKeyDown(Input.KEY_J)){
                this.tuberia.destroy();
                //inventario.setMeter(true);
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
