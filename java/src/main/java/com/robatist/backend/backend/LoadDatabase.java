package com.robatist.backend.backend;

import com.robatist.backend.backend.domain.Explication;
import com.robatist.backend.backend.domain.StudyArea;
import com.robatist.backend.backend.domain.user.Teacher;
import com.robatist.backend.backend.domain.user.User;
import com.robatist.backend.backend.repository.ExplicationRepository;
import com.robatist.backend.backend.repository.StudyAreaRepository;
import com.robatist.backend.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    private final User user1 = new Teacher("Rodrigo", "Batista", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true);
    private final User user2 = new Teacher("Gonçalo", "Batista", 19, "333222111", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true);

    private final StudyArea studyArea1 = new StudyArea("Informatique", "Informatique description");
    private final StudyArea studyArea2 = new StudyArea("Economy", "Economy description");

    @Bean
    CommandLineRunner loadUsers(UserRepository userRepository) {
        return args -> {
            LOGGER.info("Preloading " + userRepository.save(user1));
            LOGGER.info("Preloading " + userRepository.save(user2));
        };
    }

    @Bean
    CommandLineRunner loadStudyAreas(StudyAreaRepository studyAreaRepository) {
        return args -> {
            LOGGER.info("Preloading " + studyAreaRepository.save(studyArea1));
            LOGGER.info("Preloading " + studyAreaRepository.save(studyArea2));
        };
    }

    @Bean
    CommandLineRunner loadExplications(ExplicationRepository explicationRepository) {
        return args -> {
            LOGGER.info("Preloading " + explicationRepository.save(new Explication("Explication 1", "Explication 1 description", studyArea1, true, user1, true)));
            LOGGER.info("Preloading " + explicationRepository.save(new Explication("Explication 2", "Explication 2 description", studyArea2, true, user2, true)));
        };
    }

}
