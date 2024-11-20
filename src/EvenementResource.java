
import java.util.ArrayList;

@Path("evenements")
public class EvenementResource {

    @Context
    private UriInfo context;
    private List<Evenement> evenements = new ArrayList<>();
    private int nextId = 1; // Pour générer des IDs uniques

    public EvenementResource() {
        // Ajouter quelques événements par défaut pour les tests
        evenements.add(new Evenement(nextId++, "Concert", "Concert de rock", new Date(), "Stade"));
        evenements.add(new Evenement(nextId++, "Conférence", "Conférence sur la technologie", new Date(), "Salle de conférence"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evenement> getEvenements() {
        return evenements;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Evenement getEvenement(@PathParam("id") int id) {
        return evenements.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Événement non trouvé"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Evenement createEvenement(Evenement evenement) {
        ajouterEvenement(evenement.getTitre(), evenement.getDescription(), evenement.getDateEvent(), evenement.getLieu());
        return evenement;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Evenement updateEvenement(@PathParam("id") int id, Evenement updatedEvenement) {
        for (Evenement evenement : evenements) {
            if (evenement.getId() == id) {
                evenement.setTitre(updatedEvenement.getTitre());
                evenement.setDescription(updatedEvenement.getDescription());
                evenement.setDateEvent(updatedEvenement.getDateEvent());
                evenement.setLieu(updatedEvenement.getLieu());
                return evenement;
            }
        }
        throw new NotFoundException("Événement non trouvé");
    }

    
    @DELETE
    @Path("{id}")
    public void deleteEvenement(@PathParam("id") int id) {
        evenements.removeIf(evenement -> evenement.getId() == id);
    }
}