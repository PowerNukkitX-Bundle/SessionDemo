package cn.powernukkitx.session;

import cn.nukkit.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Session {

    // Using a HashMap to Store Player Sessions
    private static final Map<Player, Session> data = new HashMap<>();

    public static Session get(Player player) {
        return data.computeIfAbsent(player, Session::loadSessionData);
    }

    private static Session loadSessionData(Player player) {
        // You could load data here, for example from a MySQL database or from a config file /from data folder
        // As an example, we'll just use a random number

        int randomId = new Random().nextInt(101); // Generates a random number between 0 and 100 inclusive
        return new Session(randomId);
    }

    private final int myRandomId;

    private Session(int myRandomId) {
        this.myRandomId = myRandomId;
    }

    public int getMyRandomId() {
        return myRandomId;
    }

}
