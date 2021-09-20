# Reign test

+ Master branch:
This branch contains a demo with a simple Android app test for "Reign".

It was built using Clean Architecture.
The app has two activities, a Main Activity and WebActivity (for details).

MainActivity
The Main Activity has a List of posts (hits) from this API (http://hn.algolia.com/api/v1/search_by_date?query=mobile)

I'm using Retrofit2 Library (http://square.github.io/retrofit/) to fetch HTTP requests.

And for the list I'm using a RecyclerView with data binding.

WebViewActivity
The WebViewActivity has a webview and show a link of each item. It can open pdf docs.

Finally:
I worwed on Android Studio 2020.3.1 Arctic Fox. 
Don't need anything special to run the app.


+ Main branch:
You can download the apk from this branch.
