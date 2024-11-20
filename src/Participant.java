public class Participant {
    private int id;
    private String nom;
    private String email;
    private int evenementId;

    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEvenementId() {
		return evenementId;
	}


	public void setEvenementId(int evenementId) {
		this.evenementId = evenementId;
	}


	public Participant(int id, String nom, String email, int evenementId) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.evenementId = evenementId;
    }

    
}