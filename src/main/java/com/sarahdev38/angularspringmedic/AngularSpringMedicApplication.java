package com.sarahdev38.angularspringmedic;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.sarahdev38.angularspringmedic.model.Patient;
import com.sarahdev38.angularspringmedic.model.Praticien;
import com.sarahdev38.angularspringmedic.model.Consultation;
import com.sarahdev38.angularspringmedic.repository.PatientRepository;
import com.sarahdev38.angularspringmedic.repository.PraticienRepository;
import com.sarahdev38.angularspringmedic.repository.ConsultationRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AngularSpringMedicApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularSpringMedicApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner init(PraticienRepository praticienRepository, PatientRepository patientRepository,
            ConsultationRepository consultationRepository) {

        LocalDateTime currentDate = LocalDateTime.now();
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(nom -> {
                Praticien praticien = new Praticien(nom, "Dr " + nom);
                praticien = praticienRepository.save(praticien);

                Patient patient = new Patient("patient " + nom + nom, "prénom " + nom, new Date());
                patient = patientRepository.save(patient);

                Consultation consultation = new Consultation("consultation de " + nom, "Rendez-vous de " + nom,
                        currentDate.plusHours(nom.length()),
                        currentDate.plusHours(nom.length() + 1L), false);
                praticien.addConsultation(consultation);
                patient.addConsultation(consultation);
                consultation = consultationRepository.save(consultation);
            });

        };
    }
}
