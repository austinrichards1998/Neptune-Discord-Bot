package Neptune.Commands;

public abstract class CommonMethods {

    protected String[] getCommandName(String MessageContent){
        String[] splitStr = MessageContent.trim().split("\\s+");
        String[] returnText = new String[2];
        if (splitStr.length == 1) {
            returnText[0] = splitStr[0].trim();
            returnText[1] = "";
        } else {
            returnText[0] = splitStr[0];
            returnText[1] = MessageContent.trim().substring(splitStr[0].length()).trim();
        }
        return returnText;
    }
    protected String getEnabledDisabledIcon(String value){
        String enabled = "✅";
        String disabled = "❌";

        if(value.equalsIgnoreCase("enabled")){
            return enabled;
        }
        else return disabled;
    }
    protected String getEnabledDisabledIconText(String value){
        String enabled = "✅ Enabled";
        String disabled = "❌ Disabled";

        if(value.equalsIgnoreCase("enabled")){
            return enabled;
        }
        else return disabled;
    }
}
