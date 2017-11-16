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

public class Yobou12 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_12_1;
    private int month2_yobou_12_1;
    private int day_yobou_12_1;


    private int year_yobou_12_2;
    private int month2_yobou_12_2;
    private int day_yobou_12_2;

    private int year_yobou_12_3;
    private int month2_yobou_12_3;
    private int day_yobou_12_3;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR12_1 = "YEAR12_1";
    private static final String MONTH12_1 = "MONTH12_1";
    private static final String DAY12_1 = "DAY12_1";


    private static final String YEAR12_2 = "YEAR12_2";
    private static final String MONTH12_2 = "MONTH12_2";
    private static final String DAY12_2 = "DAY12_2";

    private static final String YEAR12_3 = "YEAR12_3";
    private static final String MONTH12_3 = "MONTH12_3";
    private static final String DAY12_3 = "DAY12_3";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou12);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_12_1 = prefs.getInt(YEAR12_1, 0);
        month2_yobou_12_1 = prefs.getInt(MONTH12_1, 0);
        day_yobou_12_1 = prefs.getInt(DAY12_1, 0);
        //2回目の受診日を読み込み
        year_yobou_12_2 = prefs.getInt(YEAR12_2, 0);
        month2_yobou_12_2 = prefs.getInt(MONTH12_2, 0);
        day_yobou_12_2 = prefs.getInt(DAY12_2, 0);
        //3回目の受診日を読み込み
        year_yobou_12_3 = prefs.getInt(YEAR12_3, 0);
        month2_yobou_12_3 = prefs.getInt(MONTH12_3, 0);
        day_yobou_12_3 = prefs.getInt(DAY12_3, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou12_1 = (TextView)findViewById(R.id.txtyobou12_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 43);
        //表示(MONTHに+1を追記)
        String result12_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou12_1.setText(result12_1);


        //2回予防接種の目安(textview)
        TextView txtyobou12_2 = (TextView)findViewById(R.id.txtyobou12_2);
        cal.set(year_yobou_12_1,month2_yobou_12_1,day_yobou_12_1);
        cal.add(Calendar.DAY_OF_MONTH, 29);
        //表示(MONTHに+1を追記)
        String result12_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou12_2.setText(result12_2);


        //3回予防接種の目安(textview)
        TextView txtyobou12_3 = (TextView)findViewById(R.id.txtyobou12_3);
        cal.set(year_yobou_12_2,month2_yobou_12_2,day_yobou_12_2);
        cal.add(Calendar.DAY_OF_MONTH, 29);
        //表示(MONTHに+1を追記)
        String result12_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou12_3.setText(result12_3);







        //１回目の入力のEdittextに反映
        EditText ed_12_1 = (EditText)findViewById(R.id.yoboued12_1);
        ed_12_1.setText("①"+year_yobou_12_1 + "/" + (month2_yobou_12_1+1)+ "/" +  day_yobou_12_1);


        //2回目の入力のEdittextに反映
        EditText ed_12_2 = (EditText)findViewById(R.id.yoboued12_2);
        ed_12_2.setText("②"+year_yobou_12_2 + "/" + (month2_yobou_12_2+1)+ "/" +  day_yobou_12_2);

        //3回目の入力のEdittextに反映
        EditText ed_12_3 = (EditText)findViewById(R.id.yoboued12_3);
        ed_12_3.setText("③"+year_yobou_12_3 + "/" + (month2_yobou_12_3+1)+ "/" +  day_yobou_12_3);





    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked12_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_12_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked12_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_12_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked12_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_12_1_3.class);
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
