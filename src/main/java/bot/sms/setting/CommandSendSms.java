package bot.sms.setting;

import mail.EmailSetting;
import mail.ExceptionEmail;
import java.util.ArrayList;
import java.util.List;

public class CommandSendSms implements Sms {

    ExceptionEmail exceptionEmail = new ExceptionEmail();

    private static final EmailSetting sender = new EmailSetting("usertelegram98", "Telegram98");
    public static List<String> list = new ArrayList<>();
    public static String text;
    public String email;
    public String subject;
    public static String textMessage;

    @Override
    public void sendSmsText() {
        email = list.get(0);
        subject = list.get(1);
        textMessage = list.get(2);

        //перевірка почти на коректність
        exceptionEmail.setAuditEmail(email);
        exceptionEmail.checkEmail();
        if (exceptionEmail.checkEmail()) {
            text = "❗️Електронна адреса не містить в собі '@' або '.'❗️";
        } else {
            sender.send(subject, "usertelegram98@gmail.com", email);
            text = "\uD83D\uDCE8✈";
        }
        list.clear();
    }
}
