package com.teachandroid.app.activity;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.teachandroid.app.R;
import com.teachandroid.app.api.ApiFacade;
import com.teachandroid.app.api.SimpleResponseListener;
import com.teachandroid.app.data.Friends;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends ActionBarActivity {


    // Create global configuration and initialize ImageLoader with this config
 //   ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//   ...
//            .build();
//    ImageLoader.getInstance().init(config);
//    ...



    private FriendsAdapter friendsAdapter;

    private ListView friendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        friendsAdapter = new FriendsAdapter(this, new ArrayList<Friends>());

        friendsList = (ListView) findViewById(R.id.list_friends);

        friendsList.setAdapter(friendsAdapter);

        ApiFacade facade = new ApiFacade(this);
        facade.getFriends(new SimpleResponseListener<List<Friends>>(){
            @Override
            public void onResponse(final List<Friends> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        friendsAdapter.addAll(response);
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friends, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static final class FriendsAdapter extends ArrayAdapter<Friends> {

        public FriendsAdapter(Context context, List<Friends> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = View.inflate(getContext(), R.layout.list_item_friends, null);
            }
            TextView firstNameView = (TextView) convertView.findViewById(R.id.text_first_name);
            TextView lastNameView = (TextView) convertView.findViewById(R.id.text_last_name);
            ImageView photo100View = (ImageView) convertView.findViewById(R.id.image_photo);

            Friends item = getItem(position);

            firstNameView.setText(item.getFirst_name());
            lastNameView.setText(item.getLast_name());

            ImageLoader.getInstance().displayImage(item.getPhoto_100(), photo100View);

            return convertView;
        }
    }
}
