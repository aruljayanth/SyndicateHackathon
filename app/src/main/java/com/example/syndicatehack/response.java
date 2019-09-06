package com.example.syndicatehack;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class response extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public response(Context context) {
        this.context = context;
    }


    public static String response="";
    public String n_ame = Second.namee;//getting string from a activity to class
    public String n_um = Second.phnum;
    public String e_mail=Second.emails;
    public String servicee=Second.service;
    public int yearr=Second.mYear;
    public int monthh=Second.mMonth;
    public int dayy=Second.mDay;
    public int hourr=Second.mHour;
    public int minutee=Second.mMinute;
    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://akashsachithanandham.000webhostapp.com/syndicate_bank/index.php?name="+ n_ame+"&phone="+ n_um+"&email="+ e_mail+"&service="+ servicee+"&year="+ yearr+"&month="+ monthh+"&day="+ dayy+"&hour="+ hourr+"&minute="+ minutee;
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                response = jsonObj.getString("tno");
                Log.v("Hk", response);

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        if(hk==1) {


            Toast.makeText(this.context, "you have Successfully booked your visit,Happy Banking", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, qrgeneratorr.class));//the website should return the samed number if theres no entry for it
        }

        }

    }

