package net.one97.paytm.common.entity.upgradeKyc;

public class LikeDislikeRequestModal {
    public String channel = "";
    public String ipAddress = "127.0.0.1";
    public String platformName = FetchCashPointRequestModal.PLATFORM_NAME;
    public Request request;
    public String version = "";

    public class Request {
        public String terminalId;

        public Request() {
        }
    }
}
