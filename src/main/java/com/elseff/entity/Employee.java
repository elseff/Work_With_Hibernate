package com.elseff.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee", schema = "public")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "employee_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_id_seq", allocationSize = 1)
    private Long id;

    //Consists of the first_name, last_name and date_of_birth fields
    @Embedded
    private EmployeePersonalInfo info;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "company_car_id")
    private CompanyCar car;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "info = " + info.toString() + ", " +
                "gender = " + gender + ", " +
                "email = " + email + ", " +
                "country = " + country + ")";
    }

    public void setCar(CompanyCar car) {
        if (getCompany().getName().equals(car.getCompany().getName())) {
            if (!car.hasOwner()) {
                this.car = car;
                car.setOwner(this);
            } else {
                log.error("{} [{}] already have a owner!", car.getModel(), car.getOwner().getInfo().getFirstName());
            }
        } else {
            log.error("this company doesn't have this car!");
        }
    }
}
