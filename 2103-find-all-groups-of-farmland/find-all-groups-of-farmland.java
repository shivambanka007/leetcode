class Solution {
    int rows = 0;
    int cols=0;
    int maxRow=0,maxCol=0;
    public int[][] findFarmland(int[][] land) {
        //Top left is min row and min col
        //Bottom right is max row and max col
        rows = land.length;
        cols=land[0].length;
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(land[i][j]==1){
                    maxRow=i;maxCol=j;
                    dfs(land,i,j);
                    result.add(new int[]{i,j,maxRow,maxCol});
                }
            }
        }
        return result.toArray(new int[0][0]);
    }

    private void dfs(int[][] land , int row,int col){
        if(row<0 || col <0 || row>=rows || col>=cols || land[row][col] == 0)return;
        land[row][col]=0; // Mark as visited
        dfs(land,row-1,col);
        dfs(land,row+1,col);
        dfs(land,row,col-1);
        dfs(land,row,col+1);
        maxRow=Math.max(row,maxRow);
        maxCol=Math.max(col,maxCol);
    }
}