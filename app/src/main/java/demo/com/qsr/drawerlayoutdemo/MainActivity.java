package demo.com.qsr.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.gridView)
    GridView gridView;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //当抽屉拉出时
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //当抽屉打开时
                Toast.makeText(MainActivity.this,"抽屉打开了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //当抽屉关闭时
                Toast.makeText(MainActivity.this,"抽屉关闭了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                //当抽屉状态改变时
                Toast.makeText(MainActivity.this,"抽屉状态改变了",Toast.LENGTH_SHORT).show();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);//传入Left意为左侧抽屉弹出
            }
        });
        GridViewAdapter adapter = new GridViewAdapter(this, getData());
        gridView.setAdapter(adapter);
    }

    public List<Bean> getData() {
        List<Bean> beanList = new ArrayList<Bean>();
        for (int i = 0; i < 15; i++)
            beanList.add(new Bean(R.mipmap.ic_launcher, "测试" + i));
        return beanList;
    }
}
