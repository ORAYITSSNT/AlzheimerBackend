package ma.wafae.ta3aounyati;

import ma.wafae.ta3aounyati.dto.requests.UserRequest;
import ma.wafae.ta3aounyati.dto.responses.UserResponse;
import ma.wafae.ta3aounyati.repositories.UserRepository;
import ma.wafae.ta3aounyati.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ta3aounyatiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ta3aounyatiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, UserRepository userRepository) {
        return args -> {
            UserRequest user = new UserRequest("Abdessalam",
                    "Abdessalam@1234",
                    "abdessalam@gmail.com",
                    "Abdessalam Yassine",
                    "https://pbs.twimg.com/profile_images/1651880493942538240/MzoTuhcJ_400x400.jpg",
                    65,"Doctor",
                    "Reading, Walking in the park, Listening to classical music, Watching nature documentaries, Painting",
                    "Loud noises, Crowded places, Spicy food, Cold weather, Watching horror movies",
                    "Peanuts, Pollen, Dust, Cat fur, Shellfish");
            if (userRepository.findByEmail(user.getEmail()) == null){
                UserResponse response = userService.add(user);
                userService.ActivateOrDeactivateUser(response.getId());
            }
        };
    }

}