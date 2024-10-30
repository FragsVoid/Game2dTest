package org.frags;

import org.frags.handlers.KeyHandler;
import org.frags.entities.Player;
import org.frags.threads.GameThread;
import org.frags.tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    // SCREEN SETTINGS
    private final int originalTileSize = 16; //16 x 16 tile
    private final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16; // 16 columns max
    private final int maxScreenRow = 12; // 12 rows max

    public final int screenWidth = tileSize * maxScreenCol;  // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    private KeyHandler keyHandler = new KeyHandler();

    public Player player;

    public TileManager tileManager;

    private GameThread gameThread;

    private Thread thread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyHandler);

        this.setFocusable(true);

        tileManager = new TileManager(this);

        player = new Player(100, 100, 4, this, keyHandler);
        player.setDefaultValues();

        startGameThread();
    }

    public void startGameThread() {

        gameThread = new GameThread(this);

        thread = new Thread(gameThread);

        thread.start();
    }


    public void update() {
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        tileManager.draw(g2d);

        player.draw(g2d);

        g2d.drawString(String.valueOf(gameThread.fpsRunning), screenWidth - 25, 25);

        g2d.dispose();
    }


    public Thread getGameThread() {
        return thread;
    }


}
