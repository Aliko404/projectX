package shooter.config;

public class GameConfig {
    private static GameConfig instance;

    public final int viewportWidth = 1280;
    public final int viewportHeight = 720;
    public final int tileSize = 64;
    public final int mapTilesWide = 48;
    public final int mapTilesHigh = 32;
    public final int worldWidth = mapTilesWide * tileSize;
    public final int worldHeight = mapTilesHigh * tileSize;
    public final float playerSpeed = 260f;
    public final float bulletSpeed = 640f;
    public final float enemyBulletSpeed = 300f;

    private GameConfig() {}

    public static GameConfig getInstance() {
        if (instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }
}
