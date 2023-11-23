package proyarqsw;

public class AdaptadorEnchufeDosPines implements EnchufeDosPines{
    private EnchufeTresPines enchufeTresPines;

    public AdaptadorEnchufeDosPines(EnchufeTresPines enchufeTresPines) {
        this.enchufeTresPines = enchufeTresPines;
    }

    @Override
    public void enchufarDosPines() {
        System.out.println("Adaptando enchufe de dos pines a enchufe de tres pines.");
        enchufeTresPines.enchufarTresPines();  //Utiliza el enchufe moderno de tres pines
    }
}
