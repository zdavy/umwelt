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

#### Lets create our first controller:
```java
import umwelt.Controllers.UmweltController;

public class FirstController extends UmweltController {
  public FirstController() {
    DIR += "/public";
    get("/test", new FirstResponse(DIR));
  }
}
```
This will add a get route to the controller's routes with a basic Response we're
going to create (You can check out the Wiki for a more detailed explaination of
responses); we also provide it the directory to look for the file responses.

#### Then we'll create that response we're referencing up there:

```java
import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

import umwelt.Responses.UmweltFactory;
import umwelt.Responses.UmweltResponse;

public class FirstResponse extends UmweltResponse {
  String DIR;
  public FirstResponse(String dir) {
    DIR = dir;
  }

  @Override
  public iResponse proccess(iRequest request) {
    try{
      return new UmweltFactory(DIR).get(request);
    } catch (Exception e) {
      setStatus("500", "Internal Server Error");
      setVersion("HTML/1.1");
      setContent("Das Boot is kaput");
      return this;
    }
  }
}
```
What we're doing here is overriding the typical process method that just returns
itself and telling it to seek out the file we're looking for, or create a 500
error.

#### Then we'll create our server:
```java
import java.io.IOException;
import umwelt.UmweltServer;
import umwelt.Responses.UmweltFactory;

public class FirstServer extends UmweltServer {
  public FirstServer() throws IOException {
    super(3000);
    addController(new FirstController());
    DIR = System.getProperty("user.dir") + "/public";
    addResponseFactory(new UmweltFactory(DIR));
  }
}
```
Here we're providing the port number to start the server on, setting the default
directory to look for files such as a 404 response, and providing in to the basic
UmweltFactory.

#### Static Files
We're going to want to add some static files to our public directory now, at
least the ones that will be served.

We should at least create ``` public/test.html ```

```html
<!DOCTYPE html>
<head><title>TEST</title></head>
<body>
<h1> This is a test page </h1>
</body>
</html>
```

You can also create ``` public/404.html ``` if you'd like, or you can ignore it
and default text will be rendered instead.

#### Main Method
The last thing left to do is create our main method
```java
public class Server {
  public static void main(String[] args) throws Exception {
    new FirstServer().start();
  }
}
```

#### Compile your Java files
Since I keep all my Libraries in a ``` lib/ ``` folder, my source files in a
``` src/ ``` folder, And I like my class files to end up in a ``` bin/ ```
folder mine would look something like this.

```
  $ javac -classpath "lib/*" -d bin src/*.java
```

### Spin up your server
This will also of course be a little different for you if you keep your
directory organized different than I do, but the important thing to do is
include the jars in your classpath when you run the server as well.

Fire up your server
```
  $ java -cp lib/*:bin Server
```

### That's all there is to it
Well that's not all, but that's all there is to the quick start guide. For a
more indepth guide at how everything is working, check out the Wiki (In Progress)
