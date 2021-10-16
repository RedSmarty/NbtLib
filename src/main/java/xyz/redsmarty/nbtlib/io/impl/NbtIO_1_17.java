package xyz.redsmarty.nbtlib.io.impl;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTCompressedStreamTools;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagLongArray;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import xyz.redsmarty.nbtlib.io.NbtIO;
import xyz.redsmarty.nbtlib.tag.NbtBase;
import xyz.redsmarty.nbtlib.tag.NbtByte;
import xyz.redsmarty.nbtlib.tag.NbtByteArray;
import xyz.redsmarty.nbtlib.tag.NbtCompound;
import xyz.redsmarty.nbtlib.tag.NbtDouble;
import xyz.redsmarty.nbtlib.tag.NbtFloat;
import xyz.redsmarty.nbtlib.tag.NbtInt;
import xyz.redsmarty.nbtlib.tag.NbtIntArray;
import xyz.redsmarty.nbtlib.tag.NbtList;
import xyz.redsmarty.nbtlib.tag.NbtLong;
import xyz.redsmarty.nbtlib.tag.NbtLongArray;
import xyz.redsmarty.nbtlib.tag.NbtShort;
import xyz.redsmarty.nbtlib.tag.NbtString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class NbtIO_1_17 implements NbtIO {

    /**
     * Read nbt data from a File
     *
     * @param file File to convert nbt from
     */
    @Override
    public NbtCompound readFromFile(File file) throws IOException {
        return (NbtCompound) convertToLib(NBTCompressedStreamTools.a(new FileInputStream(file)));
    }

    /**
     * Read nbt data from a FileInputStream
     *
     * @param in FileInputStream to convert nbt from
     */
    @Override
    public NbtCompound readFromFile(FileInputStream in) throws IOException {
        return (NbtCompound) convertToLib(NBTCompressedStreamTools.a(in));
    }

    /**
     * Saves nbt data to a File
     *
     * @param tag  Tag to save
     * @param file File to save nbt to
     */
    @Override
    public void saveToFile(NbtCompound tag, File file) throws IOException {
        NBTCompressedStreamTools.a((NBTTagCompound) convertToNMS(tag), file);
    }

    /**
     * Save nbt data to a FileInputStream
     *
     * @param tag Tag to save
     * @param out FileOutputStream to save nbt to
     */
    @Override
    public void saveToFile(NbtCompound tag, FileOutputStream out) throws IOException {
        NBTCompressedStreamTools.a((NBTTagCompound) convertToNMS(tag), out);
    }


    /**
     * Converts nms nbt tag types to lib internal nbt types
     * @param base NBTBase to convert
     * */
    private NbtBase convertToLib(NBTBase base) {
        switch (base.getTypeId()) {
            case 1:
                return new NbtByte(((NBTTagByte) base).asByte());
            case 2:
                return new NbtShort(((NBTTagShort) base).asShort());
            case 3:
                return new NbtInt(((NBTTagInt) base).asInt());
            case 4:
                return new NbtLong(((NBTTagLong) base).asLong());
            case 5:
                return new NbtFloat(((NBTTagFloat) base).asFloat());
            case 6:
                return new NbtDouble(((NBTTagDouble) base).asDouble());
            case 7:
                return new NbtByteArray(((NBTTagByteArray) base).getBytes());
            case 8:
                return new NbtString(base.asString());
            case 9:
                List<NbtBase> list = new ArrayList<>();
                ((NBTTagList) base).forEach(nbtBase -> list.add(convertToLib(nbtBase)));
                return new NbtList(list);
            case 10:
                NBTTagCompound nbtTagCompound = (NBTTagCompound) base;
                Map<String, NbtBase> map = new HashMap<>();
                Set<String> keys = nbtTagCompound.getKeys();
                for (String key: keys) {

                    map.put(key, convertToLib(Objects.requireNonNull(nbtTagCompound.get(key))));
                }
                return new NbtCompound(map);
            case 11:
                return new NbtIntArray(((NBTTagIntArray) base).getInts());
            case 12:
                return new NbtLongArray(((NBTTagLongArray) base).getLongs());
        }
        return null;
    }

    /**
     * Converts nms nbt tag types to lib internal nbt types
     * @param base NBTBase to convert
     * */
    public NBTBase convertToNMS(NbtBase base) {
        switch (base.getType()) {
            case BYTE:
                return NBTTagByte.a((byte) base.getValue());
            case SHORT:
                return NBTTagShort.a((short) base.getValue());
            case INT:
                return NBTTagInt.a((int) base.getValue());
            case LONG:
                return NBTTagLong.a((long) base.getValue());
            case FLOAT:
                return NBTTagFloat.a((float) base.getValue());
            case DOUBLE:
                return NBTTagDouble.a((double) base.getValue());
            case BYTE_ARRAY:
                return new NBTTagByteArray((byte[]) base.getValue());
            case STRING:
                return NBTTagString.a((String) base.getValue());
            case LIST:
                NBTTagList list = new NBTTagList();
                ((List<NbtBase>) base.getValue()).forEach(nbtBase -> list.add(convertToNMS(nbtBase)));

                return list;
            case COMPOUND:
                NbtCompound nbtCompound = (NbtCompound) base;
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                for (String key: nbtCompound.getKeys()) {
                    nbtTagCompound.set(key, convertToNMS(nbtCompound));
                }
                return nbtTagCompound;
            case INT_ARRAY:
                return new NBTTagIntArray(((int[]) base.getValue()));
            case LONG_ARRAY:
                return new NBTTagLongArray(((long[]) base.getValue()));
        }
        return null;
    }
}
