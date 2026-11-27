class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
    if(fresh==0) return 0;
    int[] dr={1,-1,0,0};    
    int[] dc={0,0,-1,1};
    int time=0;
    while(!q.isEmpty()){
        int size=q.size();
        boolean rotten=false;
        for(int i=0;i<size;i++){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                    fresh--;
                    rotten = true;
                }
            }
        }
        if(rotten) time++;
    }
    if(fresh>0) return -1;
    return time;
       
    }
}