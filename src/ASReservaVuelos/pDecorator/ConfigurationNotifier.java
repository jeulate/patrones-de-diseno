package ASReservaVuelos.pDecorator;

public class ConfigurationNotifier {
    private INotifier _notifier;
    private boolean _enableMail;
    private boolean _enableSMS;

    public ConfigurationNotifier(boolean enableMail,boolean enableSMS){
        _enableMail = enableMail;
        _enableSMS = enableSMS;

        this.configNotifier();
    }
    private void configNotifier(){
        _notifier = new PDFNotifier();
        if(_enableMail){
            _notifier = new MailNotifier(_notifier);
        }

        if(_enableSMS){
            _notifier = new SMSNotifier(_notifier);
        }
    }

    public void SendNotification(String message){
        _notifier.send(message);
    }
}
