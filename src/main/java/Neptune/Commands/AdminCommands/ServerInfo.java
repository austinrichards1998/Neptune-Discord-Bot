package Neptune.Commands.AdminCommands;

import Neptune.Commands.CommandInterface;
import Neptune.Commands.commandCategories;
import Neptune.Storage.VariablesStorage;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class ServerInfo implements CommandInterface {
    @Override
    public String getName() {
        return "Server Info";
    }

    @Override
    public String getCommand() {
        return "serverinfo";
    }

    @Override
    public String getDescription() {
        return "Displays basic server info and channels neptune can view";
    }

    @Override
    public commandCategories getCategory() {
        return commandCategories.Admin;
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public boolean getRequireManageServer() {
        return true;
    }

    @Override
    public boolean getRequireOwner() {
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

    @Override
    public boolean run(MessageReceivedEvent event, VariablesStorage variablesStorage, String messageContent) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        StringBuilder ChannelList = new StringBuilder();
        StringBuilder RoleList = new StringBuilder();
        for (Channel channel : event.getGuild().getTextChannels()){
            ChannelList.append(channel.getName()).append("\n");
        }
        for (Role role : event.getGuild().getRoles()){
            RoleList.append(role.getName()).append("\n");
        }

        embedBuilder.setTitle(getName());
        embedBuilder.setColor(Color.MAGENTA);
        embedBuilder.addField("Server Owner", event.getGuild().getOwner().getAsMention(),true);
        embedBuilder.addField("Server Region",event.getGuild().getRegion().toString(),true);
        embedBuilder.addField("Members", String.valueOf(event.getGuild().getMembers().size()),true);
        embedBuilder.addField("Channels", ChannelList.toString(),true);
        embedBuilder.addField("Roles",RoleList.toString(),true);
        event.getChannel().sendMessage(embedBuilder.build()).queue();
        return false;
    }
}
