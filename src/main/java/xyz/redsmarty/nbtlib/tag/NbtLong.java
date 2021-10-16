package xyz.redsmarty.nbtlib.tag;

public class NbtLong implements NbtBase {
    private final long value;

    public NbtLong(long value) {
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
    return NbtType.LONG;
    }
}
