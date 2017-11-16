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

public class Yobou_1_1_2 extends Activity {


    //摂取目安テキスト
    private TextView meyasu2;


    //年、月、日
    private int year_yobou_1_2;
    private int month2_yobou_1_2;
    private int day_yobou_1_2;

    private int year_yobou_1_1;
    private int month2_yobou_1_1;
    private int day_yobou_1_1;


    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR1_1 = "YEAR1_1";
    private static final String MONTH1_1 = "MONTH1_1";
    private static final String DAY1_1 = "DAY1_1";




    public void onCreate(Bundle savedInstanceState) {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou_1_1_2);


        //1回目受診日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year_yobou_1_1 = prefs.getInt(YEAR1_1, 0);
        month2_yobou_1_1 = prefs.getInt(MONTH1_1, 0);
        day_yobou_1_1 = prefs.getInt(DAY1_1, 0);


        //初回予防接種の目安
        meyasu2 = (TextView)findViewById(R.id.meyasu2);
        cal.set(year_yobou_1_1,month2_yobou_1_1,day_yobou_1_1);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        meyasu2.setText(result);








        //EditText未記入がないかチェック＆ボタンを押すと保存＆ページ遷移
        View saveButton = (Button) findViewById(R.id.save1_1_2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameText1_1_1 = (EditText)findViewById(R.id.edityobou1_2);


                //未記入があるかチェック
                if(nameText1_1_1.getText().toString().equals("") == false)
                {


                    //1回目接種日を本体に記憶する
                    savePrefs1_2();

                    Intent i = new Intent(getApplicationContext(), Yobou1.class);

                    //SubActivityの起動
                    startActivity(i);
                }else {   //未記入があるとページ遷移できずトースト表示
                    Toast.makeText(Yobou_1_1_2.this, "日付を入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();



    //2回目のedittextを押すと日付を出す
    public void onclick_ed_1_2(View view) {
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Yobou_1_1_2.this.year_yobou_1_2 = year;
                month2_yobou_1_2 = monthOfYear;
                day_yobou_1_2 = dayOfMonth;


                EditText txtDate = (EditText) Yobou_1_1_2.this.findViewById(R.id.edityobou1_2);
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
    private void savePrefs1_2() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("YEAR1_2", year_yobou_1_2);
        editor.putInt("MONTH1_2", month2_yobou_1_2);
        editor.putInt("DAY1_2", day_yobou_1_2);
        editor.commit();

    }


    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou1.class);
        //SubActivityの起動
        startActivity(i);
    }
}
