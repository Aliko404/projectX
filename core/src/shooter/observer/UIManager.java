package shooter.observer;

public class UIManager implements GameObserver {
    private int currentHealth = 100;

    @Override
    public void onEnemyKilled() {
    }

    @Override
    public void onPlayerDamaged(int health) {
        currentHealth = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
}