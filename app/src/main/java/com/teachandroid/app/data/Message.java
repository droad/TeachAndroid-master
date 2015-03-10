package com.teachandroid.app.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by дима on 03.03.2015.
 */
public class Message {

    @SerializedName("id")
    private long id ;

    @SerializedName("user_id")
    private long user_id ;

    @SerializedName("from_id")
    private long from_id ;

    @SerializedName("date")
    private long date ;

    @SerializedName("read_state")
    private long read_state ;

    @SerializedName("out")
    private long out ;

    @SerializedName("title")
    private long title ;

    @SerializedName("body")
    private long body ;

    @SerializedName("attachments")
    private long attachments ;

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getFrom_id() {
        return from_id;
    }

    public long getDate() {
        return date;
    }

    public long getRead_state() {
        return read_state;
    }

    public long getOut() {
        return out;
    }

    public long getTitle() {
        return title;
    }

    public long getBody() {
        return body;
    }

    public long getAttachments() {
        return attachments;
    }
}
