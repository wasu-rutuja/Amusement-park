package dsa2;
import java.util.*;

public class NodeRide {
	String name;
	int ageLimit;
	int activity;

	NodeRide()        //default constructor
	{
		name="";
		ageLimit=0;
		activity=1;

	}
	NodeRide(String n,int age,int ID,int a)   //parameterized constructor
	{
		name=n;
		ageLimit=age;
		activity=a;

	}
	void accept() {         //to accept details of ride
		Scanner sc=new Scanner(System.in);
		Scanner t=new Scanner(System.in);
		System.out.println("Enter Ride Name: ");       //accept name of ride
		name=t.nextLine();
		System.out.println("Enter Age limit for ride: ");  //accept age limit of ride
		ageLimit=sc.nextInt();
		System.out.println("Activity status(1/0): ");  //accept status of ride whether it's active or inactive
		activity=sc.nextInt(); 
		System.out.println("\n");
	}
}

/*OUTPUT
							======================================================================================================

									_____ .    . .   .        .    .   . .__         ____  ___     __         _____    ____   
									|     |    | |\  |       / \   |\  | |  \    	|     |   )   /  \   |      |    //      
									|---  |    | | \ |      /---\  | \ | |   )   	|---  |---   (    )) |      |   ((       
									|     |____| |  \|     /     \ |  \| |__/    	|     |   \   \__/   |___ __|__  \_____ 
								
								
							======================================================================================================

Enter your identity:
1.Authority
2.Visitor
1
------------------------------
Enter Authority Name: 
reena
Enter password: 
hello
INCORRECT PASSWORD!!!!
------------------------------

Do you want to continue?(main)
1.Yes	0.No

1

Enter your identity:
1.Authority
2.Visitor
1
------------------------------
Enter Authority Name: 
reena
Enter password: 
secret
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
1
------------------------------
Enter number of rides=
8
Enter Ride Name: 
salimgarh
Enter Age limit for ride: 
12
Activity status(1/0): 
1


Enter Ride Name: 
mrindia
Enter Age limit for ride: 
8
Activity status(1/0): 
1


Enter Ride Name: 
daredrop
Enter Age limit for ride: 
18
Activity status(1/0): 
1


Enter Ride Name: 
deepspace
Enter Age limit for ride: 
21
Activity status(1/0): 
0


Enter Ride Name: 
splash
Enter Age limit for ride: 
8
Activity status(1/0): 
1


Enter Ride Name: 
wackywaves
Enter Age limit for ride: 
18
Activity status(1/0): 
1


Enter Ride Name: 
zooballoo
Enter Age limit for ride: 
21
Activity status(1/0): 
1


Enter Ride Name: 
loopywoopy
Enter Age limit for ride: 
15
Activity status(1/0): 
1


Enter number of edges=
7
Enter ride ID across edge 1 =
0
1
Enter distance between 2 rides
100
Enter ride ID across edge 2 =
1
2
Enter distance between 2 rides
50
Enter ride ID across edge 3 =
2
3
Enter distance between 2 rides
50
Enter ride ID across edge 4 =
3
0
Enter distance between 2 rides
150
Enter ride ID across edge 5 =
4
5
Enter distance between 2 rides
300
Enter ride ID across edge 6 =
5
6
Enter distance between 2 rides
150
Enter ride ID across edge 7 =
6
7
Enter distance between 2 rides
250


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
3
------------------------------
Enter Ride Name: 
nitro
Enter Age limit for ride: 
20
Activity status(1/0): 
1


Enter ride ID across edge 8 =
0
8
Enter distance between 2 rides
200


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
2
------------------------------
enter source ride id:
8
enter destination ride id:
3
Enter distance between two rides in metres: 
100


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
3
------------------------------
Enter Ride Name: 
boomeranggo
Enter Age limit for ride: 
12
Activity status(1/0): 
0


Enter ride ID across edge 9 =
4
9
Enter distance between 2 rides
50


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
2
------------------------------
enter source ride id:
9
enter destination ride id:
7
Enter distance between two rides in metres: 
70


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
4
------------------------------
Ride Name		 RideID	  Age Limit

salimgarh			0		12
mrindia				1		8
daredrop			2		18
deepspace			3		21
splash				4		8
wackywaves			5		18
zooballoo			6		21
loopywoopy			7		15
nitro				8		20
boomeranggo			9		12
------------------------------------------------------


Continue?(admin) 
1.Yes	0.No

1
------------------------------
------------------------------

Menu-Authority:
1.Create
2.Add Path
3.Insert Ride
4.Display list of all rides
5.List of Active and Inactive rides
Enter choice number:
5
------------------------------
Active Rides List
-------------------------
salimgarh
mrindia
daredrop
splash
wackywaves
zooballoo
loopywoopy
nitro

INActive Rides List 
-------------------------
deepspace
boomeranggo



Continue?(admin) 
1.Yes	0.No

0
------------------------------
------------------------------


Enter your identity:
1.Authority
2.Visitor
2
------------------------------
........................................................................................................

WELCOME TO FUN AND FROLIC AMUSEMENT PARK

HAVE A GREAT DAY AHEAD ! ENJOY TO THE FULLEST !
FOLLOW ALL SAFETY MEASURES AND TAKE UP A RIDE AT YOUR OWN RISK
FOR EMERGENCY CALL ON : 20120145263
........................................................................................................

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
2
=========================================================================================================
Enter present ride name: 
daredrop
Enter ride you are searching for: 
loopywoopy
The two rides are in different section



Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
4
=========================================================================================================
Enter present ride name: 
splash
Enter ride you are searching for: 
mrindia
The two rides are in different section



Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
1
=========================================================================================================
Active Rides List
-------------------------
salimgarh
mrindia
daredrop
splash
wackywaves
zooballoo
loopywoopy
nitro

INActive Rides List 
-------------------------
deepspace
boomeranggo



Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
3
=========================================================================================================
-----------------
Kids Rides List :
-----------------
salimgarh
mrindia
splash
loopywoopy
boomeranggo
Total Kids Rides are :5
------------------
Adult Rides List :
------------------
deepspace
zooballoo
nitro
Total Adult Rides are :3


Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
2
=========================================================================================================
Enter present ride name: 
nitro
Enter ride you are searching for: 
mrindia
Locations	 Distance	Path
8 -> 1 		 200		8->3->2->1->ARRIVED!



Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
4
=========================================================================================================
Enter present ride name: 
daredrop
Enter ride you are searching for: 
salimgarh

Paths (Mentioned numbers are ride numbers,follow in sequence left to right):
[2, 1, 0]
[2, 3, 0]
[2, 8, 0]


Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
5
=========================================================================================================
Enter present ride name: 
nitro
Enter ride you are searching for: 
splash

Sorry!! Ride is in other block

Continue?(Visitor) 
1.Yes	0.No

1
-----------------------------

Visitor Menu

1.Display List of active and inactive rides
2.Find shortest path to the ride
3.Kids and Adult Ride List
4.Get all paths
5.Check if ride is your sector

Enter choice number:
5
=========================================================================================================
Enter present ride name: 
deepspace
Enter ride you are searching for: 
mrindia

Ride is in your block!


Continue?(Visitor) 
1.Yes	0.No

0
-----------------------------

Do you want to continue?(main)
1.Yes	0.No

0
*/