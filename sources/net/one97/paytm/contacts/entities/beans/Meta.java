package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Meta extends IJRPaytmDataModel implements IJRDataModel {
    private String image;
    PhoneDTO phoneDto;

    public PhoneDTO getPhoneDto() {
        return this.phoneDto;
    }

    public void setPhoneDto(PhoneDTO phoneDTO) {
        this.phoneDto = phoneDTO;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
