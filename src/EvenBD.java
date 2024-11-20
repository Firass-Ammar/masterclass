import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvenBD {
    private static List<Evenement> evenements = new ArrayList<>();

    static {
        // Ajouter quelques événements par défaut pour les tests
        evenements.add(new Evenement(1, "Concert", "Concert de rock", new Date(), "Stade"));
        evenements.add(new Evenement(2, "Conférence", "Conférence sur la technologie", new Date(), "Salle de conférence"));
    }

    public static List<Evenement> getEvenements() {
        return evenements;
    }
}