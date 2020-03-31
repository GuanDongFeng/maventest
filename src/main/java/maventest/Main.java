package maventest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

	public static List<String> result = new LinkedList<String>();

	public static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> dp[] = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<String>();
		//java8
		IntStream.range(0,s.length()).forEach(i -> {
			if (dp[i] == null) {
				return;
			}
			wordDict.forEach( word -> {
				int len = word.length();
				if (i + len > s.length()) {
					return;
				}
				String sub = s.substring(i, i + len);
				if (word.equals(sub)) {
					if (dp[i + len] == null) {
						dp[i + len] = new ArrayList<String>();
					}
					dp[i + len].add(word);
				}
			});
		});
		
		if (dp[s.length()] != null) {
			backTrack(dp, s.length(), new ArrayList<String>());
		}
		return result;
	}

	public static void backTrack(List<String> dp[], int end, ArrayList<String> tmp) {
		if (end <= 0) {
			String path = tmp.get(tmp.size() - 1);
			for (int i = tmp.size() - 2; i >= 0; i--) {
				path += " " + tmp.get(i);
			}
			result.add(path);
			return;
		}
		dp[end].forEach( word -> {
			tmp.add(word);
			backTrack(dp, end - word.length(), tmp);
			tmp.remove(tmp.size() - 1);
		});
	}

}
