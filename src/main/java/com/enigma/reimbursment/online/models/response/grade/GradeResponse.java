package com.enigma.reimbursment.online.models.response.grade;

public class GradeResponse {

    private String id;

    private Integer grade;

    private Integer glasessCost;

    private Integer giveBirthCost;

    private Integer hotelCost;

    private Integer transportationCost;

    private Integer mealCost;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GradeResponse{" +
                "id='" + id + '\'' +
                ", grade=" + grade +
                ", glasessCost=" + glasessCost +
                ", giveBirthCost=" + giveBirthCost +
                ", hotelCost=" + hotelCost +
                ", transportationCost=" + transportationCost +
                ", mealCost=" + mealCost +
                '}';
    }
}
