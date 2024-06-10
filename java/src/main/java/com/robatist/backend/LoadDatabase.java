package com.robatist.backend;

import com.robatist.backend.auth.AuthenticationResponse;
import com.robatist.backend.auth.AuthenticationService;
import com.robatist.backend.auth.RegisterRequest;
import com.robatist.backend.domain.Explication;
import com.robatist.backend.domain.StudyArea;
import com.robatist.backend.domain.user.Admin;
import com.robatist.backend.domain.user.Manager;
import com.robatist.backend.domain.user.Teacher;
import com.robatist.backend.domain.user.User;
import com.robatist.backend.repository.ExplicationRepository;
import com.robatist.backend.repository.StudyAreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.robatist.backend.domain.user.Role.*;

@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    private final User user1 = new Teacher("André", "Mateus", "andre@email.pt", "password", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, USER);
    private final User user2 = new Teacher("Francisco", "Silva", "francisco@email.pt", "password", 19, "333222111", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, USER);

    private final StudyArea studyArea1 = new StudyArea("Informatique", "Informatique description");
    private final StudyArea studyArea2 = new StudyArea("Economy", "Economy description");

    @Bean
    CommandLineRunner loadAdmin(AuthenticationService authenticationService) {
        return args -> {
            final User user = new Admin("Rodrigo", "Batista", "rodrigo@email.pt", "password", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, ADMIN);

            var admin = RegisterRequest.builder()
                    .user(user)
                    .build();

            AuthenticationResponse authenticationResponse = authenticationService.register(admin);
            LOGGER.info("Admin (Token) : " + authenticationResponse.getAccessToken());
        };
    }

    @Bean
    CommandLineRunner loadManager(AuthenticationService authenticationService) {
        return args -> {
            final User user = new Manager("Gonçalo", "Batista", "goncalo@email.pt", "password", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, MANAGER);

            var manager = RegisterRequest.builder()
                    .user(user)
                    .build();

            AuthenticationResponse authenticationResponse = authenticationService.register(manager);
            LOGGER.info("Manager (Token) : " + authenticationResponse.getAccessToken());
        };
    }

    @Bean
    CommandLineRunner loadUsers(AuthenticationService authenticationService) {
        return args -> {
            var registerRequest1 = RegisterRequest.builder()
                    .user(user1)
                    .build();
            LOGGER.info("User1 (Token) : " + authenticationService.register(registerRequest1).getAccessToken());

            var registerRequest2 = RegisterRequest.builder()
                    .user(user2)
                    .build();
            LOGGER.info("User2 (Token) : " + authenticationService.register(registerRequest2).getAccessToken());
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
