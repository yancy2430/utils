# 整理开发中常用的工具类

## API接口
* 返回结果
* 请求bean

## 常用加解密
* MD5Util
* RASUtil

## IO处理
* FileUtil

## json转换
* GsonUtil

## 网络处理
* GsonUtil
* 
## 随机数生成

## 反射工具

## 字符串处理

## 时间处理

## 树形结构


##使用方式
在pom.xml中添加仓库
```
<repositories>
        <repository>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <id>releases</id>
            <name>tdeado</name>
            <url>http://nexus.tdeado.com/repository/maven-releases/</url>
        </repository>
</repositories>
```
然后再添加依赖
```
<dependency>
            <groupId>com.tdeado</groupId>
            <artifactId>utils</artifactId>
            <version>x.x-RELEASE</version>
</dependency>
```