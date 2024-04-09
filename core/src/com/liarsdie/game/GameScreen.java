package com.liarsdie.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
    final LiarsDie liarsDie;
    Texture pokerTableImage;
    Array<Texture> dieImages;
    /*
    Consider whether or not I want to add music or sound affects at this point
     */
    OrthographicCamera camera;
    Array<Rectangle> diceRoll;
    long lastRollTime;
    int rollTotal;
    int score;
    Rectangle pokerTable;
    Rectangle dieRollOne;
    Rectangle dieRollTwo;
    Array<Integer> rolls;
    Texture onePip;
    Texture twoPip;

    public GameScreen(final LiarsDie liarsDie1){
        liarsDie = liarsDie1;
        dieImages = new Array<>();
        // load the images for the die and the tables.
        for (int i = 1; i < 7; i ++ ){
            Texture dice = new Texture(Gdx.files.internal("die-"+ i +" (1).png"));
            dieImages.add(dice);
        }
        pokerTableImage = new Texture(Gdx.files.internal("poker-table.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 920, 400);

        //create a rectangle to logically represent the poker table
        pokerTable = new Rectangle();
        pokerTable.x = 0; // might need more work to center the table horizontally
        pokerTable.y = 22.5F; // also might need more work, it might make more sense to try and rep the poker table as something else
        pokerTable.width = 920;
        pokerTable.height = 400;
        onePip = new Texture(Gdx.files.internal("die-1 (1).png"));
        twoPip = new Texture (Gdx.files.internal("die-2 (1).png"));
        dieRollOne = new Rectangle();
        dieRollTwo = new Rectangle();
        dieRollOne.width = 64;
        dieRollOne.height = 64;
        dieRollOne.x = 100;
        dieRollOne.y = 100;
        dieRollTwo.width = 64;
        dieRollTwo.height = 64;
        dieRollTwo.x = 200;
        dieRollTwo.y = 200;
        rolls = new Array<>();





    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0.1f, 0.3f, 0.2f,0.5f);
        camera.update(); // so up until this line, I can successfully switch between the mm screen and the game screen

        liarsDie.batch.setProjectionMatrix(camera.combined);

        //begin new batch and draw at least the poker table while I figure it out

        liarsDie.batch.begin();
        liarsDie.batch.draw(pokerTableImage, pokerTable.x, pokerTable.y);
        System.out.println("Poker Table drawn");
        liarsDie.font.draw(liarsDie.batch, "Click Anywhere to Roll", 800/2, 390);

        if (Gdx.input.isTouched()){

            liarsDie.batch.draw(onePip, dieRollOne.x, dieRollOne.y);
            liarsDie.batch.draw(twoPip, dieRollTwo.x, dieRollTwo.y);






        }

        liarsDie.batch.end();

    }
    @Override
    public void show() {

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
        pokerTableImage.dispose();
        onePip.dispose();
        twoPip.dispose();

    }
}
