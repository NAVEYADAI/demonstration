package Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "demonstration", schema = "public", catalog = "demonstration")
public class DemonstrationEntity {
    private int id;
    private String subject;
    private Date dateOfDis;
    private String micoom;

    public DemonstrationEntity() {
    }

    public DemonstrationEntity(String subject, String micoom) {
        this.subject = subject;
        this.micoom = micoom;
    }

    public DemonstrationEntity(int id, String subject, Date dateOfDis, String micoom) {
        this.id = id;
        this.subject = subject;
        this.dateOfDis = dateOfDis;
        this.micoom = micoom;
    }

    public DemonstrationEntity(String subject, Date dateOfDis, String micoom) {
        this.subject = subject;
        this.dateOfDis = dateOfDis;
        this.micoom = micoom;
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
    @Column(name = "subject", nullable = false, length = -1)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "date_of_dis", nullable = false)
    public Date getDateOfDis() {
        return dateOfDis;
    }

    public void setDateOfDis(Date dateOfDis) {
        this.dateOfDis = dateOfDis;
    }

    @Basic
    @Column(name = "micoom", nullable = false, length = -1)
    public String getMicoom() {
        return micoom;
    }

    public void setMicoom(String micoom) {
        this.micoom = micoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemonstrationEntity that = (DemonstrationEntity) o;

        if (id != that.id) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (dateOfDis != null ? !dateOfDis.equals(that.dateOfDis) : that.dateOfDis != null) return false;
        if (micoom != null ? !micoom.equals(that.micoom) : that.micoom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (dateOfDis != null ? dateOfDis.hashCode() : 0);
        result = 31 * result + (micoom != null ? micoom.hashCode() : 0);
        return result;
    }
}
