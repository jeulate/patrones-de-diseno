package ASReservaVuelos.pDecorator;

public class PDFNotifier implements INotifier{
    @Override
    public void send(String message) {
        System.out.println("Se generó el PDF y se inicio la descarga.");
        System.out.println(message);
    }
}
