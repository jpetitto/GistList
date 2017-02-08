# Coding Assignment

We would like to thank you for taking the time to complete this assignment. We believe this to be an effective way at allowing you to show us your skills, on your own time, without the pressure of someone looking over your shoulder. Your code will be used to help us decide if we'd like to proceed with the interview process. Please understand that completing this assignment doesn't guarantee a job or follow up interviews. We will keep you posted either way.

# GistList
GistList is a useful app for Gist enthusiasts, it fetches and displays the top 100 public gists from Github. This project was initially outsourced to a group of Android developers in Poketown, but it's been a couple of years since anyone has touched it. We need your help to update the app and improve it with the latest Android technologies!

### Submission Instructions
* **FORK** this repository
* Create a local branch named with the following format: `firstName_lastName`
* For each task, make one commit with title of `task #(task_number)` ex: task #3
* Once all work is completed, create a new pull-request pointing at ****YOUR**** fork with your changes
* Add @kayvannj as a contributor on your fork and tag this account on your PR description.
* If you'd like to include comments to explain your thought process, feel free to do so within the code or in your PR

### We are looking for:
* Clean, optimized, well-organized code
* Knowledge of framework
* Ability to interpret and leverage existing code, documentation
* Correctness of implementation according to spec
* Your implementation should not crash the app with any type of input, you should not relying on validity of any data from api

### Limitations
* We know you are eager to show us what you can do, but please don't do more than what is specifically requested in the tasks
* Do not integrate additional libraries, but feel free to utilize any functionality from the libraries already included
* Do not skip any Task even if you can jump ahead and implement the final result. We would like to see your progress from each task to the next

# Tasks
### Task 1

Looking at `ListViewAdapter` class, we noticed that having to call `findViewById()` on every call of `getView()` is a very expensive operation. Optimize.

### Task 2
*WARNING*: don't forget to commit your finished work for task 1 with commit title "Task 1" before starting this task.

Some of the gists that we are getting have anonymous owners, which in turn means we don't have the owner's image to load for the gist. 

1. Switch to use `GithubApi.getGistsObservable()` as your api which will return you an `Observable` instead of `Call` object. Make sure the app behaves as it supposed to with the new method of fetching the data.
2. Filter out the gists with no owners/images

### Task 3
*WARNING*: don't forget to commit your finished work for task 2 with commit title "Task 2" before starting this task.

We are always excited about new features and tools that Android frameworks provide us with. So we decided to further simplify our list of gists by using [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html).

Use the databinding feature to populate all the data we need for each gist row.

We expect you to utilize all the benefits that we can get from this library in this context.

### Task 4
*WARNING*: don't forget to commit your finished work for task 3 with commit title "Task 3" before starting this task.

We have received a feature request that we would like you to implement. Our users are asking for a menu button that hides all the images in the list so they can just see the plain gists in our list.

1. Implement functionality for `change_image_visibility` item in the `main_menu.xml` menu so that when tapped, its title switches between `R.string.show_images` and `R.string.hide_images`
2. Trigger the visibility of ImageView in each item in a way that all the image animations are triggered at the same time and not with any delay between items.
3. Make sure your choice of show or hide images continues when user scrolls the list further down.

***BONUS*** Try to implment this feature without ```Notifing``` your adapter.

Here is a preview of how the final result should look like:

![Demo](http://i.giphy.com/3o7TKW0nrNSwdar7Ms.gif)


### Task 5

Make sure that your implementation is error free (your app doesn't crash with any input from api) and then make your pull-request as described in the submission section.

Thank you for your time and we will get back to you as soon as possible.

Best of luck.
