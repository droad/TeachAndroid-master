package com.teachandroid.app.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by дима on 03.03.2015.
 */
public class Friends {

    @SerializedName("id")
    private long id ;

    @SerializedName("first_name")
    private String first_name ;

    @SerializedName("last_name")
    private String last_name ;

   @SerializedName("photo_100")
    private String photo_100 ;

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

 public String getPhoto_100() {
      return photo_100;
  }
}
