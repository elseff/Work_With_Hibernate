package com.elseff.entity;

import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "company_id_gen", sequenceName = "company_id_seq_new", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_gen")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyCar> cars;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "dateOfCreation = " + new SimpleDateFormat("yyyy-MM-dd")
                .format(dateOfCreation) + ")";
    }
}
