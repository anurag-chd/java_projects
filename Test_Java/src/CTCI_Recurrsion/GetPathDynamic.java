package CTCI_Recurrsion;
import java.util.*;

public class GetPathDynamic {
	static ArrayList<Point> path_list = new ArrayList<Point>();
	static HashSet<Point> point_set = new HashSet<Point>();
	public static void main(String args[]){
		int grid_x = 1;
		int grid_y = 1;
		GetPathDynamic gpd = new GetPathDynamic();
		gpd.getPath(grid_x,grid_y,path_list,point_set);
		System.out.println("The set of points are");
		for(Point p : point_set){
			System.out.print("("+p.getX() + ", "+p.getY()+"),");
		}
		System.out.println("The Paths possible");
		for(Point p : path_list){
			System.out.print("("+p.getX() + ", "+p.getY()+"),");
		}
	}
	
	public boolean getPath(int x, int y, ArrayList<Point> path, HashSet<Point> point_set){
		Point p = new Point(x,y);
		path.add(p);
		if(point_set.contains(p)){
			return true;
		}
		if(x == 0 && y == 0){
			//point_set.add(p);
			return true;
		}
		boolean success = false;
		if(x>=1){
			success = getPath(x-1,y,path,point_set);
		}
		if(y>=1){
			success = getPath(x,y-1,path,point_set);
		}
		point_set.add(p);
		return success;
		
	}

}

/* class Point{
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
*/