import java.io.*;
import java.util.*;
public class Labyrinth
{
	public static void main(String ar[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		
		char arr[][] = new char[n][m];
		
		for(int i = 0;i<n;i++)
		{
			String s = br.readLine();
			for(int j = 0;j<m;j++)
			{
				arr[i][j] = s.charAt(j);
			}
		}
		
		
		int srci = -1;
		int srcj = -1;
		
		int desi = -1;
		int desj = -1;
		
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<m;j++)
			{
				if(arr[i][j] == 'A')
				{
					srci = i;
					srcj = j;
				}
				if(arr[i][j] == 'B')
				{
					desi = i;
					desj = j;
				}
			}
		}
		
		bfs(srci, srcj,desi, desj, arr);
		
		
	}
	public static void bfs(int sRow, int sCol, int dRow, int dCol, char arr[][])
	{
		int ans = -1;
		String path = "";
		int n = arr.length;
		int m = arr[0].length;
		boolean vis[][] = new boolean[n][m];
		
		Queue<Pair> queue = new LinkedList<>();
		
		vis[sRow][sCol] = true;
		queue.add(new Pair(sRow, sCol, 0, ""));
		
		int dx[] = {0,0,1,-1};
		int dy[] = {-1,1,0,0};
		char dir[] = {'L', 'R', 'D', 'U'};
		while(!queue.isEmpty())
		{
			Pair curr = queue.poll();
			String str = curr.s;
			int row = curr.row;
			int col = curr.col;
			int step = curr.step;
			
			if(col == dCol && row == dRow){
				ans = step;
				path = str;
				break;
			}
			for(int i = 0;i<4;i++)
			{
				int newRow = row + dx[i]; 
				int newCol = col + dy[i];
				
				if(newRow < 0 || newCol <0 || newRow >= n|| newCol >= m || arr[newRow][newCol] == '#' || vis[newRow][newCol] == true)continue;
				
				vis[newRow][newCol] = true;
				queue.add(new Pair(newRow, newCol, step+1, str+dir[i]));
				
			}
			
		}
		
		if(ans != -1)
		{
			System.out.println("YES");
			System.out.println(ans);
			System.out.println(path);
		}
		else
		{
			System.out.println("NO");
		}
		
	}
}
class Pair
{
	int row;
	int col;
	int step;
	String s;
	
	Pair(int r, int c, int s , String str)
	{
		this.row = r;
		this.col = c;
		this.s = str;
		this.step = s;
	}
}