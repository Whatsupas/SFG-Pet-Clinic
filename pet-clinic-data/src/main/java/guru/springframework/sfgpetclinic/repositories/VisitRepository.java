package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Robertas Tutlys on 2020-04-24
 */
public interface VisitRepository extends CrudRepository<Visit,Long> {

}
