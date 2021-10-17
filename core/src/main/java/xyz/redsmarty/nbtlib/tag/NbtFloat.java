package xyz.redsmarty.nbtlib.tag;

public class NbtFloat implements NbtBase {
    private float value;

    /**
     * Constructs a new NbtFloat with the given value
     * @param value Value of the float
     */
    public NbtFloat(float value) {
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
        return NbtType.FLOAT;
    }
}
