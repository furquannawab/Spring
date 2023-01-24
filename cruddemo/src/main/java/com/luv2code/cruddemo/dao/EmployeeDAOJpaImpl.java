package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
       Employee employee1 = entityManager.merge(employee);
       employee.setId(employee1.getId());
    }

    @Override
    public void delete(int id) {
        Query theQuery =
                entityManager.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();
    }
}
