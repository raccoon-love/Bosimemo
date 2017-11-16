package com.example.sunrise_system.bosimemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by sunrise-system on 2016/10/14.
 */

public class Yobou6 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_6_1;
    private int month2_yobou_6_1;
    private int day_yobou_6_1;


    private int year_yobou_6_2;
    private int month2_yobou_6_2;
    private int day_yobou_6_2;

    private int year_yobou_6_3;
    private int month2_yobou_6_3;
    private int day_yobou_6_3;

    private int year_yobou_6_4;
    private int month2_yobou_6_4;
    private int day_yobou_6_4;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR6_1 = "YEAR6_1";
    private static final String MONTH6_1 = "MONTH6_1";
    private static final String DAY6_1 = "DAY6_1";


    private static final String YEAR6_2 = "YEAR6_2";
    private static final String MONTH6_2 = "MONTH6_2";
    private static final String DAY6_2 = "DAY6_2";

    private static final String YEAR6_3 = "YEAR6_3";
    private static final String MONTH6_3 = "MONTH6_3";
    private static final String DAY6_3 = "DAY6_3";

    private static final String YEAR6_4 = "YEAR6_4";
    private static final String MONTH6_4 = "MONTH6_4";
    private static final String DAY6_4 = "DAY6_4";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou6);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_6_1 = prefs.getInt(YEAR6_1, 0);
        month2_yobou_6_1 = prefs.getInt(MONTH6_1, 0);
        day_yobou_6_1 = prefs.getInt(DAY6_1, 0);
       //2回目の受診日を読み込み
        year_yobou_6_2 = prefs.getInt(YEAR6_2, 0);
        month2_yobou_6_2 = prefs.getInt(MONTH6_2, 0);
        day_yobou_6_2 = prefs.getInt(DAY6_2, 0);
       //3回目の受診日を読み込み
        year_yobou_6_3 = prefs.getInt(YEAR6_3, 0);
        month2_yobou_6_3 = prefs.getInt(MONTH6_3, 0);
        day_yobou_6_3 = prefs.getInt(DAY6_3, 0);
        //4回目の受診日を読み込み
        year_yobou_6_4 = prefs.getInt(YEAR6_4, 0);
        month2_yobou_6_4 = prefs.getInt(MONTH6_4, 0);
        day_yobou_6_4 = prefs.getInt(DAY6_4, 0);





        //初回予防接種の目安(textview)
        TextView txtyobou6_1 = (TextView)findViewById(R.id.txtyobou6_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 90);
        //表示(MONTHに+1を追記)
        String result6_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou6_1.setText(result6_1);


        //2回予防接種の目安(textview)
        TextView txtyobou6_2 = (TextView)findViewById(R.id.txtyobou6_2);
        cal.set(year_yobou_6_1,month2_yobou_6_1,day_yobou_6_1);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        //表示(MONTHに+1を追記)
        String result6_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou6_2.setText(result6_2);


        //3回予防接種の目安(textview)
        TextView txtyobou6_3 = (TextView)findViewById(R.id.txtyobou6_3);
        cal.set(year_yobou_6_2,month2_yobou_6_2,day_yobou_6_2);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        //表示(MONTHに+1を追記)
        String result6_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou6_3.setText(result6_3);

        //4回予防接種の目安(textview)
        TextView txtyobou6_4 = (TextView)findViewById(R.id.txtyobou6_4);
        cal.set(year_yobou_6_3,month2_yobou_6_3,day_yobou_6_3);
        cal.add(Calendar.DAY_OF_MONTH, 366);
        //表示(MONTHに+1を追記)
        String result6_4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou6_4.setText(result6_4);







        //１回目の入力のEdittextに反映
        EditText ed_5_1 = (EditText)findViewById(R.id.yoboued6_1);
        ed_5_1.setText("①"+year_yobou_6_1 + "/" + (month2_yobou_6_1+1)+ "/" +  day_yobou_6_1);


        //2回目の入力のEdittextに反映
        EditText ed_6_2 = (EditText)findViewById(R.id.yoboued6_2);
        ed_6_2.setText("②"+year_yobou_6_2 + "/" + (month2_yobou_6_2+1)+ "/" +  day_yobou_6_2);

        //3回目の入力のEdittextに反映
        EditText ed_6_3 = (EditText)findViewById(R.id.yoboued6_3);
        ed_6_3.setText("③"+year_yobou_6_3 + "/" + (month2_yobou_6_3+1)+ "/" +  day_yobou_6_3);

        //4回目の入力のEdittextに反映
        EditText ed_6_4 = (EditText)findViewById(R.id.yoboued6_4);
        ed_6_4.setText("④"+year_yobou_6_4 + "/" + (month2_yobou_6_4+1)+ "/" +  day_yobou_6_4);




    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked6_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_6_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked6_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_6_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked6_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_6_1_3.class);
        //SubActivityの起動
        startActivity(i);
    }

    public void onclicked6_4(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_6_1_4.class);
        //SubActivityの起動
        startActivity(i);
    }




    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), YobouGamen.class);
        //SubActivityの起動
        startActivity(i);
    }


}
