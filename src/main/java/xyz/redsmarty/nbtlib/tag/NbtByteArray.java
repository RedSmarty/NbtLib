package xyz.redsmarty.nbtlib.tag;

public class NbtByteArray implements NbtBase {
    private final byte[] value;

    public NbtByteArray(byte[] value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public NbtType getType() {
        return NbtType.BYTE_ARRAY;
    }
}
