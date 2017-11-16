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

public class Yobou3 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_3_1;
    private int month2_yobou_3_1;
    private int day_yobou_3_1;


    private int year_yobou_3_2;
    private int month2_yobou_3_2;
    private int day_yobou_3_2;

    private int year_yobou_3_3;
    private int month2_yobou_3_3;
    private int day_yobou_3_3;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR3_1 = "YEAR3_1";
    private static final String MONTH3_1 = "MONTH3_1";
    private static final String DAY3_1 = "DAY3_1";


    private static final String YEAR3_2 = "YEAR3_2";
    private static final String MONTH3_2 = "MONTH3_2";
    private static final String DAY3_2 = "DAY3_2";

    private static final String YEAR3_3 = "YEAR3_3";
    private static final String MONTH3_3 = "MONTH3_3";
    private static final String DAY3_3 = "DAY3_3";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou3);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_3_1 = prefs.getInt(YEAR3_1, 0);
        month2_yobou_3_1 = prefs.getInt(MONTH3_1, 0);
        day_yobou_3_1 = prefs.getInt(DAY3_1, 0);
        //2回目の受診日を読み込み
        year_yobou_3_2 = prefs.getInt(YEAR3_2, 0);
        month2_yobou_3_2 = prefs.getInt(MONTH3_2, 0);
        day_yobou_3_2 = prefs.getInt(DAY3_2, 0);
        //3回目の受診日を読み込み
        year_yobou_3_3 = prefs.getInt(YEAR3_3, 0);
        month2_yobou_3_3 = prefs.getInt(MONTH3_3, 0);
        day_yobou_3_3 = prefs.getInt(DAY3_3, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou3_1 = (TextView)findViewById(R.id.txtyobou3_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 60);
        //表示(MONTHに+1を追記)
        String result3_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou3_1.setText(result3_1);


        //2回予防接種の目安(textview)
        TextView txtyobou3_2 = (TextView)findViewById(R.id.txtyobou3_2);
        cal.set(year_yobou_3_1,month2_yobou_3_1,day_yobou_3_1);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result3_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou3_2.setText(result3_2);


        //3回予防接種の目安(textview)1回目から139日あける
        TextView txtyobou3_3 = (TextView)findViewById(R.id.txtyobou3_3);
        cal.set(year_yobou_3_1,month2_yobou_3_1,day_yobou_3_1);
        cal.add(Calendar.DAY_OF_MONTH, 139);
        //表示(MONTHに+1を追記)
        String result3_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou3_3.setText(result3_3);







        //１回目の入力のEdittextに反映
        EditText ed_3_1 = (EditText)findViewById(R.id.yoboued3_1);
        ed_3_1.setText("①"+year_yobou_3_1 + "/" + (month2_yobou_3_1+1)+ "/" +  day_yobou_3_1);


        //2回目の入力のEdittextに反映
        EditText ed_3_2 = (EditText)findViewById(R.id.yoboued3_2);
        ed_3_2.setText("②"+year_yobou_3_2 + "/" + (month2_yobou_3_2+1)+ "/" +  day_yobou_3_2);

        //3回目の入力のEdittextに反映
        EditText ed_3_3 = (EditText)findViewById(R.id.yoboued3_3);
        ed_3_3.setText("③"+year_yobou_3_3 + "/" + (month2_yobou_3_3+1)+ "/" +  day_yobou_3_3);





    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked3_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_3_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked3_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_3_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked3_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_3_1_3.class);
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
