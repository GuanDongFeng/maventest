package maventest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

import junit.framework.TestCase;

public class MainTest extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testWordBreak() {
		String s = "ilikeicecreamandmango";
		//{ i, like, sam, sung, mobile, icecream, man go, mango}
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("i");
		wordDict.add("like");
		wordDict.add("sam");
		wordDict.add("sung");
		wordDict.add("mobile");
		wordDict.add("icecream");
		wordDict.add("man go");
		wordDict.add("mango");
		wordDict.add("and");
		
		System.out.println("wordDict:"+wordDict);
		List<String> wordBreak = Main.wordBreak(s,wordDict);
		System.out.println("wordBreak:"+wordBreak);
		
		
	}

}
