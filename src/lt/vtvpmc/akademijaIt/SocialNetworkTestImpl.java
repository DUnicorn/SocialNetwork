package lt.vtvpmc.akademijaIt;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class SocialNetworkTestImpl extends BaseSocialNetworkTest{


	@Override
	protected SocialNetwork getSocialNetwork() {
		SocialNetworkImpl socialNetwork = new SocialNetworkImpl();
		return socialNetwork;
	}

}
