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

	int gravity = 2;
	int accel = 30;
	int accelFall = 10;
	boolean jump = false;
	int ground = 0;
	Texture platform;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ju.png");
		platform = new Texture("pl.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, x, y, 70, 70);
		batch.draw(platform, 200, 100, 100, 20);
		batch.draw(platform, 500, 200, 100, 20);
		batch.draw(platform, 800, 300, 100, 20);

		batch.draw(platform, 1000, 300, 1000, 20);
		batch.draw(platform, 300, 0, 3000, 20);
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.D)) x+=15;
		if (Gdx.input.isKeyPressed(Input.Keys.A)) x-=15;
		if (y == ground) if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) jump = true;

		if (x >= 130 && x <= 300 && y >= 120) ground = 120;
		else if (x >= 430 && x <= 600 && y >= 220) ground = 220;
		else if (x >= 730 && x <= 900 && y >= 320) ground = 320;

		else if (x >= 930 && x <= 2000 && y >= 300 && y <= 325) {
			ground = 320;
			System.out.println("Win");
			x = 0;
			y = 0;
		}
		else if (x >= 230 && x <= 3300 && y >= 0 && y <= 20) {
			ground = 0;
			System.out.println("Dead");
			x = 0;
			y = 0;
		}
		else ground = 0;

		if (jump) {
			y += accel;
			accel -= gravity;
			if (accel < 0) {
				jump = false;
			}
		}
		if (y > ground && !jump) {
			y -= accelFall;
			accelFall += gravity;
		}
		if (y < ground) {
			y = ground;
		}
		if (y == ground) {
			accel = 30;
			accelFall = 10;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
