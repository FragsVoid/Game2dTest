package org.frags.threads;

import org.frags.GamePanel;

import java.time.Duration;

public class GameThread implements Runnable {

    private GamePanel gamePanel;
    private final long FPS = 60L;

    public int fpsRunning;

    public GameThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {

        long drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gamePanel.getGameThread() != null) {
            currentTime = System.nanoTime();

            delta += (double) (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                gamePanel.update();
                gamePanel.repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                fpsRunning = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }


}
