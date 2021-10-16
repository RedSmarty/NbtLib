package xyz.redsmarty.nbtlib.tag;

public interface NbtBase {

    /**
     * Get the literal value of the tag
     * */
    Object getValue();

    /**
     * Get the type of the tag
     * @return type of the tag
     * */
    NbtType getType();
}
