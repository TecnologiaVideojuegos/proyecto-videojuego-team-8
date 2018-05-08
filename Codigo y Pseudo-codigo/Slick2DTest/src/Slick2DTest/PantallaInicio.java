/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slick2DTest;

import org.newdawn.slick.geom.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Alvaro
 */
public class PantallaInicio extends BasicGameState{

    private Rectangle rect1 , rect2;
    private Image fondo;
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       fondo = new Image("res/Umbral.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        fondo.drawCentered(683,384);//683 y 384
        g.setColor(Color.white);
        g.fillRect(683,334,37,20);
        g.fillRect(683,434,37,20);
        g.setColor(Color.black);
        g.drawString("Play", 683, 334);
        g.drawString("Exit", 683, 434);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        System.out.println("X:"+posX+" Y:"+posY);
        
        //play button
        if ((posX > 683 && posX < 995) && (posY > 334 && posY < 585)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(1);
            }
        }
        //exit button
        if ((posX > 683 && posX < 998) && (posY > 434 && posY < 487)){
            if(Mouse.isButtonDown(0)){
            System.exit(0);
            }
        }
    }
}
