package proyarqsw.decorator;

import proyarqsw.EnchufeTresPines;
import proyarqsw.EnchufeTresPinesImpl;

public class Main {
    public static void main(String[] args) {
        //Crear un enchufe moderno de tres pines
        EnchufeTresPines enchufeTresPines = new EnchufeTresPinesImpl();

        //Agregar un interruptor de encendido/apagado al enchufe
        EnchufeTresPines enchufeConInterruptor = new EnchufeConInterruptor(enchufeTresPines);

        //Enchufar el dispositivo moderno con el decorado
        enchufeConInterruptor.enchufarTresPines();
    }
}
