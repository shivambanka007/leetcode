class Solution {
    public boolean isRobotBounded(String instructions) {
        // North = move 1 in y, 
        // East = move 1 in x,
        // South = move -1 in y
        // West = move -1 in x
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int inX = 0,inY=0;
        // If north , Pos = 0, East = 1, South = 2, West = 3
        int idx = 0;
        for(char c:instructions.toCharArray()) {
            if(c == 'L')idx = (idx+3)%4;  // +3 as we go west from here
            else if(c == 'R')idx = (idx+1)%4;
            else {
                inX += dirs[idx][0];
                inY += dirs[idx][1];
            }
        }
        //If idx == 0 , means robot faces north
        return (inX == 0 && inY == 0 ) || idx !=0; 
    }
}