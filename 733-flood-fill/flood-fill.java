class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc=image[sr][sc];
        if(oc==color) return image;
        dfs(sr,sc,image,oc,color);
        return image;
    }
    public void dfs(int i,int j,int[][] image,int oc,int color){
        if(i<0||j<0||i>=image.length||j>=image[0].length||image[i][j]!=oc) return;
        image[i][j]=color;

        dfs(i+1,j,image,oc,color);
        dfs(i-1,j,image,oc,color);
        dfs(i,j+1,image,oc,color);
        dfs(i,j-1,image,oc,color);
    }
}