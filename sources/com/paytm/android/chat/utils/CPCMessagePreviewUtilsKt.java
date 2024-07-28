package com.paytm.android.chat.utils;

public final class CPCMessagePreviewUtilsKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.paytm.android.chat.bean.jsonbean.FileDataBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.android.chat.data.models.messages.MPCMessagePreview getMessagePreview(com.sendbird.android.BaseMessage r8) {
        /*
            java.lang.String r0 = "baseMessage"
            kotlin.g.b.k.c(r8, r0)
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r0 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r1 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE
            r2 = 0
            r0.<init>(r2, r1)
            boolean r1 = r8 instanceof com.sendbird.android.UserMessage
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0214
            r1 = r8
            com.sendbird.android.UserMessage r1 = (com.sendbird.android.UserMessage) r1
            com.sendbird.android.Sender r2 = r1.getSender()
            java.lang.String r5 = r8.getCustomType()
            java.lang.String r6 = "TRANSFER"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
            java.lang.String r6 = "paymentStatusBean"
            java.lang.String r7 = ""
            if (r5 == 0) goto L_0x00c0
            if (r2 == 0) goto L_0x02f5
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson     // Catch:{ Exception -> 0x02f5 }
            r1.<init>()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r8 = r8.getData()     // Catch:{ Exception -> 0x02f5 }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r5 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r8 = r1.fromJson((java.lang.String) r8, r5)     // Catch:{ Exception -> 0x02f5 }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r8     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = r2.getUserId()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x02f5 }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x02f5 }
            r2 = 2
            if (r1 == 0) goto L_0x009f
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x02f5 }
            int r1 = r8.getStatus()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            if (r1 != r2) goto L_0x0077
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r1 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewDrawable(r1)     // Catch:{ Exception -> 0x02f5 }
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = "Pending ₹%1$s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r6 = r8.getAmount()     // Catch:{ Exception -> 0x02f5 }
            r2[r3] = r6     // Catch:{ Exception -> 0x02f5 }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ Exception -> 0x02f5 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewText(r1)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x0096
        L_0x0077:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r1 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.RUPEE     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewDrawable(r1)     // Catch:{ Exception -> 0x02f5 }
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = "Paid ₹%1$s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r6 = r8.getAmount()     // Catch:{ Exception -> 0x02f5 }
            r2[r3] = r6     // Catch:{ Exception -> 0x02f5 }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ Exception -> 0x02f5 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewText(r1)     // Catch:{ Exception -> 0x02f5 }
        L_0x0096:
            java.lang.String r8 = r8.getSender_preview_text()     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewText(r8)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x02f5
        L_0x009f:
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x02f5 }
            int r1 = r8.getStatus()     // Catch:{ Exception -> 0x02f5 }
            if (r1 != r2) goto L_0x00b2
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewDrawable(r8)     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewText(r7)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x02f5
        L_0x00b2:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r1 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.RUPEE     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewDrawable(r1)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r8 = r8.getReceiver_preview_text()     // Catch:{ Exception -> 0x02f5 }
            r0.setPreviewText(r8)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x02f5
        L_0x00c0:
            java.lang.String r3 = r8.getCustomType()
            java.lang.String r5 = "MINI_APP_BASIC_NOTIFICATION"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0106
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r1 = new com.paytm.android.chat.data.models.messages.MiniAppNotificationBean
            r1.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r2 = new com.sendbird.android.shadow.com.google.gson.Gson
            r2.<init>()
            java.lang.String r8 = r8.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.MiniAppNotificationData> r3 = com.paytm.android.chat.data.models.messages.MiniAppNotificationData.class
            java.lang.Object r8 = r2.fromJson((java.lang.String) r8, r3)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r8 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationData) r8
            r1.setNotifData(r8)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r8 = r1.getNotifData()
            if (r8 == 0) goto L_0x00fc
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r8 = r1.getNotifData()
            if (r8 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            java.lang.String r8 = r8.getPreview_text()
            r0.setPreviewText(r8)
            goto L_0x00ff
        L_0x00fc:
            r0.setPreviewText(r7)
        L_0x00ff:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE
            r0.setPreviewDrawable(r8)
            goto L_0x02f5
        L_0x0106:
            java.lang.String r3 = r8.getCustomType()
            java.lang.String r5 = "GENERIC_NOTIF"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x014c
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r1 = new com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel
            r1.<init>()
            com.sendbird.android.shadow.com.google.gson.Gson r2 = new com.sendbird.android.shadow.com.google.gson.Gson
            r2.<init>()
            java.lang.String r8 = r8.getData()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean> r3 = com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean.class
            java.lang.Object r8 = r2.fromJson((java.lang.String) r8, r3)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r8 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean) r8
            r1.setData(r8)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r8 = r1.getData()
            if (r8 == 0) goto L_0x0142
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r8 = r1.getData()
            if (r8 != 0) goto L_0x013a
            kotlin.g.b.k.a()
        L_0x013a:
            java.lang.String r8 = r8.getPreview_text()
            r0.setPreviewText(r8)
            goto L_0x0145
        L_0x0142:
            r0.setPreviewText(r7)
        L_0x0145:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE
            r0.setPreviewDrawable(r8)
            goto L_0x02f5
        L_0x014c:
            java.lang.String r3 = r8.getCustomType()
            java.lang.String r5 = "TRANSFER_FAIL"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0192
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson
            r1.<init>()
            java.lang.String r8 = r8.getData()
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r3 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r8 = r1.fromJson((java.lang.String) r8, r3)
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r8
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r1 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.FAIL
            r0.setPreviewDrawable(r1)
            java.lang.String r1 = "sender"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            java.lang.String r1 = r2.getUserId()
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x018d
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r8 = r8.getSender_preview_text()
            r0.setPreviewText(r8)
            goto L_0x02f5
        L_0x018d:
            r0.setPreviewText(r7)
            goto L_0x02f5
        L_0x0192:
            java.lang.String r2 = r8.getCustomType()
            java.lang.String r3 = "contact"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x01ac
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.CONTACT
            r0.setPreviewDrawable(r8)
            java.lang.String r8 = r1.getMessage()
            r0.setPreviewText(r8)
            goto L_0x02f5
        L_0x01ac:
            java.lang.String r2 = r8.getCustomType()
            java.lang.String r3 = "UPI_REQUEST"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)
            if (r2 != 0) goto L_0x01ce
            java.lang.String r2 = r8.getCustomType()
            java.lang.String r3 = "UPI_RESPONSE"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)
            if (r2 == 0) goto L_0x01c5
            goto L_0x01ce
        L_0x01c5:
            java.lang.String r8 = r1.getMessage()
            r0.setPreviewText(r8)
            goto L_0x02f5
        L_0x01ce:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x020b }
            r2 = r8
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x020b }
            java.lang.String r2 = r2.getData()     // Catch:{ Exception -> 0x020b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x020b }
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x020b }
            r3 = r8
            com.sendbird.android.UserMessage r3 = (com.sendbird.android.UserMessage) r3     // Catch:{ Exception -> 0x020b }
            com.sendbird.android.Sender r3 = r3.getSender()     // Catch:{ Exception -> 0x020b }
            java.lang.String r5 = "userMessage.sender"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x020b }
            java.lang.String r3 = r3.getUserId()     // Catch:{ Exception -> 0x020b }
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x020b }
            if (r2 == 0) goto L_0x0200
            java.lang.String r2 = "sender_preview_text"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x020b }
            r0.setPreviewText(r1)     // Catch:{ Exception -> 0x020b }
            goto L_0x02f5
        L_0x0200:
            java.lang.String r2 = "receiver_preview_text"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x020b }
            r0.setPreviewText(r1)     // Catch:{ Exception -> 0x020b }
            goto L_0x02f5
        L_0x020b:
            java.lang.String r8 = r8.getMessage()
            r0.setPreviewText(r8)
            goto L_0x02f5
        L_0x0214:
            boolean r1 = r8 instanceof com.sendbird.android.FileMessage
            if (r1 == 0) goto L_0x02b4
            java.lang.String r1 = r8.getData()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0236
            com.sendbird.android.shadow.com.google.gson.Gson r1 = new com.sendbird.android.shadow.com.google.gson.Gson
            r1.<init>()
            java.lang.String r2 = r8.getData()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r4 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r1 = r1.fromJson((java.lang.String) r2, r4)
            r2 = r1
            com.paytm.android.chat.bean.jsonbean.FileDataBean r2 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r2
        L_0x0236:
            com.sendbird.android.FileMessage r8 = (com.sendbird.android.FileMessage) r8
            java.lang.String r8 = r8.getType()
            java.lang.String r1 = "type"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            if (r8 == 0) goto L_0x02ac
            java.lang.String r1 = r8.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r5 = "audio"
            boolean r1 = kotlin.m.p.b(r1, r5, r3)
            if (r1 == 0) goto L_0x0275
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.AUDIO
            r0.setPreviewDrawable(r8)
            if (r2 == 0) goto L_0x02f5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "Audio"
            r8.<init>(r1)
            long r1 = r2.time
            java.lang.String r1 = com.paytm.android.chat.utils.DateUtils.getAudioTime(r1)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r0.setPreviewText(r8)
            goto L_0x02f5
        L_0x0275:
            java.lang.String r8 = r8.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            java.lang.String r1 = "image"
            boolean r8 = kotlin.m.p.b(r8, r1, r3)
            if (r8 == 0) goto L_0x02a1
            if (r2 == 0) goto L_0x0296
            java.lang.String r8 = r2.message
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0296
            java.lang.String r8 = r2.message
            r0.setPreviewText(r8)
            goto L_0x029b
        L_0x0296:
            java.lang.String r8 = "Photo"
            r0.setPreviewText(r8)
        L_0x029b:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.PHOTO
            r0.setPreviewDrawable(r8)
            goto L_0x02f5
        L_0x02a1:
            java.lang.String r8 = "Document"
            r0.setPreviewText(r8)
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r8 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.FILE
            r0.setPreviewDrawable(r8)
            goto L_0x02f5
        L_0x02ac:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r0)
            throw r8
        L_0x02b4:
            boolean r1 = r8 instanceof com.sendbird.android.AdminMessage
            if (r1 == 0) goto L_0x02f5
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r1 = com.paytm.android.chat.utils.AppUtilKt.getValidAdminMessage(r8)
            if (r1 == 0) goto L_0x02f5
            java.lang.String r1 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{  }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{  }
            java.lang.String r8 = r8.getData()     // Catch:{  }
            r2.<init>(r8)     // Catch:{  }
            int r8 = r2.length()     // Catch:{  }
        L_0x02cf:
            if (r3 >= r8) goto L_0x02f5
            org.json.JSONObject r5 = r2.getJSONObject(r3)     // Catch:{  }
            java.lang.String r6 = "u_id"
            java.lang.String r6 = r5.optString(r6)     // Catch:{  }
            boolean r6 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r4)     // Catch:{  }
            if (r6 == 0) goto L_0x02f2
            java.lang.String r8 = "d"
            org.json.JSONObject r8 = r5.optJSONObject(r8)     // Catch:{  }
            java.lang.String r1 = "preview_text"
            java.lang.String r8 = r8.getString(r1)     // Catch:{  }
            r0.setPreviewText(r8)     // Catch:{  }
            goto L_0x02f5
        L_0x02f2:
            int r3 = r3 + 1
            goto L_0x02cf
        L_0x02f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt.getMessagePreview(com.sendbird.android.BaseMessage):com.paytm.android.chat.data.models.messages.MPCMessagePreview");
    }
}
