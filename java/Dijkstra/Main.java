import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int closeKey;
    private static int nearestKey;

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("graph.txt"));
            String s = in.readLine();
            int num = Integer.valueOf(s);
            int[][] graph = new int[num][num];
            for (int i = 0; (s = in.readLine()) != null && i < num; i++) {
                String[] nums = s.split(" +");
                for (int j = 0; j < num; j++) {
                    graph[i][j] = Integer.valueOf(nums[j]);
                }
            }
            int[] length = new int[num];
            int[] preIndex = new int[num];
            dijkstra(graph, 0, length, preIndex);
            for (int i = 0; i < num ; i++){
                System.out.println(preIndex[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void dijkstra(int[][] graph, int v0, int[] length, int[] preIndex) {
        int num = graph.length;
        boolean[] visit = new boolean[num];
        for (int i = 0; i < num; i++) {
            visit[i] = false;
        }
        visit[v0] = true;
        for (int i = 0; i < num; i++) {
            length[i] = graph[v0][i];
            preIndex[i] = v0;
        }
        for (int i = 1; i < num; i++) {
            int value = Integer.MAX_VALUE;  //记录最小距离
            //记录最小距离的节点
            int nearestKey = -1;
            /**
             * 选出当前未访问的最近点
             */
            for (int j = 0; j < num; j++) {
                if (!visit[j] && length[j] < value) {
                    nearestKey = j;
                    value = length[j];
                }
            }
            visit[nearestKey] = true;
            /**
             * 使用k点到其他点的更短距离代替之前距离
             */
            for (int j = 0; j < num; j++) {
                if (!visit[j] && (value + graph[nearestKey][j] < length[j])) {
                    length[j] = value + graph[nearestKey][j];
                    preIndex[j] = nearestKey;
                }
            }
        }

    }
}
