package com.elseff.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_car")
public class CompanyCar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    private Employee owner;

    @Column(name = "model")
    private String model;

    @Column(name = "date_of_release")
    private Date dateOfRelease;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public void setOwner(Employee employee) {
        this.owner = employee;
        employee.setCar(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyCar that = (CompanyCar) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean hasOwner() {
        return getOwner() != null;
    }
}
