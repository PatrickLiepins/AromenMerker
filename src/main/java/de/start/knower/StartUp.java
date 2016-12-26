package de.start.knower;

import de.start.knower.model.Flavor;
import de.start.knower.model.Producer;
import de.start.knower.model.Recipe;
import de.start.knower.model.User;
import de.start.knower.repository.FlavorRepository;
import de.start.knower.repository.ProducerRepository;
import de.start.knower.repository.RecipeRepository;
import de.start.knower.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {

    private final FlavorRepository flavorRepository;
    private final ProducerRepository producerRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public StartUp(FlavorRepository flavorRepository, ProducerRepository producerRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.flavorRepository = flavorRepository;
        this.producerRepository = producerRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Producer mompop = new Producer("Mom&Pop");
        Producer owl = new Producer("OWL");
        Producer vampire = new Producer("Vampire Vape");
        
        Flavor cryptonite = new Flavor("Cryptonite II", owl, 5, 5.45);
        Flavor calipitter = new Flavor("Calipitter Chow", mompop, 10, 5.45);
        Flavor heisenberg = new Flavor("Heisenberg", vampire, 15, 14.99);
        
        producerRepository.save(mompop);
        producerRepository.save(owl);
        producerRepository.save(vampire);
        
        flavorRepository.save(cryptonite);
        flavorRepository.save(calipitter);
        flavorRepository.save(heisenberg);
        
        User patrick = new User("Patrick");
        userRepository.save(patrick);
        
        Recipe recipecalipper 
                = recipeRepository.save(new Recipe(patrick, calipitter, "12", "the next time with 112 percent mixture"));
        Recipe recipecryptonite
                = recipeRepository.save(new Recipe(patrick, cryptonite, "5", "5 percent is perfect and the flavor gets 5 of 5 stars"));
        patrick.getRecipes().add(recipecalipper);
        patrick.getRecipes().add(recipecryptonite);
        
        
        
        
        
    }

}
