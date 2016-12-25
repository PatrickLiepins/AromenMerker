package de.start.knower.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
public class Flavor implements Serializable {
    
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne()
    private Producer producer;
    private int mixture;
    private double price;

    public Flavor(String name, Producer producer, int mixture, double price) {
        this.name = name;
        this.producer = producer;
        this.mixture = mixture;
        this.price = price;
    }

    

    public Flavor() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flavor other = (Flavor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
