package shooter.observer;

public interface GameObserver {
    void onEnemyKilled();
    void onPlayerDamaged(int health);
}