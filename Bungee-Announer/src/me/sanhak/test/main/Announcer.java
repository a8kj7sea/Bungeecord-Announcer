package me.sanhak.test.main;

import java.util.*;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;



public class Announcer
{//Start
	
	public static Announcer obj = new Announcer();		
	
	public static List<String> List(){
		List<String> Zker = Main.cg.getStringList("Announcements.List");
		return Zker;		
	}
	
	public static String color(String msg) {
	      return ChatColor.translateAlternateColorCodes('&', msg);
	   }
		
    public String getRandomList(List<String> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
   		
	public static void Run() {
		Timer timer = new Timer();
		int Time = Main.cg.getInt("Announcements.Time");				
		timer.schedule( new TimerTask() {
		    @SuppressWarnings("deprecation")
			public void run() {
		    	Iterator<ProxiedPlayer> var5 = ProxyServer.getInstance().getPlayers().iterator();
		        while(var5.hasNext()) {
		           ProxiedPlayer on = (ProxiedPlayer)var5.next();;
		           on.sendMessage(color(obj.getRandomList(List())));;
		        }
		    }
		 }, 0, Time*1000);
	}
	
	

	
	
}//End
