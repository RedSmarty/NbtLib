package xyz.redsmarty.nbtlib;

import xyz.redsmarty.nbtlib.tag.NbtCompound;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface NbtIO {

    /**
     * Read nbt data from a File
     * @param file File to read nbt from
     * */
    NbtCompound readFromFile(File file) throws IOException;

    /**
     * Read nbt data from a FileInputStream
     * @param in FileInputStream to read nbt from
     * */
    NbtCompound readFromFile(InputStream in) throws IOException;

    /**
     * Saves nbt data to a File
     * @param tag Tag to save
     * @param file File to save nbt to
     * */
    void saveToFile(NbtCompound tag, File file) throws IOException;

    /**
     * Save nbt data to a FileInputStream
     * @param tag Tag to save
     * @param out FileOutputStream to save nbt to
     * */
    void saveToFile(NbtCompound tag, OutputStream out) throws IOException;
}