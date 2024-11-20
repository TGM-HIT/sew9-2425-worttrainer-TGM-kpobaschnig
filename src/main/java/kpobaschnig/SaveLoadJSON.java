package src.main.java.kpobaschnig;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author kevin
 * @version 20.11.2024
 *
 * Diese Klasse implementiert 2 Methoden um den WortTrainer zu laden bzw. zu speichern
 */
public class SaveLoadJSON implements SaveLoad {

    private static final String PATH = "src/main/resources/wortTrainer.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Diese Methode wird genutzt zum Speichern des WortTrainers in ein File
     */
    public void save(WortTrainer wortTrainer) throws IOException {
        try(FileWriter fw = new FileWriter(PATH)) {
            gson.toJson(wortTrainer, fw);
        }
    }

    /**
     * Diese Methode wird genutzt um den WortTrainer aus einem File zu laden
     *
     * @return gibt den geladenen WortTrainer zurück
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public WortTrainer load() throws IOException, ClassNotFoundException {
        try(FileReader fr = new FileReader(PATH)) {
            return gson.fromJson(fr, WortTrainer.class);
        }
    }
}
