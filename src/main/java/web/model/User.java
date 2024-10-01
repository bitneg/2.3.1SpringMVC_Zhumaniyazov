package web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@NotEmpty(message = "имя не должно быть пустым")
@Size(min = 2, max = 30, message = "длина имени должна быть в диапазоне от 2 до 30")
    private String name;


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
}