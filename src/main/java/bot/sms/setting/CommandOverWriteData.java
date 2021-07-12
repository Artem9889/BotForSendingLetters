package bot.sms.setting;

public class CommandOverWriteData implements Sms {

    public static String text;

    @Override
    public void sendSmsText() {
        text = "Дані видалено!\uD83D\uDDDE\uD83D\uDDD1";
        CommandSendSms.list.clear();
    }
}
