package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Grade {

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "glasess_cost")
    private Integer glasessCost;
    @Column(name = "give_birth_cost")
    private Integer giveBirthCost;
    @Column(name = "hotel_cost")
    private Integer hotelCost;
    @Column(name = "transportation_cost")
    private Integer transportationCost;
    @Column(name = "meal_cost")
    private Integer mealCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer numgrade) {
        this.grade = numgrade;
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
