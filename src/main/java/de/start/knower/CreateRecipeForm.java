package de.start.knower;

import de.start.knower.model.Flavor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CreateRecipeForm {
    
    private Long recipeId;
    private Long flavorId;
    private String myMixture;

    public CreateRecipeForm() {
    }
    
    
    
    

}
