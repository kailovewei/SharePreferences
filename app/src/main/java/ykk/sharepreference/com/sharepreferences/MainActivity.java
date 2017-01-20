package ykk.sharepreference.com.sharepreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//SharedPreference存储数据主要是用于存储一些键值对
public class MainActivity extends AppCompatActivity {
    private Button s_button;
    private  Button r_button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_button= (Button) findViewById(R.id.save_Id);
        r_button= (Button) findViewById(R.id.restore_Id);
        editText= (EditText) findViewById(R.id.edit_Id);
        //保存数据监听器
        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用SharedPreferences对象的edit()方法获取一个SharedPreferences.Editor对象。
                SharedPreferences.Editor editor=getSharedPreferences("yan",MODE_PRIVATE).edit();
                //利用put()方法向对象中添加数据.
                editor.putString("name","yan");
                editor.putInt("age",23);
                editor.putBoolean("married",false);
                //将添加的数据提交。
                editor.commit();
            }
        });
        //获取数据监听器
        r_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 生成一个SharedPreferences对象
                SharedPreferences pref=getSharedPreferences("yan",MODE_PRIVATE);
                //使用对象中的get方法得到存储的内容。
                //第二个参数是一个默认值，既表示当传入的键找不到对应的值时，会以什么样的默认值进行返回。
                String name=pref.getString("name"," ");
                int age=pref.getInt("age",0);
                boolean married= pref.getBoolean("marred",false);
                editText.setText("name:"+name+"    age:"+age+"   married:"+married);

            }
        });
    }
}
