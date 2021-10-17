package xyz.redsmarty.nbtlib.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NbtCompound implements NbtBase {

    private final Map<String, NbtBase> data;

    /**
     * Constructs a new NbtCompound with the given value
     * @param data Value of the NbtCompound
     */
    public NbtCompound(Map<String, NbtBase> data) {
        this.data = data;
    }

    /**
     * Constructs a new empty NbtCompound with the given value
     */
    public NbtCompound() {
        this.data = new HashMap<>();
    }


    /**
     * Get the literal value of the tag
     * */
    @Override
    public Object getValue() {
        return data;
    }

    /**
     * Get the type of the tag
     * @return type of the tag
     */
    @Override
    public NbtType getType() {
        return NbtType.COMPOUND;
    }

    /**
     * Get nbt tag from the supplied path
     * @param path Path of the tag
     * @return Requested tag or null if not found
     * */
    public NbtBase get(String path, NbtType type) {
        if (data.containsKey(path) && data.get(path).getType() == type) {
            return data.get("path");
        }
        return null;
    }

    /**
     * Get nbt tag from the supplied path
     * @param path Path of the tag
     * @param defaultValue Value to return if not found
     * @return Requested byte or default value if not found
     * */
    public NbtBase get(String path, NbtType type, NbtBase defaultValue) {
        if (data.containsKey(path) && data.get(path).getType() == type) {
            return data.get("path");
        }
        return defaultValue;
    }

    /**
     * Get byte from the supplied path
     * @param path Path of the byte
     * @return Requested byte or 0 if not found
     * */
    public byte getByte(String path) {
        return (byte) get(path, NbtType.BYTE, new NbtByte((byte) 0)).getValue();
    }

    /**
     * Get byte from the supplied path
     * @param path Path of the byte
     * @param defaultValue Value to return if not found
     * @return Requested byte or default value if not found
     * */
    public byte getByte(String path, byte defaultValue) {
        return (byte) get(path, NbtType.BYTE, new NbtByte(defaultValue)).getValue();
    }

    /**
     * Get short from the supplied path
     * @param path Path of the short
     * @return Requested short or 0 if not found
     * */
    public short getShort(String path) {
        return (short) get(path, NbtType.SHORT, new NbtShort((short) 0)).getValue();
    }

    /**
     * Get short from the supplied path
     * @param path Path of the short
     * @param defaultValue Value to return if not found
     * @return Requested byte or default value if not found
     * */
    public short getShort(String path, short defaultValue) {
        return (short) get(path, NbtType.SHORT, new NbtShort(defaultValue)).getValue();
    }

    /**
     * Get int from the supplied path
     * @param path Path of the int
     * @return Requested int or 0 if not found
     * */
    public int getInt(String path) {
        return (int) get(path, NbtType.INT, new NbtInt(0)).getValue();
    }

    /**
     * Get int from the supplied path
     * @param path Path of the int
     * @param defaultValue Value to return if not found
     * @return Requested int or default value if not found
     * */
    public int getInt(String path, int defaultValue) {
        return (int) get(path, NbtType.INT, new NbtInt(defaultValue)).getValue();
    }

    /**
     * Get long from the supplied path
     * @param path Path of the long
     * @return Requested long or 0 if not found
     * */
    public long getLong(String path) {
        return (long) get(path, NbtType.LONG, new NbtLong(0)).getValue();
    }

    /**
     * Get long from the supplied path
     * @param path Path of the long
     * @param defaultValue Value to return if not found
     * @return Requested long or default value if not found
     * */
    public long getLong(String path, long defaultValue) {
        return (long) get(path, NbtType.LONG, new NbtLong(defaultValue)).getValue();
    }

    /**
     * Get float from the supplied path
     * @param path Path of the float
     * @return Requested float or 0 if not found
     * */
    public float getFloat(String path) {
        return (float) get(path, NbtType.FLOAT, new NbtFloat(0)).getValue();
    }

    /**
     * Get float from the supplied path
     * @param path Path of the float
     * @param defaultValue Value to return if not found
     * @return Requested float or default value if not found
     * */
    public float getFloat(String path, float defaultValue) {
        return (float) get(path, NbtType.FLOAT, new NbtFloat(defaultValue)).getValue();
    }

    /**
     * Get double from the supplied path
     * @param path Path of the double
     * @return Requested double or 0 if not found
     * */
    public double getDouble(String path) {
        return (double) get(path, NbtType.DOUBLE, new NbtDouble(0)).getValue();
    }

    /**
     * Get double from the supplied path
     * @param path Path of the double
     * @param defaultValue Value to return if not found
     * @return Requested double or default value if not found
     * */
    public double getDouble(String path, double defaultValue) {
        return (double) get(path, NbtType.DOUBLE, new NbtDouble(defaultValue)).getValue();
    }


    /**
     * Get byte array from the supplied path
     * @param path Path of the byte array
     * @return Requested byte array or empty array if not found
     * */
    public byte[] getByteArray(String path) {
        return (byte[]) get(path, NbtType.BYTE_ARRAY, new NbtByteArray(new byte[0])).getValue();
    }

    /**
     * Get byte array from the supplied path
     * @param path Path of the byte array
     * @param defaultValue Value to return if not found
     * @return Requested byte array or default value if not found
     * */
    public byte[] getByteArray(String path, byte[] defaultValue) {
        return (byte[]) get(path, NbtType.BYTE_ARRAY, new NbtByteArray(defaultValue)).getValue();
    }


    /**
     * Get string from the supplied path
     * @param path Path of the string
     * @return Requested string or null if not found
     * */
    public String getString(String path) {
        return (String) get(path, NbtType.STRING).getValue();
    }

    /**
     * Get string from the supplied path
     * @param path Path of the string
     * @param defaultValue Value to return if not found
     * @return Requested string or default value if not found
     * */
    public String getString(String path, String defaultValue) {
        return (String) get(path, NbtType.STRING, new NbtString(defaultValue)).getValue();
    }

    /**
     * Get raw list from the supplied path
     * @param path Path of the list
     * @return Requested list or empty list if not found
     * */
    public List<NbtBase> getRawList(String path) {
        return (List<NbtBase>) get(path, NbtType.LIST, new NbtList(new ArrayList<>())).getValue();
    }

    /**
     * Get raw list from the supplied path
     * @param path Path of the list
     * @param defaultValue Value to return if not found
     * @return Requested list or default value if not found
     * */
    public List<NbtBase> getRawList(String path, List<NbtBase> defaultValue) {
        return (List<NbtBase>) get(path, NbtType.LIST, new NbtList(defaultValue)).getValue();
    }

    /**
     * Get list from the supplied path. This will return the literal value of any nbt tag
     * @param path Path of the list
     * @return Requested list or empty list if not found
     * */
    public List<Object> getList(String path) {
        List<Object> list = new ArrayList<>();
        for (NbtBase nbtBase: ((List<NbtBase>) get(path, NbtType.LIST, new NbtList(new ArrayList<>())).getValue())) {
            list.add(nbtBase.getValue());
        }
        return list;
    }

    /**
     * Get list from the supplied path. This will return the literal value of any nbt tag
     * @param path Path of the list
     * @return Requested list or empty list if not found
     * */
    public List<Object> getList(String path, List<Object> defaultValue) {
        List<Object> list = new ArrayList<>();
        NbtBase value = get(path, NbtType.LIST);
        if (value == null) {
            return defaultValue;
        }
        for (NbtBase nbtBase: ((List<NbtBase>) value.getValue())) {
            list.add(nbtBase.getValue());
        }
        return list;
    }

    /**
     * Get compound tag from the supplied path
     * @param path Path of the compound tag
     * @return Requested compound tag or 0 if not found
     * */
    public NbtCompound getCompound(String path) {
        return (NbtCompound) get(path, NbtType.COMPOUND, new NbtCompound(new HashMap<>()));
    }

    /**
     * Get compound tag from the supplied path
     * @param path Path of the compound tag
     * @param defaultValue Value to return if not found
     * @return Requested compound tag or default value if not found
     * */
    public NbtCompound getCompound(String path, Map<String, NbtBase> defaultValue) {
        return (NbtCompound) get(path, NbtType.COMPOUND, new NbtCompound(defaultValue));
    }

    /**
     * Get int array from the supplied path
     * @param path Path of the int array
     * @return Requested int array or 0 if not found
     * */
    public int[] getIntArray(String path) {
        return (int[]) get(path, NbtType.INT_ARRAY, new NbtIntArray(new int[0])).getValue();
    }

    /**
     * Get int array from the supplied path
     * @param path Path of the int array
     * @param defaultValue Value to return if not found
     * @return Requested int array or default value if not found
     * */
    public int[] getIntArray(String path, int[] defaultValue) {
        return (int[]) get(path, NbtType.INT_ARRAY, new NbtIntArray(defaultValue)).getValue();
    }

    /**
     * Get long array from the supplied path
     * @param path Path of the long array
     * @return Requested long array or 0 if not found
     * */
    public long[] getLongArray(String path) {
        return (long[]) get(path, NbtType.LONG_ARRAY, new NbtLongArray(new long[0])).getValue();
    }

    /**
     * Get long array from the supplied path
     * @param path Path of the long array
     * @param defaultValue Value to return if not found
     * @return Requested long array or default value if not found
     * */
    public long[] getLongArray(String path, long[] defaultValue) {
        return (long[]) get(path, NbtType.LONG_ARRAY, new NbtLongArray(defaultValue)).getValue();
    }

    /**
     * Get boolean from the supplied path
     * @param path Path of the boolean
     * @return Requested boolean or false if not found
     * */
    public boolean getBoolean(String path) {
        return ((byte) get(path, NbtType.BYTE, new NbtByte((byte) 0)).getValue() != 0);
    }

    /**
     * Get boolean from the supplied path
     * @param path Path of the boolean
     * @param defaultValue Value to return if not found
     * @return Requested boolean or default value if not found
     * */
    public boolean getBoolean(String path, boolean defaultValue) {
        return ((byte) get(path, NbtType.BYTE, new NbtByte((byte) (defaultValue ? 1 : 0))).getValue() != 0);
    }

    /**
     * Get keys of this compound tag
     * @return A set of keys present in this tag
     * */
    public Set<String> getKeys() {
        return data.keySet();
    }

    /**
     * Sets the specified path to the given value. If value is null, the entry will be removed. Any existing entry will be replaced, regardless of what the new value is.
     * @param path Path to set the value on
     * @param nbtBase Value to set on the path
     * */
    public void set(String path, NbtBase nbtBase) {
        if (nbtBase == null) {
            data.remove(path);
            return;
        }
        this.data.put(path, nbtBase);
    }
}
