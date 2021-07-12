package bot.sms.setting;

public class ProcessSms {

    private Sms sms;

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public void sendSms() {
        sms.sendSmsText();
    }
}
