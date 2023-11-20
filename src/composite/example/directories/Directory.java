package composite.example.directories;

import java.util.ArrayList;

public class Directory extends File{
    private ArrayList<File> files;

    public Directory (String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    @Override
    public void add(File file) {
        files.add(file);
    }

    @Override
    public void remove(File file) {
        files.remove(file);
    }

    @Override
    public void showInfo() {
        System.out.print(identado.toString() + "* Directory: " + getName() + "\n");
        identado.append("   ");
        for(File file : files){
            file.showInfo();
        }
        identado.setLength(identado.length() - 3);
    }

}
