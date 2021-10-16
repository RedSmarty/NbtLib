package xyz.redsmarty.nbtlib.io;

import org.bukkit.Bukkit;
import xyz.redsmarty.nbtlib.io.impl.NbtIO_1_17;
import xyz.redsmarty.nbtlib.tag.NbtCompound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface NbtIO {
    NbtIO Instance = NbtImpls.instance;

    class NbtImpls {
        private static NbtIO instance;

        static {
            String version;

            try {

                version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

                Bukkit.getLogger().info("Your server is running version " + version);

                if (version.equals("1_17_R1")) {
                    instance = new NbtIO_1_17();
                }
            } catch (ArrayIndexOutOfBoundsException ignored) { }
        }
    }

    /**
     * Read nbt data from a File
     * @param file File to read nbt from
     * */
    NbtCompound readFromFile(File file) throws IOException;

    /**
     * Read nbt data from a FileInputStream
     * @param in FileInputStream to read nbt from
     * */
    NbtCompound readFromFile(FileInputStream in) throws IOException;

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
    void saveToFile(NbtCompound tag, FileOutputStream out) throws IOException;
}