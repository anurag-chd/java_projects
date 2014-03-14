package CTCI_Recurrsion;

import java.util.ArrayList;
public class GetPathRecurrsion {
	static ArrayList<Point> path_list = new ArrayList<Point>();
	public static void main(String args[]){
		int grid_x = 1;
		int grid_y = 1;
		GetPathRecurrsion gpr = new GetPathRecurrsion();
		gpr.getPath(grid_x,grid_y,path_list);
		for( Point p : path_list){
			System.out.print("("+p.getX()+", "+p.getY()+"), ");
		}
		
	}
	
	public /*ArrayList<Point>*/ boolean getPath(int x, int y, ArrayList<Point> path){
		Point p = new Point(x,y);
		path.add(p);
		
		//int x1 = x-1;
		//int y1 = y-1;
		if(x == 0 && y == 0){
			return true;
		}
		boolean success = false;
		if(x >= 1){
			success= getPath(x-1,y,path);
		}
		if(!success && y >= 1){
			success= getPath(x,y-1,path);
		}
		if(success){
			path.add(p);
		}
		return success;
	}
}



class Point{
	int x;
	int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
