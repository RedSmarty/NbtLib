package xyz.redsmarty.nbtlib.tag;

public class NbtLongArray implements NbtBase {
    private final long[] value;

    /**
     * Constructs a new NbtLongArray with the given value
     * @param value Value of the long array
     */
    public NbtLongArray(long[] value) {
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
        return NbtType.LONG_ARRAY;
    }
}
