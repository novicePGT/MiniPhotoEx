package com.example.miniphotoex;

import static com.example.miniphotoex.MainActivity.angle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class MyGraphicView extends View {
    public MyGraphicView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //상위클래스의 onDraw를 호출한다.
        int cenX = this.getWidth() / 2;
        //
        int cenY = this.getHeight() / 2;
        canvas.rotate(angle, cenX, cenY);
        Bitmap picture= BitmapFactory.decodeResource(getResources(),R.drawable.lena256);

        int picX = (this.getWidth() - picture.getWidth()) / 2;
        //시작X = (View의 너비 - 이미지의 너비) / 2
        int picY = (this.getHeight() - picture.getHeight()) / 2;
        //시작Y = (View의 높이 - 이미지의 너비) / 2 로 picX, picY는 이미지를 화면의 중앙에 출력하는 메소드이다.
        canvas.drawBitmap(picture, picX, picY, null);
        //이미지를 화면에 출력하는 메소드이다.
        picture.recycle();
        //비트맵의 리소스를 해제한다.
    }
}
