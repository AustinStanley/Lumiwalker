package se.team11.lumiwalker.states;

import se.team11.lumiwalker.handlers.GameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Play extends GameState
{
	private World world;
	private Box2DDebugRenderer b2dr;
	
	public Play(GameStateManager gsm)
	{
		super(gsm);
		world = new World(new Vector2(0, -9.81f), true);
		b2dr = new Box2DDebugRenderer();
	}

	@Override
	public void handleInput() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) 
	{
		// TODO Auto-generated method stub
		world.step(dt, 6, 2);
		
	}

	@Override
	public void render() 
	{
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// draw world
		b2dr.render(world, cam.combined);
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}
}
