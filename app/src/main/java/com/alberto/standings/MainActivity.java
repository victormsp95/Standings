package com.alberto.standings;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.standings.Data.model.SOService;
import com.alberto.standings.Data.remote.StandingsAPI;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.equipos) TextView equipos;
    @Bind(R.id.ganados) TextView ganados;
    @Bind(R.id.perdidos) TextView perdidos;
    @Bind(R.id.Juegos) TextView juegos;
    @Bind(R.id.Ultimos) TextView ultimos;
    @Bind(R.id.fecha) TextView fecha;
    int i=0;

    @Bind(R.id.button_refresh) Button button_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button_refresh) public void onClick_button_refresh(){



            StandingsAPI.Factory.getIstance().getSOservice().enqueue(new Callback<SOService>() {
                @Override
                public void onResponse(Response<SOService> response) {
                    equipos.setText(response.body().getStanding().get(20).getLastName()+"\n" +
                                    response.body().getStanding().get(21).getLastName()+"\n"+
                                    response.body().getStanding().get(22).getLastName()+"\n"+
                                    response.body().getStanding().get(23).getLastName()+"\n"+
                                    response.body().getStanding().get(24).getLastName()+"\n");
                    ganados.setText(response.body().getStanding().get(20).getWon()+"\n"+
                                    response.body().getStanding().get(21).getWon()+"\n"+
                                    response.body().getStanding().get(22).getWon()+"\n"+
                                    response.body().getStanding().get(23).getWon()+"\n"+
                                    response.body().getStanding().get(24).getWon()+"\n");
                    perdidos.setText(response.body().getStanding().get(20).getLost()+"\n"+
                                    response.body().getStanding().get(21).getLost()+"\n"+
                                    response.body().getStanding().get(22).getLost()+"\n"+
                                    response.body().getStanding().get(23).getLost()+"\n"+
                                    response.body().getStanding().get(24).getLost()+"\n");
                    juegos.setText(response.body().getStanding().get(20).getGamesBack()+"\n"+
                                    response.body().getStanding().get(21).getGamesBack()+"\n"+
                                    response.body().getStanding().get(22).getGamesBack()+"\n"+
                                    response.body().getStanding().get(23).getGamesBack()+"\n"+
                                    response.body().getStanding().get(24).getGamesBack()+"\n");
                    ultimos.setText(response.body().getStanding().get(20).getLastTen()+"\n"+
                                    response.body().getStanding().get(21).getLastTen()+"\n"+
                                    response.body().getStanding().get(22).getLastTen()+"\n"+
                                    response.body().getStanding().get(23).getLastTen()+"\n"+
                                    response.body().getStanding().get(24).getLastTen()+"\n");

                    fecha.setText("Last update "+response.body().getStandingsDate());

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e("Failed", t.getMessage());

                }
            });
        }
    @Override
    protected void onResume(){
        super.onResume();
        onClick_button_refresh();
    }
}
