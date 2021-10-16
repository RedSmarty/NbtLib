package xyz.redsmarty.nbtlib.tag;

public class NbtIntArray implements NbtBase {
    private int[] value;

    public NbtIntArray(int[] value) {
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
        return NbtType.INT_ARRAY;
    }
}
