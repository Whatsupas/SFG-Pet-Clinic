package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Robertas Tutlys on 2020-04-24
 */
public interface PetTypeRepository extends CrudRepository<PetType,Long> {

}
