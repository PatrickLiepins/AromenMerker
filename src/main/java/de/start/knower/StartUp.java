package de.start.knower;

import de.start.knower.model.Flavor;
import de.start.knower.model.Producer;
import de.start.knower.model.User;
import de.start.knower.repository.FlavorRepository;
import de.start.knower.repository.ProducerRepository;
import de.start.knower.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {

    private final FlavorRepository flavorRepository;
    private final ProducerRepository producerRepository;
    private final UserRepository userRepository;

    public StartUp(FlavorRepository flavorRepository, ProducerRepository producerRepository, UserRepository userRepository) {
        this.flavorRepository = flavorRepository;
        this.producerRepository = producerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Producer mompop = new Producer("Mom&Pop");
        Producer owl = new Producer("OWL");
    
        Flavor cryptonite = new Flavor("Cryptonite II", owl, 5, 5.45);
        Flavor calipitter = new Flavor("Calipitter Chow", mompop, 10, 5.45);
        
        producerRepository.save(mompop);
        producerRepository.save(owl);
        
        flavorRepository.save(cryptonite);
        flavorRepository.save(calipitter);
        
        User patrick = new User("Patrick");
        patrick.getFlavors().add(calipitter);
        patrick.getFlavors().add(cryptonite);
        userRepository.save(patrick);
        
        
        
    }

}
