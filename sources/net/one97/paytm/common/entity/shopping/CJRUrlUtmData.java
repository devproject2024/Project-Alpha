package net.one97.paytm.common.entity.shopping;

import java.util.LinkedList;
import java.util.Queue;

public class CJRUrlUtmData {
    private boolean fromPush = false;
    private String utmCampaign;
    private String utmContent;
    private String utmMedium;
    private Queue<String> utmSource = new LinkedList();
    private String utmTerm;

    public String getUtmSource() {
        return convertListToString(this.utmSource);
    }

    public void addToUtmSource(String str) {
        this.utmSource.add(str);
        if (this.utmSource.size() > 5) {
            this.utmSource.remove();
        }
    }

    public String getUtmMedium() {
        return this.utmMedium;
    }

    public void setUtmMedium(String str) {
        this.utmMedium = str;
    }

    public String getUtmTerm() {
        return this.utmTerm;
    }

    public void setUtmTerm(String str) {
        this.utmTerm = str;
    }

    public String getUtmCampaign() {
        return this.utmCampaign;
    }

    public void setUtmCampaign(String str) {
        this.utmCampaign = str;
    }

    public String getUtmContent() {
        return this.utmContent;
    }

    public void setUtmContent(String str) {
        this.utmContent = str;
    }

    public boolean isFromPush() {
        return this.fromPush;
    }

    public void setFromPush(boolean z) {
        this.fromPush = z;
    }

    private String convertListToString(Queue<String> queue) {
        StringBuilder sb = new StringBuilder("");
        for (String append : queue) {
            sb.append(append);
            sb.append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
