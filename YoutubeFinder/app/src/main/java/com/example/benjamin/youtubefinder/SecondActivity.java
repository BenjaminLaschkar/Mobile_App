package com.example.benjamin.youtubefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import static com.example.benjamin.youtubefinder.R.id.editText2;

public class SecondActivity extends AppCompatActivity {

    //TextView mTextView;
    ListView listview;
    String url="https://www.googleapis.com/youtube/v3/search?part=snippet&q=";
    String apikey="AIzaSyDcq6A5DQBZx_RBhmFLxlAzrIotBEMkmxI";
    private EditText textbox2;
    Adapter adapter;
    Gson gson;
    com.example.benjamin.youtubefinder.Response responseObj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textbox2 = (EditText) findViewById(editText2);
        textbox2.setText(getIntent().getStringExtra("editText"));
        listview = (ListView) findViewById(R.id.listview);
       // mTextView =(TextView) findViewById(R.id.textview);

        String recherche_utilisateur=textbox2.getText().toString();
        String recherche_utilisateur_sans_espace=recherche_utilisateur.replaceAll(" ","-");
        String urlwithapikey=url+recherche_utilisateur_sans_espace+"&maxResults=50&type=video&key="+apikey;


        StringRequest request = new StringRequest(urlwithapikey, new Response.Listener<String>()
        {
            // new Response.Listener<String>()
            @Override
            public void onResponse(String response)
            {
                Log.d("Contracts", response);
                String responsestr = new String(response);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, com.example.benjamin.youtubefinder.Response.class);
                adapter  = new Adapter(SecondActivity.this,responseObj.getItems());
                listview.setAdapter(adapter);

                //mTextView.setText(response);
            }
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError response)
            {
                Log.e("Contracts",response.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(request);
    }



}