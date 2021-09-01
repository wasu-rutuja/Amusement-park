package dsa2;
import java.util.*;
public class Main {

	public static void main(String[] args) {

		String str="\n\t\t\t\t\t";
		// TODO Auto-generated method stub
		Graph G=new Graph();
		int in;
		int identity;
		String logo= String.join("\n\t\t\t\t\t",
				" \n\t\t\t\t\t\t_____ .    . .   .        .    .   . .__         ____  ___     __         _____    ____   ",
							"	|     |    | |\\  |       / \\   |\\  | |  \\    	|     |   )   /  \\   |      |    //      ",
							"	|---  |    | | \\ |      /---\\  | \\ | |   )   	|---  |---   (    )) |      |   ((       ",
							"	|     |____| |  \\|     /     \\ |  \\| |__/    	|     |   \\   \\__/   |___ __|__  \\_____ ");

		System.out.println(str+str+"======================================================================================================");
		System.out.println(logo);
		System.out.println(str+str+"======================================================================================================");
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("\nEnter your identity:\n1.Authority\n2.Visitor");
			identity=sc.nextInt();
			System.out.println("------------------------------");
			switch(identity)
			{
			case 1:
			admin(G);
			break;
			case 2:
			Visiter(G);
			break;
			}
			System.out.println("\nDo you want to continue?(main)\n1.Yes\t0.No\n");
			in=sc.nextInt();

		}while(in!=0);

	}

	static void admin(Graph G) {       //class for admins, all the func admin can perform
		String str="\n\t\t\t\t\t";
		Scanner s=new Scanner(System.in);
		int choice,ch;
		String auhority_name;
		System.out.println("Enter Authority Name: ");

		auhority_name=s.next();
		String password;
		System.out.println("Enter password: "); //correct password required!!

		password=s.next();
		if(password.compareTo("secret")==0) {
			do {
				System.out.println("------------------------------");
				System.out.println("\nMenu-Authority:\n1.Create\n2.Add Path\n3.Insert Ride\n4.Display list of all rides\n5.List of Active and Inactive rides");
				System.out.println("Enter choice number:");
				choice=s.nextInt();
				System.out.println("------------------------------");
				switch(choice) {
				case 1: G.createMat();
				System.out.println();
				break;
				case 2:G.addEdge();
				System.out.println();
				break;
				case 3:G.addRide();
				System.out.println();
				break;
				case 4:G.printallrides();
				System.out.println();
				break;
				case 5:G.print_list_activity();
				System.out.println();
				break;
				}
				System.out.println("\nContinue?(admin) \n1.Yes\t0.No\n");
				ch=s.nextInt();
				System.out.println("------------------------------");
			}while(ch!=0 );
		}
		else
			System.out.println("INCORRECT PASSWORD!!!!");
		System.out.println("------------------------------");
		}

	static void Visiter(Graph G) {  //class for visitors, for all the queries of visitors

		Scanner SC=new Scanner(System.in);
		
		System.out.println("........................................................................................................");
		int select,choice1;
		System.out.println();
		System.out.println("WELCOME TO FUN AND FROLIC AMUSEMENT PARK");
		System.out.println();
		System.out.println("HAVE A GREAT DAY AHEAD ! ENJOY TO THE FULLEST !");
		System.out.println("FOLLOW ALL SAFETY MEASURES AND TAKE UP A RIDE AT YOUR OWN RISK");
		System.out.println("FOR EMERGENCY CALL ON : 20120145263");
		System.out.println("........................................................................................................");
		do {
			System.out.println("\nVisitor Menu\n\n1.Display List of active and inactive rides\n2.Find shortest path to the ride\n3.Kids and Adult Ride List\n4.Get all paths\n5.Check if ride is your sector\n");
			System.out.println("Enter choice number:");
			select=SC.nextInt();
			System.out.println("=========================================================================================================");
			switch(select) {
			case 1:G.print_list_activity();
			System.out.println();
			break;
			case 2:G.dijkstra();
			System.out.println();
			break;
			case 3:G.print_list_age();
			System.out.println();
			break;
			case 4:G.getPaths();
			System.out.println();
			break;
			case 5:G.hasPath_check();
			System.out.println();
			break;
			}
			System.out.println("\nContinue?(Visitor) \n1.Yes\t0.No\n");
			choice1=SC.nextInt();
			System.out.println("-----------------------------");
		}while(choice1!=0);

	}
}