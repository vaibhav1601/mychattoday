package com.application.chat.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.application.chat.myapplication.Adapter.DataAdapter;
import com.application.chat.myapplication.model.User;
import com.inscripts.interfaces.SubscribeCallbacks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cometchat.inscripts.com.cometchatcore.coresdk.CometChat;

public class ChatService extends AppCompatActivity
{

    @Bind(R.id.card_recycler_view)
    RecyclerView cardRecyclerView;
    private CometChat cometChat;
    private DataAdapter dataAdapter;
   private ArrayList<User> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_service);
        ButterKnife.bind(this);
        cometChat = CometChat.getInstance(getApplicationContext());

        SubscriptionChat();


    }

    private void SubscriptionChat()
    {

        cometChat.subscribe(true, new SubscribeCallbacks()
        {


            @Override
            public void gotOnlineList(JSONObject jsonObject)
            {

                Log.e("subscribe","In subscribe success response "+ jsonObject.toString());


                try {



                   JSONArray names= jsonObject.names();
                   data.clear();

                   for(int i=0;i<names.length();i++){
                       JSONObject userObj=jsonObject.getJSONObject(names.getString(i));
                       User user= new User();
                       user.setId(userObj.getString("id"));
                       user.setN(userObj.getString("n"));
                       user.setL(userObj.getString("l"));
                       user.setA(userObj.getString("a"));
                       user.setD(userObj.getString("d"));
                       user.setS(userObj.getString("s"));
                       user.setM(userObj.getString("m"));
                       user.setG(userObj.getString("g"));
                       user.setLs(userObj.getString("ls"));
                       user.setLstn(userObj.getString("lstn"));
                       user.setCh(userObj.getString("ch"));
                       user.setRdrs(userObj.getString("rdrs"));
                       data.add(user);
                   }


                    dataAdapter= new DataAdapter(data);
                    cardRecyclerView.setLayoutManager(new LinearLayoutManager(ChatService.this));
                    cardRecyclerView.setAdapter(dataAdapter);




                } catch (JSONException e) {
                    e.printStackTrace();
                }




                }





               /* try {
                    JSONArray jArray = new JSONArray(jsonObject);

                    for(int i=0;i<jArray.length();i++){
                        JSONObject json_data = jArray.getJSONObject(i);
                        User user = new User();

                        user.setId(json_data.getString("id"));
                        user.setN(json_data.getString("n"));
                        user.setA(json_data.getString("a"));
                        user.setL(json_data.getString("l"));
                        user.setS(json_data.getString("s"));
                        user.setM(json_data.getString("m"));
                        user.setPush_an_channel(json_data.getString("push_channel"));
                        user.setPush_an_channel(json_data.getString("push_an_channel"));
                        data.add(user);

                        dataAdapter= new DataAdapter(data);
                        cardRecyclerView.setAdapter(dataAdapter);

                        cardRecyclerView.setLayoutManager(new LinearLayoutManager(ChatService.this));


                    }
                } catch (JSONException e)
                {
                    //Toast.makeText(ChatService.this, e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }*/





            @Override
            public void gotBotList(JSONObject jsonObject)
            {

            }

            @Override
            public void gotRecentChatsList(JSONObject jsonObject)
            {

            }

            @Override
            public void onError(JSONObject jsonObject)
            {

            }

            @Override
            public void onMessageReceived(JSONObject jsonObject) {

            }

            @Override
            public void gotProfileInfo(JSONObject jsonObject) {

            }

            @Override
            public void gotAnnouncement(JSONObject jsonObject) {

            }

            @Override
            public void onAVChatMessageReceived(JSONObject jsonObject) {

            }

            @Override
            public void onActionMessageReceived(JSONObject jsonObject) {

            }

            @Override
            public void onGroupMessageReceived(JSONObject jsonObject) {

            }

            @Override
            public void onGroupsError(JSONObject jsonObject) {

            }

            @Override
            public void onLeaveGroup(JSONObject jsonObject) {

            }

            @Override
            public void gotGroupList(JSONObject jsonObject) {

            }

            @Override
            public void gotGroupMembers(JSONObject jsonObject) {

            }

            @Override
            public void onGroupAVChatMessageReceived(JSONObject jsonObject) {

            }

            @Override
            public void onGroupActionMessageReceived(JSONObject jsonObject) {

            }
        });


    }


}
