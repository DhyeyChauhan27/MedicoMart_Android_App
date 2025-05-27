package com.example.medicomart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class DetailsViewActivity extends AppCompatActivity {

    TextView modelTextView,priceTextView,mdeliverTextView;
    ImageView productImageView,Back_button;
    Button orderemail,ordersms,qrcode;

    QRGEncoder qrgEncoder;
    Bitmap bitmap;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_view);


        modelTextView=findViewById(R.id.mname);
        priceTextView=findViewById(R.id.mprice);
        mdeliverTextView=findViewById(R.id.mdeliver);
        productImageView=findViewById(R.id.imageView);

        String mname = getIntent().getStringExtra("mname");
        String mprice= getIntent().getStringExtra("mprice");
        String mdeliver= getIntent().getStringExtra("mdeliver");
        String image = getIntent().getStringExtra("image");

        modelTextView.setText(mname);
        priceTextView.setText(mprice);
        mdeliverTextView.setText(mdeliver);
        Picasso.get().load(image).into(productImageView);

        orderemail=findViewById(R.id.orderemail);
        orderemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"dhyeychauhan052@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "BCA");
                email.putExtra(Intent.EXTRA_TEXT,"");
                email.setType("message/rfc822");
                startActivity(email);
            }
        });

        ordersms=findViewById(R.id.ordersms);
        ordersms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sms = new Intent(Intent.ACTION_VIEW);
                Sms.setData(Uri.parse("smsto:9429961716"));
                Sms.putExtra("sms_body","medicomart");
                startActivity(Sms);
            }
        });

        Back_button=findViewById(R.id.Back_button);
        Back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DetailsViewActivity.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        qrcode=findViewById(R.id.qrcode);
        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                Display display = windowManager.getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                int width = point.x;
                int height = point.y;

                int dimen=width < height? width:height;

                qrgEncoder = new QRGEncoder("dhyeychauhan052@oksbi "+mprice,null, QRGContents.Type.TEXT,dimen);

                try {
                    bitmap =qrgEncoder.getBitmap();
                    productImageView.setImageBitmap(bitmap);
                }catch (Exception e)
                {
                    Log.e("Tag",e.toString());
                }

            }
        });

       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}