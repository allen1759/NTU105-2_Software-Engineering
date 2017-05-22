import java.util.ArrayList;

public class ListIterator implements Iterator{
	private ArrayList list = new ArrayList<String>();
	private int index;

	public ListIterator(List _list){
		this.list = _list.getList();
		this.index = -1;
	}
	
	public String next(){
		this.index++;
		return (String)list.get(index);
	}
	
	public boolean hasNext(){
		return (this.index+1 < this.list.size()); 
	}	
}
