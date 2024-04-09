package com.liarsdie.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LiarsDie extends Game {
	SpriteBatch batch;
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(); // using the default fonts once again
		this.setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {
		super.render(); // that simple... I guess ?

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
