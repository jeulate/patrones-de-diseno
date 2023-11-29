package ASReservaVuelos.pDecorator;

public class SMSNotifier extends BaseNotifier{
    public SMSNotifier(INotifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Se notificó por SMS al cliente.");
        System.out.println(message);
    }
}
