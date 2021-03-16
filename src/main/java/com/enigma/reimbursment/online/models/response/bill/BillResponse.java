package com.enigma.reimbursment.online.models.response.bill;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.web.multipart.MultipartFile;

public class BillResponse {

    private String id;
    private MultipartFile billImage;
    private String reimbursementId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MultipartFile getBillImage() {
        return billImage;
    }

    public void setBillImage(MultipartFile billImage) {
        this.billImage = billImage;
    }

    public String getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(String reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}
