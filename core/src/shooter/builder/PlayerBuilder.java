package shooter.builder;

import com.badlogic.gdx.graphics.Texture;
import shooter.entity.Player;

public class PlayerBuilder {
    private float x = 100;
    private float y = 100;
    private float width = 48;
    private float height = 48;
    private float speed = 220;
    private int health = 100;
    private Texture texture;

    public PlayerBuilder setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public PlayerBuilder setSize(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public PlayerBuilder setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public PlayerBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public PlayerBuilder setTexture(Texture texture) {
        this.texture = texture;
        return this;
    }

    public Player build() {
        return new Player(x, y, width, height, texture, speed, health);
    }
}