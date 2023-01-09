package com.springbootfast.model;

public class Country {
    private String name;
    private long population;

    public static Country of(String name, long population) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
