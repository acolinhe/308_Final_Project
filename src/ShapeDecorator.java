public abstract class ShapeDecorator implements Decorated {
    protected Decorated shapeDecorator;

    @Override
    public String decorate() {
        return shapeDecorator.decorate();
    }
}
