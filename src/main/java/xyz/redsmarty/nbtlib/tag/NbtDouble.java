package xyz.redsmarty.nbtlib.tag;

public class NbtDouble implements NbtBase {
    private final double value;

    public NbtDouble(double value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    /**
     * Get the type of the tag
     *
     * @return type of the tag
     */
    @Override
    public NbtType getType() {
        return NbtType.DOUBLE;
    }
}
