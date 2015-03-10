package com.teachandroid.app.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by дима on 03.03.2015.
 */
public class Dialog {

    @SerializedName("unread")
    private long unread ;

    @SerializedName("message")
    private long message ;


    public long getUnread() {
        return unread;
    }

    public long getMessage() {
        return message;
    }
}
