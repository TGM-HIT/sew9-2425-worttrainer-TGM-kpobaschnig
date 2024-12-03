package kpobaschnig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author kevin
 * @version 03.12.2024
 *
 * Diese Klasse initialisiert einen WortTrainer mit mehreren WortEinträgen
 */
public class WortTrainer implements Serializable {
    private int answer = 0;
    private int correct = 0;
    private ArrayList<WortEintrag> list = new ArrayList<>();
    private WortEintrag currWortEintrag;

    public WortTrainer(ArrayList<WortEintrag> list) {
        if(list == null) throw new IllegalArgumentException("Die Liste ist leer!");
        this.list = list;
        this.currWortEintrag = list.get(0);
    }

    /**
     * Diese Methode gibt einen Random WortEintrag aus dem WortTrainer zurück.
     *
     * @return Random WortEintrag des WortTrainers
     */
    public WortEintrag getRndEintrag() {
        Random rand = new Random();
        this.currWortEintrag = this.list.get(rand.nextInt(this.list.size()));
        return this.currWortEintrag;
    }

    /**
     * Diese Methode gibt den derzeitigen WortEintrag aus dem WortTrainer zurück.
     *
     * @return Derzeitiger WortEintrag des WortTrainers
     */
    public WortEintrag getCurrent() {
        return this.currWortEintrag;
    }

    /**
     * Diese Methode gibt die richtige Antwort des derzeitigen WortEintrages zurück
     *
     * @return Richtige Antwort des derzeitigen WortEintrages
     */
    public int getAnswer() {
        return this.answer;
    }

    /**
     * Diese Methode gibt die Anzahl der richtig gegebenen Antworten zurück
     *
     * @return Anzahl richtig gegebener Antworten
     */
    public int getCorrect() {
        return this.correct;
    }

    /**
     * Diese Methode gibt die vollständige Liste der WortEinträge zurück
     *
     * @return vollständige Liste der WortEinträge
     */
    public ArrayList<WortEintrag> getList() {
        return this.list;
    }

    /**
     * Diese Methode setzt den derzeitigen WortEintrag
     *
     * @param currWortEintrag
     */
    public void setCurrent(WortEintrag currWortEintrag) {
        this.currWortEintrag = currWortEintrag;
    }

    /**
     * Diese Methode überprüft die Antwort des Benutzers
     * 1. Besteht die Antwort nur aus Buchstaben?
     * 2. Stimmt die Antwort mit der Lösung überein?
     *
     * @param input
     */
    public void checkAnswer(String input) {
        if(input.length() < 2) throw new IllegalArgumentException("Zu kurze Eingabe!");
        for(int i = 0; i < input.length(); i++) {
            if (!((input.charAt(i) >= 65 && input.charAt(i) <= 90 || (input.charAt(i) >= 97 && input.charAt(i) <= 122)))) {
                throw new IllegalArgumentException("Ungültige Eingabe!");
            }
        }
        answer++;

        if(input.equalsIgnoreCase(currWortEintrag.getWort())) {
            correct++;
            this.getRndEintrag();
        } else {
            throw new IllegalArgumentException("Die Antwort ist nicht korrekt!");
        }
    }

    /**
     * Diese Methode gibt den WortTrainer als String zurück
     *
     * @return WortTrainer als String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Wort Nr.: ").append(answer).append("\n");
        sb.append("Korrekt: ").append(correct).append("\n");
        sb.append("Inkorrekt: ").append(answer-correct).append("\n");

        return sb.toString();
    }
}
