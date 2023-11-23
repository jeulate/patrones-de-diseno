package proyarqsw;

public class Main {
    public static void main(String[] args) {
        // Crear un enchufe moderno de tres pines.
        EnchufeTresPines enchufeTresPines = new EnchufeTresPinesImpl();

        //crear un adaptador para el enchufe moderno
        EnchufeDosPines adaptador = new AdaptadorEnchufeDosPines(enchufeTresPines);

        //Enchufar el dispositivo moderno a la toma de corriente antigua utilizando el adaptador
        adaptador.enchufarDosPines();
    }
}
