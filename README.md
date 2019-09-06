# Issue #

Reinstalling the app prevents the work from being executed

https://issuetracker.google.com/issues/140572171

## How to use ##

1. Build and run the app via Android Studio ("Debug" button) on Android emulator with API 22.
2. Click the "Enqueue work" button in the app.
3. Observe the logs for 1 minute.

    * Expected & actual: there is a piece of work scheduled and processed immediately but due to an exception being thrown, the work is rescheduled so it is triggered again and again with respect to the backoff policy.

4. Run the app again via Android Studio ("Debug" button).

    * Do NOT close the app in a different way. When you click the "Debug" button in Android Studio, the app should be still running and the debugger should be attached, exactly the same as when you performed step 1.

5. Observe the logs for 2 minutes, then click the "Enqueue work" button in the app and observe the logs again for 2 minutes.

    * Expected option A: the work that was previously scheduled (step 2) is picked up by WorkManager again automatically so that you can see in the logs that the work is being processed and it happens even before clicking the "Enqueue work" button in the app.
    * Expected option B (this possibility was suggested in the comments to the linked issue): the work that was previously scheduled is not picked up by WorkManager until you click the "Enqueue work" button in the app again. Clicking the button again initializes WorkManager so that it finally picks up the previously enqueued work.
    * Actual: neither waiting nor clicking the "Enqueue work" button in the app again makes WorkManager pick up the previously enqueued work.

## Additional notes ##

1. Two workarounds are marked in the code. Search for "workaround" to find them.
2. The app includes a library that allows browsing the app's databases using an internet browser while the app is running.

    1. Run command: `adb forward tcp:8080 tcp:8080`
    2. Open http://localhost:8080/#table=WorkSpec to see the enqueued work that is not being executed ("How to use" - step 5).