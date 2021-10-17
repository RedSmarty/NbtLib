package xyz.redsmarty.nbtlib.tag;

public class NbtInt implements NbtBase {
    private final int value;

    /**
     * Constructs a new NbtInt with the given value
     * @param value Value of the int
     */
    public NbtInt(int value) {
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
        return NbtType.INT;
    }
}
