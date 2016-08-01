package demo.com.qsr.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.gridView)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        GridViewAdapter adapter = new GridViewAdapter(this, getData());
        gridView.setAdapter(adapter);
    }

    public List<Bean> getData() {
        List<Bean> beanList = new ArrayList<Bean>();
        for (int i = 0;i< 15;i++ )
            beanList.add(new Bean(R.mipmap.ic_launcher,"测试"+i));
        return beanList;
    }
}
