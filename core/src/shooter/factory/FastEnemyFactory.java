package shooter.factory;

import shooter.entity.Enemy;
import shooter.util.AssetLoader;

public class FastEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy(float x, float y) {
        Enemy enemy = new Enemy(
                x, y,
                40, 40,
                AssetLoader.getInstance().getFastEnemyTexture(),
                140f,
                40
        );

        enemy.setZigZag(true);
        enemy.setCollisionDamage(20);
        enemy.setCanShoot(false);

        return enemy;
    }
}