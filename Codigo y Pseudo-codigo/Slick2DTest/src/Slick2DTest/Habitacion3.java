package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Habitacion3 extends BasicGameState {

    Animation character, moveLeft, moveRight,nomove;
    private Image habitacion;
    int[] duration = {200,200,200,200};
    private Input entrada;
    float characterPositionX = 250,  characterPositionY = 406;
    BasicGameState prevState = Principal.prevState;
    
    
    @Override
    public int getID() {
        return 6;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.habitacion = new Image("res/habitacion1bis.jpg");
       
       Image[] walkRight = {new Image("res/personaje2.png"),new Image("res/personaje3.png"),new Image("res/personaje4.png"),new Image("res/personaje5.png")}; 
       Image[] walkLeft = {new Image("res/personaje2.png"),new Image("res/personaje3.png"),new Image("res/personaje4.png"),new Image("res/personaje5.png")};
       Image[] nowalk = {new Image("res/personaje1.png"),new Image("res/personaje1.png"),new Image("res/personaje1.png"),new Image("res/personaje1.png")};
        
       moveRight = new Animation(walkRight, duration, true);
       moveLeft = new Animation(walkLeft,duration,true);
       nomove = new Animation(nowalk,duration,true);

       character = nomove;
       
       Principal.prevState = this;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        this.habitacion.drawCentered(683,384);
        this.character.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 683, 384);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
         entrada = gc.getInput();
        
        //Building 1 entrance
        if (characterPositionX < 211){
           {
                sbg.enterState(2);
                characterPositionX = 250;
            }
        }
        
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)){
                character = nomove;
            }
        
        if(entrada.isKeyDown(Input.KEY_I)){
            Principal.prevState2 = this;
            sbg.enterState(7);
        }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            character = moveRight;
            characterPositionX += i * .1f;
            if (characterPositionX > 939){
                    characterPositionX -= i *.10f;
            }
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            character = moveLeft;
            characterPositionX -= i * .1f;
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
    }
    
}