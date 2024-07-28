package net.one97.paytm.fastag.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class OeLeadRequest extends IJRPaytmDataModel {
    private SolutionAdditionalMetaData solutionAdditionalMetaData;
    private ArrayList<SolutionDocuments> solutionDocuments;

    public SolutionAdditionalMetaData getSolutionAdditionalMetaData() {
        return this.solutionAdditionalMetaData;
    }

    public void setSolutionAdditionalMetaData(SolutionAdditionalMetaData solutionAdditionalMetaData2) {
        this.solutionAdditionalMetaData = solutionAdditionalMetaData2;
    }

    public ArrayList<SolutionDocuments> getSolutionDocuments() {
        return this.solutionDocuments;
    }

    public void setSolutionDocuments(ArrayList<SolutionDocuments> arrayList) {
        this.solutionDocuments = arrayList;
    }

    public String toString() {
        return "ClassPojo [solutionAdditionalMetaData = " + this.solutionAdditionalMetaData + ", solutionDocuments = " + this.solutionDocuments + "]";
    }
}
