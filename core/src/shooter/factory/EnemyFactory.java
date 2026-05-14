package shooter.factory;

import shooter.entity.Enemy;

public abstract class EnemyFactory {
    public abstract Enemy createEnemy(float x, float y);
}