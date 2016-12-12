package cat.tecnocampus.domain;

/**
 * Created by roure on 14/11/2016.
 */
public class Station {

    private String nom;

    private String longitud;
    private String latitud;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        return nom.equals(station.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return "Station{" +
                ", nom='" + nom + '\'' +
                ", longitud='" + longitud + '\'' +
                ", latitud='" + latitud + '\'' +
                '}';
    }
}
