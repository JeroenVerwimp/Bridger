package be.goofydev.bridger.velocity;

import be.goofydev.bridger.api.model.proxy.Proxy;
import be.goofydev.bridger.api.model.user.User;
import be.goofydev.bridger.common.plugin.BridgerPlugin;
import com.velocitypowered.api.proxy.Player;
import net.kyori.text.Component;

import java.util.UUID;

public class VelocityUser implements User {

    private final BridgerPlugin plugin;
    private final Player player;

    public VelocityUser(BridgerPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public UUID getUniqueId() {
        return this.player.getUniqueId();
    }

    @Override
    public String getUsername() {
        return this.player.getUsername();
    }

    @Override
    public String getIp() {
        return this.player.getRemoteAddress().toString();
    }

    @Override
    public Proxy getProxy() {
        return this.plugin.getCurrentProxy();
    }

    @Override
    public String getServer() {
        if (!this.player.getCurrentServer().isPresent()) {
            return null;
        }
        return this.player.getCurrentServer().get().getServerInfo().getName();
    }

    @Override
    public void sendMessage(Component message) {
        this.player.sendMessage(message);
    }
}
