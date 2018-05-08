package Slick2DTest;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pasillo extends BasicGameState{
    
    Animation character, moveLeft, moveRight,nomoveright,nomoveleft;
    boolean sideright=true;    
    private Image pasillo;
    int[] duration = {200,200,200,200};
    private Input entrada;
        float characterPositionX = 24,  characterPositionY = 406;
    BasicGameState prevState = Principal.prevState;



    @Override
    public int getID() {
       return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.pasillo = new Image("res/pasillo.jpg");
       
       Principal.prevState = this;
       Image[] walkRight = {new Image("res/B.ANIM_1.png"),new Image("res/B.ANIM_2.png"),new Image("res/B.ANIM_3.png"),new Image("res/B.ANIM_4.png")}; 
       Image[] walkLeft = {new Image("res/B.ANIM_1_OPUESTO.png"),new Image("res/B.ANIM_2_OPUESTO.png"),new Image("res/B.ANIM_3_OPUESTO.png"),new Image("res/B.ANIM_4_OPUESTO.png")};
       Image[] nowalkright = {new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png"),new Image("res/B.STANCE.png")};
       Image[] nowalkleft = {new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png"),new Image("res/B.STANCE_OPUESTO.png")};
        
       moveRight = new Animation(walkRight, duration, true);
       moveLeft = new Animation(walkLeft,duration,true);
       nomoveright = new Animation(nowalkright,duration,true);
       nomoveleft = new Animation(nowalkleft,duration,true);
       
       character = nomoveright;

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        this.pasillo.drawCentered(683,384);//fondo.drawCentered(683,384);//683 y 384
        this.character.draw(characterPositionX,characterPositionY);
        
        g.drawString("CharacterX: " +characterPositionX+" CharacterY:"+characterPositionY, 683, 384);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        entrada = gc.getInput();
        
        if ((characterPositionX > 1221)){
                Principal.prevState = this;
                sbg.enterState(8);
            }
        
        if ((characterPositionX < -67)){
                Principal.prevState = this;
                sbg.enterState(1);
            }
        
        if(entrada.isKeyDown(Input.KEY_I)){
            Principal.prevState2 = this;
            sbg.enterState(7);
        }
        
        if ((characterPositionX > 21 && characterPositionX < 158) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(4);
            }
        
        if ((characterPositionX > 561 && characterPositionX < 700) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(5);
            }
        
        if ((characterPositionX > 1087 && characterPositionX < 1221) && 
           (entrada.isKeyDown(Input.KEY_J))){
                Principal.prevState = this;
                sbg.enterState(6);
            }

        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& sideright){ 
            character = nomoveright;
            }
        
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)&& !sideright){
                character = nomoveleft;
            }
        
        if(entrada.isKeyDown(Input.KEY_D)){
            sideright = true;
            character = moveRight;
            characterPositionX += i * .10f;
        }
        
        if(entrada.isKeyDown(Input.KEY_A)){
            sideright = false;
            character = moveLeft;
            characterPositionX -= i * .10f;
        }
        
        if(entrada.isKeyDown(Input.KEY_ESCAPE)){
            Principal.prevState = this;
            sbg.enterState(3);
        }
               
}
        
    }
    

