package Basics;
import java.util.*;
import java.io.*;
public class TestGenerics_Collections {
	static ArrayList<Song> mySongList = new ArrayList<Song>();
	public static void main(String args[]){
		
		TestGenerics_Collections test = new TestGenerics_Collections();
		test.go();
		System.out.println(mySongList);
		//Collections.sort(mySongList);
		//System.out.println(mySongList);
		
		ArtistCompare artist_compare = new ArtistCompare();
		Collections.sort(mySongList,artist_compare);
		System.out.println(mySongList);
		///////////////////////
		
		TitleCompare title_compare = new TitleCompare();
		Collections.sort(mySongList,title_compare);
		System.out.println(mySongList);
	}
	public void go(){
		getSongs();
	}

public void getSongs(){
	try{
		File f = new File("SongList.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while((line=br.readLine())!=null){
			addSong(line);
		}
	}
	catch(Exception e){
		
	}
}
	
	public void addSong(String s){
		String[] song_part = s.split("/");
		Song nextSong = new Song(song_part[0],song_part[1],song_part[2],song_part[3]);
		mySongList.add(nextSong);
	}
}


class Song /*implements Comparable<Song>*/{
	String title;
	String artist;
	String rating;
	String bpm;
	
	public Song(String s1, String s2, String s3, String s4){
		title = s1;
		artist = s2;
		rating = s3;
		bpm = s4;
	}
	
	public String toString(){
		return title;
	}
	
	public int compareTo(Song s){
		return title.compareTo(s.title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getBpm() {
		return bpm;
	}

	public void setBpm(String bpm) {
		this.bpm = bpm;
	}
	
	
	
	
}

class ArtistCompare implements Comparator<Song>{
	public int compare(Song one, Song two){
		return one.getArtist().compareTo(two.getArtist());
	}
}
class TitleCompare implements Comparator<Song>{
	public int compare(Song one, Song two){
		return one.getTitle().compareTo(two.getTitle());
	}
}