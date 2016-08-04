# GistList
GistList is a useful app for Gist enthusiasms, it fetches top 100 public gists on Github and displays gist of them.
This project initially was outsourced to a group of android developers in Poketown and its been couple of years that no one has touched it. We need your help to bring this app up-to-date and use the latest Android technologies to improve it.

### Getting Set Up
1. Clone this repo: `git clone git@github.com:doximity/GistList.git`
2. Use Android Studio 2.1.2 Stable version
3. Use "Open an existing Android Studio project" to open GistList project

### Submission Instructions

* Create a local branch named with the following format: `firstName_lastName`
* **DO NOT PUSH TO MASTER, DO NOT FORK THE REPOSITORY**
* Push your branch to Github
* For each task, make one commit with title of `task #(task_number)` ex: task #3
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
### Task 1 (Estimated time 5 min)

Looking at `ListViewAdapter` class, we noticed that having to call `findViewById()` on every call of `getView()` is a very expensive operation. Solve this problem and *preferably* use an Android Structural Pattern.

### Task 2 (Estimated time 10 min)
*WARNING*: don't forget to commit your finished work for task 1 with commit title "Task 1" before starting this task.

We have heard of new View that is included in [support library](https://developer.android.com/topic/libraries/support-library/features.html) which is suppose to be much cleaner than ListView.
1. Change the `activity_main` layout to replace the `ListView`
2. Change `MainActivity` to initialize the view and do the required configurations
3. Implement the new adapter in `NewAdapter.java` and use it as your adapter for the list.

*NOTE*: You should not need to include any new dependencies.

### Task 3 (Estimated time 15 min)
*WARNING*: don't forget to commit your finished work for task 2 with commit title "Task 2" before starting this task.

Some of the gists that we are getting have anonymous owners, which intern means we don't have the owner's image to load for the gist. 

1. Switch to use `GithubApi.getGistsObservable()` as your api which will return you an `Observable` instead of `Call` object. Make sure the app behaves as it suppose to with the new method of fetching the data.  
2. Then use an appropriate `RxJava` operator to only display the gists with owner and not the ones with `null` value;
3. You will encounter an `IllegalArgumentException` when using the `getGistsObservable()`. Find the reason and fix it.

***You have a better solution than using RxJava operators?*** Go ahead and implement you own solution so long it does the job.

### Task 4 (Estimated time 20 min)
*WARNING*: don't forget to commit your finished work for task 3 with commit title "Task 3" before starting this task.

We are always excited about new features and tools that android framework provides us. So we decide to further simplify our list of gists by using [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html).

Use the databinding feature to populate all the data we need for each gist row.

*NOTE*: There should not be any setText() method call or use of Picassa in your adapter after this task is finished.
*HINT*: For loading images use the CustomSetters pattern

### Task 5 (Estimated time 30 min)
*WARNING*: don't forget to commit your finished work for task 4 with commit title "Task 4" before starting this task.

We have received a feature request that we would like you to implement. Our users are asking for a menu button that hides all the images in the list so they can just see the plain, useless, and colorless gists in our list.

1. Implement functionality for `change_image_visibility` item in the `main_menu.xml` menu so that when tapped its title switches between `R.string.show_images` and `R.string.hide_images`
2. Use RxJava and Observable pattern to trigger the visibility of ImageView in each item.
3. Make sure all the image's animation triggered at the same time and not with any delay between items.
4. Make sure your choice of show or hide images continues when user scrolls the list further down.

*NOTE*: You do not have to use RxJava for this task but your solution needs to work as expected.

### Task 6

Make sure that your implementation is error free and then make your pull-request as described in the submission section.

Thank you for your time and we will get back to you as soon as possible.

Best of luck.
