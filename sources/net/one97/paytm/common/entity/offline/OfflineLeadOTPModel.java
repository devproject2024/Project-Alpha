package net.one97.paytm.common.entity.offline;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class OfflineLeadOTPModel extends IJRPaytmDataModel implements IJRDataModel {
    public String cgcp_offline_header;
    public String message;
    public OTPConfig otp_config;
    public String responseCode;
    public String status = "";
    public String ud_map;

    public class OTPConfig {
        public long epoch_time;
        public int time_interval = 60;

        public OTPConfig() {
        }
    }
}
