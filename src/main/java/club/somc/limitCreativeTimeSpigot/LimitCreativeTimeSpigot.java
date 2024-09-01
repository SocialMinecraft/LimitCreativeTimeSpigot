package club.somc.limitCreativeTimeSpigot;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public final class LimitCreativeTimeSpigot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            player.sendTitle(
                    ChatColor.GREEN + "Creative Entered",
                    "", 1, 20, 1);
            BukkitScheduler scheduler = getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                @Override
                public void run() {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 5*20, 1));
                    player.sendTitle(
                            ChatColor.GREEN + "Creative Exited",
                            "", 1, 20, 1);
                    player.setGameMode(GameMode.SURVIVAL);
                }
            }, 30 * 20L);
        }
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        if (event.getNewGameMode() == GameMode.CREATIVE) {
            player.sendTitle(
                    ChatColor.GREEN + "Creative Entered",
                    "", 1, 20, 1);
            BukkitScheduler scheduler = getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                @Override
                public void run() {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 5*20, 1));
                    player.sendTitle(
                            ChatColor.GREEN + "Creative Exited",
                            "", 1, 20, 1);
                    player.setGameMode(GameMode.SURVIVAL);
                }
            }, 30 * 20L);
        }
    }
}
