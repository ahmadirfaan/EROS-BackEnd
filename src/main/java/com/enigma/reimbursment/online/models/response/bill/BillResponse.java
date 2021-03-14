package com.enigma.reimbursment.online.models.response.bill;

import com.enigma.reimbursment.online.entities.Reimbursement;
import org.springframework.web.multipart.MultipartFile;

public class BillResponse {
    private MultipartFile billImage;
    private String reimbursementId;

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
