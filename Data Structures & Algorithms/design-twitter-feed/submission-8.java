class Twitter {


    // userId, tweetId, followeeId
    // Queue<Integer> (size 10) for tweets
    // Map<Integer, Object[]>

    private Map<Integer, Deque<int[]>> users;
    private Map<Integer, Map<Integer,Deque<int[]>>> follows;
    // private AtomicInteger counter;
    private int counter;
    
    public Twitter() {
        users = new HashMap<>();
        follows = new HashMap<>();
        // counter = new AtomicInteger();        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) {
            users.put(userId, new ArrayDeque<>());
            follows.put(userId, new HashMap<>());
        }
        Deque<int[]> tweets = users.get(userId);
        // tweets.offer(new Object[]{tweetId,counter.incrementAndGet()});
        // System.out.println(counter.get());
        tweets.offer(new int[]{tweetId,++counter});
        // System.out.println(counter);
        if(tweets.size() > 10) {
            tweets.remove();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(users.get(userId) == null) {
            return new ArrayList<>();
        }
        Map<Integer, Deque<int[]>> followee = follows.get(userId);
        Comparator<int[]> timestamp = (a, b) -> a[1] - b[1];
        Queue<int[]> minHeap = new PriorityQueue<>(timestamp);
        Deque<int[]> tweetsCopy;
        // System.out.println(followee);
        if(followee != null) {
            for(Deque<int[]> tweets:followee.values()) {
                tweetsCopy = new ArrayDeque<>(tweets);
                while(!tweetsCopy.isEmpty()) {
                    minHeap.offer(tweetsCopy.pop());
                    if(minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }
        }

        Deque<int[]> tweets = users.get(userId);
        tweetsCopy = new ArrayDeque<>(tweets);
        while(!tweetsCopy.isEmpty()) {
            minHeap.offer(tweetsCopy.pop());
            if(minHeap.size() > 10) {
                minHeap.poll();
            }
        }

        LinkedList<Integer> newsFeed = new LinkedList<>();

        while(!minHeap.isEmpty()) {
            newsFeed.addFirst((Integer)minHeap.poll()[0]);
        }
            
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            users.put(followerId, new ArrayDeque<>());
            follows.put(followerId, new HashMap<>());
        }

        if(!users.containsKey(followeeId)) {
            users.put(followeeId, new ArrayDeque<>());
            follows.put(followeeId, new HashMap<>());
        }

        Map<Integer,Deque<int[]>> followedUsers = follows.get(followerId);
        followedUsers.put(followeeId, users.get(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.get(followerId).remove(followeeId);
    }
}
