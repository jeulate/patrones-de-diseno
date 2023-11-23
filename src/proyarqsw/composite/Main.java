package proyarqsw.composite;

import proyarqsw.AdaptadorEnchufeDosPines;
import proyarqsw.EnchufeDosPines;
import proyarqsw.EnchufeTresPines;
import proyarqsw.EnchufeTresPinesImpl;

public class Main {
    public static void main(String[] args) {
        //Crear Enchufes y Dispositivos

        EnchufeTresPines enchufe1 = new EnchufeTresPinesImpl();
        EnchufeTresPines enchufe2 = new EnchufeTresPinesImpl();
        EnchufeTresPines enchufe3 = new EnchufeTresPinesImpl();
        DispositivoModernoComposite dispositivo = new DispositivoModernoComposite();

        //Agregar enchufes al dispositivo compuesto
        dispositivo.agregarEnchufe(enchufe1);
        dispositivo.agregarEnchufe(enchufe2);
        dispositivo.agregarEnchufe(enchufe3);

        // Enchufarel dispositivo moderno con multiples enchufes
        dispositivo.enchufarTresPines();
    }
}
