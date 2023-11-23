package abstractfactory;

public class ProductATwo extends AbstractProductA{
    public ProductATwo(String name, String description){
        super(name, description);
    }

    public ProductATwo(){
        setName("Product A - Part Two");
        setDescription("Description of Product A - Part Two");
    }
}
