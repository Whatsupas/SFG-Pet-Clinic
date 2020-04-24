package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Robertas Tutlys on 2020-04-24
 */
public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
    Set<Owner> findAll();
}
