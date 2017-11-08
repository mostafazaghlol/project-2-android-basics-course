package com.example.android.tennisscorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int p=0,s=0,advantage=0,advantage2=0;
    int p2=0,s2=0;
    TextView txPoint1;
    TextView txgame1;
    TextView txPoint2;
    TextView txgame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txPoint1=(TextView)findViewById(R.id.Point_player1);
         txgame1=(TextView)findViewById(R.id.no_of_sets1);
         txPoint2=(TextView)findViewById(R.id.Point_player2);
         txgame2=(TextView)findViewById(R.id.no_of_sets2);

    }

    //To keep track of first player.
    public void Point1(View view) {

        if(p<30){
            p+=15;
            txPoint1.setText(String.valueOf(p));
        }else if(p==30){
            p+=10;
            txPoint1.setText(String.valueOf(p));
        }else if((p==40&&advantage==1) || (p==40&&p2!=40)){
            p=0;
            p2=0;
            advantage=0;
            s++;
            txgame1.setText(String.valueOf(s));
            txPoint1.setText(String.valueOf(p));
            txPoint2.setText(String.valueOf(p2));
        }else if(p==40 && p2==40 && advantage==0 ){
            txPoint1.setText("A");
            txPoint2.setText(String.valueOf(p2));
            advantage=1;

        }


    }
    //keep track of second player.
    public void Point2(View view) {

        if(p2<30){
            p2+=15;
            txPoint2.setText(String.valueOf(p2));
        }else if(p2==30){
            p2+=10;
            txPoint2.setText(String.valueOf(p2));
        }else if(p==40 && p2==40 && advantage2==0){
            txPoint2.setText("A");
            txPoint1.setText(String.valueOf(p2));
            advantage2=1;
            Log.e("MainActivity",String.valueOf(advantage));

        }else if((p2==40&&advantage2==1) || (p2==40&&p!=40) ){
            p2=0;
            p=0;
            s2++;
            advantage2=0;
            txgame2.setText(String.valueOf(s2));
            txPoint2.setText(String.valueOf(p2));
            txPoint1.setText(String.valueOf(p));

        }
    }
    //to rest the game.
    public void Rest(View view) {
        p=0;
        p2=0;
        s=0;
        s2=0;
        advantage=0;
        advantage2=0;

        txPoint1.setText("0");
        txPoint2.setText("0");
        txgame1.setText("0");
        txgame2.setText("0");
    }
}
