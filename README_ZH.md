# CS306NewsApp_plus

[English](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/README.md) | 简体中文

这里是课程CS306的Coursework的代码
代码提交日期为2023年1月7日
**注意：本代码已经作为课程作业上交给了斯旺西大学，请勿将此代码作为您的课程作业或者学术报告**

## 项目简介

这个是一个安卓项目，使用Kotlin编程语言开发
使用 [NewsAPI](https://newsapi.org) 提供的新闻API以获取新闻
能够通过API获取新闻，然后将新闻排版之后呈现给用户

### 应用功能

- 主要功能：使用API接口获取第三方提供的新闻，将获取到的JSON文件解析为适于展现给用户的方式（这里选用的是卡片列表）
- 当用户点击卡片列表的元素时，会跳转到新闻详细页面
- 用户可以点击页面右上方的字体按钮以放大和缩小字体
- 登陆和注册系统：使用了Google Firebase作为登陆和注册的认证服务器，并且用户登陆后会将用户信息显示在左滑的菜单之中
- 连接到第三方新闻API以获取新闻，将API返回的Json文件解析和重新排版为便于用户浏览的版本
- 保存新闻功能，用户可以点击页面右上方的”爱心“图案的图标以保存新闻，保存了的新闻会出现在页面"Saved News"中
- 订阅功能，用户可以自定义首页的新闻类别，比如体育，娱乐，游戏等不同类别，并且使用该类别来检索新闻
- 刷新按钮，用户点击后可以重新获取新闻
- 前往原网址按钮，新闻详细页面有一个前往原网站的按钮，点击后会打开系统默认浏览器以前往网页

### 项目测试

测试平台为Android Kotlin API 28，Pixel_6_API_28:5554，通过测试并且尚未发现错误

## 版本控制

你可以在本项目的commit历史中看到版本控制的详细信息

## 本项目使用的额外的库: 

- Gson from Google, 
- Firebase from Google, 
- Picasso from [jrodbx](https://github.com/square/picasso)

## 项目Demo

视频链接：https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/2131205.mp4
*你也可以在项目主目录下的/demo文件夹下找到video.mp4视频文件*

## 项目截图

![侧滑菜单](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture%201.png)
![新闻信息页](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture%202.png)
![新闻列表](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture.png)