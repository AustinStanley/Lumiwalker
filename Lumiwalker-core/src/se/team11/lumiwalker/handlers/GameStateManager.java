package se.team11.lumiwalker.handlers;

import java.util.Stack;

import se.team11.lumiwalker.main.Lumiwalker;
import se.team11.lumiwalker.states.GameState;
import se.team11.lumiwalker.states.Play;

public class GameStateManager 
{
	public static final int PLAY = 0;
	
	private Lumiwalker game;
	private Stack<GameState> gameStates;
	
	public GameStateManager(Lumiwalker game)
	{
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	public Lumiwalker game() { return game; }
	
	public void update(float dt)
	{
		gameStates.peek().update(dt);
	}
	
	public void render()
	{
		gameStates.peek().render();
	}
	
	private GameState getState(int state)
	{
		if (state == PLAY) return new Play(this);
		return null;
	}
	
	public void setState(int state)
	{
		popState();
		pushState(state);
	}
	
	public void pushState(int state)
	{
		gameStates.push(getState(state));
	}
	
	public void popState()
	{
		GameState g = gameStates.pop();
		g.dispose();
	}
}
