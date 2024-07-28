package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class User implements Serializable {
    @c(a = "experiment_id")
    private String experimentId;

    public String getExperimentId() {
        return this.experimentId;
    }
}
