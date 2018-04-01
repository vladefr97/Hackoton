package hackoton;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class FriendPalich {
    public static void run(String text) {
        ByteArrayInputStream bin = new ByteArrayInputStream(text.getBytes());
        System.setIn(bin);
        Scanner in = new Scanner(bin);
        // your code goes here
        int n = in.nextInt();
        in.nextLine();
        TreeSet<Integer> friends = new TreeSet<Integer>();
        TreeSet<Integer> friendsFriends = new TreeSet<Integer>();

        for(int i = 0; i < n; i++){
            friends.add(in.nextInt());
            int m = in.nextInt();
            for(int j = 0; j < m; j++){
                friendsFriends.add(in.nextInt());
            }

        }
        friendsFriends.removeAll(friends);
        System.out.println(friendsFriends.size());

        System.setIn(System.in);
    }
}
