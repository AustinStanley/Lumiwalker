package se.team11.lumiwalker.main;

import se.team11.lumiwalker.handlers.GameStateManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Lumiwalker extends ApplicationAdapter 
{
	public static final String TITLE = "Lumiwalker";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE = 2;
	public static final float STEP = 1 / 60f;
	
	private float accum;
	private SpriteBatch sb;
	private OrthographicCamera cam, hudCam;
	private GameStateManager gsm;
	Texture img;
	
	@Override
	public void create () 
	{
		sb = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		cam = new OrthographicCamera();
		hudCam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		gsm = new GameStateManager(this);
	}

	@Override
	public void render () 
	{
		/*
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		sb.draw(img, 0, 0);
		sb.end();
		*/
		
		accum += Gdx.graphics.getDeltaTime();
		while (accum >= STEP)
		{
			accum -= STEP;
			gsm.update(STEP);
			gsm.render();
		}
	}
	
	@Override
	public void dispose()
	{
		
	}
	
	public void pause()
	{
		
	}
	
	public void resume()
	{
		
	}
	
	public void resize(int width, int height)
	{
		
	}
	
	public SpriteBatch getSpriteBatch() { return sb; }
	public OrthographicCamera getCamera() { return cam; }
	public OrthographicCamera getHUDCamera() {return hudCam; }	
	
	}
