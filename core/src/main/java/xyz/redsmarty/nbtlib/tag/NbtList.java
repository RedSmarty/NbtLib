package xyz.redsmarty.nbtlib.tag;

import java.util.ArrayList;
import java.util.List;

public class NbtList implements NbtBase {
    private final List<NbtBase> value;

    /**
     * Constructs a new empty NbtList
     */
    public NbtList() {
        this.value = new ArrayList<>();
    }

    /**
     * Constructs a new NbtList with the given value
     * @param value Value of the list, must only contain one type of nbt tags
     * @throws IllegalArgumentException if types are not equal
     */
    public NbtList(List<NbtBase> value) {
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i).getType() != value.get(0).getType()) {
                throw new IllegalArgumentException("A list can't mix different types of nbt tags");
            }
        }
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
        return NbtType.LIST;
    }

    /**
     * Adds the given nbt base to the list. Types can't be mixed
     * @param nbtBase NbtTag to add
     */
    public void add(NbtBase nbtBase) {
        if (value.size() == 0) {
            value.add(nbtBase);
            return;
        }
        if (value.get(0).getType() != nbtBase.getType()) {
            throw new IllegalArgumentException("A list can't mix different types of nbt tags");
        }
        value.add(nbtBase);
    }

    /**
     * Removes the given nbt base from the list.
     * @param nbtBase NbtTag to add
     */
    public void remove(NbtBase nbtBase) {
        value.remove(nbtBase);
    }

    /**
     * Gets the size of the list
     * @return The size of the list
     */
    public int size() {
        return value.size();
    }
}
