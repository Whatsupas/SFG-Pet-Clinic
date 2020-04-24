package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final PetService petService;

    private final VisitService visitService;

    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, VisitService visitService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.visitService = visitService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        boolean isEmpty = petTypeService.findAll().isEmpty();

        if (isEmpty){
            LoadData();
        }

    }

    private void LoadData() {
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

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);


        System.out.println("Loaded owners ....");

        // Adding vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Exe");

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Radiology");
        specialityService.save(speciality1);

        vet1.setSpeciality(speciality1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Surgery");
        specialityService.save(speciality2);

        vet2.setSpeciality(speciality2);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Roger");
        vet3.setLastName("Smith");

        Speciality speciality3 = new Speciality();
        speciality3.setDescription("Dentistry");
        specialityService.save(speciality3);

        vet3.setSpeciality(speciality3);
        vetService.save(vet3);

        System.out.println("Loaded vets ....");
    }
}