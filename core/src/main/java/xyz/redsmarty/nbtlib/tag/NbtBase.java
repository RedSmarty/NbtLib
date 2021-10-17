package xyz.redsmarty.nbtlib.tag;

public interface NbtBase {
    /**
     * Get the literal value of the tag
     * @return The literal value
     * */
    Object getValue();

    /**
     * Get the type of the tag
     * @return type of the tag
     * */
    NbtType getType();
}
