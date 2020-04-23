package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Robertas Tutlys on 2020-03-27
 */
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{

    @Column(name ="description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
