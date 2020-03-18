# ViewModelSHP
    
    在ViewModel中使用SharedPreferences保存数据、实现app被系统杀死、或手动退出、正常的重启手机都能够保证数据存在不会丢失。
---
### 使用前说明

    需要添加依赖：
```gradle
android {
    ...
    dataBinding.enabled true
}

dependencies {
    ...
    implementation 'androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
}
```

### 步骤
1. 编辑布局文件：[activity_main.xml](https://github.com/yi-sheep/ViewModelSHP/blob/master/app/src/main/res/layout/activity_main.xml) (`完整代码地址`)
    
        这里加入了一个TextView和两个Button
        TextView
            用于显示数字
        Button_1    用于做加一操作
        Button_2    用于做减一操作
        我的字符串是定义在string.xml中的
    [string.xml](https://github.com/yi-sheep/ViewModelSHP/blob/master/app/src/main/res/values/strings.xml)
    
    具体代码:
    ```xml
    <!-- TextView -->
    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    <!-- Button_1 -->
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/button_plus"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/guideline"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />
    <!-- Button_2 -->
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/button_minus"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline"
        app:layout_constraintTop_toBottomOf="@+id/textView" />
    ```
2. 创建ViewModel类：[MyViewMode.java](https://github.com/yi-sheep/ViewModelSHP/blob/master/app/src/main/java/com/gaoxianglong/viewmodelshp/MyViewMode.java) (`完整代码地址`)

        在这里类里进行数据的读取和保存，源码里注释写得很清楚，这里就不多解释什么了

3. 编辑布局文件：[activity_main.xml](https://github.com/yi-sheep/ViewModelSHP/blob/master/app/src/main/res/layout/activity_main.xml) (`完整代码地址`)

        这里向布局文件中添加一个data标签用于声明一个在xml中的变量方便实用MyViewModel类，给TextView加上text属性，两个Button加上onClick属性
    具体代码：
    ```xml
    <!-- data -->
    <!-- 这里的name属性就是定义的变量名 -->
    <!-- type就是这个变量指向的类的包名 -->
    <data>
        <variable
            name="data"
            type="com.gaoxianglong.viewmodelshp.MyViewModel" />
    </data>
    <!-- TextView -->
    <!-- 通过@{}能在xml中使用java代码实现调用函数等一系列操作 -->
    <TextView
        ...
        android:text="@{String.valueOf(data.getNumber())}"/>
    <!-- Button_1 -->
    <!-- 方法调用可以使用()->要调用的方法 -->
    <!-- 这里传入1表示加一 -->
    <Button
        android:onClick="@{()->data.add(1)}"/>
    <!-- Button_2 -->
    <!-- 这里传入-1表示减一 -->
    <Button
        android:onClick="@{()->data.add(-1)}"/>
    ```
4. 编辑MainActivity类：[MainActivity.java](https://github.com/yi-sheep/ViewModelSHP/blob/master/app/src/main/java/com/gaoxianglong/viewmodelshp/MainActivity.java) (`完整代码地址`)
        
        这里面进行activity与ViewModel和布局文件的绑定，具体看源码

---

如果遇到什么问题请联系:

`QQ：1766816333`

`邮箱：1766816333@qq.com`

---

