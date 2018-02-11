package com.application.chat.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.inscripts.interfaces.Callbacks;
import com.inscripts.interfaces.LaunchCallbacks;
import com.inscripts.interfaces.SubscribeCallbacks;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cometchat.inscripts.com.cometchatcore.coresdk.CometChat;

public class MainActivity extends AppCompatActivity
{
    @Bind(R.id.sdvLogo)
    ImageView sdvLogo;
    @Bind(R.id.etUserId)
    EditText etUserId;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnLogout)
    Button btnLogout;

    private String siteUrl="";

    private String licenseKey = "COMETCHAT-V528X-727B9-XUDUT-WE44H";

    private String apiKey = "10108xbe8e430df890202085ea36a364745175";

    private CometChat cometChat;

    private String isUserLoggedIn;

    private SessionPref sessionPref;

    private String[] need;

    private int PERMISSION_CODE = 23;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        checkSelfPermission();

        cometChat = CometChat.getInstance(getApplicationContext());

        intilizeChat();

        sessionPref= new SessionPref(MainActivity.this);


       // System.out.println("chat on demand"+cometChat.isCometOnDemand());


    }





    public boolean checkSelfPermission()
    {

        List<String> listPermissionsNeeded = new ArrayList<>();

        int coarseResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        if (coarseResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        int fineResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        if (fineResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }

        int cameraResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA);
        if (cameraResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }

        int readResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        int contactResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.READ_PHONE_STATE);
        if (contactResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_PHONE_STATE);
        }

        int smsResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.READ_SMS);
        if (smsResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_SMS);
        }

        int writeResult = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeResult != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!listPermissionsNeeded.isEmpty())
        {
            listPermissionsNeeded.toArray(need = new String[listPermissionsNeeded.size()]);

            return false;
        }
        return true;
    }



    public void requestStoragePermission()
    {
        ActivityCompat.requestPermissions(MainActivity.this, need, PERMISSION_CODE);
    }




    @Override
    protected void onResume()
    {
        super.onResume();
        isUserLoggedIn = sessionPref.getPreference(SessionPref.isUserLoggedIn);

        if (isUserLoggedIn != null && isUserLoggedIn.equals("yes"))
        {
            Log.e("UserId","onResume if"+ isUserLoggedIn);
            etUserId.setVisibility(View.GONE);
            btnLogin.setText("Re-Enter");
            btnLogout.setVisibility(View.VISIBLE);
        } else
            {
             Log.e("UserId","onResume else"+ isUserLoggedIn);
            etUserId.setVisibility(View.VISIBLE);
            btnLogin.setText("Login");
            btnLogout.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.btnLogin, R.id.btnLogout})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.btnLogin:

                onPressLogin();

                break;
            case R.id.btnLogout:

                LogoutChat();

        }
    }

    private void onPressLogin()
    {

        String userId;
        isUserLoggedIn = sessionPref.getPreference(SessionPref.isUserLoggedIn);
        if(isUserLoggedIn == null || isUserLoggedIn.equalsIgnoreCase("no"))
        {
//
            sessionPref.setPreference(SessionPref.userId, etUserId.getText().toString().trim());
            userId = sessionPref.getPreference(SessionPref.userId);
            Log.e("UserId","From variable if"+ userId);
        }else{
//
            userId = sessionPref.getPreference(SessionPref.userId);
             Log.e("UserId","From variable else"+ userId);
        }

        loginIntoChat(userId);




    }



    private void loginIntoChat(String userId)
    {

    cometChat.login(userId, new Callbacks()
        {
            @Override
            public void successCallback(JSONObject jsonObject)
            {
                Log.e("Sucessqewqewqe", "Sucessssss");

                sessionPref.setPreference(SessionPref.isUserLoggedIn, "yes");


                Log.e("Success","login response "+ jsonObject.toString());

              //  launchCometChat();(


               // subscribeChat();



                Intent intent= new Intent(MainActivity.this,ChatService.class);
                startActivity(intent);



            }

            @Override
            public void failCallback(JSONObject jsonObject) {

               // Log.e("Failure", "login");

                Log.e("Failure", "In login failure response " + jsonObject.toString());
                Log.e("Failure", "In login failure");

                sessionPref.setPreference(SessionPref.isUserLoggedIn, "no");
                sessionPref.setPreference(SessionPref.userId, "");
            }
        });


    }


    private void launchCometChat()
    {

        cometChat.launchCometChat(MainActivity.this, false, new LaunchCallbacks()
        {
            @Override
            public void successCallback(JSONObject jsonObject)
            {

                Log.e("Success", "In launchcometchat success response " + jsonObject.toString());
                Log.e("Success", "In launchcometchat success");



               // subscribeChat();

            }

            @Override
            public void failCallback(JSONObject jsonObject)
            {
                sessionPref.setPreference(SessionPref.isUserLoggedIn, "no");
                sessionPref.setPreference(SessionPref.userId, "");
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();



            }

            @Override
            public void userInfoCallback(JSONObject jsonObject)
            {

            }

            @Override
            public void chatroomInfoCallback(JSONObject jsonObject) {

            }

            @Override
            public void onMessageReceive(JSONObject jsonObject) {

            }

            @Override
            public void error(JSONObject jsonObject) {

            }

            @Override
            public void onLogout() {

            }
        });
    }




    private void LogoutChat()
    {

        cometChat.logout(new Callbacks()
        {
            @Override
            public void successCallback(JSONObject jsonObject)
            {

                sessionPref.setPreference(SessionPref.isUserLoggedIn, "no");
                sessionPref.setPreference(SessionPref.userId, "");

                Log.e("Success", "In logout success response " + jsonObject.toString());
                Log.e("Success", "In logout success");
                btnLogin.setText("Login");
                etUserId.setText("");
                etUserId.setVisibility(View.VISIBLE);
                btnLogout.setVisibility(View.GONE);
            }

            @Override
            public void failCallback(JSONObject jsonObject)
            {
                Log.e("fail", "In logout fail response " + jsonObject.toString());
                Log.e("fail", "In logout fail");
            }
        });
    }



    private void intilizeChat()
    {

        cometChat.initializeCometChat(" ", licenseKey, apiKey, true, new Callbacks()
        {
            @Override
            public void successCallback(JSONObject jsonObject)
            {

                Log.e("Success","In launchcometchat success response "+ jsonObject.toString());
                Log.e("Success","In launchcometchat success");



            }

            @Override
            public void failCallback(JSONObject jsonObject)
            {

                Log.e("Failure", "In launchcometchat failure response " + jsonObject.toString());
                Log.e("Failure", "In launchcometchat failure");
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });
    }




    private void subscribeChat()
    {

        cometChat.subscribe(true, new SubscribeCallbacks()
        {
            @Override
            public void gotOnlineList(JSONObject jsonObject)
            {
                Log.d("subscribe","subscribe onlineMember");

                Log.e("subscribe","In subscribe success response "+ jsonObject.toString());

            }

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
            public void onMessageReceived(JSONObject jsonObject)
            {

            }

            @Override
            public void gotProfileInfo(JSONObject jsonObject)
            {

            }

            @Override
            public void gotAnnouncement(JSONObject jsonObject)
            {

            }

            @Override
            public void onAVChatMessageReceived(JSONObject jsonObject)
            {

            }

            @Override
            public void onActionMessageReceived(JSONObject jsonObject)
            {

            }

            @Override
            public void onGroupMessageReceived(JSONObject jsonObject)
            {

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



    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(MainActivity.this, "Service Un-Binded", Toast.LENGTH_LONG).show();
    };





}
