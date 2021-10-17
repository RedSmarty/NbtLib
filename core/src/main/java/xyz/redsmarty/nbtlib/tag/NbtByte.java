package xyz.redsmarty.nbtlib.tag;

public class NbtByte implements NbtBase {
    private byte value;

    /**
     * Constructs a new NbtByte with the given value
     * @param value Value of the byte
     */
    public NbtByte(byte value) {
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
        return NbtType.BYTE;
    }
}
