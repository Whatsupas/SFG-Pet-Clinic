package guru.springframework.sfgpetclinic.model;

/**
 * Created by Robertas Tutlys on 2020-03-27
 */
public class Speciality extends BaseEntity{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}