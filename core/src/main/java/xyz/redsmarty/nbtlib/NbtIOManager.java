package xyz.redsmarty.nbtlib;

import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;

public class NbtIOManager {
    private static NbtIO instance;

    /**
     * Get the NbtIO implementation for the current server version. If there is no implementation for the current version, this will return null
     * @return NbtIO implementation or null if no implementation found
     * */
    public static NbtIO getInstance() {
        if (instance == null) {
            try {
                String packageName = NbtIO.class.getPackage().getName();
                String internalsName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
                instance = (NbtIO) Class.forName(packageName + ".NbtIO_" + internalsName).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException | NoSuchMethodException | InvocationTargetException exception) {
                Bukkit.getLogger().severe("NbtLib could not find a valid implementation for this server version.");
            }
        }
        return instance;
    }

    /**
     * Checks if server version is compatible with this lib
     * @return true if compatible, false otherwise
     */
    public static boolean isCompatible() {
        if (getInstance() == null) {
            Bukkit.getLogger().severe("You are running an unsupported server version. NbtLib will not work.");
            return false;
        }
        return true;
    }
}
