package xyz.redsmarty.nbtlib.tag;

public class NbtString implements NbtBase {
    private final String value;

    /**
     * Constructs a new NbtString with the given value
     * @param value Value of the string
     */
    public NbtString(String value) {
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
        return NbtType.STRING;
    }
}
