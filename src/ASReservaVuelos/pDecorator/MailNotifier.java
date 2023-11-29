package ASReservaVuelos.pDecorator;

public class MailNotifier extends BaseNotifier{

    public MailNotifier(INotifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Se notificó por MAIL al cliente.");
        System.out.println(message);

    }
}
