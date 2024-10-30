package org.frags.entities;

import java.awt.image.BufferedImage;

public class Entity {

    public int x,y;
    public int speed;


    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, guardingUp, guardingDown, guardingLeft, guardingRight;
    public String direction;
    public int guardTime = 0;

    public int spriteCounter = 0;
    public int spriteNumber = 1;

    public boolean isGuarding;

    public Entity(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }


}
