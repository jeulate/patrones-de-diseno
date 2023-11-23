package proyarqsw.decorator;

import proyarqsw.EnchufeTresPines;

public abstract class EnchufeDecorator implements EnchufeTresPines {
    protected  EnchufeTresPines enchufeDecorado;

    public EnchufeDecorator(EnchufeTresPines enchufeDecorado) {
        this.enchufeDecorado = enchufeDecorado;
    }

    @Override
    public void enchufarTresPines() {
        enchufeDecorado.enchufarTresPines();
    }

}
