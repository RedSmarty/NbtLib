package xyz.redsmarty.nbtlib.tag;

public class NbtShort implements NbtBase {
    private short value;

    public NbtShort(short value) {
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
        return NbtType.SHORT;
    }
}
