# DrawerLayoutDemo侧滑菜单
Google控件DrawerLayout的基本使用

##第一步导入相关包android.support.v4.widget.DrawerLayout
    
    它相当于是一个布局文件，需要将其作为根布局使用

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
