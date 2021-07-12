package bot.sms.setting;

public class CommandWrite implements Sms{

    public static String text;

    @Override
    public void sendSmsText() {
        CommandSendSms.list.clear();
        text = "Сао\uD83D\uDD90, введи такі дані, як:\n" +
                "1️⃣ - Електронна адреса✉\n" +
                "2️⃣ - Тема листа\uD83D\uDD16\n" +
                "3️⃣ - Текст листа\uD83D\uDCDD\n" +
                "Після цього натисни '/sendsms', та відправ листа!";
    }
}
