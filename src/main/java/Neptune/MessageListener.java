package Neptune;

import Neptune.Storage.StorageController;
import Neptune.Storage.VariablesStorage;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

//intercepts discord messages
public class MessageListener extends ListenerAdapter {
    private VariablesStorage variableStorageRead;
    private final messageInterprter message;
    MessageListener(VariablesStorage variableStorageRead, StorageController storageController) {
        this.variableStorageRead = variableStorageRead;
        message = new messageInterprter(storageController, variableStorageRead);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        event.getJDA().getPresence().setGame(Game.playing(variableStorageRead.getCallBot() + " help"));
        //checks if the message was sent from a bot
        if (event.getAuthor().isBot()) return;
        message.runEvent(event);

    }
}



