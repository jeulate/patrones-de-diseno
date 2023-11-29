package ASReservaVuelos.pDecorator;

public class BaseNotifier implements INotifier{
    private INotifier wrapppe;

    public BaseNotifier (INotifier notifier){
        wrapppe = notifier;
    }
    @Override
    public void send(String message) {
        wrapppe.send(message);
    }
}
