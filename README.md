# Android app - Event finder
Android app in kotlin

The application allows you to plan various group or pair activities in a simple and user-friendly way. The app contains fun activity ideas for all ages, whether it's a birthday party venue or an annual outing for the retirement club in Budapest.

The app was inspired by the theory that people tend to organise activities in previously visited places rather than trying new ones. The app helps to find new places, saving users time and effort. It can also support many small Hungarian businesses in their recovery from the Covid period.

Main features

The home screen of the application is the login screen, where the user can log in with a username and password. Then a list of categories (e.g. Meals, Trips, Others) are shown to the user. Choosing from these, the following Activity Recycler View will list the activities in each category. Clicking on the 'Description' icon, the activity will bring up a DialogFragment displaying a text description of the activity. If the user clicks on "add" instead of the "description" icon, the next Activity is displayed, where he/she can add participants to the program and select a time. Here it is also possible to delete participants. If the third icon (star) is clicked, the user has the possibility to add the activity to his/her favourites. Favourites are listed in a separate Activity, which can be accessed from the Activity that displays the categories. The application uses persistent data storage.
