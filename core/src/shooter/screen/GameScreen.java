package shooter.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import shooter.config.GameConfig;
import shooter.facade.GameFacade;
import shooter.util.AssetLoader;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private BitmapFont font;
    private GameFacade gameFacade;
    private OrthographicCamera worldCamera;
    private OrthographicCamera hudCamera;
    private final GameConfig config = GameConfig.getInstance();

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        gameFacade = new GameFacade();
        worldCamera = new OrthographicCamera();
        hudCamera = new OrthographicCamera();
        resize(config.viewportWidth, config.viewportHeight);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if (gameFacade.isGameOver() && Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            gameFacade = new GameFacade();
        }

        gameFacade.update(delta);

        Gdx.gl.glClearColor(0.1f, 0.1f, 0.12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameFacade.updateCamera(worldCamera);
        batch.setProjectionMatrix(worldCamera.combined);
        batch.begin();
        gameFacade.render(batch);
        batch.end();

        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        float hudTop = hudCamera.viewportHeight - 20f;
        font.draw(batch, "Health: " + gameFacade.getHealth(), 20, hudTop);
        font.draw(batch, "Score: " + gameFacade.getScore(), 20, hudTop - 30);
        font.draw(batch, "Wave: " + gameFacade.getWave(), 20, hudTop - 60);
        font.draw(batch, "SPACE - Shoot", 20, hudTop - 90);
        font.draw(batch, "ESC - Exit", 20, hudTop - 120);

        if (gameFacade.isGameOver()) {
            float centerX = hudCamera.viewportWidth * 0.5f;
            float centerY = hudCamera.viewportHeight * 0.5f;
            font.draw(batch, "GAME OVER", centerX - 45, centerY + 30);
            font.draw(batch, "Final Score: " + gameFacade.getScore(), centerX - 55, centerY);
            font.draw(batch, "Press R to Restart", centerX - 70, centerY - 30);
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        if (worldCamera != null) {
            worldCamera.setToOrtho(false, width, height);
        }

        if (hudCamera != null) {
            hudCamera.setToOrtho(false, width, height);
        }
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        AssetLoader.getInstance().dispose();
    }
}
