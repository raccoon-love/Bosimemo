package com.example.sunrise_system.bosimemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by sunrise-system on 2016/10/06.
 */

public class TopGamen extends AppCompatActivity {

    //年、月、日
    private int year;
    private int month;
    private int day;

    private TextView txtBirthDay;
    private TextView txtAge;

    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topgamen);

        //名前の読み込み
        TextView result_cb = (TextView)findViewById(R.id.nametext);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String edittext_preference = sharedPreferences.getString("name", "");
        result_cb.setText(edittext_preference);


        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);



        //Viewの初期化
        txtAge = (TextView)findViewById(R.id.age);

        txtBirthDay = (TextView)findViewById(R.id.birthday);


        txtAge.setText(getAge(year, month + 1, day));
        txtBirthDay.setText(year + "年 " + (month + 1) + "月 " +  day + "日 うまれ");



    }



    //メニュー定義ファイルを元にオプションメニューを生成
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumenu, menu);
        return true;
    }

    //オプションメニューでボタン処理を実装
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //登録変更　Nametourokuページに移動
            case R.id.item1:
                //処理
                Intent i = new Intent(getApplicationContext(), NameTouroku.class);
                //次のActivityの起動
                startActivity(i);
                break;

            //登録削除
            case R.id.item2:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // アラートダイアログのタイトルを設定します
                alertDialogBuilder.setTitle("削除してよろしいですか？");

                // アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
                alertDialogBuilder.setPositiveButton("はい",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //登録されているデータを削除
                                SharedPreferences sp = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.clear();
                                editor.commit();
                                //トーストで表示
                                Toast.makeText(TopGamen.this, "削除しました。", Toast.LENGTH_LONG).show();

                                //ページ移動
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                //次のActivityの起動
                                startActivity(i);
                            }
                        });

                // アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
                alertDialogBuilder.setNegativeButton("いいえ",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                // アラートダイアログのキャンセルが可能かどうかを設定します
                alertDialogBuilder.setCancelable(true);
                AlertDialog alertDialog = alertDialogBuilder.create();
                // アラートダイアログを表示します
                alertDialog.show();

                break;

        }
        return false;
    }





    //年齢を設定する（◯年◯ヶ月◯日）
    private static String getAge(int year, int month, int day) {
        int age;
        int mon;
        int dy;

        String ageStr;
        Calendar cal = Calendar.getInstance();
        int yeartoday = cal.get(Calendar.YEAR);
        int monthtoday = cal.get(Calendar.MONTH)+1;
        int daytoday = cal.get(Calendar.DATE);

        //年を設定
        if( month > monthtoday ){
            age = yeartoday - year - 1;
        }else if( month == monthtoday && day > daytoday ){
            age = yeartoday - year - 1;
        }else{
            age = yeartoday-year;
        }

        //月を設定
        mon=monthtoday-month;
        if(month<monthtoday){
            mon=monthtoday-month;
        }
        if(mon<0){
            mon +=12;
        }


        // 日を設定
        if (daytoday >= day) {
            dy = daytoday - day;
        } else {
            Calendar tmpCal = Calendar.getInstance();
            if (monthtoday == 0) {
                tmpCal.set(monthtoday-1, 11,day);
            } else {
                tmpCal.set(yeartoday, monthtoday-1,day);
            }
            long diffD = cal.getTimeInMillis() - tmpCal.getTimeInMillis();
            Calendar diffCal = Calendar.getInstance();
            diffCal.setTimeInMillis(diffD);
            dy= diffCal.get(Calendar.DATE) - 1;
        }
        ageStr = age + "歳"+mon+"ヶ月"+dy+"日";
        return ageStr;
    }






    // インテントで身長体重ページ移動
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






