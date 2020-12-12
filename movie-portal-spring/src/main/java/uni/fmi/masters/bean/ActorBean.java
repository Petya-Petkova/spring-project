package uni.fmi.masters.bean;

import javax.persistence.*;


@Entity
@Table(name ="actors")
public class ActorBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actorId")
    private int id;
    
    @Column(name = "name")
    private String name;

    public ActorBean() {
    }

    public ActorBean(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}