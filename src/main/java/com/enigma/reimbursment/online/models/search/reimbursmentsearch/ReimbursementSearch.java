package com.enigma.reimbursment.online.models.search.reimbursmentsearch;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.models.pagination.PageSearch;

import java.util.Date;

public class ReimbursementSearch extends PageSearch {


    private String dateOfClaimSubmission;

    public String getDateOfClaimSubmission() {
        return dateOfClaimSubmission;
    }

    public void setDateOfClaimSubmission(String dateOfClaimSubmission) {
        this.dateOfClaimSubmission = dateOfClaimSubmission;
    }
}
