package kpobaschnig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author kevin
 * @version 20.11.2024
 *
 * Diese Klasse representiert die simple GUI des WortTrainers
 */
public class WortTrainerGUI{
    public static void main(String[] args) throws MalformedURLException {
        WortTrainer trainer = null;
        SaveLoad salo = new SaveLoadJSON();

        int restart = JOptionPane.showConfirmDialog(null, "Möchtest du den WortTrainer neu starten?", "WortTrainer", JOptionPane.YES_NO_OPTION);

        try {
            if(restart == JOptionPane.YES_OPTION){
                ArrayList<WortEintrag> list = new ArrayList<>();

                list.add(new WortEintrag("Kuh", new URI("https://www.planet-wissen.de/gesellschaft/trinken/milch/milchkuhwdrgjpg100~_v-gseapremiumxl.jpg")));
                list.add(new WortEintrag("Katze", new URI("https://www.peta.de/wp-content/uploads/2022/12/katzen-cat-6568422_1280-c-pixabay.jpg")));
                list.add(new WortEintrag("Hand", new URI("https://orthinform.de/processed/3/article_408_a604ef64_900x600.jpg")));

                trainer = new WortTrainer(list);
                salo.save(trainer);
            } else {
                try {
                    trainer = salo.load();
                } catch(IOException | ClassNotFoundException e) {
                    ArrayList<WortEintrag> list = new ArrayList<>();
                    try {
                        list.add(new WortEintrag("Kuh", new URI("https://www.planet-wissen.de/gesellschaft/trinken/milch/milchkuhwdrgjpg100~_v-gseapremiumxl.jpg")));
                        list.add(new WortEintrag("Katze", new URI("https://www.peta.de/wp-content/uploads/2022/12/katzen-cat-6568422_1280-c-pixabay.jpg")));
                        list.add(new WortEintrag("Hand", new URI("https://orthinform.de/processed/3/article_408_a604ef64_900x600.jpg")));

                        trainer = new WortTrainer(list);
                    } catch(Exception uriException) {
                        uriException.printStackTrace();
                        return;
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
            return;
        } catch(Exception uriException) {
            uriException.printStackTrace();
            return;
        }

        while(true) {
            WortEintrag currentWort = trainer.getCurrent();
            ImageIcon icon = new ImageIcon(currentWort.getURL().toURL());
            String message = "Aktuelle Statistik:\n" + trainer + "\nWas ist das?";

            Object[] options = {icon, message};
            String input = (String) JOptionPane.showInputDialog(null, options, "WortTrainer", JOptionPane.PLAIN_MESSAGE, null, null, null);

            if(input == null) {
                break;
            }

            try {
                trainer.checkAnswer(input);
                JOptionPane.showMessageDialog(null, "Korrekt!");
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        try {
            salo.save(trainer);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}