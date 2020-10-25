package neptune.commands.UtilityCommands;

import neptune.commands.CommandInterface;
import neptune.commands.commandCategories;
import neptune.storage.Guild.guildObject;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.lang.management.ManagementFactory;

public class Uptime implements CommandInterface {
    @Override
    public String getName() {
        return "Uptime";
    }

    @Override
    public String getCommand() {
        return "uptime";
    }

    @Override
    public String getDescription() {
        return "Find out how long I have been running.";
    }

    @Override
    public commandCategories getCategory() {
        return commandCategories.General;
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public boolean getRequireManageServer() {
        return false;
    }

    @Override
    public boolean getHideCommand() {
        return false;
    }

    @Override
    public boolean getRequireManageUsers() {
        return false;
    }

    public guildObject run(
            GuildMessageReceivedEvent event, String messageContent, guildObject guildEntity) {
        // Taken from Almighty Alpaca
        // https://github.com/Java-Discord-Bot-System/Plugin-Uptime/blob/master/src/main/java/com/almightyalpaca/discord/bot/plugin/uptime/UptimePlugin.java#L28-L42
        final long duration = ManagementFactory.getRuntimeMXBean().getUptime();

        final long years = duration / 31104000000L;
        final long months = duration / 2592000000L % 12;
        final long days = duration / 86400000L % 30;
        final long hours = duration / 3600000L % 24;
        final long minutes = duration / 60000L % 60;
        final long seconds = duration / 1000L % 60;
        // final long milliseconds = duration % 1000;

        String uptime =
                (years == 0 ? "" : "**" + years + "** Years, ")
                        + (months == 0 ? "" : "**" + months + "** Months, ")
                        + (days == 0 ? "" : "**" + days + "** Days, ")
                        + (hours == 0 ? "" : "**" + hours + "** Hours, ")
                        + (minutes == 0 ? "" : "**" + minutes + "** Minutes, ")
                        + (seconds == 0
                                ? ""
                                : "**"
                                        + seconds
                                        + "** Seconds,"
                                        + " ") /* + (milliseconds == 0 ? "" : milliseconds + " Milliseconds, ") */;

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Uptime");
        embedBuilder.setDescription("I've been online for: " + uptime);
        embedBuilder.setColor(Color.MAGENTA);
        event.getChannel().sendMessage(embedBuilder.build()).queue();
        return guildEntity;
    }
}
