package bot;

import bot.sms.setting.AuditSms;
import mail.EmailSetting;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotSetting extends TelegramLongPollingBot {

    AuditSms auditSms = new AuditSms();

    private static final EmailSetting sender = new EmailSetting("usertelegram98", "Telegram98");

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            setButtons(sendMessage);
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            auditSms.setTextSms(message.getText()); //Задаємо TextSms получене смс повідомлення від користувача
            auditSms.audit(); // перевіряємо получене повідомлення на наявність команди в ньому
            sendMsg(message, auditSms.getCommandText()); // відправляємо реалізацію команди(якщо вона є)
            auditSms.setCommandText(""); // видаляємо текс
        }
    }

    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/write"));
        keyboardFirstRow.add(new KeyboardButton("/sendsms"));
        keyboardFirstRow.add(new KeyboardButton("/overwritedata"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    @Override
    public String getBotUsername() {
        return "emailsend_bot";
    }

    @Override
    public String getBotToken() {
        return "1723026063:AAE9C7Mz5EV4wn8DUtaFQUuQRqLf18PZuyA";
    }

}
