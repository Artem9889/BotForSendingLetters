package bot.sms.setting;

public class AuditSms {

    ProcessSms processSms = new ProcessSms();

    private String textSms;
    private String commandText;

    public String getCommandText() {
        return commandText;
    }

    public void setCommandText(String commandText) {
        this.commandText = commandText;
    }

    public String getTextSms() {
        return textSms;
    }

    public void setTextSms(String textSms) {
        this.textSms = textSms;
    }

    public void audit() {

        switch (getTextSms()) {

            case "/start":
                processSms.setSms(new CommandStart());
                processSms.sendSms();
                setCommandText(CommandStart.text);
                break;
            case "/write":
                processSms.setSms(new CommandWrite());
                processSms.sendSms();
                setCommandText(CommandWrite.text);
                break;
            case "/sendsms":
                processSms.setSms(new CommandSendSms());
                processSms.sendSms();
                setCommandText(CommandSendSms.text);
                break;
            case "/overwritedata":
                processSms.setSms(new CommandOverWriteData());
                processSms.sendSms();
                setCommandText(CommandOverWriteData.text);
                break;
            default:
                CommandSendSms.list.add(getTextSms());
        }
    }
}
