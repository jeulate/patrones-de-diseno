package proyarqsw.decorator;

import proyarqsw.EnchufeTresPines;

public class EnchufeConInterruptor extends EnchufeDecorator{
    public EnchufeConInterruptor(EnchufeTresPines enchufeDecorado) {
        super(enchufeDecorado);
    }

    @Override
    public void enchufarTresPines() {
        super.enchufarTresPines();
        System.out.println("Interruptor de Encendido/Apagado activado.");
    }
}
