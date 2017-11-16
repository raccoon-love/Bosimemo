package com.example.sunrise_system.bosimemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by sunrise-system on 2016/10/06.
 */

public class SokuteiGamen extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sokuteigmn);
    }

    // インテントで身長体重の登録ページ移動
    public void onclicktouroku(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), KeisokuGamen.class);
        //SubActivityの起動
        startActivity(i);
    }

    // インテントで一覧ページ移動
    public void onclickitiran(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), SokuteiGamen.class);
        //SubActivityの起動
        startActivity(i);
    }


    // インテントでTOPページ移動
    public void onclicktop(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), TopGamen.class);
        //SubActivityの起動
        startActivity(i);
    }



    // インテントで予防接種ページ移動
    public void onclickyobou(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), YobouGamen.class);
        //SubActivityの起動
        startActivity(i);
    }

    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        finish();
    }

}
