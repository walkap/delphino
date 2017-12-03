package Entity.Users;

/**This is a generic structure for a User in own application
 * It will be finished in next iteration
 */

public class User {
    private int ID;
    private String nome;
    private String cognome;

    public User(int ID, String nome, String cognome){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
