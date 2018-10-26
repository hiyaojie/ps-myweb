package com.blog.model;

import javax.persistence.*;

public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer salary;

    private Integer managerid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * @return managerid
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * @param managerid
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }
}