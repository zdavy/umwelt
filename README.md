# Umwelt (The Environment We Live In)

Umwelt is a simple, extendable Web Application Framework for Java built ontop of
the flexible HTTP handling service
[dasBoot](http://www.github.com/zachmokahn/dasBoot).

## Quickstart guide
It's really easy to get up and going, You're only going to need a few
components.

First you're going to need to add both
[Umwelt.jar](https://github.com/zachmokahn/umwelt/blob/master/Umwelt.jar?raw=true)
and the
[dasBoot.jar](https://github.com/zachmokahn/umwelt/blob/master/lib/dasBoot.jar?raw=true) to your classpath.

You'll need to implement a controller, something to process the request.
The UmweltController is very basic, it validates a request depending on whether
or not it's in the list of routes provided for the Controller (Defaults to none)
and then 'handles' the request if valid.

Lets create our first controller:
```java
import umwelt.Controllers.UmweltController;
import umwelt.Responses.UmweltResponse;

public class FirstController extends UmweltController {
  public FirstController() {
    get("/public/test", new UmweltResponse());
  }
}
```
This will add a get route to the controller's routes with a basic
UmweltResponse; (You can check out the Wiki for a more explaination of
responses)
