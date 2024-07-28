package net.one97.paytm.common.entity.cst;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTNavEngineNoOp extends IJRPaytmDataModel implements IJRDataModel {
    private String node_id;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getNodeId() {
        return this.node_id;
    }

    public void setNodeId(String str) {
        this.node_id = str;
    }
}
