package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerID;
    String lastName;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = Owner.ownerBuilder().lastName("TestName").pets(new HashSet<>()).build();
        Owner savedOwner = ownerMapService.save(owner);
        this.ownerID = savedOwner.getId();
        this.lastName = savedOwner.getLastName();
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);
        assertEquals(ownerID,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = this.ownerID;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastNameFound() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}