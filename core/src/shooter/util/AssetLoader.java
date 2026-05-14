package shooter.util;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class AssetLoader {
    private static AssetLoader instance;

    private final Texture playerTexture;
    private final Texture enemyTexture;
    private final Texture bulletTexture;
    private final Texture fastEnemyTexture;
    private final Texture tankEnemyTexture;
    private final Texture floorTexture;
    private final Texture wallTexture;
    private final Texture healthPackTexture;

    private AssetLoader() {
        playerTexture = new Texture("player.png");
        enemyTexture = new Texture("enemy.png");
        bulletTexture = new Texture("bullet.png");
        fastEnemyTexture = new Texture("fast_enemy.png");
        tankEnemyTexture = new Texture("tank_enemy.png");

        floorTexture = createFloorTexture();
        wallTexture = createWallTexture();
        healthPackTexture = new Texture("health_pack.png");
    }

    public static AssetLoader getInstance() {
        if (instance == null) {
            instance = new AssetLoader();
        }
        return instance;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public Texture getEnemyTexture() {
        return enemyTexture;
    }

    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Texture getFastEnemyTexture() {
        return fastEnemyTexture;
    }

    public Texture getTankEnemyTexture() {
        return tankEnemyTexture;
    }

    public Texture getFloorTexture() {
        return floorTexture;
    }

    public Texture getWallTexture() {
        return wallTexture;
    }

    public Texture getHealthPackTexture() {
        return healthPackTexture;
    }

    private Texture createFloorTexture() {
        Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
        pixmap.setColor(0.18f, 0.2f, 0.21f, 1f);
        pixmap.fill();
        pixmap.setColor(0.13f, 0.15f, 0.16f, 1f);

        for (int i = 0; i < 64; i += 16) {
            pixmap.drawLine(i, 0, i, 63);
            pixmap.drawLine(0, i, 63, i);
        }

        pixmap.setColor(0.22f, 0.24f, 0.25f, 1f);
        pixmap.drawRectangle(3, 3, 58, 58);

        Texture texture = new Texture(pixmap);
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        pixmap.dispose();
        return texture;
    }

    private Texture createWallTexture() {
        Pixmap pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
        pixmap.setColor(0.34f, 0.36f, 0.37f, 1f);
        pixmap.fill();
        pixmap.setColor(0.2f, 0.22f, 0.23f, 1f);

        for (int y = 0; y < 64; y += 16) {
            pixmap.drawLine(0, y, 63, y);
        }

        for (int y = 0; y < 64; y += 32) {
            pixmap.drawLine(32, y, 32, y + 16);
            pixmap.drawLine(0, y + 16, 0, Math.min(63, y + 32));
        }

        pixmap.setColor(0.44f, 0.46f, 0.47f, 1f);
        pixmap.drawRectangle(1, 1, 62, 62);

        Texture texture = new Texture(pixmap);
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        pixmap.dispose();
        return texture;
    }

    public void dispose() {
        playerTexture.dispose();
        enemyTexture.dispose();
        bulletTexture.dispose();
        fastEnemyTexture.dispose();
        tankEnemyTexture.dispose();
        floorTexture.dispose();
        wallTexture.dispose();
        healthPackTexture.dispose();
    }
}
