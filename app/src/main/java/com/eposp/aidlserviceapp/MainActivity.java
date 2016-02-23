package com.eposp.aidlserviceapp;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private String strTransType="trade";// 交易类型
    private String strOrderId="11111111111111111";// 订单号
    private String strTransTime="20160222";// 交易时间
    private String strAmount="100";// 交易金额
    private String strCardNo="6222521544545784";// 交易卡号
    private String strTerminalNo="123456789";// 终端编号
    private String strPosMid="123123123";// 商户编号
    private String strMechantName="xqf";// 顶级商户名
    private String strSignPic;// 签名图片名
    private String strTempOrderId;
    private String strBillNo;//上传图片需要的
    String SUCCESS="SUCCESS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void payendClick(View v){
        try {
            MyIntentService.mIRemoteServiceCallback.payEnd(
                    true, SUCCESS,"{\n" +
                            "  \"status\":"+SUCCESS +",\n" +
                            "  \"MerchantName\":"+strMechantName+",\n" +
                            "  \"PosMid\":"+strPosMid+",\n" +
                            "\"TerminalNo\":"+strTerminalNo+",\n" +
                            "\"CardNo\":"+strCardNo+",\n" +
                            "\"TransType\": "+strTransType+",\n" +
                            "\"OrderId\":"+strOrderId+",\n" +
                            "\"Amount\":"+strAmount+",\n" +
                            "\"TransTime\":"+strTransTime+",\n" +
                            "}");
        } catch (RemoteException e) {
            e.printStackTrace();

        }
        finish();
    }
}
