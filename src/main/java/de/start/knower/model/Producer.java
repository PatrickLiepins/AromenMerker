package de.start.knower.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString 
public class Producer implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "producer")
    private final Set<Flavor> flavors = new HashSet<>();

    public Producer(String name) {
        this.name = name;
    }

    public Producer() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Producer other = (Producer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    

}
