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

public class Yobou1 extends Activity {

    //カレンダー変数
 //   Calendar cal;

    //摂取目安テキスト
    private TextView txtyobou1;
    private TextView txtyobou2;


    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_1_1;
    private int month2_yobou_1_1;
    private int day_yobou_1_1;


    private int year_yobou_1_2;
    private int month2_yobou_1_2;
    private int day_yobou_1_2;

    private int year_yobou_1_3;
    private int month2_yobou_1_3;
    private int day_yobou_1_3;

    private int year_yobou_1_4;
    private int month2_yobou_1_4;
    private int day_yobou_1_4;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR1_1 = "YEAR1_1";
    private static final String MONTH1_1 = "MONTH1_1";
    private static final String DAY1_1 = "DAY1_1";


    private static final String YEAR1_2 = "YEAR1_2";
    private static final String MONTH1_2 = "MONTH1_2";
    private static final String DAY1_2 = "DAY1_2";

    private static final String YEAR1_3 = "YEAR1_3";
    private static final String MONTH1_3 = "MONTH1_3";
    private static final String DAY1_3 = "DAY1_3";

    private static final String YEAR1_4 = "YEAR1_4";
    private static final String MONTH1_4 = "MONTH1_4";
    private static final String DAY1_4 = "DAY1_4";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou1);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_1_1 = prefs.getInt(YEAR1_1, 0);
        month2_yobou_1_1 = prefs.getInt(MONTH1_1, 0);
        day_yobou_1_1 = prefs.getInt(DAY1_1, 0);
        //2回目の受診日を読み込み
        year_yobou_1_2 = prefs.getInt(YEAR1_2, 0);
        month2_yobou_1_2 = prefs.getInt(MONTH1_2, 0);
        day_yobou_1_2 = prefs.getInt(DAY1_2, 0);
        //3回目の受診日を読み込み
        year_yobou_1_3 = prefs.getInt(YEAR1_3, 0);
        month2_yobou_1_3 = prefs.getInt(MONTH1_3, 0);
        day_yobou_1_3 = prefs.getInt(DAY1_3, 0);
        //3回目の受診日を読み込み
        year_yobou_1_4 = prefs.getInt(YEAR1_4, 0);
        month2_yobou_1_4 = prefs.getInt(MONTH1_4, 0);
        day_yobou_1_4 = prefs.getInt(DAY1_4, 0);






        //初回予防接種の目安(textview)
        txtyobou1 = (TextView)findViewById(R.id.yoboutx1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 60);
        //表示(MONTHに+1を追記)
        String result = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou1.setText(result);


        //2回予防接種の目安(textview)
        txtyobou2 = (TextView)findViewById(R.id.yoboutx2);
        cal.set(year_yobou_1_1,month2_yobou_1_1,day_yobou_1_1);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～※";
        txtyobou2.setText(result2);


        //3回予防接種の目安(textview)
        TextView txtyobou3 = (TextView)findViewById(R.id.yoboutx3);
        cal.set(year_yobou_1_2,month2_yobou_1_2,day_yobou_1_2);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～※";
        txtyobou3.setText(result3);

        //4回予防接種の目安(textview)
        TextView txtyobou4 = (TextView)findViewById(R.id.yoboutx4);
        cal.set(year_yobou_1_1,month2_yobou_1_1,day_yobou_1_1);
        cal.add(Calendar.DAY_OF_MONTH, 210);
        //表示(MONTHに+1を追記)
        String result4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou4.setText(result4);








        //１回目の入力のEdittextに反映
        EditText ed_1_1 = (EditText)findViewById(R.id.yoboued1);
        ed_1_1.setText("①"+year_yobou_1_1 + "/" + (month2_yobou_1_1+1)+ "/" +  day_yobou_1_1);

        //2回目の入力のEdittextに反映
        EditText ed_1_2 = (EditText)findViewById(R.id.yoboued2);
        ed_1_2.setText("②"+year_yobou_1_2 + "/" + (month2_yobou_1_2+1)+ "/" +  day_yobou_1_2);

        //3回目の入力のEdittextに反映
        EditText ed_1_3 = (EditText)findViewById(R.id.yoboued3);
        ed_1_3.setText("③"+year_yobou_1_3 + "/" + (month2_yobou_1_3+1)+ "/" +  day_yobou_1_3);

        //4回目の入力のEdittextに反映
        EditText ed_1_4 = (EditText)findViewById(R.id.yoboued4);
        ed_1_4.setText("④"+year_yobou_1_4 + "/" + (month2_yobou_1_4+1)+ "/" +  day_yobou_1_4);




    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked1(View view) {
        // インテントで予防接種ページ移動
            Intent i = new Intent(getApplicationContext(), Yobou_1_1_1.class);
            //SubActivityの起動
            startActivity(i);
        }


    public void onclicked2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_1_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_1_1_3.class);
        //SubActivityの起動
        startActivity(i);
    }

    public void onclicked4(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_1_1_4.class);
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
