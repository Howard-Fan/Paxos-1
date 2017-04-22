Publish a small service on the web that has two endpoints:

1. /messages takes a message (a string) as a POST and returns the SHA256 hash digest of that message (in hexadecimal format)

2. /messages/<hash> is a GET request that returns the original message. A request to a non-existent <hash> should return a 404 error.

Hint: When does ordering of messages you POST vs digests you GET matter?

Yes, the ordering of the messages matter because this microservice uses a in memory map to store the message and hash.
    If the hash is not generated before the GET call, the GET call will always return a message not found.
    This behavior is due to a hashed String cannot be unhashed.

Optional bonus question​: What would the bottlenecks in your implementation be as you acquire more users. How you might scale your microservice?

If this microservice is only hosted on a single machine, the machine itself will become the bottleneck.
We can easily scale the machine into a cluster of machines with AWS Autoscaling groups.

If we use a backend database to replace the in memory map, the database I/O will become the bottleneck.
We can easily improve the performance by using a caching layer such as Redis/Memecache to improve the performance.