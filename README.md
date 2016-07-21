# GistList
GistList is a usefull app for Gist entusiasims, it fetches top 100 public gists on Github and displays gist of them.
This project initially was outsourced to a group of android developers in Poketown and its been couple of years that no one has touched it. We need your help to bring this app uptodate and use the latest Android technologies to improve it.

### Getting Set Up
1. Clone this repo: `git clone git@github.com:doximity/tweetmd.git`


### Submission Instructions

* Create a local branch named with the following format: `firstName_lastName`
* **DO NOT PUSH TO MASTER, DO NOT FORK THE REPOSITORY**
* Push your branch to Github
* For each task, make one commit with title of `task #(task_number)`
* Once all work is completed, create a new pull request (`firstName lastName`) between master and your branch
* Tag @kayvannj on your pull request message to notify us that you've completed your assignment. If you want to include any additional comments about your solution, do so on the pull-request.

### We are looking for:
* Clean, optimized, well-organized code
* Knowledge of framework
* Ability to interpret and leverage existing code, documentation
* Correctness of implementation according to spec
* Your implementation should not crash the app with any type of input

### Limitations
* We know you are eager to show us what you can do, but please don't do more than what is specifically requested in the tasks
* Do not integrate additional libraries, but feel free to utilize any functionality from the libraries already included
* Do not jump any Task even if you can jump ahead and implement the final result. We would like to see your progress from each task to the next.

# Tasks
### Task 1

Looking at `ListViewAdapter` class, there is a wellknown pattern that has not been used.
Change the adapter to use the pattern.

*HINT*: Lint detects the missing pattern and warns us to use it.

### Task 2
*warning*: don't forget to commit your finished work for task 1 with commit title "Task 1" before starting this task.

We have heared of new View that is included in [support library](https://developer.android.com/topic/libraries/support-library/features.html) which is suppose to be much cleaner than ListView.
Change the `activity_main` layout to replace the `ListView`, `MainActivity` to initialize the view and do the required configurations, and then create a new adapter class to be used with the our new view.

*HINT*: The support library you need to be using is already added to the project in the `build.gradle` file.

### Task 3
*warning*: don't forget to commit your finished work for task 2 with commit title "Task 2" before starting this task.

Some of the gists that we are getting have annonimus owners, which inturn means we don't have a owner image to load for the gist. 

1. Switch to use `GithubApi.getGistsObservable()` as your api which will return you an `Observable` instead of `Call` object. Make sure the app behaves as it suppose to with the new method of fetching the data.  
2. Then use an apptopiate `RxJava` operator to only display the gists with owner and not the ones with `null` value;

### Task 4
*warning*: don't forget to commit your finished work for task 3 with commit title "Task 3" before starting this task.

We are always excited about new feqatures and tools that android framework provide us. So we decide to further simplify our list of gists by using [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html).

Use the databinding feature to populate all the data we need for each gist row.

*HINT*: for loading images use the [CustomSetters}(https://developer.android.com/topic/libraries/data-binding/index.html#custom_setters) pattern

### Task 5 (Optional Bounes)
*warning*: don't forget to commit your finished work for task 4 with commit title "Task 4" before starting this task.
*warning*: This task is optional but implementing a solution for this task is a bounes.

We have recieve a feature request that we would like you to implement. Our users are asking for a menu button that hides all the images in the list so they can just see the plain, useless, and uncolorfull gists in our list.

Implement functionality for `hide_images` item in the `main_menu.xml` menu so that when tapped it make all the images in our list `gone` with an animated change to the layout. 

<demo gif here>


