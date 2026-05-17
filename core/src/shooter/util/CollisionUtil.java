package shooter.util;

import shooter.entity.GameObject;

public class CollisionUtil {
    public static boolean isColliding(GameObject a, GameObject b) {
        return a.getBounds().overlaps(b.getBounds());
    }
}