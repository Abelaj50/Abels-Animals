# Abels-Animals
Android application showcasing various animals and interesting facts about them along with other features, creating using the Android flavor of Java. CS 478 Project 2, UIC Spring 2022.

## Table of contents
* [General Info](#general-info)
* [Getting Started](#getting-started)
* [Technologies](#technologies)
* [Credits](#credits)
* [Visual Demonstration](#visual-demonstration)

## General info
This project is the second project for CS 478 (Software Development for Mobile Platforms) at the University of Illinois at Chicago, Spring 2022. Our task was to develop an Android app that displays information about wild animals. The app’s main activity displays a grid whose cells contain a thumbnail picture of an animal above the name of the animal. Each grid cell supports two kinds of functionality, depending on whether an app viewer performs a short or a long click on the cell. A short click brings up a new activity that shows an enlarged picture of the selected animal on the entire device display. The user can return to the grid view by selecting the “back” soft button on the phone. If, instead, a user clicks anywhere on the displayed picture, a third activity launches showing interesting facts about the selected animal. A long click on a grid cell of the main activity brings up a “context menu” showing the following three options for the animal under consideration: (1) View the entire picture (similar to a short click); (2) Show the interesting facts about the animal; and (3) go to the Wikipedia page for the animal.

## Getting Started
If you would like to simply download the app from the Google Play Store, click **here**. If you would like to browse through the source code in the environment it was created in, make sure you have **Android Studio Bumblebee 2021.1.1** installed.
* Windows: https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-windows.exe
* Mac (Intel): https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-mac.dmg
* Mac (ARM): https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-mac_arm.dmg
* Linux: https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2021.1.1.20/android-studio-2021.1.1.20-linux.tar.gz
* Chrome OS: https://redirector.gvt1.com/edgedl/android/studio/install/2021.1.1.20/android-studio-2021.1.1.20-cros.deb

Once you are ready, open the project in Android Studio. Ensure that the Run/Debug Configurations are set and set the device to a Pixel 3a XL using API 30. The application should load up and look something like this:

![App Start](images/app_start.png)


The first activity of the application shows animal thumbnails in just two columns on the screen as to provide a lush, viewable image, and the animal name beneath, created using a couple different XML layouts (a main GridView and definition for each item in the GridView) and a customized version of BaseAdapter for control handling. Scrolling is enabled by default as not all animals are immediately viewed on the screen. The app handles orientation changes flawlessly through seperate landscape layout files. 

Any single click on any item in the grid (i.e. any animal thumbnail) brings about the second activity, which is simply an enlarged version of the image. A click on this enlarged image will bring about the *third* activity, which displays interesting facts about that animal.  

A "long click" on any item in the grid (i.e. any animal thumbnail) within the first activity shows a context menu with three options: 
* **"View Image"** will launch the second activity, which simply displays an enlarged version of the animal image.
* **"Interesting Facts"** will launch the third activity, which displays interesting facts about that animal on the screen.
* **"See Wikipedia Page"** starts an activity with an *ACTION_VIEW* intent, which should launch the device's default browser and open up that animal's Wikipedia page using a linked Uri. 
    
## Technologies
Project is created with:
* Android Studio Bumblebee 2021.1.1
* Java SE 8

## Credits
All credits for the project idea go to Professor Ugo Buy. Credits to much of the [GridLayoutActivity.java](src/main/java/com/example/project2/GridLayoutActivity.java) and [ImageAdapter.java](src/main/java/com/example/project2/ImageAdapter.java) codebase also go to Professor Ugo Buy as the beginning template for our project. Credits to [Pexels.com](https://www.pexels.com/) and the following contributors listed below for the animal images used throughout this project:
* [Flickr](https://www.pexels.com/photo/tiger-beside-tree-145971/)
* [Husain Chauhan](https://www.pexels.com/photo/silhouettes-of-unrecognizable-arabic-man-with-camel-at-sunset-4456133/) 
* [Pixabay](https://www.pexels.com/photo/chimpanzee-sitting-on-gray-stone-in-closeup-photography-during-daytime-33787/)
* [Pixabay](https://www.pexels.com/photo/brown-white-and-black-eagle-flying-nearby-pink-flower-field-158330/)
* [antonytrivet](https://pixabay.com/images/id-5799523/)
* [Valdemaras D.](https://www.pexels.com/photo/group-of-people-taking-picture-of-shark-1700656/)
* [Sameera Madusanka](https://www.pexels.com/photo/macro-photography-of-green-crested-lizard-735174/)

All credits to technologies used are given to their owners and all items specified in their respective licenses are adhered to throughout this project.  

## Visual Demonstration
The following link leads to a visual demonstration of the project.
* https://youtu.be/9GdFLcM8d1k
