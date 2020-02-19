import java.io.FileNotFoundException;
import java.io.IOException;


public class FindConnection {
	Map cityMap;
	
	//find the connection from the first  to the destination
	public FindConnection (String filename)throws InvalidMapException, FileNotFoundException, IOException{
		
		cityMap=  new Map(filename);
		MapCell inicell= cityMap.getStart();
		
		ArrayStack<MapCell> stack= new ArrayStack<MapCell>(); 
		
		stack.push(inicell);
		inicell.markInStack();
		
		boolean isFind = false;
		
		while(stack.size()!=0) {
			MapCell Cell=stack.peek();
			if(Cell.isCustomer()) {
				isFind=true;
				break;
			}
			MapCell Nextcell=bestCell(Cell);
			if(Nextcell!=null) {
				stack.push(Nextcell);
				Nextcell.markInStack();
			}else {
				stack.pop();
				Cell.markOutStack();
			}
		}
		if (isFind) 
			System.out.println("Connected  !!  \n"+stack.size()+" STEPS");
		else 
			System.out.println("sorry didn't find it");
				
	}
	
	//find the right cell
	private MapCell bestCell(MapCell ccell) {
		MapCell[] nb =new MapCell[4];
		int[] val = new int [4];
		for(int i=0;i<4;i++) {
			MapCell nbCell=ccell.getNeighbour(i);
			nb[i]=nbCell;
			if(nbCell!=null) {
				val[i]=4-i;
				if(nbCell.isMarked()||nbCell.isBlock()||
						((nbCell.isHorizontalSwitch()||ccell.isHorizontalSwitch())&&(i==0|| i==2))||
						((nbCell.isVerticalSwitch()||ccell.isVerticalSwitch())&&(i==1||i==3))				
						) //check the cell
				
					val[i]=-1;
				else {
				if(nbCell.isCustomer()) 
					return nbCell;
				
				if(nbCell.isOmniSwitch()) 
					val[i]=5;
				}
			  }
			}
			
			int maxindex=-1;
			int maxval=-1;
			for (int i=0;i<4;i++) {
				if (val[i]>maxval) {
					maxval=val[i];
					maxindex=i;
				}
			}
			
			if(maxindex==-1) 
				return null;
			else 
				return nb[maxindex];
		}
	
	
	public static void main (String[] args) throws InvalidMapException, FileNotFoundException, IOException {
		
		
		   if(args.length < 1) {
				System.out.println("You must provide the name of the input file");
				System.exit(0);
			   }
			   String mapFileName = args[0];
			   new FindConnection(mapFileName);

		
		
		
	}
	



}
