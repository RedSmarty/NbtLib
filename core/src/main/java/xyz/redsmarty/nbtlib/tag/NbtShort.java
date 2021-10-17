package xyz.redsmarty.nbtlib.tag;

public class NbtShort implements NbtBase {
    private short value;

    /**
     * Constructs a new NbtShort with the given value
     * @param value Value of the short
     */
    public NbtShort(short value) {
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
        return NbtType.SHORT;
    }
}
