import java.util.LinkedList;

public class Group implements Component{
	LinkedList<Component> components = new LinkedList<Component>();
	
	public void add(Component c){
		this.components.add(c);
	}
	@Override
	public void print(){
		System.out.print("Group:{");
		for (Component temp : components){
			temp.print();
			System.out.print(" ");
		}
		System.out.print("}");
	}
}
