package xyz.redsmarty.nbtlib.tag;

import java.util.List;

public class NbtList implements NbtBase {
    private final List<NbtBase> value;

    public NbtList(List<NbtBase> value) {
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
        return NbtType.LIST;
    }
}
