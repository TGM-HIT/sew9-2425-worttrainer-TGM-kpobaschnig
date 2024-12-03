package kpobaschnig;

import java.io.*;

/**
 * @author kevin
 * @version 20.11.2024
 *
 * Diese Klasse implementiert 2 Methoden um den WortTrainer zu laden bzw. zu speichern
 */
public class SaveLoadOBJECT implements SaveLoad {

    /**
     * Diese Methode wird genutzt zum Speichern des WortTrainers in ein File
     */
    public void save(WortTrainer wortTrainer) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("src/main/resources/wortTrainer.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(wortTrainer);
        fos.close();
        oos.close();
    }

    /**
     * Diese Methode wird genutzt um den WortTrainer aus einem File zu laden
     *
     * @return gibt den geladenen WortTrainer zurück
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public WortTrainer load() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("src/main/resources/wortTrainer.txt"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        WortTrainer wt = (WortTrainer) ois.readObject();
        fis.close();
        ois.close();
        return wt;
    }
}
