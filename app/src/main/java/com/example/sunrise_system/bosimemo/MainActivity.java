package com.example.sunrise_system.bosimemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //プリファレンスで初回起動時と２回目で分岐を作る
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ImageView startButton = (ImageView) findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {
                                               //プリファレンスの準備
                                               preference = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
                                               editor = preference.edit();

                                               if (preference.getBoolean("Launched", false) == false) {
                                                   //初回起動時の処理

                                                   //↓どのアクティビティに行くか指定
                                                   Intent i = new Intent(getApplicationContext(), NameTouroku.class);
                                                   //次のActivityの起動
                                                   startActivity(i);

                                                   //プリファレンスの書き変え
                                                   editor.putBoolean("Launched", true);
                                                   editor.commit();
                                               } else {
                                                   //二回目以降の処理
                                                   Intent i = new Intent(getApplicationContext(), TopGamen.class);
                                                   //次のActivityの起動
                                                   startActivity(i);
                                               }
                                           }

                                       }
        );}


}