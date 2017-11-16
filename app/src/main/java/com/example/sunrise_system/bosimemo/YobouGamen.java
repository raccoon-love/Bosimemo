package com.example.sunrise_system.bosimemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sunrise-system on 2016/10/06.
 */

public class YobouGamen extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;

    private TextView txtAge;

    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobougmn);

        TextView namename = (TextView)findViewById(R.id.nametxt);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String edittext_preference = sharedPreferences.getString("name", "");
        namename.setText(edittext_preference);



        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);



        //Viewの初期化
        txtAge = (TextView)findViewById(R.id.textage);



        txtAge.setText(getAge(year, month + 1, day));



        // リソースに準備した画像ファイルからBitmapを作成しておく
        Bitmap ninni;
        ninni = BitmapFactory.decodeResource(getResources(), R.drawable.nini);

        Bitmap teiki;
        teiki = BitmapFactory.decodeResource(getResources(), R.drawable.teiki);


        // データの作成
        List<ListViewCustomData> objects = new ArrayList<ListViewCustomData>();



        ListViewCustomData item1 = new ListViewCustomData();
        item1.setImagaData(teiki);
        item1.setTextData("Hibワクチン");
        item1.setTextData2(" 次回受診目安");


        ListViewCustomData item2 = new ListViewCustomData();
        item2.setImagaData(teiki);
        item2.setTextData("小児用肺炎球菌ワクチン");
        item2.setTextData2(" 次回受診目安");

        ListViewCustomData item3 = new ListViewCustomData();
        item3.setImagaData(teiki);
        item3.setTextData("B型肝炎(HBV)ワクチン");
        item3.setTextData2(" 次回受診目安");

        ListViewCustomData item4 = new ListViewCustomData();
        item4.setImagaData(teiki);
        item4.setTextData("四種混合(DPT-IPV)ワクチン");
        item4.setTextData2(" 次回受診目安");

        ListViewCustomData item5 = new ListViewCustomData();
        item5.setImagaData(teiki);
        item5.setTextData("三種混合(DPT)ワクチン");
        item5.setTextData2(" 次回受診目安");

        ListViewCustomData item6 = new ListViewCustomData();
        item6.setImagaData(teiki);
        item6.setTextData("不活化ポリオワクチン");
        item6.setTextData2(" 次回受診目安");

        ListViewCustomData item7 = new ListViewCustomData();
        item7.setImagaData(teiki);
        item7.setTextData("BCGワクチン");
        item7.setTextData2(" 次回受診目安");

        ListViewCustomData item8 = new ListViewCustomData();
        item8.setImagaData(teiki);
        item8.setTextData("麻しん・風しん(MR)ワクチン");
        item8.setTextData2(" 次回受診目安");

        ListViewCustomData item9 = new ListViewCustomData();
        item9.setImagaData(teiki);
        item9.setTextData("水痘ワクチン");
        item9.setTextData2(" 次回受診目安");

        ListViewCustomData item10 = new ListViewCustomData();
        item10.setImagaData(teiki);
        item10.setTextData("日本脳炎ワクチン");
        item10.setTextData2(" 次回受診目安");

        ListViewCustomData item11 = new ListViewCustomData();
        item11.setImagaData(teiki);
        item11.setTextData("二種混合(DT)ワクチン");
        item11.setTextData2(" 次回受診目安");

        ListViewCustomData item12 = new ListViewCustomData();
        item12.setImagaData(ninni);
        item12.setTextData("ロタウイルスワクチン");
        item12.setTextData2(" 次回受診目安");

        ListViewCustomData item13 = new ListViewCustomData();
        item13.setImagaData(ninni);
        item13.setTextData("おたふくかぜワクチン");
        item13.setTextData2(" 次回受診目安");

        ListViewCustomData item14 = new ListViewCustomData();
        item14.setImagaData( ninni);
        item14.setTextData("インフルエンザワクチン");
        item14.setTextData2(" 次回受診目安");




        objects.add(item1);
        objects.add(item2);
        objects.add(item3);
        objects.add(item4);
        objects.add(item5);
        objects.add(item6);
        objects.add(item7);
        objects.add(item8);
        objects.add(item9);
        objects.add(item10);
        objects.add(item11);
        objects.add(item12);
        objects.add(item13);
        objects.add(item14);

        ListViewCustomAdapter customAdapater = new ListViewCustomAdapter(this, 0, objects);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(customAdapater);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                switch (position) {
                    case 0:
                        Intent i = new Intent(getApplicationContext(), Yobou1.class);
                        //SubActivityの起動
                        startActivity(i);
                        break;
                    case 1:
                        Intent io = new Intent(getApplicationContext(), Yobou2.class);
                        //SubActivityの起動
                        startActivity(io);
                        break;
                    case 2:
                        Intent i2 = new Intent(getApplicationContext(), Yobou3.class);
                        //SubActivityの起動
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getApplicationContext(), Yobou4.class);
                        //SubActivityの起動
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getApplicationContext(), Yobou5.class);
                        //SubActivityの起動
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getApplicationContext(), Yobou6.class);
                        //SubActivityの起動
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(getApplicationContext(), Yobou7.class);
                        //SubActivityの起動
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(getApplicationContext(), Yobou8.class);
                        //SubActivityの起動
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(getApplicationContext(), Yobou9.class);
                        //SubActivityの起動
                        startActivity(i8);
                        break;
                    case 9:
                        Intent i9 = new Intent(getApplicationContext(), Yobou10.class);
                        //SubActivityの起動
                        startActivity(i9);
                        break;
                    case 10:
                        Intent i10 = new Intent(getApplicationContext(), Yobou11.class);
                        //SubActivityの起動
                        startActivity(i10);
                        break;
                    case 11:
                        Intent i11 = new Intent(getApplicationContext(), Yobou12.class);
                        //SubActivityの起動
                        startActivity(i11);
                        break;
                    case 12:
                        Intent i12 = new Intent(getApplicationContext(), Yobou13.class);
                        //SubActivityの起動
                        startActivity(i12);
                        break;
                    case 13:
                        Intent i13 = new Intent(getApplicationContext(), Yobou14.class);
                        //SubActivityの起動
                        startActivity(i13);
                        break;
                }

            }
        });


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





    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), TopGamen.class);
        //SubActivityの起動
        startActivity(i);
    }

}
