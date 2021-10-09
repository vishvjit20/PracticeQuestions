package DesignQuestions;

import java.util.*;

class Twitter {
	
	// give order to our tweets
	public int timeStamp = 0;
	
	// user storage
	private Map<Integer, User> userMap;
	
	// Tweet object
	private class Tweet {
		public int id;
		public int time;
		public Tweet next;
		
		public Tweet(int id) {
			this.id = id;
			time = timeStamp++;
			next = null;
		}
	}
	
	public class User {
		public int id;
		
		// Followed list
		public Set<Integer> followed;
		
		// Tweet head pointer
		public Tweet tweet_head;
		
		public User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id);
		}
		
		public void follow(int id) {
			followed.add(id);
		}
		
		public void unfollow(int id) {
			followed.remove(id);
		}
		
		// everytime user posts a new tweet, add it to the head of tweet list
		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweet_head;
			tweet_head = t;
		}
	}
	
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
        	User u = new User(userId);
        	userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;
        
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
        	Tweet t = userMap.get(user).tweet_head;
        	if (t != null) q.add(t);
        }
        int n = 0;
        while (!q.isEmpty() && n < 10) {
        	Tweet t = q.poll();
        	res.add(t.id);
        	n++;
        	if (t.next != null) q.add(t.next);
        }
        return res; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (!userMap.containsKey(followerId)) {
    		User u = new User(followerId);
    		userMap.put(followerId, u);
    	}
    	if (!userMap.containsKey(followeeId)) {
    		User u = new User(followeeId);
    		userMap.put(followeeId, u);
    	}
    	userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
        	return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */