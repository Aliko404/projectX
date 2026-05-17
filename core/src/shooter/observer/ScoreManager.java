package shooter.observer;

public class ScoreManager implements GameObserver {
    private int score = 0;

    @Override
    public void onEnemyKilled() {
        score += 10;
    }

    @Override
    public void onPlayerDamaged(int health) {
    }

    public int getScore() {
        return score;
    }
}