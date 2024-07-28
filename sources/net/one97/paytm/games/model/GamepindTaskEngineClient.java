package net.one97.paytm.games.model;

import com.google.gson.a.c;

public class GamepindTaskEngineClient extends GamepindCasClient {
    @c(a = "appCode")
    public String appCode;
    @c(a = "eventCode")
    public String eventCode;
    @c(a = "gameName")
    public String gameName;
    @c(a = "gratifyUrl")
    public String gratifyUrl;
    @c(a = "ruleId")
    public String ruleId;
    @c(a = "shortcutEventCode")
    @Deprecated
    public String shortcutEventCode;
    @c(a = "shortcutRuleId")
    @Deprecated
    public String shortcutRuleId;
    @c(a = "taskPushUrl")
    public String taskPushUrl;
}
