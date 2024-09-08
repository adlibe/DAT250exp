For this assignment there wasn't any problems when it came to Spring Boot and creating the repository. 
Most of the stuff I did worked just fine, however I had some problems too. 

At first, I managed to use Bruno perfectly to make the CRUD requests for users and polls, 
but the problems started when I got to the votes and voteOptions, which I didn't manage to implement right, 
as I always ended up with a new error in Bruno. Even though I feel like I understood the domain model good, I did not
understand it well enough when I tried to implement the functionality for votes and voteOptions.

In addition, Bruno sometimes made up errors out of thin air, which got fixed by just creating an entirely new http 
request with the exact same url and json prompt, which confused me and led to some frustration as it was never clear 
what the issue was.

I managed to successfully do all the test scenarios apart from the ones involving showcasing the votes. Some positives 
are that I feel like I handled the resource identification well and also found a way to uniquely identify
the different polls by using a random UUID generator.