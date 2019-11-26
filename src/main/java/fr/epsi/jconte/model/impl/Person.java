package fr.epsi.jconte.model.impl;

import fr.epsi.jconte.model.IPerson;

public class Person implements IPerson {

    private Long id;

    private double wealth;

    public Person(Long id, double wealth) {
        this.id = id;
        this.wealth = wealth;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public double getWealth() {
        return this.wealth;
    }

    @Override
    public void setWealth(double wealth) {
        this.wealth = wealth;
    }
}
