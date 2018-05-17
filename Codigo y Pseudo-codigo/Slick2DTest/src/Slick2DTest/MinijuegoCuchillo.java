package Slick2DTest;

import java.util.ArrayList;
import java.util.Random;
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

public class MinijuegoCuchillo extends BasicGameState{

    Image habitacion;
    Animation character, moveLeft, moveRight,nomove;
    private ArrayList<Circle> balls;
    private Circle mouseBall;
    private Rectangle boxpersonaje;
    private int timePassed;
    private Random random;
    private Image personaje;
    private Input entrada;
    private float posicionX=1060, posicionY=560;
    private int posX=1060,posY= 560;
    int[] duration = {200,200,200,200,200,200,200};
    
    
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {
        //personaje1 = new Image("respuzzles/0.png");
        habitacion = new Image("res/habitacion1bis.jpg");
        balls = new ArrayList<Circle>();
        mouseBall = new Circle(0,0,30);
        timePassed = 0;
        random = new Random();
        personaje = new Image("res/A.ANIM_1_MINIGAME.png");
        boxpersonaje = new Rectangle(posX,posY,38,102);
       
        Image[] walkRight = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_2_MINIGAME.png"),new Image("res/A.ANIM_3_MINIGAME.png"),new Image("res/A.ANIM_4_MINIGAME.png"),new Image("res/A.ANIM_5_MINIGAME.png"),new Image("res/A.ANIM_6_MINIGAME.png"),new Image("res/A.ANIM_7_MINIGAME.png")}; 
        Image[] walkLeft = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_2_MINIGAME.png"),new Image("res/A.ANIM_3_MINIGAME.png"),new Image("res/A.ANIM_4_MINIGAME.png"),new Image("res/A.ANIM_5_MINIGAME.png"),new Image("res/A.ANIM_6_MINIGAME.png"),new Image("res/A.ANIM_7_MINIGAME.png")}; 
        Image[] nowalk = {new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png"),new Image("res/A.ANIM_1_MINIGAME.png")}; 
    
        moveRight = new Animation(walkRight, duration, true);
        moveLeft = new Animation(walkLeft,duration,true);
        nomove = new Animation(nowalk,duration,true);
        character = nomove;
    }
    
    public void update(GameContainer container, StateBasedGame sbg, int delta)
            throws SlickException {
        
        System.out.println("X: "+posX+ "Y: "+ posY);
        entrada = container.getInput();
        
        if (entrada.isKeyDown(Input.KEY_D)) {
            character = moveRight;
            posicionX += delta * .5f;
            boxpersonaje.setX(posicionX);
            if (posicionX>1038){
                posicionX -= delta * .5f;
                boxpersonaje.setX(posicionX);
            }
        }
        if (entrada.isKeyDown(Input.KEY_A)) {
            character = moveLeft;
            posicionX -= delta * .5f;
            boxpersonaje.setX(posicionX);
            if (posicionX<298){
                posicionX += delta * .5f;
                boxpersonaje.setX(posicionX);
            }
        }
        if (entrada.isKeyDown(Input.KEY_S)) {
            character = moveRight;
            posicionY += delta * .5f;
            boxpersonaje.setY(posicionY);
            if (posicionY>563){
                posicionY -= delta * .5f;
                boxpersonaje.setY(posicionY);
            }
        }
        if (entrada.isKeyDown(Input.KEY_W)) {
            character = moveLeft;
            posicionY -= delta * .5f;
            boxpersonaje.setY(posicionY);
            if (posicionY<86){
                posicionY += delta * .5f;
                boxpersonaje.setY(posicionY);
            }
            
        }
        if (!entrada.isKeyDown(Input.KEY_D) && !entrada.isKeyDown(Input.KEY_A)){
            character = nomove;
        }
        
        timePassed += delta;
        if (timePassed > 500) {
            timePassed = 0;
            balls.add(new Circle(280,90+random.nextInt(590),10));
        }
        for (Circle c : balls) {
            c.setCenterX(c.getCenterX()+(delta/3f));
        }
        for (int i = balls.size()-1; i >= 0; i--) {
            Circle c = balls.get(i);
            if (c.getCenterX() > 1070) {
                balls.remove(i);
            }else if (c.intersects(boxpersonaje)) {
                balls.remove(i);
                Principal.vidasMinijuegoCuchillo--;
            }
        }
        //Aqui serÃ­a la condicion para cambiar de stage
        if(posicionX<300 && posicionY>555){
            sbg.enterState(66);
        }
        
        if (Principal.vidasMinijuegoCuchillo <= 0) {
            sbg.enterState(65);
            posicionX = 1060;
            posicionY = 560;
        }
        
        
    }
    
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
            throws SlickException {
        habitacion.drawCentered(683,384);
        g.drawString(" "+posicionX +" "+posicionY,100,100);
        g.drawString("Estado 1", 10, 50);
        g.setColor(Color.transparent);
        g.fill(boxpersonaje);
        this.character.draw(posicionX,posicionY);
        
        g.setColor(Color.white);
        for(Circle c : balls) {
            g.fill(c);            
        }
        g.drawString ("Vidas: " + Principal.vidasMinijuegoCuchillo, 10, 100);
    }
    
    
    public int getID() {
        return 64;
    }    
    
}

