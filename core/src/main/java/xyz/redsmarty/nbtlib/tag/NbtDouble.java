package xyz.redsmarty.nbtlib.tag;

public class NbtDouble implements NbtBase {
    private final double value;

    /**
     * Constructs a new NbtDouble with the given value
     * @param value Value of the double
     */
    public NbtDouble(double value) {
        this.value = value;
    }

    /**
     * Get the literal value of the tag
     * */
    @Override
    public Object getValue() {
        return value;
    }

    /**
     * Get the type of the tag
     * @return type of the tag
     */
    @Override
    public NbtType getType() {
        return NbtType.DOUBLE;
    }
}
