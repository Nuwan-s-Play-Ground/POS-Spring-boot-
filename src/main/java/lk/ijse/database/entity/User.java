package lk.ijse.database.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    // public long getId() {
    //     return id;
    // }

    // public String getUserName() {
    //     return userName;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setId(long id) {
    //     this.id = id;
    // }

    // public void setUserName(String userName) {
    //     this.userName = userName;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    
}
