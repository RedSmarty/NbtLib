package xyz.redsmarty.nbtlib.tag;

public class NbtByte implements NbtBase {
    private byte value;

    public NbtByte(byte value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public NbtType getType() {
        return NbtType.BYTE;
    }
}
