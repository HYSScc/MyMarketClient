package com.gthncz.mymarketclient.main;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.gthncz.mymarketclient.grant.GrantActivity;
import com.gthncz.mymarketclient.payment.BPayActivity;

/**
 * 扫描结果分派类
 * Created by GT on 2018/5/9.
 */

public class ScanResDispatch {

    private static final String MARKET = "market://";
    private static final String[] ACTIONS = {"grant", "login", "balancePay"};// ...

    private ScanResDispatch(){}

    /**
     * 分派
     * @param rawResult 扫描结果
     */
    public static final void dispatch(final Context context, final String rawResult){
        int pos = rawResult.indexOf(MARKET);
        if(pos != -1){// 无人超市类型
            String str = rawResult.substring(pos+MARKET.length());
            pos = str.indexOf('/');
            String action = str.substring(0, pos);
            action.toLowerCase();
            Log.e(ScanResDispatch.class.getSimpleName(), "** 信息 >> action:" + action);
            if(action.equals(ACTIONS[0])){//授权请求
                String token = str.substring(pos+1);
                Log.e(ScanResDispatch.class.getSimpleName(), "** 信息 >> token:" + token);
                handleGrantReq(context, token);
            }else if(action.equals(ACTIONS[1])){//登陆请求
                // TODO 登陆请求
            }else if(action.equals(ACTIONS[2])){//支付请求
                String token = str.substring(pos+1);
                Log.e(ScanResDispatch.class.getSimpleName(), "** 信息 >> token:" + token);
                handlerBalancePayReq(context, token);
            }else{//显示链接，有另外的界面显示
                handlerOthers(context ,rawResult);
            }
        }else{
            handlerOthers(context ,rawResult);
        }
    }

    private static void handlerBalancePayReq(Context context, String token) {
        // TODO 处理余额支付请求
        Intent intent = new Intent(context, BPayActivity.class);
        intent.putExtra("token", token);
        context.startActivity(intent);
    }

    private static void handleGrantReq(Context context,final String token) {
        Intent intent = new Intent(context, GrantActivity.class);
        intent.putExtra("token", token);
        context.startActivity(intent);
    }

    private static void handlerOthers(Context context, String rawResult){
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle("扫一扫");
        builder.setMessage("获得Scanner返回数据:\r\n" + rawResult);
        builder.setPositiveButton("复制到剪贴板", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("plaintext", rawResult);
                clipboardManager.setPrimaryClip(clipData);
            }
        });
        builder.setNegativeButton("取消", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
