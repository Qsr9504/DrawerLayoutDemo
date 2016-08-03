效果图如下：

 ![image]（https://github.com/Qsr9504/DrawerLayoutDemo/blob/master/DrawerLayoutDemo.gif）

# DrawerLayoutDemo侧滑菜单
Google控件DrawerLayout的基本使用

##第一步导入相关包android.support.v4.widget.DrawerLayout
    
    它相当于是一个布局，需要将其作为根布局使用

##xml布局文件中控件数量和位置十分重要

* DrawerLayout里边只许包裹两个View（可以是布局可以是控件）
  * 第一个View是主界面布局
  * 第二个View是抽屉式菜单的布局
* 第二个View控件属性中需要有以下其中一个属性
  * android:layout_gravity="start" 从左拉出现抽屉式菜单
  * android:layout_gravity="end" 从右拉出现抽屉式菜单
* 主界面中什么都不需要做，抽屉侧滑效果就已经出来了。


###xml示例代码如下：
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v4.widget.DrawerLayout
        android:id="@+id/drawerLayout"
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >
        <!-- 主界面代码 -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="Hello World!" />
        <!-- 抽屉侧滑代码 -->
        <LinearLayout
            android:layout_width="240dp"
            android:orientation="vertical"
            android:layout_gravity="start"
            android:layout_height="match_parent">
            <LinearLayout
                android:background="#ffffff"
                android:orientation="horizontal"
                android:layout_width="match_parent"
                android:layout_height="55dp">
                <TextView
                    android:text="水果"
                    android:layout_weight="1"
                    android:layout_width="0dp"
                    android:gravity="center"
                    android:layout_height="match_parent" />
                <View
                    android:background="#000000"
                    android:layout_width="1dp"
                    android:layout_marginLeft="1dp"
                    android:layout_marginRight="1dp"
                    android:layout_height="match_parent"/>
                <TextView
                    android:text="蔬菜"
                    android:gravity="center"
                    android:layout_weight="1"
                    android:layout_width="0dp"
                    android:layout_height="match_parent" />
            </LinearLayout>
            <GridView
                android:id="@+id/gridView"
                android:layout_width="240dp"
                android:layout_height="match_parent"
                android:background="#978e8e"
                android:numColumns="2"
                android:verticalSpacing="5dp"
                android:horizontalSpacing="5dp"
                />
        </LinearLayout>
    </android.support.v4.widget.DrawerLayout>

##给抽屉添加展开收回事件监听（想让其有一个顶部系统默认titleBar，并对其操作）
* 需要用到ActionBarFrawerToggle类，它是DrawerLayout.DrawerListener的具体实现类
    * 改变android.R.id.home图标（构造方法）
    * Drawer拉出、隐藏,带有android.R.id.home动画效果(SyncState())
    * 监听Drawer拉出、隐藏事件
* 覆写ActionBarDrawerToggle的onDrawerOpened()和onDrawerClosed()以监听抽屉拉出或隐藏事件
* 覆写Acticity的onPostCreat()和onConfigurationChanged()方法

##最简单的监听

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

* drawerLayout.openDrawer(Gravity.LEFT);//传入Left意为左侧抽屉弹出
* drawerLayout.openDrawer(Gravity.RIGHT);//传入RIGHT意为右侧抽屉弹出
* drawerLayout.closeDrawer(Gravity.LEFT);//传入Left意为左侧抽屉关闭
* drawerLayout.closeDrawer(Gravity.RIGHT);//传入RIGHT意为右侧抽屉关闭
 

##如果要给抽屉中控件设置监听事件
    需要在抽屉的布局中添加clickable=true，用来消耗点击事件
    
