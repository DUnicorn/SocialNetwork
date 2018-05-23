package lt.vtvpmc.akademijaIt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class SocialNetworkImpl implements SocialNetwork {
	
	List<Friend> friends = new ArrayList<>();

	@Override
	public void addFriend(Friend friend) {
		if(friend==null) {
			throw new IllegalArgumentException();
		}
		
		boolean uniqueFriend = true;
		
		for (Friend oneFriend: friends) {
			if (friend.equals(oneFriend)){
				uniqueFriend = false;
			}
		}
			if (uniqueFriend) {
			friends.add(friend);
			}
	}

	@Override
	public Collection<Friend> findByCity(String city) {
		
		if (city==null) {
			throw new IllegalArgumentException();
		}
		
		List<Friend> friendByCity = new ArrayList<>();	

		for ( Friend f : friends) {
			if(f.getCity().equals(city)) {
				friendByCity.add(f);
			}
		}
			return friendByCity;
	}
	


	
	@Override
	public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
		
		if (firstName==null) {
			throw new IllegalArgumentException();
		}else if (lastName==null){
			throw new IllegalArgumentException();
			}
//		int index = 0;
//		int friendNum = 0;
//		boolean friendFound = false;
//		for (Friend f :friends) {
//			if (f.getFirstName().equals(firstName) && f.getLastName().equals(lastName)) {
//				friendFound = true;
//				friendNum = index;
//			}
//			index ++;
//		}
		
		return 
	
	friends.stream()
	  .filter(x ->(firstName.equals(x.getFirstName()))&& (lastName.equals(x.getLastName())))
	  .findAny()
	  .orElseThrow(() -> new FriendNotFoundException(firstName,lastName));
	  
	 
}
	@Override
	public int getNumberOfFriends() {	
		return friends.size();
	}

	@Override
	public List<Friend> getOrderedFriends() {
		
		return friends.stream()
				 .sorted(Comparator.comparing(Friend :: getCity).
						thenComparing(Friend :: getFirstName).
						thenComparing(Friend :: getLastName))
			     .collect(Collectors.toList());
	}

}
