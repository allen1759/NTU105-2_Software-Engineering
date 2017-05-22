import java.util.ArrayList;

public class List implements Container{
	private ArrayList<String> list = new ArrayList<String>();
	
	public ArrayList<String> getList(){
		return this.list;
	}
	
	public void add(String str){
		this.list.add(str);
	}
	
	public int length(){
		return this.list.size();
	}
	
	public String getNode(int index){
		return this.list.get(index);
	}
	
	public Iterator iterator(){
		return new ListIterator(this);
	}
}
