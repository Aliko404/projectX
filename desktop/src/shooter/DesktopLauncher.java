package shooter;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import shooter.config.GameConfig;

public class DesktopLauncher {
    public static void main(String[] args) {
        GameConfig gameConfig = GameConfig.getInstance();
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("ProjectX");
        config.setWindowedMode(gameConfig.viewportWidth, gameConfig.viewportHeight);
        config.useVsync(true);
        new Lwjgl3Application(new ProjectX(), config);
    }
}
