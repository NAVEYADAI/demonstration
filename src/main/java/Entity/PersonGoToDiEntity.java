package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person_go_to_di", schema = "public", catalog = "demonstration")
public class PersonGoToDiEntity {
    private int id;
    private int idDemons;
    private int idPersonalDitels;

    @Override
    public String toString() {
        return "PersonGoToDiEntity{" +
                "id=" + id +
                ", idDemons=" + idDemons +
                ", idPersonalDitels=" + idPersonalDitels +
                '}';
    }

    public PersonGoToDiEntity() {
    }

    public PersonGoToDiEntity(int idDemons, int idPersonalDitels) {
        this.idDemons = idDemons;
        this.idPersonalDitels = idPersonalDitels;
    }

    public PersonGoToDiEntity(int id, int idDemons, int idPersonalDitels) {
        this.id = id;
        this.idDemons = idDemons;
        this.idPersonalDitels = idPersonalDitels;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_demons", nullable = false)
    public int getIdDemons() {
        return idDemons;
    }

    public void setIdDemons(int idDemons) {
        this.idDemons = idDemons;
    }

    @Basic
    @Column(name = "id_personal_ditels", nullable = false)
    public int getIdPersonalDitels() {
        return idPersonalDitels;
    }

    public void setIdPersonalDitels(int idPersonalDitels) {
        this.idPersonalDitels = idPersonalDitels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonGoToDiEntity that = (PersonGoToDiEntity) o;

        if (id != that.id) return false;
        if (idDemons != that.idDemons) return false;
        if (idPersonalDitels != that.idPersonalDitels) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idDemons;
        result = 31 * result + idPersonalDitels;
        return result;
    }
}
