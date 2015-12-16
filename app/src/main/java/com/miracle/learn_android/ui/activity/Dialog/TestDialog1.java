package com.miracle.learn_android.ui.activity.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.miracle.learn_android.R;

/**
 * Created by gongzhuo on 15/12/16.
 */
public class TestDialog1 extends Activity implements View.OnClickListener {
    private Button mBtnDftDialog;
    private Button mBtnListDialog;
    private Button mSingleChoiceDialog;
    private Button mMultiChoiceDialog;
    private Button mProgressSpinnerDialog;
    private Button mProgressHorizontalDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_test_dialog1);

        mBtnDftDialog = (Button)findViewById(R.id.btn_default_dialog);
        mBtnDftDialog.setOnClickListener(this);

        mBtnListDialog = (Button)findViewById(R.id.btn_list_dialog);
        mBtnListDialog.setOnClickListener(this);

        mSingleChoiceDialog = (Button)findViewById(R.id.btn_single_choice_dialog);
        mSingleChoiceDialog.setOnClickListener(this);

        mMultiChoiceDialog = (Button)findViewById(R.id.btn_multi_choice_dialog);
        mMultiChoiceDialog.setOnClickListener(this);

        mProgressSpinnerDialog = (Button)findViewById(R.id.btn_progress_spinner_dialog);
        mProgressSpinnerDialog.setOnClickListener(this);

        mProgressHorizontalDialog = (Button)findViewById(R.id.btn_progress_horizontal_dialog);
        mProgressHorizontalDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_default_dialog:
                generateDftDialog();
                break;
            case R.id.btn_list_dialog:
                generateListDialog();
                break;
            case R.id.btn_single_choice_dialog:
                generateSingleChoiceDialog();
                break;
            case R.id.btn_multi_choice_dialog:
                generateMultiChoiceDialog();
                break;
            case R.id.btn_progress_spinner_dialog:
                generateProgressSpinnerDialog();
                break;
            case R.id.btn_progress_horizontal_dialog:
                generateProgressHorizontalDialog();
        }
    }

    private void generateDftDialog() {
        DialogInterface.OnClickListener clickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(TestDialog1.this,"确定"+which,Toast.LENGTH_LONG).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(TestDialog1.this,"取消"+which,Toast.LENGTH_LONG).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(TestDialog1.this,"忽略"+which,Toast.LENGTH_LONG).show();
                        break;

                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(TestDialog1.this);
        builder.setTitle("提示");
        builder.setMessage("弹出对话框");
        builder.setIcon(R.drawable.icon_android);
        builder.setPositiveButton("确定",clickListener);
        builder.setNegativeButton("取消",clickListener);
        builder.setNeutralButton("忽略",clickListener);
        builder.create().show();
    }


    private void generateListDialog() {
        final String items[] = {"item1","item2","item3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(TestDialog1.this);
        builder.setTitle("提示");
        builder.setIcon(R.drawable.icon_android);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(TestDialog1.this, items[which], Toast.LENGTH_LONG).show();
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(TestDialog1.this, "确定", Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }

    private void generateSingleChoiceDialog() {
        final String items[] = {"男","女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(TestDialog1.this);
        builder.setTitle("提示")
                .setSingleChoiceItems(items,0,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestDialog1.this,items[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(TestDialog1.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

    private void generateMultiChoiceDialog() {
        final String[] items = {"篮球","足球","排球","网球","乒乓球","橄榄球"};
        final boolean[] selected = {true,false,false,true,false,false};
        AlertDialog.Builder builder = new AlertDialog.Builder(TestDialog1.this);
        builder.setTitle("确定")
                .setIcon(R.drawable.icon_android)
                .setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(TestDialog1.this, items[which] + isChecked, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestDialog1.this,"确定",Toast.LENGTH_SHORT).show();
                        for(int i = 0; i < selected.length; ++i) {
                            Log.i("vincent", "i=" + i + ",seleted=" + selected[i]);
                        }
                    }
                })
                .create().show();
    }

    private void generateProgressSpinnerDialog() {
        ProgressDialog dialog = new ProgressDialog(TestDialog1.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("提示");
        dialog.setMessage("这是一个圆形进度条对话框");
        dialog.setIcon(R.drawable.icon_android);
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }


    private void generateProgressHorizontalDialog() {
        final ProgressDialog dialog = new ProgressDialog(TestDialog1.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("提示");
        dialog.setMessage("这是一个水平对话框进度条");
        dialog.setIcon(R.drawable.icon_android);
        dialog.setIndeterminate(false);//dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.setMax(100);
        dialog.show();
        dialog.setProgress(50);//setProgress should be set after show()

        new Thread() {
            @Override
            public void run() {
                int count = 0;
                try {
                    while ( count <= 200) {
                        dialog.setProgress(count++);
                        Thread.sleep(100);
                    }
                    dialog.cancel();
                } catch (InterruptedException e) {
                    dialog.cancel();
                }
            }
        }.start();
        
    }

}


/*
备注：ProgressDialog的setProgress()方法要在show()之后调用，否者进度条还是0

 */