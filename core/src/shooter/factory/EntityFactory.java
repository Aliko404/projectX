package shooter.factory;

import shooter.entity.Enemy;
import shooter.entity.Player;

public interface EntityFactory {
    Player createPlayer();
    Enemy createBasicEnemy(float x, float y);
}