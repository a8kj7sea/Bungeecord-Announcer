package me.sanhak.test.main;

import java.io.*;
import java.nio.file.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.config.*;


public class Main extends Plugin 
{
	
	public static Configuration cg;
	static Main instance;
	public static Main getInstance() {return instance;}
	   
	   @Override
	   public void onEnable() {
	      instance = this;
	      this.createFiles();
	      registerConfig();
	      Announcer.Run();	 	    
	      getLogger().severe("[Announcer] plugin has been Enabled");
	      getLogger().severe("[Announcer] plugin by Sanhak");
	      getLogger().severe("[Announcer] github.com/hacked34354tf");
	   }

	   @Override
	public void onDisable() {
		   getLogger().severe("[Announcer] plugin has been Disabled");
		   getLogger().severe("[Announcer] plugin by Sanhak");
		   getLogger().severe("[Announcer] github.com/hacked34354tf");
	  }
	   
	   public void createFiles() {
		      if (!this.getDataFolder().exists()) {
		         this.getDataFolder().mkdir();
		      }

		      File file = new File(this.getDataFolder(), "config.yml");
		      if (!file.exists()) {
		         try {
		            InputStream in = this.getResourceAsStream("config.yml");
		            Files.copy(in, file.toPath(), new CopyOption[0]);
		         } catch (IOException var3) {
		            var3.printStackTrace();
		         }
		      }

		   }

		   public static void registerConfig() {
		      try {
		         cg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(instance.getDataFolder(), "config.yml"));
		      } catch (IOException var1) {
		         var1.printStackTrace();
		      }

		   }
  
}