package xyz.redsmarty.nbtlib.tag;

public class NbtFloat implements NbtBase {
    private float value;

    public NbtFloat(float value) {
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
        return NbtType.FLOAT;
    }
}
