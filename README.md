# Santa's Christmas Shop
A playground project with Scala and AKKA for a christmas workshop. Feel free to download it and have a go at Scala and the Akka framework.

**Helpful resources:**
* The repo contains a set of slides which will give some background on the actor concept. It also provides some tips on how to write actor communication and test it.
* For Akka's main website go to https://akka.io/.
* For the documentation, go to https://doc.akka.io/docs.

## Exercise:

1. Request Nice-List from Bernard (see TODOs in the code, Messages are provided)
   * Santa requests the Nice-List
   * Bernard sends the list backit back
2. Order Sweets and Toys
   * Santa tells Bernard to load the slide based on the number of people on the nice list
   * Bernard orders toys from Pumuckl and sweets from Charlie
3. Request Nice-List from Bernard (see TODOs in the code)
   * When Bernard has recieved both a toy and a piece of candy he packages it to a present
   * Bernard sends the present to Rudolph who ships it (e.i. prints it)

## Tips and Tricks
* you can pass the actor's self-reference by calling `context.self`
* it is considered good style to add all messages which are understood by the actor to the actor's companion object
