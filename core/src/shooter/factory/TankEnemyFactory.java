package shooter.factory;

import shooter.entity.Enemy;
import shooter.util.AssetLoader;

public class TankEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy(float x, float y) {
        Enemy enemy = new Enemy(
                x, y,
                64, 64,
                AssetLoader.getInstance().getTankEnemyTexture(),
                55f,
                120
        );

        enemy.setCollisionDamage(30);
        enemy.setCanShoot(false);

        return enemy;
    }
}