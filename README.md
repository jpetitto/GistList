# Coding Assignment
We would like to thank you for taking the time to complete this assignment. We believe this to be an effective way at allowing you to show us your skills, on your own time, without the pressure of someone looking over your shoulder. Your code will be used to help us decide if we'd like to proceed with the interview process. Please understand that completing this assignment doesn't guarantee a job or follow up interviews. We will carefully evalutate your work and let you know within a few days if we'd like to proceed with the process. 

# GistList
GistList is a useful app for Gist enthusiasts, it fetches and displays the top 100 public gists from Github. This project was initially outsourced to a group of Android developers in Poketown, but it's been a couple of years since anyone has touched it. We need your help to update the app and improve it with the latest Android technologies!

### Submission Instructions
* Create a local branch named with the following format: `firstName_lastName`.
* When finished each task, make a final commit for that task with commit message of `task #(task_number)` ex: task #3.
* If you'd like to include comments to explain your thought process, feel free to do so within the code or in your PR description.
* Do not move, rename, or reformat the files but feel free to create new ones as you see appropiate.
* Once all work is completed, create a new pull-request from your branch to master.
* Our [bot](https://github.com/facebook/mention-bot) will tag the appropiate people to the PR and notify them.
* You will hear back from us soon after.

### We are looking for:
* Clean, optimized, well-organized code.
* Ability to interpret and leverage existing code and documentation.
* Correctness of implementation according to requirements.  
* Don't trust data or APIs, your implementation should handle any necessary data validation to prevent crashes.

### Limitations
* We know you are eager to show us what you can do, but please don't do more than what is specifically requested in the tasks.
* Do not integrate additional libraries, but feel free to utilize any functionality from the libraries already included.
* Do not skip any task even if you can jump ahead and implement the final result. We would like to see your progress from each task to the next.

# Tasks
### Task 1

Some of the gists that we are fetching have anonymous owners, which in turn means we don't have the owner's image to load for the gist. 

1. Switch to use `GithubApi.getGistsObservable()` as your api which will return you an `Observable` instead of `Call` object. Make sure the app behaves as it is supposed to with the new method of fetching the data.
2. Filter out the gists with no owners/images
3. Optimize the adapter in charge of populating the list

### Task 2

We are always excited about new features and tools that Android frameworks provide us with. So we decided to further simplify our list of gists by using [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html).

We expect you to utilize all the benefits that we can get from this library in this context.

### Task 3

We have received a feature request that we would like you to implement. Our users are asking for a menu button that hides all the images in the list so they can just see the plain gists in our list.

1. Implement functionality for `change_image_visibility` item in the `main_menu.xml` menu so that when tapped, its title switches between `R.string.show_images` and `R.string.hide_images`
2. Trigger the visibility of ImageView in each item with animations in a way that all the image animations are triggered at the same time and not with any delay between items.
3. Make sure your choice to show or hide images continues when user scrolls the list further down.

***BONUS*** Try to implement this feature without ```Notifying``` your adapter.

Here is a preview of how the final result should look like:

![Demo](http://i.giphy.com/3o7TKW0nrNSwdar7Ms.gif)

Best of luck.
