package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="grade")
public class Grade {

    @Id
    @GenericGenerator(name="id_grade",strategy = "uuid2")
    @GeneratedValue(generator = "id_grade",strategy = GenerationType.IDENTITY)
    private String id;
    private Integer numgrade;
    private Integer glasessCost;
    private Integer giveBirthCost;
    private Integer hotelCost;
    private Integer transportationCost;
    private Integer mealCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumgrade() {
        return numgrade;
    }

    public void setNumgrade(Integer numgrade) {
        this.numgrade = numgrade;
    }

    public Integer getGlasessCost() {
        return glasessCost;
    }

    public void setGlasessCost(Integer glasessCost) {
        this.glasessCost = glasessCost;
    }

    public Integer getGiveBirthCost() {
        return giveBirthCost;
    }

    public void setGiveBirthCost(Integer giveBirthCost) {
        this.giveBirthCost = giveBirthCost;
    }

    public Integer getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(Integer hotelCost) {
        this.hotelCost = hotelCost;
    }

    public Integer getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(Integer transportationCost) {
        this.transportationCost = transportationCost;
    }

    public Integer getMealCost() {
        return mealCost;
    }

    public void setMealCost(Integer mealCost) {
        this.mealCost = mealCost;
    }
}
