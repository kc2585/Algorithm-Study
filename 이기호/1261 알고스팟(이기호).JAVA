import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int min = Integer.MAX_VALUE;
    private static int M;
    private static int N;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        boolean[][] maze = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            
            for(int j = 0; j < M; j++) {
                maze[i][j] = temp[j] == '0' ? true : false;
            }
        }
        
        boolean[][] visited = new boolean[N][M];
        
        dfs(maze, visited, 0, 0, 0);
        
        System.out.println(min);
    }
 
    private static void dfs(boolean[][] maze, boolean[][] visited, int i, int j, int cnt) {
        visited[i][j] = true;
        
        if(cnt >= min) {
            return;
        }
        
        if(i == N - 1 && j == M - 1) {
            if(cnt < min) {
                min = cnt;
            }
            
            return;
        }
        
        for(int k = 0; k < 4; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];
            
            if(nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M && !visited[nextI][nextJ]) {
                if(maze[nextI][nextJ]) {
                    dfs(maze, visited, nextI, nextJ, cnt);
                } else {
                    dfs(maze, visited, nextI, nextJ, cnt + 1);
                }
                
                visited[nextI][nextJ] = false;
            }
        }

	}

}
