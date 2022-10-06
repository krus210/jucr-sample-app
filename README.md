### Stack
- Kotlin Coroutines
- Jetpack Compose
- Hilt
- MVVM Architecture
- Clean
- MotionLayout

### About
1. I choose Hilt for dependency injection because it is effortless to implement it to a new project, also it matches with Jetpack Compose
2. In Data layer I implement Repository interface and mock implementation to minimize the Coupling
3. I created three responses to load data asynchronously, but I didn't implement it in UIi layer(I don't have much time)
4. I Created DTO where I can get from repository names of resources, it is more flexible
5. In view model I map dto to ui model
6. For asynchronous work I use coroutines, in data layer and domain layer I use only suspend functions, and launch coroutines in viewModel (closer to UI)
7. Set CoroutineDispatcher to repository constructor for unit tests
8. I use State pattern for UI presentation, I did not implement Laoding and error state
9. For UI I choose Compose because it is interesting to me to use new technologies
10. for collapsing Appbar I used MotionLayout and made constraints in JSON, motion depends on scrolling, I used MotionLayout because in view I have a lot of constraints and motions, I didn't implement transitions for more smoothness
11. Some things I did not implement because I did not have much time)
