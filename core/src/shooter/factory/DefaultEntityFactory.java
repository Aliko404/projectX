package shooter.factory;

import shooter.builder.PlayerBuilder;
import shooter.config.GameConfig;
import shooter.entity.Enemy;
import shooter.entity.Player;
import shooter.util.AssetLoader;

public class DefaultEntityFactory implements EntityFactory {
    @Override
    public Player createPlayer() {
        return new PlayerBuilder()
                .setPosition(100, 300)
                .setSize(48, 48)
                .setSpeed(GameConfig.getInstance().playerSpeed)
                .setHealth(100)
                .setTexture(AssetLoader.getInstance().getPlayerTexture())
                .build();
    }

    @Override
    public Enemy createBasicEnemy(float x, float y) {
        Enemy enemy = new Enemy(
                x, y,
                48, 48,
                AssetLoader.getInstance().getEnemyTexture(),
                85f,
                60
        );

        enemy.setCollisionDamage(10);
        enemy.setCanShoot(true);

        return enemy;
    }
}
