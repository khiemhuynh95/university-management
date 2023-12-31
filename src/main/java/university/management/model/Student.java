package university.management.model;

import java.time.LocalDate;
import javax.persistence.*;
/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Persistence entity that represents a student, registered at the university
 */

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 60, nullable = false)
    private String firstName;
    
    @Column(length = 60, nullable = false)
    private String lastName;
    
    @Column(length = 60, nullable = false, unique = true)
    private String email;

    private LocalDate dateOfBirth;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private LearnerProfile learnerProfile;
    
    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.learnerProfile = new LearnerProfile((short) LocalDate.now().getYear());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public LearnerProfile getLearnerProfile() {
        return learnerProfile;
    }
}
