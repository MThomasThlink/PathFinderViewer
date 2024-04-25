# Intro
This piece of software has didactical purposes: it explores the performance and complexity of an algorithm to find (if possible) the best route from a start to an end point.
By allowing the user te set a configuration (grid size, starting and end point and obstacles), the algorithm search the possible path using BFS or a reccursive cycle tolerant way.

#ScreenShots
9x9 grid with starting and end points (no obstacles)

![image](https://github.com/MThomasThlink/PathFinderViewer/assets/151654642/61e0ec16-bb77-4d92-ae3a-44e9df59966f)

Best path (only 1):

![image](https://github.com/MThomasThlink/PathFinderViewer/assets/151654642/579e578c-deb7-4a85-abdd-5a2f0992f476)

Best three options (results overlapp):

![image](https://github.com/MThomasThlink/PathFinderViewer/assets/151654642/26413538-cb3e-4dc7-857f-3a0784af3e08)

9x9 with obstacles (in black): 2 options

![image](https://github.com/MThomasThlink/PathFinderViewer/assets/151654642/d1d6d902-15c8-4cf0-a41e-6f6ba89013a3)

# Conclusion
Despite good results found, there are evident restrictions related to grid size and amount of obstacles (regarding both performance and memory size), making the use or more efficient algorithms, as Dijkstra's.

