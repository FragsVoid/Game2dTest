package org.frags.tiles;

import org.frags.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {

        try {

            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tiles/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tiles/wall.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tiles/water.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {

        g.drawImage(tiles[0].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g.drawImage(tiles[1].image, 48, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g.drawImage(tiles[2].image, 96, 0, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
