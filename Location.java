import java.util.*;
public class Location{
	private final int locationID;
	private final String description;
	private final Map<String,Integer> exits;
	public Location(int locationID,String description,Map<String,Integer>exits){
		this.locationID=locationID;
		this.description=description;
		this.exits=new HashMap<>(exits);
		this.exits.put("Q",0);
	}
	public String getDescription(){
		return description;
	}
	public int getLocationID(){
		return locationID;
	}
	public void addExits(String description,int locationID){
		exits.put(description,locationID);
	}
	public Map<String,Integer> getExits(){
		return new HashMap<>(exits);
	}
	public static void main(String[] args) {
		Map<Integer,Location> locations=new HashMap<>();
		Scanner scanner=new Scanner(System.in);
		Map<String,Integer> tempExits=new HashMap<>();
		locations.put(0,new Location(0,"You just sitted infront of your computer learning programming.",tempExits));
		tempExits.put("W",2);
		tempExits.put("E",3);
		tempExits.put("S",4);
		tempExits.put("N",5);
		locations.put(1,new Location(1,"You are standing at the end of the road before a small brick.",tempExits));

		tempExits=new HashMap<String,Integer>();
		tempExits.put("N",5);
		locations.put(2,new Location(2,"You are at the top of the hill.",tempExits));

		tempExits=new HashMap<String,Integer>();
		tempExits.put("W",1);
		locations.put(3,new Location(3,"You are inside a building, a small house for spring.",tempExits));

		tempExits=new HashMap<String,Integer>();
		tempExits.put("N",1);
		tempExits.put("W",2);
		locations.put(4,new Location(4,"You in a valley beside a stream.",tempExits));

		tempExits=new HashMap<String,Integer>();
		tempExits.put("S",1);
		tempExits.put("W",2);
		locations.put(5,new Location(5,"You are in the forest.",tempExits));
		//we now need inputting the whole words instead of the letters for that matter and we also tryna search out for the value
		//the words such as quit, south, north,east and west if the appear in the string array 
		//we'll loop around to see if they appear in that for that matter.
		tempExits=new HashMap<String,Integer>();
		Map<String,String>vocabulary=new HashMap<>();
		vocabulary.put("QUIT","Q");
		vocabulary.put("SOUTH","S");
		vocabulary.put("NORTH","N");
		vocabulary.put("EAST","E");
		vocabulary.put("WEST","W");
		int loc=1;
		while(true){
			System.out.println(locations.get(loc).getDescription());
			if(loc==0){
				break;
			}
			Map<String,Integer>exits=locations.get(loc).getExits();
			System.out.print("Available exits are: ");
			for(String key: exits.keySet()){ 
				System.out.print(key+","); 
			}
			System.out.println();
			String direction=scanner.nextLine().toUpperCase();
			if(direction.length()>1){
				String [] words= direction.split("");
				for(String word:words){
					if(vocabulary.containsKey(word)){
						direction=vocabulary.get(word);
						break;
					}
				}
			}
			if(exits.containsKey(direction)){
				loc=exits.get(direction);
			}else{
				System.out.println("Can't go in that direction please.");
			}
		}
	}
}