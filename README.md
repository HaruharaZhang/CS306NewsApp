# CS306NewsApp_plus

English | [简体中文](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/README_ZH.md)

This is the code for the CS306 course coursework.
Code submission date: January 7, 2023.
**Note: This code has already been submitted to Swansea University as part of the coursework. Please do not use this code for your own coursework or academic reports.**

## Project Introduction

This is an Android project developed using the Kotlin programming language.
It utilizes the [NewsAPI](https://newsapi.org) to fetch news data from a third-party API and presents the news in a formatted way to the users.

### Application Features

- Main Functionality: Utilizing the API to fetch news from a third-party source and parsing the received JSON files to present them to the users in a card-list format.
- When the user clicks on an item in the card list, they will be taken to the detailed news page.
- Users can click the font button in the top-right corner of the page to enlarge or reduce the font size.
- Login and Registration System: Google Firebase is used as the authentication server for user login and registration. After login, the user's information will be displayed in the left-slide menu.
- Connection to a third-party news API to fetch news data, parse the API's returned JSON files, and reformat them for user-friendly browsing.
- Save News Functionality: Users can click the "heart" icon in the top-right corner of the page to save news. The saved news will appear in the "Saved News" section.
- Subscription Functionality: Users can customize the news categories displayed on the home page, such as sports, entertainment, games, etc., and use these categories to retrieve news.
- Refresh Button: Users can click this button to fetch news again.
- Visit Original Website Button: The detailed news page has a button to visit the original website. Clicking it will open the default system browser to visit the webpage.

### Project Testing

The testing platform is Android Kotlin API 28, Pixel_6_API_28:5554. The project has been tested, and no errors were found.

## Version Control

You can find detailed version control information in the commit history of this project.

## Additional Libraries Used

- Gson from Google,
- Firebase from Google,
- Picasso from [jrodbx](https://github.com/square/picasso)

## Project Demo

Video link: https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/2131205.mp4
*You can also find the video file "video.mp4" in the /demo folder of the project's main directory.*

## Project Screenshots

![Slide Menu](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture%201.png)
![News Detail Page](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture%202.png)
![News List](https://github.com/HtmlIsTheBestProgrammingLanaguage/CS306NewsApp/blob/main/demo/ScreenCapture.png)