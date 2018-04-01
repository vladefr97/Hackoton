package hackoton;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();

        Stack<Integer> friends = new Stack<Integer>();
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
    }



}
