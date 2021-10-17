package xyz.redsmarty.nbtlib.tag;

public class NbtIntArray implements NbtBase {
    private int[] value;

    /**
     * Constructs a new NbtIntArray with the given value
     * @param value Value of the int array
     */
    public NbtIntArray(int[] value) {
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
        return NbtType.INT_ARRAY;
    }
}
