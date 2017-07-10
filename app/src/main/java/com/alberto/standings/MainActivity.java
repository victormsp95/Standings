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
import butterknife.OnTouch;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.equipos) TextView equipos;
    @Bind(R.id.ganados) TextView ganados;
    @Bind(R.id.perdidos) TextView perdidos;
    @Bind(R.id.Juegos) TextView juegos;
    @Bind(R.id.Ultimos) TextView ultimos;
    @Bind(R.id.fecha) TextView fecha;

    @Bind(R.id.equipos1) TextView equipos1;
    @Bind(R.id.ganados1) TextView ganados1;
    @Bind(R.id.perdidos1) TextView perdidos1;
    @Bind(R.id.Juegos1) TextView juegos1;
    @Bind(R.id.Ultimos1) TextView ultimos1;


    @Bind(R.id.equipos2) TextView equipos2;
    @Bind(R.id.ganados2) TextView ganados2;
    @Bind(R.id.perdidos2) TextView perdidos2;
    @Bind(R.id.Juegos2) TextView juegos2;
    @Bind(R.id.Ultimos2) TextView ultimos2;

    int i=0;

  //  @Bind(R.id.button_refresh) Button button_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
     //   onClick_button_refresh();






     //   @OnClick(R.id.button_refresh) public void onClick_button_refresh(){



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

                    equipos1.setText(response.body().getStanding().get(15).getLastName()+"\n" +
                            response.body().getStanding().get(16).getLastName()+"\n"+
                            response.body().getStanding().get(17).getLastName()+"\n"+
                            response.body().getStanding().get(18).getLastName()+"\n"+
                            response.body().getStanding().get(19).getLastName()+"\n");
                    ganados1.setText(response.body().getStanding().get(15).getWon()+"\n"+
                            response.body().getStanding().get(16).getWon()+"\n"+
                            response.body().getStanding().get(17).getWon()+"\n"+
                            response.body().getStanding().get(18).getWon()+"\n"+
                            response.body().getStanding().get(19).getWon()+"\n");
                    perdidos1.setText(response.body().getStanding().get(15).getLost()+"\n"+
                            response.body().getStanding().get(16).getLost()+"\n"+
                            response.body().getStanding().get(17).getLost()+"\n"+
                            response.body().getStanding().get(18).getLost()+"\n"+
                            response.body().getStanding().get(19).getLost()+"\n");
                    juegos1.setText(response.body().getStanding().get(15).getGamesBack()+"\n"+
                            response.body().getStanding().get(16).getGamesBack()+"\n"+
                            response.body().getStanding().get(17).getGamesBack()+"\n"+
                            response.body().getStanding().get(18).getGamesBack()+"\n"+
                            response.body().getStanding().get(9).getGamesBack()+"\n");
                    ultimos1.setText(response.body().getStanding().get(15).getLastTen()+"\n"+
                            response.body().getStanding().get(16).getLastTen()+"\n"+
                            response.body().getStanding().get(17).getLastTen()+"\n"+
                            response.body().getStanding().get(18).getLastTen()+"\n"+
                            response.body().getStanding().get(19).getLastTen()+"\n");

                    equipos2.setText(response.body().getStanding().get(25).getLastName()+"\n" +
                            response.body().getStanding().get(26).getLastName()+"\n"+
                            response.body().getStanding().get(27).getLastName()+"\n"+
                            response.body().getStanding().get(28).getLastName()+"\n"+
                            response.body().getStanding().get(29).getLastName()+"\n");
                    ganados2.setText(response.body().getStanding().get(25).getWon()+"\n"+
                            response.body().getStanding().get(26).getWon()+"\n"+
                            response.body().getStanding().get(27).getWon()+"\n"+
                            response.body().getStanding().get(28).getWon()+"\n"+
                            response.body().getStanding().get(29).getWon()+"\n");
                    perdidos2.setText(response.body().getStanding().get(25).getLost()+"\n"+
                            response.body().getStanding().get(26).getLost()+"\n"+
                            response.body().getStanding().get(27).getLost()+"\n"+
                            response.body().getStanding().get(28).getLost()+"\n"+
                            response.body().getStanding().get(29).getLost()+"\n");
                    juegos2.setText(response.body().getStanding().get(25).getGamesBack()+"\n"+
                            response.body().getStanding().get(26).getGamesBack()+"\n"+
                            response.body().getStanding().get(27).getGamesBack()+"\n"+
                            response.body().getStanding().get(28).getGamesBack()+"\n"+
                            response.body().getStanding().get(29).getGamesBack()+"\n");
                    ultimos2.setText(response.body().getStanding().get(25).getLastTen()+"\n"+
                            response.body().getStanding().get(26).getLastTen()+"\n"+
                            response.body().getStanding().get(27).getLastTen()+"\n"+
                            response.body().getStanding().get(28).getLastTen()+"\n"+
                            response.body().getStanding().get(29).getLastTen()+"\n");

                    fecha.setText("Last update "+response.body().getStandingsDate());

                }




                @Override
                public void onFailure(Throwable t) {
                    Log.e("Failed", t.getMessage());

                }
            });
    }
}
