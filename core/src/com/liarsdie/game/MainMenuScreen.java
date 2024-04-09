package com.liarsdie.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    final LiarsDie liarsDie;
    OrthographicCamera camera;

    public MainMenuScreen(LiarsDie liarDie){
        liarsDie = liarDie;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 920, 400); // have not loaded in the poker table yet

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.2f, 0.4f, 0.2f, 0.5f); // bg color, should be kind of like a pale green
        camera.update();
        liarsDie.batch.setProjectionMatrix(camera.combined);

        liarsDie.batch.begin();
        liarsDie.font.draw(liarsDie.batch, "Welcome to the Grady Casino", 200,200);
        liarsDie.font.draw(liarsDie.batch, "Tap Anywhere to begin!", 200,150);
        liarsDie.batch.end();

        if (Gdx.input.isTouched()){
            liarsDie.setScreen(new GameScreen(liarsDie));
            dispose();
        }


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
