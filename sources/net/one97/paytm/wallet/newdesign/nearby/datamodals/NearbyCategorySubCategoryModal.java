package net.one97.paytm.wallet.newdesign.nearby.datamodals;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class NearbyCategorySubCategoryModal extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "orderId")
    @a
    private Object orderId;
    @c(a = "requestGuid")
    @a
    private Object requestGuid;
    @c(a = "response")
    @a
    private Response response;
    @c(a = "status")
    @a
    private String status;
    @c(a = "statusCode")
    @a
    private String statusCode;
    @c(a = "statusMessage")
    @a
    private String statusMessage;

    public Object getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(Object obj) {
        this.requestGuid = obj;
    }

    public Object getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Object obj) {
        this.orderId = obj;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public static class CategoryDetail implements Serializable {
        @c(a = "categoryName")
        @a
        private String categoryName;
        @c(a = "subCategoryDetails")
        @a
        private List<SubCategoryDetail> subCategoryDetails = new ArrayList();

        public String getCategoryName() {
            return this.categoryName;
        }

        public void setCategoryName(String str) {
            this.categoryName = str;
        }

        public List<SubCategoryDetail> getSubCategoryDetails() {
            return this.subCategoryDetails;
        }

        public void setSubCategoryDetails(List<SubCategoryDetail> list) {
            this.subCategoryDetails = list;
        }
    }

    public class Response {
        @c(a = "categoryDetails")
        @a
        private ArrayList<CategoryDetail> categoryDetails = new ArrayList<>();

        public Response() {
        }

        public ArrayList<CategoryDetail> getCategoryDetails() {
            return this.categoryDetails;
        }

        public void setCategoryDetails(ArrayList<CategoryDetail> arrayList) {
            this.categoryDetails = arrayList;
        }
    }

    public class SubCategoryDetail implements Serializable {
        @c(a = "logoUrl")
        @a
        private String logoUrl;
        @c(a = "subCategoryName")
        @a
        private String subCategoryName;

        public SubCategoryDetail() {
        }

        public String getSubCategoryName() {
            return this.subCategoryName;
        }

        public void setSubCategoryName(String str) {
            this.subCategoryName = str;
        }

        public String getLogoUrl() {
            return this.logoUrl;
        }

        public void setLogoUrl(String str) {
            this.logoUrl = str;
        }
    }
}
