package neptune.commands.DevCommands;

import neptune.commands.CommandInterface;
import neptune.commands.commandCategories;
import neptune.storage.guildObject;
import neptune.music.AudioController;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class music implements CommandInterface {
    private AudioController AudioOut;

    @Override
    public String getName() {
        return "Music";
    }

    @Override
    public String getCommand() {
        return "music";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public commandCategories getCategory() {
        return commandCategories.Dev;
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
        return true;
    }

    @Override
    public boolean getRequireManageUsers() {
        return false;
    }

    @Override
    public guildObject run(MessageReceivedEvent event, String messageContent, guildObject guildEntity) {
        if (event.getGuild() != null && AudioOut == null) {
            AudioOut = new AudioController(event);
        }
        if (event.getGuild().getAudioManager() != null || event.getMember().getVoiceState().getChannel() != null && event.getGuild() != null ) {
            AudioOut.playSound(event, messageContent);
        }
        return guildEntity;
    }
}
