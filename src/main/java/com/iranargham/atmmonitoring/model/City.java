package com.iranargham.atmmonitoring.model;

import java.util.Objects;

public class City {

    private Long id;
    private String name;
    private int population;

    public City(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
    //regain begin

    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public int getPopulation() {
        return population;
    }

    public City setPopulation(int population) {
        this.population = population;
        return this;
    }

    //end

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population &&
                Objects.equals(id, city.id) &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }
}
