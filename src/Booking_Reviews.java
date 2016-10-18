import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Booking_Reviews {
	
//	3 4
//	Skating
//	Food
//	Climbing
//	1 1467720000
//	Skating is good in Austria
//	22 1464782400
//	I loved the Spanish food, it had so many varieties and it was super super delicious. The price was a little bit high but it was worth it. People who don't like spicy food might need to think twice as it could be a little bit problematic for them.
//	4 1467720000
//	I didn’t like the Indian food!
//	50  1467720000
//	People were really friendly, I enjoyed being there.
	
	final static long date_15_Jun = 1465992000;
	final static long date_15_Jul = 1468584000;
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in);) {
			int n = scanner.nextInt();//Passions
			int m  = scanner.nextInt();//Reviews
			ArrayList<String> passions = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				passions.add(scanner.next());
			}
//			for (int i = 0; i < n; i++) {
//				System.out.println(passions.get(i));
//			}
			HashMap<Integer, Reviewer> hashMap = new HashMap<>();
			HashMap<String, ArrayList<Reviewer>> passionMap = new HashMap<>();
			for (int i = 0; i < m; i++) {
				Review review = new Review(scanner.nextInt());
				review.timestamp = scanner.nextLong();
				scanner.nextLine();
				review.body = scanner.nextLine();
				Reviewer reviewer = hashMap.get(review.reviewerId);
				if (reviewer == null) {
					reviewer = new  Reviewer(review.reviewerId);
					reviewer.addReview(review);
				} else {
					reviewer.addReview(review);
				}
				String passion = reviewContainPassion(review, passions);
				if (passion != null) {	
					if (passionMap.get(passion) != null) {
						if (!passionMap.get(passion).contains(reviewer)) {
							passionMap.get(passion).add(reviewer);
						}
					} else {
						ArrayList<Reviewer> reviewers = new ArrayList<>();
						reviewers.add(reviewer);
						passionMap.put(passion, reviewers);
					}
				}
				
				hashMap.put(review.reviewerId, reviewer);
			}
//			printMap(hashMap);
			Set<String> containedPassions = passionMap.keySet();
			for (String passion : passions) {
				if (containedPassions.contains(passion)) {
					// print score
					ArrayList<Reviewer> reviewers = passionMap.get(passion);
					for (Reviewer reviewer : reviewers) {
						reviewer.setScoreByPassion(passion);
					} 
					if (reviewers.size() > 1) {
						Collections.sort(reviewers);
					}
					System.out.println(reviewers.get(0).ID);
				} else {
					System.out.println("-1");
				}
			}
		}
	}
	
	private static String reviewContainPassion(Review review, ArrayList<String> passions) {
		for (String passion : passions) {
			if (review.body.toLowerCase().contains(passion.toLowerCase())) {
				return passion;
			}
		}
		
		return null;
	}
	
	private static boolean reviewContainPassion(Review review, String passion) {
		return review.body.toLowerCase().contains(passion.toLowerCase());
	}

	private static void printMap(HashMap hashMap){
		for ( Object key : hashMap.keySet()) {
			System.out.println("key " + key + " -- " + hashMap.get(key));
		}
	}
	
	static class Review {
		int reviewerId;
		long timestamp;
		String body;
		
		public Review(int id) {
			reviewerId = id;
		}
		@Override
		public String toString() {
			return  " " + body.length() + "";
		}
	}
	
	static class Reviewer implements Comparable<Reviewer>{
		int ID;
		ArrayList<Review> reviews;
		int score;
		
		Reviewer(int id) {
			ID = id;
			reviews = new ArrayList<>();
			score = 0;
		}
		
		public void addReview(Review review) {
//			if (review.timestamp >= date_15_Jun && review.timestamp <= date_15_Jul) {
//				score+=20;
//			} else {
//				score+=10;
//			}
//			if (review.body.length() >= 100) {
//				score+=20;
//			}else {
//				score+=10;
//			}
			reviews.add(review);
		}
		
		@Override
		public String toString() {
			return ID + "";
		}

		@Override
		public int compareTo(Reviewer reviewer) {
			if (this.score == reviewer.score) {
				return this.ID - reviewer.ID; // small first
			} else {
				return reviewer.score - this.score; //large first
			}
		}
		
		public void setScoreByPassion(String passion){
			for (Review review : reviews) {
				if (reviewContainPassion(review, passion)){
					if (review.timestamp >= date_15_Jun && review.timestamp <= date_15_Jul) {
						score+=20;
					} else {
						score+=10;
					}
					if (review.body.length() >= 100) {
						score+=20;
					}else {
						score+=10;
					}
				}
			}
		}
		
	}
	
	
}
