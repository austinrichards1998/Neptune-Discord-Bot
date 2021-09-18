package neptune.commands.FunCommands;

import neptune.commands.ICommand;
import neptune.commands.ISlashCommand;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.List;
import java.util.Random;

public class PowerLevel implements ICommand, ISlashCommand {
    Random random = new Random();


    @Override
    public Message run(GuildMessageReceivedEvent event, String messageContent, MessageBuilder builder) {
        int powerlevel = random.nextInt(random.nextInt(9001)) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        List<Member> mention = event.getMessage().getMentionedMembers();
        stringBuilder.append("Vegeta, What does the scouter say about ");
        if (mention.size() != 0) {
            Member target = mention.get(random.nextInt(mention.size()));
            stringBuilder.append(target.getAsMention()).append("'s power level?");
        } else {
            stringBuilder.append("your power level?");
        }
        stringBuilder.append("\nIt's, ").append(powerlevel);
        float radiz = (float) powerlevel / (float) 1500;
        stringBuilder.append(" or, ").append(String.format(java.util.Locale.US, "%.2f", radiz)).append(" Raditz");
        return builder.setContent(stringBuilder.toString()).build();

    }

    @Override
    public CommandData RegisterCommand(CommandData commandData) {
        return commandData.addOption(OptionType.USER,"Target User","Check another users power level.");
    }

    @Override
    public Message run(SlashCommandEvent event, MessageBuilder builder) {
        int powerlevel = random.nextInt(random.nextInt(9001)) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        OptionMapping optionMapping = event.getOption("Target User");
        stringBuilder.append("Vegeta, What does the scouter say about ");
        if (optionMapping != null){
            User target = optionMapping.getAsUser();
            stringBuilder.append(target.getAsMention()).append("'s power level?");
        } else {
            stringBuilder.append("your power level?");
        }
        stringBuilder.append("\nIt's, ").append(powerlevel);
        float radiz = (float) powerlevel / (float) 1500;
        stringBuilder.append(" or, ").append(String.format(java.util.Locale.US, "%.2f", radiz)).append(" Raditz");
        return builder.setContent(stringBuilder.toString()).build();    }
}
