package de.start.knower.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
public class Recipe implements Serializable {
    
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne()
    private Flavor flavor;
    private String myMixture;
    private String notice;

    public Recipe() {
    }

    public Recipe(User user, Flavor flavor, String myMixture, String notice) {
        this.user = user;
        this.flavor = flavor;
        this.myMixture = myMixture;
        this.notice = notice;
    }
    
    public String noticeShortened () {
        if (notice.length() <=20) return notice;
        return notice.substring(0, 20);
    }
    
    
    
    
    

}
