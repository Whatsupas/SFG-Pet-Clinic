package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Adding pet types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types ....");

        // Adding owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("6654 Country Club Rd");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("989784564561");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("5944 Saddle Dr");
        owner2.setCity("New York");
        owner2.setTelephone("1221274545");

        // Adding pets to Owners
        Pet pet1 = new Pet();
        LocalDate birthDate = LocalDate.of(2014,11,12);
        pet1.setBirthDate(birthDate);
        pet1.setPetType(savedDogPetType);
        pet1.setName("Shadow");
        pet1.setOwner(owner1);
        owner1.setPet(pet1);
        ownerService.save(owner1);

        Pet pet2 = new Pet();
        LocalDate birthDate2 = LocalDate.of(2017,01,11);
        pet2.setBirthDate(birthDate2);
        pet2.setPetType(savedCatPetType);
        pet2.setName("Just Cat");
        pet2.setOwner(owner2);
        owner2.setPet(pet2);
        ownerService.save(owner2);

        System.out.println("Loaded owners ....");

        // Adding vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Exe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Roger");
        vet3.setLastName("Smith");
        vetService.save(vet3);

        System.out.println("Loaded vets ....");
    }
}