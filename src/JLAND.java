import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sreps on 9/5/2016.
 */
public class JLAND {
    static class Ticket {
        Long cost;
        Integer hops;

        Ticket(Integer hops, Long cost) {
            this.cost = cost;
            this.hops = hops;
        }
    }

    static Long cost[];
    static boolean visited[];
    static Integer N;
    static boolean adj[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        Integer M = Integer.parseInt(temp[1]);
        cost = new Long[N];
        visited = new boolean[N];
        adj = new boolean[N][N];
        for (int i = 1; i < N; i++) {
            temp = br.readLine().split(" ");
            Integer A = Integer.parseInt(temp[0]) - 1;
            Integer B = Integer.parseInt(temp[1]) - 1;
            adj[A][B] = true;
        }

        HashMap<Integer, ArrayList<Ticket>> tickets = new HashMap<>();

        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            Integer V = Integer.parseInt(temp[0]) - 1;
            Integer K = Integer.parseInt(temp[1]);
            Long W = Long.parseLong(temp[2]);

            if (tickets.containsKey(V)) {
                tickets.get(V).add(new Ticket(K, W));
                continue;
            }

            ArrayList<Ticket> tempTicket = new ArrayList<>();
            tempTicket.add(new Ticket(K, W));
            tickets.put(V, tempTicket);
        }

        Integer friends = Integer.parseInt(br.readLine());

        while (friends-- > 0) {
            Integer friend = Integer.parseInt(br.readLine()) - 1;

            if (friend.equals(0)) {
                System.out.println(0);
                continue;
            }

            for (int i = 0; i < N; i++) {
                cost[i] = Long.MAX_VALUE;
                visited[i] = false;
            }

            cost[friend] = 0L;
            System.out.println(getMinimalCost(friend, tickets));
        }
    }

    private static Long getMinimalCost(Integer friend, HashMap<Integer, ArrayList<Ticket>> tickets) {
        if (friend.equals(0)) {
            return cost[0];
        }


        updateCost(friend, cost, tickets.get(friend));
        Integer nextFriend = getNextFriend(visited, cost, N);
        visited[friend] = true;

        return getMinimalCost(nextFriend, tickets);
    }

    private static Integer getNextFriend(boolean[] visited, Long[] cost, Integer N) {
        Long min = Long.MAX_VALUE;
        Integer index = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (cost[i] < min)) {
                min = cost[i];
                index = i;
            }
        }
        return index;
    }

    private static void updateCost(Integer friend, Long[] cost, ArrayList<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            traverse(friend, 1, cost, ticket.hops, ticket.cost + cost[friend]);
        }
    }

    private static void traverse(Integer currentCity, int currentHop, Long[] cost, Integer maxHops, Long currentCost) {

        if (visited[currentCity]) {
            return;
        }

        if (currentHop > maxHops) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (adj[currentCity][i]) {
                if (cost[i] > (cost[currentCity] + currentCost)) {
                    cost[i] = currentCost;
                }

                traverse(i, currentHop + 1, cost, maxHops, currentCost);
            }
        }


    }
}