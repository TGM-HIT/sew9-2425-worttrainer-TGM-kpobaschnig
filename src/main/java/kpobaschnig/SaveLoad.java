package kpobaschnig;

import java.io.IOException;

/**
 * @author kevin
 * @version 20.11.2024
 *
 * Dieses Interface gibt eine Struktur vor, wie die beiden SaveLoad Klassen zumindest auszusehen haben
 */
public interface SaveLoad {

    /**
     * Diese Methode wird genutzt zum Speichern des WortTrainers in ein File
     */
    public void save(WortTrainer wortTrainer) throws IOException;

    /**
     * Diese Methode wird genutzt um den WortTrainer aus einem File zu laden
     *
     * @return gibt den geladenen WortTrainer zurück
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public WortTrainer load() throws IOException, ClassNotFoundException;

}