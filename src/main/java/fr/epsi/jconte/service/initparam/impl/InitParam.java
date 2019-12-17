package fr.epsi.jconte.service.initparam.impl;

import fr.epsi.jconte.service.initparam.IInitParam;

/**
 * Abstract class that provides the minimum properties and methods used when initializing parameters.
 */
public abstract class InitParam implements IInitParam {

    protected int numberOfPersons;
    protected int mean;
    protected int deviation;
    protected int numberOfIterations;

    @Override
    public int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    @Override
    public int getMean() {
        return this.mean;
    }

    @Override
    public int getDeviation() {
        return this.deviation;
    }

    @Override
    public int getNumberOfIterations() {
        return this.numberOfIterations;
    }
}
