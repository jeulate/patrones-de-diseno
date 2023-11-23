package proyarqsw.composite;

import proyarqsw.EnchufeTresPines;

import java.util.ArrayList;
import java.util.List;

public class DispositivoModernoComposite implements EnchufeTresPines {
    private List<EnchufeTresPines> enchufes = new ArrayList<>();
    public void agregarEnchufe(EnchufeTresPines enchufe){
        enchufes.add(enchufe);
    }
    @Override
    public void enchufarTresPines(){
        System.out.println("Enchufando dispositivo moderno de tres pines.");
        for (EnchufeTresPines enchufe: enchufes){
            enchufe.enchufarTresPines();
        }
    }
}
