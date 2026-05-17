package shooter.facade;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import shooter.entity.Bullet;
import shooter.entity.Enemy;
import shooter.entity.EnemyBullet;
import shooter.entity.HealthPack;
import shooter.observer.ScoreManager;
import shooter.observer.UIManager;
import shooter.world.GameWorld;

public class GameFacade {
    private final GameWorld world;
    private final ScoreManager scoreManager;
    private final UIManager uiManager;

    public GameFacade() {
        world = new GameWorld();
        scoreManager = new ScoreManager();
        uiManager = new UIManager();

        world.addObserver(scoreManager);
        world.addObserver(uiManager);
    }

    public void update(float delta) {
        world.update(delta);
    }

    public void render(SpriteBatch batch) {
        world.getMap().render(batch);
        world.getPlayer().render(batch);

        for (Enemy enemy : world.getEnemies()) {
            enemy.render(batch);
        }

        for (Bullet bullet : world.getBulletPool().getBullets()) {
            bullet.render(batch);
        }

        for (EnemyBullet bullet : world.getEnemyBullets()) {
            bullet.render(batch);
        }

        for (HealthPack healthPack : world.getHealthPacks()) {
            healthPack.render(batch);
        }
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getHealth() {
        return uiManager.getCurrentHealth();
    }

    public boolean isGameOver() {
        return world.isGameOver();
    }

    public int getWave() {
        return world.getWave();
    }

    public void updateCamera(OrthographicCamera camera) {
        world.updateCamera(camera);
    }
}
