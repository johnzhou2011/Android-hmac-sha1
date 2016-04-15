# Android-hmac-sha1接口签名加密工具
##简介
本工具用于android调用后台接口时对接口进行签名加密，算法使用各大开放平台常用的hmac-sha1。接口签名能有效的防止请求参数被篡改，提高App数据的安全性。
##编译
1. 本工具使用Android studio编译，NDK版本为android-ndk-r10e。
2. 可以修改com_jia13_encrypt_SignatureEncryptor中secureKey值，将secureKey打入so文件中，提高安全性。

##用法
new SignatureEncryptor类，调用encrypt方法返回签名结果。


1. `public final String encrypt(Map<String, String> param, String key)`
  
  参数param为访问后台接口使用的参数Map，key为用于签名的secureKey

2. `public final String encrypt(Map<String, String> param)`

  参数param为访问后台接口使用的参数Map，secureKey硬编码进so文件
