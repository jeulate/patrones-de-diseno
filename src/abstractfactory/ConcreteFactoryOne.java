package abstractfactory;

public class ConcreteFactoryOne extends AbstractFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ProductAOne();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductBOne();
    }
}
