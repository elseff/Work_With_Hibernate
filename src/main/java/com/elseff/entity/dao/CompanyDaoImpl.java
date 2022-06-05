package com.elseff.entity.dao;

import com.elseff.entity.Company;
import com.elseff.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao {
    private final SessionFactory sessionFactory;

    public CompanyDaoImpl() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public Optional<Company> getCompanyByName(String name) {
        @Cleanup Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.createQuery("select c from Company c where name=:companyName", Company.class)
                .setParameter("companyName", name).getSingleResult());
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        @Cleanup Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.get(Company.class, id));
    }

    @Override
    public List<Company> getAllCompanies() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Company> list = session.createQuery("select e from Company e", Company.class)
                .getResultList();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Company addCompany(Company company) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        return company;
    }

    @Override
    public void deleteCompany(Long id) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
    }
}
