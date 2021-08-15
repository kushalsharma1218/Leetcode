import java.util.*;
class A
{
	static int dx[] = {0,0, -1,-1,-1,1,1,1};
	static int dy[] = {1,-1, 0,-1,1, 0,-1,1};
	public static void main(String ar[])
	{
		String dict[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		
		char boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
					   
		
		printAllWordsFromBoggle(dict, boggle);
	}
	public static void printAllWordsFromBoggle(String arr[], char chars[][])
	{
		// lets just find all the words that can be create from chars
		
		// From a charcter in chars we are alowed to go in 8 diffrent directions
		
		
		Set<String> dict = new HashSet<>();
		for(String s: arr)
		{
			dict.add(s);
		}
		
		int n= chars.length;
		int m = chars[0].length;
		int vis[][] = new int[n][m];
		
	
		
		
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<m;j++){
				StringBuilder sb =new StringBuilder("");
				dfs(chars, i, j, vis, dict, sb);
			}
		}
		
	}
	public static void dfs(char arr[][], int row, int col, int vis[][], Set<String> dict, StringBuilder sb)
	{
		
		vis[row][col] = 1;
		sb.append(arr[row][col]+"");
		
		if(dict.contains(sb.toString()))
		{
			System.out.println(sb);
			dict.remove(sb.toString());
		}
		
		for(int i =0;i<8;i++)
		{
			int newi = row + dx[i];
			int newj = col + dy[i];
			
			if(newi < 0 || newj < 0 || newi >= arr.length || newj >= arr[0].length || vis[newi][newj] == 1)continue;
			
			dfs(arr, newi, newj, vis, dict, sb);
			
		}
		vis[row][col] = 0;
		sb.deleteCharAt(sb.length() -1);
	}
}
