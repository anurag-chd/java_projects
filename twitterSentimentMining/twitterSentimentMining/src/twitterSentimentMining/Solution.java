/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitterSentimentMining;

import twitter4j.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import alchemyAPI.src.com.alchemyapi.test.KeywordTest;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class Solution {
    /**
     * Usage: java twitter4j.examples.timeline.GetHomeTimeline
     *
     * @param args String[]
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getUserTimeline();
            Twitter newproftwitter = new TwitterFactory().getInstance();
           List<Status> status1 = newproftwitter.getUserTimeline("iPoonampandey");
            
            for (Status status : status1)
            System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
          /*  
            ///////////times of india//////////////////////////////////////
            IDs id1 =newproftwitter.getFollowersIDs("timesofindia", -1);
            long [] times_user_id = id1.getIDs();
            User follower_times = twitter.showUser(times_user_id[3]);
            System.err.println("Showing @" + follower_times.getScreenName() + "'s home timeline.");
            
            /*ResponseList<Status> list  = newproftwitter.getFavorites(follower_times.getScreenName());
            for (Status status : list) {
                System.out.println(" Twwets of times follower @" + status.getUser().getScreenName() + " - " + status.getText());
            }*/
            
            /*
            FileWriter writer = new FileWriter("Anurag.txt");
            //KeywordTest.class.
           
           Query query = new Query("timesofindia");
           int numberOfTweets = 512;
           long lastID = Long.MAX_VALUE;
           ArrayList<Status> tweets = new ArrayList<Status>();
           while (tweets.size () < numberOfTweets) {
        	    if (numberOfTweets - tweets.size() > 100)
        	      query.setCount(100);
        	    else 
        	      query.setCount(numberOfTweets - tweets.size());
        	    try {
        	      QueryResult result = twitter.search(query);
        	      tweets.addAll(result.getTweets());
        	     System.out.println("Gathered " + tweets.size() + " tweets");
        	      for (Status t: tweets) 
        	        if(t.getId() < lastID) lastID = t.getId();

        	    } 	
        	    
        	    catch (TwitterException te) {
        	    	System.out.println("Couldn't connect: " + te);
        	      }; 
        	      query.setMaxId(lastID-1);
        	    }
        	    
           for (int i = 0; i < tweets.size(); i++) {
        	    Status t = (Status) tweets.get(i);
        	    System.err.println(" Twwets of times follower @" + t.getUser().getScreenName() + " - " + t.getText());
        	    writer.write( "Tweets of times follower @" + t.getUser().getScreenName() + " - " + t.getText()+"~!");
                    
                
           } 
           writer.close();
           
          // query.setCount(500);
           
            //QueryResult result = twitter.search(new Query("Gas Prices").setMaxId(100));
           /* QueryResult result = newproftwitter.search(query);
            List<Status> status3 = result.getTweets();
            for (Status status : status3) {
                System.err.println(" Twwets of times follower @" + status.getUser().getScreenName() + " - " + status.getText());
            }*/
            
            
            /*List<Status> status3 = newproftwitter.getUserTimeline(follower_times.getScreenName());
            for (Status status : status3) {
                System.err.println(" Twwets of times follower @" + status.getUser().getScreenName() + " - " + status.getText());
            }*/
            
            
            
            
            
            
            
            
List<Status> status2 = newproftwitter.getUserTimeline("timesofindia");
            
           /* for (Status status : status2)
            System.out.println("\n@" + status.getUser().getScreenName() + " - " + status.getText());
           */ 
            
           // writer.write("Anuarg");
           /* for (Status status : status2)
            	writer.write("\n@" + status.getUser().getScreenName() + " - " + status.getText()+"\n");
                
            writer.close();*/
            
            
            /*IDs ids = twitter.getFollowersIDs("iPoonampandey",-1);
            long [] user_id = ids.getIDs();
            
            
            
            
            
            
            
            System.out.println("The followers are"+ids);
            User followers = twitter.showUser(user_id[1]);
            
            System.out.println("The followers are"+followers.getName());
            System.out.println("The follower has following discription" + followers.getDescription());
            */
            /*System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }*/
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }

public ArrayList<Status> generateTweets(String username){
	  Twitter twitter = new TwitterFactory().getInstance();
	 // Query query = new Query("timesofindia");
      int numberOfTweets = 123;
      long lastID = Long.MAX_VALUE;
      ArrayList<Status> tweets = new ArrayList<Status>();
      while (tweets.size () < numberOfTweets) {
   	    /*if (numberOfTweets - tweets.size() > 100)
   	      query.setCount(100);
   	    else 
   	      query.setCount(numberOfTweets - tweets.size());*/
   	    try {
   	    	Paging paging = new Paging(1, 100);
   	      ResponseList<Status> result = twitter.getUserTimeline(username, paging);
   	   
   	      tweets.addAll(result);
   	     System.out.println("Gathered " + tweets.size() + " tweets");}
   	     /* for (Status t: tweets) 
   	        if(t.getId() < lastID) lastID = t.getId();

   	    } 	
   	    */
   	    catch (TwitterException te) {
   	    	System.out.println("Couldn't connect: " + te);
   	      }; 
   	      //query.setMaxId(lastID-1);
   	    }
   	    

      return tweets;
}











}