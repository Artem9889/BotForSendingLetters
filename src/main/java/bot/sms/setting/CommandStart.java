package bot.sms.setting;


public class CommandStart implements Sms {

    public static String text;

    @Override
    public void sendSmsText() {
        text = "Сао\uD83D\uDD90\nНатискай  '/write',  та пиши листа\uD83E\uDD13\uD83D\uDCDD";
    }
}
