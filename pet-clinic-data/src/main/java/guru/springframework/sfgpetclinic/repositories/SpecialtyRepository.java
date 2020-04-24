package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Robertas Tutlys on 2020-04-24
 */
public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {

}
