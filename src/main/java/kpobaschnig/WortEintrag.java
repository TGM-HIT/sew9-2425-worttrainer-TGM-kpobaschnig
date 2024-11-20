package src.main.java.kpobaschnig;

import java.io.Serializable;
import java.net.URI;

/**
 * @author kevin
 * @version 20.11.2024
 *
 * Diese Klasse initialisiert einen einzelnen WortEintrag also einem Wort verbunden mit einer URL (verweist auf ein Bild).
 */
public class WortEintrag implements Serializable {
    private final String WORT;
    private final URI URL;

    public WortEintrag(String wort, URI url) {
        this.WORT = wort;
        this.URL = url;
    }

    /**
     * Diese Methode überprüft, ob ein WortEintrag valide ist.
     * Also ob das Wort und die URL zeichen enthält.
     *
     * @return True oder False je nachdem ob der WortEintrag valide ist oder nicht
     */
    public boolean valid() {
        return WORT != null && URL != null && !WORT.isEmpty();
    }

    /**
     * Diese Methode gibt das Wort des aktuellen WortEintrags zurück.
     *
     * @return aktuelles Wort des WortEintrags
     */
    public String getWort() {
        return this.WORT;
    }

    /**
     * Diese Methode gibt die URL des aktuellen WortEintrags zurück.
     *
     * @return aktuelle URL des WortEintrags
     */
    public URI getURL() {
        return this.URL;
    }

    /**
     * Diese Methode gibt den WortEintrag als String zurück.
     *
     * @return Wort und URL als String
     */
    public String toString() {
        return this.WORT + " - " + this.URL;
    }
}
