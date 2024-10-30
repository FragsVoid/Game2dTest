package org.frags.entities;

import org.frags.GamePanel;
import org.frags.handlers.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    private GamePanel gamePanel;
    private KeyHandler keyHandler;

    public Player(int x, int y, int speed, GamePanel gamePanel, KeyHandler keyHandler) {
        super(x, y, speed);
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/walking/boy_right_2.png"));

            guardingDown = ImageIO.read(getClass().getResourceAsStream("/sprites/player/guarding/boy_guard_down.png"));
            guardingLeft = ImageIO.read(getClass().getResourceAsStream("/sprites/player/guarding/boy_guard_left.png"));
            guardingRight = ImageIO.read(getClass().getResourceAsStream("/sprites/player/guarding/boy_guard_right.png"));
            guardingUp = ImageIO.read(getClass().getResourceAsStream("/sprites/player/guarding/boy_guard_up.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.rightPressed || keyHandler.leftPressed || keyHandler.downPressed || keyHandler.upPressed) {
            spriteCounter++;
            guardTime = 0;
            int necessaryFrames;
            isGuarding = false;
            if (keyHandler.sprintPressed) {
                necessaryFrames = 10;
            } else {
                necessaryFrames = 14;
            }
            if (spriteCounter > necessaryFrames) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
            if (keyHandler.upPressed) {
                this.moveUp();
                direction = "up";
                if (keyHandler.sprintPressed) {
                    this.moveUp();
                }
            } else if (keyHandler.downPressed) {
                this.moveDown();
                direction = "down";
                if (keyHandler.sprintPressed) {
                    this.moveDown();
                }
            } else if (keyHandler.leftPressed) {
                this.moveLeft();
                direction = "left";
                if (keyHandler.sprintPressed) {
                    this.moveLeft();
                }
            } else if (keyHandler.rightPressed) {
                this.moveRight();
                direction = "right";
                if (keyHandler.sprintPressed) {
                    this.moveRight();
                }
            }
        } else {
            guardTime++;
            if (guardTime > 10) {
                isGuarding = true;
            }
        }

    }

    public void draw(Graphics2D g) {
//        g.setColor(Color.white);
//        g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (isGuarding) {
                    image = guardingUp;
                    break;
                }
                if (spriteNumber == 1) {
                    image = up1;
                } else {
                    image = up2;
                }
                break;
            case "down":
                if (isGuarding) {
                    image = guardingDown;
                    break;
                }
                if (spriteNumber == 1) {
                    image = down1;
                } else {
                    image = down2;
                }
                break;
            case "left":
                if (isGuarding) {
                    image = guardingLeft;
                    break;
                }
                if (spriteNumber == 1) {
                    image = left1;
                } else {
                    image = left2;
                }
                break;
            case "right":
                if (isGuarding) {
                    image = guardingRight;
                    break;
                }
                if (spriteNumber == 1) {
                    image = right1;
                } else {
                    image = right2;
                }
                break;
        }

        g.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
