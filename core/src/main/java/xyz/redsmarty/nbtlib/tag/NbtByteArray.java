package xyz.redsmarty.nbtlib.tag;

public class NbtByteArray implements NbtBase {
    private final byte[] value;

    /**
     * Constructs a new NbtByteArray with the given value
     * @param value Value of the byte array
     */
    public NbtByteArray(byte[] value) {
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
     * */
    @Override
    public NbtType getType() {
        return NbtType.BYTE_ARRAY;
    }
}
