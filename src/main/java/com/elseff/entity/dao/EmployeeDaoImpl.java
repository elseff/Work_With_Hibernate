package com.elseff.entity.dao;

import com.elseff.entity.Employee;
import com.elseff.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        @Cleanup Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.get(Employee.class, id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Employee> list = session.createQuery("select e from Employee e", Employee.class)
                .getResultList();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee updateEmployee = (Employee) session.merge(employee);
        session.getTransaction().commit();
        return updateEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
    }
}
