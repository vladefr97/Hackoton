package hackoton;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Friend {

    public static void run(String text) {
        ByteArrayInputStream bin = new ByteArrayInputStream(text.getBytes());
        System.setIn(bin);
        Scanner in = new Scanner(bin);
        int n;
        n = in.nextInt();

        TreeSet<Integer> friends = new TreeSet<Integer>();
        TreeSet<Integer> friendFriends = new TreeSet<Integer>();

        for(int i=0;i<n;i++)
        {
            friends.add(in.nextInt());
            int m = in.nextInt();
            for (int j = 0;j<m;j++)
            {
                int friend = in.nextInt();
                if(!friends.contains(friend))
                {
                    friendFriends.add(friend);
                }
            }
            m = friends.iterator().next();
            for(Integer el: friends )
                if(friendFriends.contains(el))
                    friendFriends.remove(el);

        }
        System.out.println(friendFriends.size());

        System.setIn(System.in);
    }
}
