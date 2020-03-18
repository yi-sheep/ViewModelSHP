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