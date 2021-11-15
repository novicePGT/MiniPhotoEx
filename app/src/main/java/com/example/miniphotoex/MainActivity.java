package com.example.miniphotoex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton btnRotate1, btnRotate2;
    //이미지 버튼에 대한 로테이션버튼 2개를 전역변수로 선언했다.
    MyGraphicView graphicView;
    //클래스 변수 1개를 전역변수로 선언했다.
    static float angle = 0;
    //angle에 실수의 값이 대입될 수 있게 float를 써주었고, MyGraphicView에서도 사용 가능하게 static을 사용하였다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");
        //타이틀을 미니 포토샵이라고 설정하였다.

        LinearLayout pictureLayout= (LinearLayout) findViewById(R.id.pictureLayout);
        //pictureLayout의 변수에 하단 리니어레이아웃을 대입하였다.
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        /* graphicView부터 addView까지는 아직 잘 모르겠습니다.. */

        btnRotate1 = (ImageButton) findViewById(R.id.btnRotate1);
        //btnRotate1에 버튼위젯을 대입하였다.
        btnRotate2 = (ImageButton) findViewById(R.id.btnRotate2);
        //btnRotate2에 btnRotate2 버튼 위젯을 대입하였다.

        btnRotate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btnRotate1 버튼에 대한 이벤트처리 메소드이다.
                angle = angle + 45;
                //angle의 변수에 버튼을 누를수록 45씩 증가하는 메소드이다.
                graphicView.invalidate();
                //graphicView에게 invalidate가 호출되면 화면이 무효화되고, onDraw메소드를 자동으로 실행해준다.
            }
        });

        btnRotate2.setOnClickListener(new View.OnClickListener() {
            @Override
            //btnRotate2 버튼에 대한 이벤트 처리 메소드이다.
            public void onClick(View view) {
                angle = angle - 45;
                //angle의 변수에 버튼을 누를수록 45씩 감소하는 메소드이다.
                graphicView.invalidate();
                //graphicView에게 invalidate가 호출되면 화면이 무효화되고, onDraw메소드를 자동으로 실행해준다.
            }
        });
    }
}