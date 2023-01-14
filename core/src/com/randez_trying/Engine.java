package com.randez_trying;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Engine extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	int x = 0;
	int y = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.W)) y+=10;
		if (Gdx.input.isKeyPressed(Input.Keys.S)) y-=10;
		if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=10;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=10;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
