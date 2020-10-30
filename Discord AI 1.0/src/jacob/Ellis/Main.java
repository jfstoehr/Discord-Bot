package jacob.Ellis;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	
	public static JDA jda;
	public static String prefix = "ssh";
	
	public static int numServersOnline;
	
	public static void main (String[] args) throws LoginException {
		
		jda = new JDABuilder(AccountType.BOT).setToken("NjMyOTc4MDQyNzE2ODE1Mzc1.Xk3pkA.j5Ju5e547PqnZvrrjoIL2fmRXHw").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.playing("Hosting " + numServersOnline + " Servers"));
		
		jda.addEventListener(new Commands(jda));
		
	}

}

