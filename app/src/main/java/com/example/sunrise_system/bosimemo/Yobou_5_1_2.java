package com.example.sunrise_system.bosimemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by sunrise-system on 2016/10/19.
 */

public class Yobou_5_1_2 extends Activity {




    //年、月、日
    private int year_yobou_5_2;
    private int month2_yobou_5_2;
    private int day_yobou_5_2;

    private int year_yobou_5_1;
    private int month2_yobou_5_1;
    private int day_yobou_5_1;


    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR5_1 = "YEAR5_1";
    private static final String MONTH5_1 = "MONTH5_1";
    private static final String DAY5_1 = "DAY5_1";




    public void onCreate(Bundle savedInstanceState) {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou_5_1_2);


        //1回目受診日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year_yobou_5_1 = prefs.getInt(YEAR5_1, 0);
        month2_yobou_5_1 = prefs.getInt(MONTH5_1, 0);
        day_yobou_5_1 = prefs.getInt(DAY5_1, 0);


        //初回予防接種の目安
        TextView meyasu5_2 = (TextView)findViewById(R.id.meyasu5_2);
        cal.set(year_yobou_5_1,month2_yobou_5_1,day_yobou_5_1);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        //表示(MONTHに+1を追記)
        String result = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        meyasu5_2.setText(result);








        //EditText未記入がないかチェック＆ボタンを押すと保存＆ページ遷移
        View saveButton5_2 = (Button) findViewById(R.id.save5_2);
        saveButton5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameText1_1_1 = (EditText)findViewById(R.id.edityobou5_2);


                //未記入があるかチェック
                if(nameText1_1_1.getText().toString().equals("") == false)
                {


                    //1回目接種日を本体に記憶する
                    savePrefs5_2();

                    Intent i = new Intent(getApplicationContext(), Yobou5.class);

                    //SubActivityの起動
                    startActivity(i);
                }else {   //未記入があるとページ遷移できずトースト表示
                    Toast.makeText(Yobou_5_1_2.this, "日付を入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();



    //2回目のedittextを押すと日付を出す
    public void onclick_ed_5_2(View view) {
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Yobou_5_1_2.this.year_yobou_5_2 = year;
                month2_yobou_5_2 = monthOfYear;
                day_yobou_5_2 = dayOfMonth;


                EditText txtDate = (EditText) Yobou_5_1_2.this.findViewById(R.id.edityobou5_2);
                // Setした日付を取得する
                txtDate.setText(String.format("%02d/%02d/%02d", year, monthOfYear + 1, dayOfMonth));
            }
        },
                cal.get(java.util.Calendar.YEAR),
                cal.get(java.util.Calendar.MONTH),
                cal.get(java.util.Calendar.DAY_OF_MONTH)
        );
        // ダイアログを表示する
        d_date.show();


    }




    //プレファレンスに保存
    private void savePrefs5_2() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("YEAR5_2", year_yobou_5_2);
        editor.putInt("MONTH5_2", month2_yobou_5_2);
        editor.putInt("DAY5_2", day_yobou_5_2);
        editor.commit();

    }


    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou5.class);
        //SubActivityの起動
        startActivity(i);
    }
}
