package com.alipay.mobile.nebulacore.wallet;

import java.util.List;

public class H5LoggerSwitchModel {
    private String output;
    private List<RulesBean> rules;

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String str) {
        this.output = str;
    }

    public List<RulesBean> getRules() {
        return this.rules;
    }

    public void setRules(List<RulesBean> list) {
        this.rules = list;
    }

    public static class RulesBean {
        private String lid;
        private String output;
        private RangeBean range;

        public String getLid() {
            return this.lid;
        }

        public void setLid(String str) {
            this.lid = str;
        }

        public RangeBean getRange() {
            return this.range;
        }

        public void setRange(RangeBean rangeBean) {
            this.range = rangeBean;
        }

        public String getOutput() {
            return this.output;
        }

        public void setOutput(String str) {
            this.output = str;
        }

        public static class RangeBean {
            private String appId;
            private String publicId;
            private String url;

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public String getAppId() {
                return this.appId;
            }

            public void setAppId(String str) {
                this.appId = str;
            }

            public String getPublicId() {
                return this.publicId;
            }

            public void setPublicId(String str) {
                this.publicId = str;
            }
        }
    }
}
