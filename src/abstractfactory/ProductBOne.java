package abstractfactory;

public class ProductBOne extends AbstractProductB{
    public ProductBOne(String name, String description){
        super(name, description);
    }

    public ProductBOne(){
        setName("Product B - Part One");
        setDescription("Description of Product B - Part One");
    }
}
