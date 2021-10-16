package xyz.redsmarty.nbtlib.tag;

public class NbtString implements NbtBase {
    private final String value;

    public NbtString(String value) {
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
        return NbtType.STRING;
    }
}
