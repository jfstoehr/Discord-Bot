package jacob.Ellis;

import java.io.File;
import java.io.IOException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	
	public static JDA jda;
	public static int numServersOnline;
	
	public Commands(JDA j) {
		
		jda = j;
		
	}
	
	@SuppressWarnings("unused")
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split(" ");
			
		if (args[0].indexOf("boot") != -1 && args[1].indexOf("mc") != -1 && args[2].indexOf("1") != -1) {
			
			EmbedBuilder info = new EmbedBuilder();
			
			try {
				
				Process process = Runtime.getRuntime().exec("cmd /c server_mc_1.bat", null, new File("C:\\Users\\jacob\\Downloads\\"));
				
				info.setTitle("MC Server01 Status");
				info.setDescription("Online");
				info.setColor(0x33cc33);
				info.setFooter("Brought to you by witpolAI");
				
				numServersOnline++;
				jda.getPresence().setActivity(Activity.playing("Hosting " + numServersOnline + " Servers"));
				
			} catch (IOException e) {
				
				System.out.println("Error: " + e);
				
				info.setTitle("MC Server01 Status");
				info.setDescription("" + e);
				info.setColor(0xffff00);
				info.setFooter("Brought to you by witpolAI");
				
			}
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			
		} else if (args[0].indexOf("terminate") != -1 && args[1].indexOf("mc") != -1 && args[2].indexOf("1") != -1) {
			
			EmbedBuilder info = new EmbedBuilder();
			
			try {
				
				Process process = Runtime.getRuntime().exec("cmd /c for /f \"tokens=1\" %i in ('jps -m ^| find \"server.jar\"') do ( taskkill /F /PID %i )", null, new File("C:\\Users\\jacob\\Downloads\\"));
				
				info.setTitle("MC Server01 Status");
				info.setDescription("Offline");
				info.setColor(0xff0000);
				info.setFooter("Brought to you by witpolAI");
				
				numServersOnline--;
				jda.getPresence().setActivity(Activity.playing("Hosting " + numServersOnline + " Servers"));
				
			} catch (IOException e) {
				
				System.out.println("Error: " + e);
				
				info.setTitle("MC Server01 Status");
				info.setDescription("" + e);
				info.setColor(0xffff00);
				info.setFooter("Brought to you by witpolAI");
				
			}
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			
		}
		
	}

}