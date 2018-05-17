package Slick2DTest;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MinijuegoLlave extends BasicGameState{


    Animation character, moveLeft, moveRight,nomove;
    private ArrayList<Circle> balls;
    private Circle mouseBall;
    private Rectangle boxpersonaje;
    private int timePassed;
    private Random random;
    private Image habitacion;
    private Input entrada;
    private float posicionX=1005, posicionY=560;
    private int posX=1005,posY= 560;
    int[] duration = {200,200,200,200,200,200,200};
        
    public void init(GameContainer arg0, StateBasedGame arg1) {
        try {
            habitacion = new Image("res/habitacion1bis.jpg");
            balls = new ArrayList<Circle>();
            mouseBall = new Circle(0,0,30);
            timePassed = 0;
            random = new Random();
            boxpersonaje = new Rectangle(posX,posY,38,102);
            
            Image[] walkRight = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_2_MINIGAME.png"),new Image("res/A.ANIM_3_MINIGAME.png"),new Image("res/A.ANIM_4_MINIGAME.png"),new Image("res/A.ANIM_5_MINIGAME.png"),new Image("res/A.ANIM_6_MINIGAME.png"),new Image("res/A.ANIM_7_MINIGAME.png")};
            Image[] walkLeft = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_2_MINIGAME.png"),new Image("res/A.ANIM_3_MINIGAME.png"),new Image("res/A.ANIM_4_MINIGAME.png"),new Image("res/A.ANIM_5_MINIGAME.png"),new Image("res/A.ANIM_6_MINIGAME.png"),new Image("res/A.ANIM_7_MINIGAME.png")};
            Image[] nowalk = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png")};
            
            moveRight = new Animation(walkRight, duration, true);
            moveLeft = new Animation(walkLeft,duration,true);
            nomove = new Animation(nowalk,duration,true);
            character = nomove;
        } catch (SlickException ex) {
            Logger.getLogger(MinijuegoLlave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(GameContainer container, StateBasedGame sbg, int delta){
        
        System.out.println("X: "+posX+ "Y: "+ posY);
        entrada = container.getInput();
        
        if (entrada.isKeyDown(Input.KEY_D)) {
            character = moveRight;
            posicionX += delta * .5f;
            boxpersonaje.setX(posicionX);
            if(posicionX>1005){
                posicionX -= delta * .5f;
                boxpersonaje.setX(posicionX);
            }
        }
        if (entrada.isKeyDown(Input.KEY_A)) {
            character = moveLeft;
            posicionX -= delta * .5f;
            boxpersonaje.setX(posicionX);
            if(posicionX<250){
                posicionX += delta * .5f;
                boxpersonaje.setX(posicionX);
            }
        }
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)){
            character = nomove;
        }
        
        timePassed += delta;
        if (timePassed > 500) {
            timePassed = 0;
            balls.add(new Circle(280+random.nextInt(755),84,10));
        }
        for (Circle c : balls) {
            c.setCenterY(c.getCenterY()+(delta/4f));
        }
        for (int i = balls.size()-1; i >= 0; i--) {
            Circle c = balls.get(i);
            if (c.getCenterY() > 700) {
                balls.remove(i);
                Principal.vidasMinijuegoLlave--;
            }else if (c.intersects(boxpersonaje)) {
                balls.remove(i);
                Principal.puntuacionMinijuegoLlave++;
            }
        }
        if (Principal.vidasMinijuegoLlave <= 0) {
            sbg.enterState(10);
             for (int i = balls.size()-1; i >= 0; i--) {
            Circle c = balls.get(i);
            if (c.getCenterY() > 84) {
                balls.remove(i);
                
            }
        }
         if (Principal.puntuacionMinijuegoLlave >= 20) {
            sbg.enterState(11);
        }
        }
    }
    
    @Override
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){
        this.habitacion.drawCentered(683,384);
        g.drawString(" "+posicionX +" "+posicionY,100,100);
        g.drawString("Estado 1", 10, 50);
        g.setColor(Color.yellow);
        g.fill(boxpersonaje);
        this.character.draw(posicionX,posicionY);
        
        g.setColor(Color.red);
        for(Circle c : balls) {
            g.fill(c);            
        }
        g.drawString ("Vidas: " + Principal.vidasMinijuegoLlave, 10, 100);
        g.drawString ("Puntuacion: " + Principal.puntuacionMinijuegoLlave, 10, 120);

    }
    
    
    public int getID() {
        return 9;
    }    
    
}
