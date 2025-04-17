package net.DANOUN.hopital;

import net.DANOUN.hopital.entities.Patient;
import net.DANOUN.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Patient 1 - constructeur vide + setters
        Patient patient1 = new Patient();
        patient1.setId(null);
        patient1.setName("WALID");
        patient1.setMalade(true);
        patient1.setDateOfBirth(new Date());
        patient1.setScore(111);

        // Patient 2 - constructeur avec paramètres
        Patient patient2 = new Patient(null, "SALAHEDDINE", new Date(), false, 200);

        // Patient 3 - builder
        Patient patient3 = Patient.builder()
                .name("SA")
                .dateOfBirth(new Date())
                .malade(true)
                .score(22)
                .build();


        Patient patient4 = new Patient(null, "Nassrollah", new Date(), false, 88);


        Patient patient5 = Patient.builder()
                .name("Laghouviz")
                .dateOfBirth(new Date())
                .malade(true)
                .score(150)
                .build();

        // Sauvegarde
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);
    }
}
