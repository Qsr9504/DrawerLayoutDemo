# DrawerLayoutDemo侧滑菜单
Google控件DrawerLayout的基本使用

###第一步导入相关包android.support.v4.widget.DrawerLayout
    
    它相当于是一个布局文件，需要将其作为根布局使用

###xml布局文件中控件数量和位置十分重要

* DrawerLayout里边只许包裹两个View（可以是布局可以是控件）
  * 第一个View是主界面布局
  * 第二个View是抽屉式菜单的布局
* 第二个View控件属性中需要有以下其中一个属性
  * android:layout_gravity="start" 从左拉出现抽屉式菜单
  * android:layout_gravity="end" 从右拉出现抽屉式菜单
