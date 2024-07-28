package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class Configuration extends BaseRequest {
    @c(a = "config_data")
    public ConfigData configData;
    @c(a = "config_type")
    public String configType;
    @c(a = "config_version")
    public String configVersion;
    public String id;
}
