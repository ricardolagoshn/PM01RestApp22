package com.example.pm01restapp22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm01restapp22.process.Autos;
import com.example.pm01restapp22.process.RestApiMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity
{
    ListView listautos;
    List<Autos> AutosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listautos = (ListView) findViewById(R.id.ListAutos);
        AutosList = new ArrayList<>();

        ObtenerLista();
    }

    private void ObtenerLista()
    {
        RequestQueue peticion = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                RestApiMethods.ApiRead, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject =  new JSONObject(response);

                    JSONArray autoarray = jsonObject.getJSONArray("autos");

                    for(int i = 0; i < autoarray.length(); i ++)
                    {
                        JSONObject RowAuto = autoarray.getJSONObject(i);

                        Autos auto = new Autos
                                (
                                        RowAuto.getInt("id"),
                                        RowAuto.getString("modelo"),
                                        RowAuto.getString("marca"),
                                        RowAuto.getDouble("precio"),
                                        RowAuto.getInt("year"),
                                        RowAuto.getString("foto")
                                );

                        AutosList.add(auto);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        peticion.add(stringRequest);
    }
}