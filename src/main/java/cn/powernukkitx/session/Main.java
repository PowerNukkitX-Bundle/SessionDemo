package cn.powernukkitx.session;

import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Get the session for the player
        Session session = Session.get(player);
        // Get the random ID from the session
        int myRandomId = session.getMyRandomId();
        // Send the player a message with their random ID
        player.sendMessage("Your random ID is " + myRandomId);
    }

    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        // Remove the session for the player
        // Don't forget to create a function in your Session class to save everything with a function this will avoid data loss
    }

    public void onDisable() {
        //Don't forget to save the session data if the server crashes randomly
    }

}