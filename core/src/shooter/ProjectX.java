package shooter;

import com.badlogic.gdx.Game;
import shooter.screen.GameScreen;

public class ProjectX extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}