package bot;


import java.util.regex.Pattern;

public abstract class HandlerConversor {

	protected HandlerConversor nextHandler;
	protected Pattern patron;
	
	public void setNextAction(HandlerConversor nextHandler){
	      this.nextHandler = nextHandler;
	}
	
	public abstract String giveAnswer(String mensaje, String nombreUsuario);
}