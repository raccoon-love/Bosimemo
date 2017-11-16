package com.example.sunrise_system.bosimemo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
//計測画面
/**
 * Created by sunrise-system on 2016/10/06.
 */

public class KeisokuGamen extends AppCompatActivity {

    Calendar cale;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setContentView(R.layout.keisokugmn);
        //今日の日付を取得
        cale = Calendar.getInstance();
    }

    //edittextを押すと日付を出す
    public void onclickcale(View view){
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth){
                        EditText txtDate=(EditText)KeisokuGamen.this.
                                findViewById(R.id.editt);
                        // Setした日付を取得する
                        txtDate.setText(
                                String.format("%02d/%02d/%02d",year,monthOfYear+1,
                                        dayOfMonth));
                    }
                },
                cale.get(java.util.Calendar.YEAR),
                cale.get(java.util.Calendar.MONTH),
                cale.get(java.util.Calendar.DAY_OF_MONTH)
        );
        // ダイアログを表示する
        d_date.show();
    }




    // インテントでTOPページ移動
    public void onclicktop(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), TopGamen.class);
        //SubActivityの起動
        startActivity(i);
    }

    // インテントでTOPページ移動
    public void onclicksokutei(View v) {                 //↓どのアクティビティに行くか指定
        Intent i = new Intent(getApplicationContext(), SokuteiGamen.class);
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

