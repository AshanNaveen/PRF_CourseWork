import java.util.*;
class untitled {
	private static Scanner input= new Scanner(System.in);
	private static String[][] loginCredentials={{"Ashan","1234"},{"Naveen","12345"}};
	private static String[][] suppliers =new String[0][0];
	private static String[][] items = new String[0][0];
	private static String[] category=new String[0];
	
	public static void main(String []args){
		loginPage();
	}
	
	public static void loginPage(){
		while(true){
			clearConsole();
			System.out.println("+---------------------------------------------------------------+");
			System.out.printf("|                           %S                          |%n","login page");
			System.out.println("+---------------------------------------------------------------+");
			int index=-1;
			
		l1:	while(true){
				System.out.print("User Name \t:\t ");
				String uName=input.next();
				
				for (int i = 0; i < loginCredentials.length; i++){
					if (uName.equals(loginCredentials[i][0])) {
						index=i;
						break l1 ;
					}
				}
				System.out.println("user name is invalid. please try again ! \n");
			}
			
			
			
		l2:	while(true){
				System.out.print("Password \t:\t ");
				String uPass=input.next();
				if (uPass.equals(loginCredentials[index][1]))
					break l2;
				System.out.println("Password is invalid. please try again ! \n");
			}
			homePage();
		}
	}
	
	public static void homePage(){
		while(true){
			clearConsole();
			System.out.println("+---------------------------------------------------------------+");
			System.out.printf("|            %S            |%n","welcome to ijse stock management system");
			System.out.println("+---------------------------------------------------------------+");
			
			System.out.println("[1] Change the Credentials \t\t [2] Supplier Manage");
			System.out.println("[3] Stock Manage \t\t\t [4] Log out");
			System.out.println("[5] Exit the system");
			
		E1:	while(true){
				System.out.print("Enter an option to continue > ");
				int option = input.nextInt();
				switch(option){
						case 1 : changeTheCredentials(); break E1;
						case 2 : supplierManage(); break E1;
						case 3 : stockManage(); break E1;
						case 4 : loginPage(); break E1;
						case 5 : System.exit(0);
						default : System.out.println("Enter VALID character!");
				}
			}
		}
	}
	
	public static void changeTheCredentials(){
		clearConsole();
		System.out.println("+---------------------------------------------------------------+");
		System.out.printf("|                       %S                       |%n","credential manage");
		System.out.println("+---------------------------------------------------------------+\n");
		
l0:		while(true){
			int index=-1;
		l1:	while(true){
			System.out.print("Please enter the user name to verify it\'s you : ");
			String uName = input.next();
			
			for (int i = 0; i < loginCredentials.length; i++) {
				if (uName.equals(loginCredentials[i][0]) ){
					System.out.println("Hey "+loginCredentials[i][0]);
					index=i;
					break l1;
				}
			}
			System.out.print("invalid user name . try again ! \n");
			} 
		l2:	while(true){
				System.out.print("Enter your current password : ");
				String uPass = input.next();
					if (uPass.equals(loginCredentials[index][1])) {
						System.out.print("Enter your new password : ");
						loginCredentials[index][1] = input.next();
						break l2;
					}
				System.out.print("Incorrect password . try again !\n");
			}
	
			while(true){
				System.out.print("Password change successfully ! Do you want to go home page (Y/N) : ");
				char option = input.next().charAt(0);
				if(option=='Y' || option=='y'){
					return;
				}else if(option=='N' || option=='n'){
					System.exit(0);
				}else{
					System.out.println("Please enter correct character !!");
				}
			}
			
		}
	}
	
	public static void supplierManage(){
		while(true){
			clearConsole();
			System.out.println("+---------------------------------------------------------------+");
			System.out.printf("|                         %S                       |%n","supplier manage");
			System.out.println("+---------------------------------------------------------------+");
			
			System.out.println("[1] Add Supplier \t\t\t [2] Update Supplier");
			System.out.println("[3] Delete Supplier \t\t\t [4] View Supplier");
			System.out.println("[5] Search Supplier \t\t\t [6] Home Page");
			
		E1:	while(true){
				System.out.print("Enter an option to continue > ");
				int option = input.nextInt();
				switch(option){
						case 1 : addSupplier(); break E1;
						case 2 : updateSupplier(); break E1;
						case 3 : deleteSupplier(); break E1;
						case 4 : viewSupplier(); break E1;
						case 5 : searchSupplier();break E1;
						case 6 : homePage();
						default : System.out.println("Enter VALID character!");
				}
			}
		}
	}
	
	//SUPPLIER MANAGE SECTION start
	
	public static void addSupplier(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.printf("|                              %S                               |%n","add supplier");
		System.out.println("+-------------------------------------------------------------------------+");
 		
		while(true){
			System.out.print("Supplier ID\t:\t");
			String id = input.next();
			boolean flag=false;
			for (int i = 0; i < suppliers.length; i++){
				if (suppliers[i][0].equals(id)) {
					System.out.print("already exists . try another supplier id !\n");
					flag=true;
					break;
				}
			}
			if (!flag){
				growS();
				System.out.print("Supplier Name\t:\t");
				suppliers[suppliers.length-1][1] = input.next();
				suppliers[suppliers.length-1][0] = id;
				System.out.println("added successfully !");
				while(true){
					System.out.print("Do you want to add another supplier (Y/N) : ");
					char option = input.next().charAt(0);
					if(option=='Y' || option=='y'){
						break;
					}else if(option=='N' || option=='n'){
						return;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}
		}
	}
	
	public static void updateSupplier(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.printf("|                             %S                             |%n","update supplier");
		System.out.println("+-------------------------------------------------------------------------+");
		
		while (true){
			System.out.print("Supplier ID\t:\t");
			String id = input.next();
			int index = -1;
			boolean flag = false;
			for (int i = 0; i < suppliers.length; i++){
				if (suppliers[i][0].equals(id)){
					flag=true;
					index=i;
					break;
				}
			}
			if (!flag){
				System.out.println("can\'t find supplier id . try again !");
			}else{
				System.out.println("Supplier Name\t:\t"+suppliers[index][1]);
				System.out.print("Enter the new supplier name\t:\t");
				suppliers[index][1]=input.next();
				
				System.out.print("Updated Successfully! ");
				while(true){
					System.out.print("Do you want to update another supplier ? (Y/N)");
					char option = input.next().charAt(0);
					if (option=='N' || option=='n'){
						return;
					}else if(option=='Y' || option=='y'){
						break;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}
		}
	}
	
	public static void deleteSupplier(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.printf("|                              %S                            |%n","delete supplier");
		System.out.println("+-------------------------------------------------------------------------+");
		
		while(true){
			System.out.print("Supplier ID\t:\t");
			String id = input.next();
			boolean flag=false;
			int index=-1;
			
			for (int i = 0; i < suppliers.length; i++) {
				if (suppliers[i][0].equals(id)) {
					flag=true;
					index=i;
					break;
				}
			}
			if(flag){
				suppliers[index][0]="null";
				removes();
				System.out.print("deleted successfully !");
				while(true){
					System.out.print("Do you want to delete another ? (Y/N)");
					char option = input.next().charAt(0);
					if (option=='N'||option=='n'){
						return;
					}else if(option=='Y' || option=='y'){
						break;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}else{
				System.out.print("can\' find supplier id . try again !");
			}
		}
	}
	
	public static void viewSupplier(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.printf("|                          %S                                  |%n","view supplier");
		System.out.println("+-------------------------------------------------------------------------+");
		
		System.out.println("+-----------------------+---------------------------------------+");
		System.out.printf("|     %S       |            %S      \t|%n","supplier id","supplier name");
		System.out.println("+-----------------------+---------------------------------------+");
		
		for (int i = 0; i < suppliers.length; i++){
				System.out.printf("|\t%s\t\t|\t\t%s    \t\t|%n",suppliers[i][0],suppliers[i][1]);
		}
		System.out.println("+-----------------------+---------------------------------------+");
		while(true){
			System.out.print("Do you want to go supplier manage page(Y/N) ? ");
			char option = input.next().charAt(0);
			if(option=='Y' || option=='y'){
				return;
			}else if(option=='N' || option=='n'){
				System.exit(0);
			}else{
				System.out.println("Please enter correct character !!");
			}
		}
	}
	
	public static void searchSupplier(){
		clearConsole();
		System.out.println("+---------------------------------------------------------------+");
		System.out.printf("|                         %S                       |%n","search supplier");
		System.out.println("+---------------------------------------------------------------+");
		
		while(true){
			System.out.print("Supplier ID\t:\t");
			String id = input.next();
			boolean flag= false;
			int index=-1;
			
			for (int i = 0; i < suppliers.length; i++) {
				if (suppliers[i][0].equals(id)){
					flag = true;
					index = i;
					break;
				}
			}
			if (flag) {
				System.out.println("Supplier Name\t:\t"+suppliers[index][1]);
				while(true){
					System.out.print("Do you want to find another supplier(Y/N) ? ");
					char option = input.next().charAt(0);
					if(option=='Y' || option=='y'){
						break;
					}else if(option=='N' || option=='n'){
						return;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}else{
				System.out.println("Can\'t find supplier id . try again !");
			}
		}
	}
	//SUPPLIER MANAGEMENT SECTION end
	public static void stockManage(){
		while(true){
			clearConsole();
			System.out.println("+---------------------------------------------------------------+");
			System.out.printf("|                          %S                         |%n","stock manage");
			System.out.println("+---------------------------------------------------------------+");
			
			System.out.println("[1] Manage Item Categoriess \t\t [2] Add Item");
			System.out.println("[3] Get Items Supplier Wise \t\t [4] View Items");
			System.out.println("[5] Rank Items Per Unit Price \t\t [6] Home Page");
			
		E1:	while(true){
				System.out.print("\nEnter an option to continue > ");
				int option = input.nextInt();
				
				switch(option){
						case 1 : categoryManage(); break E1;
						case 2 : addItem(); break E1;
						case 3 : getItemSupplierWise(); break E1;
						case 4 : viewItem(); break E1;
						case 5 : sortItem();break E1;
						case 6 : homePage();break E1;
						default : System.out.println("Enter VALID Character !");
				}
			}
		}
	}
	
	//STOCK MANAGEMENT SECTION start
	
	public static void categoryManage(){
		while(true){
			clearConsole();
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("|                          MANAGE ITEM CATEGORY                           |");
			System.out.println("+-------------------------------------------------------------------------+");
			
			System.out.println("[1] Add New Item Categories \t\t [2] Delete Item Category");
			System.out.println("[3] Update Item Category \t\t [4] Stock Management");
			
		L:	while(true){
				System.out.print("\nEnter an option to continue > ");
				int option = input.nextInt();
				switch(option){
					case 1 : addCategory(); break L;
					case 2 : deleteCategory(); break L;
					case 3 : updateCategory(); break L;
					case 4 : stockManage();break L;
					default : System.out.println("Enter VALID Character !");
				}
			}
		}
	}
	
	public static void addCategory(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                            ADD ITEM CATEGORY                            |");
		System.out.println("+-------------------------------------------------------------------------+");
		
		while(true){
			System.out.print("Enter the new item category:\t");
			String id = input.next();
			boolean flag=false;
			for (int i = 0; i < category.length; i++){
				if (category[i].equals(id)) {
					System.out.print("already exists . try another category !\n");
					flag=true;
					break;
				}
			}
			if (!flag){
				growC();
				category[category.length-1] = id;
				
				while(true){
					System.out.print("added successfully ! Do you want to add another category (Y/N) : ");
					char option = input.next().charAt(0);
					if(option=='Y' || option=='y'){
						break;
					}else if(option=='N' || option=='n'){
						return;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}
		}
	}
	
	public static void deleteCategory(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                           DELETE ITEM CATEGORY                           |");
		System.out.println("+-------------------------------------------------------------------------+");
		
		while(true){
			System.out.print("Category name\t:\t");
			String id = input.next();
			boolean flag=false;
			int index=-1;
			
			for (int i = 0; i < category.length; i++) {
				if (category[i].equals(id)) {
					flag=true;
					index=i;
					break;
				}
			}
			if(flag){
				category[index]="null";
				removec();
				System.out.print("deleted successfully !");
				while(true){
					System.out.print("Do you want to delete another category ? (Y/N)");
					char option = input.next().charAt(0);
					if (option=='N'||option=='n'){
						return;
					}else if(option=='Y' || option=='y'){
						break;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
			}else{
				System.out.println("Can\' find category . try again !");
			}
		}
	}
	
	public static void updateCategory(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                        UPDATE ITEM CATEGORY                             |");
		System.out.println("+-------------------------------------------------------------------------+");
		
	E1:	while (true) {
			System.out.print("Enter Item Category\t:\t");
			String id = input.next();
		E2:	for (int i = 0; i < category.length; i++) {
				if (category[i].equals(id)) {
					System.out.print("Enter the new category name\t:\t");
					category[i]=input.next();
					
					System.out.print("Updated Successfully! ");
					while(true){
						System.out.print("Do you want to update another category ? (Y/N)");
						char option = input.next().charAt(0);
						if (option=='N'||option=='n'){
							return;
						}else if(option=='Y' || option=='y'){
							break E2;
						}else{
							System.out.println("Please enter correct character !!");
						}
					}
				}
			}
			System.out.println("Can\'t find Item Category !");
		}
	}
	
	public static void addItem(){
	L:	while(true){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                                ADD ITEM                                 |");
		System.out.println("+-------------------------------------------------------------------------+");
		
		if(category.length==0){
			System.out.println("OOPS! It seems that you don\'t have any item categories in the system .");
			while(true){
				System.out.print("Do you want to add new item category ? (Y/N)");
				char option = input.next().charAt(0);
				if (option=='N'||option=='n'){
					return;
				}else if(option=='Y' || option=='y'){
					addCategory();
					continue L;
				}else{
					System.out.println("Please enter correct character !!");
				}
			}
		}
		if(suppliers.length==0){
			System.out.println("OOPS! It seems that you don\'t have any suppliers in the system .");
			while(true){
				System.out.print("Do you want to add new supplier ? (Y/N)");
				char option = input.next().charAt(0);
				if (option=='N'||option=='n'){
					return;
				}else if(option=='Y' || option=='y'){
					addSupplier();
					continue L;
				}else{
					System.out.println("Please enter correct character !!");
				}
			}
		}
		
		while(true){
			System.out.print("Item Code\t:\t");
			String item = input.next();
			boolean flag=false;
			for (int i = 0; i < items.length; i++){
				if (items[i][0].equals(item)) {
					System.out.print("already exists . try another Item Code!\n");
					flag=true;
					break;
				}
			}
			if (!flag){
				growI();
				items[items.length-1][0]=item;
				System.out.println("Supplier list\t: ");
				System.out.println("+---------------+-----------------------+---------------------------------------+");
				System.out.println("|       #       |      SUPPLIER ID      |              SUPPLIER NAME            |");
				System.out.println("+---------------+-----------------------+---------------------------------------+");
				for (int i = 0; i < suppliers.length; i++){
					System.out.printf("|\t%d\t|\t%s\t\t|\t\t%s    \t\t|%n",(i+1),suppliers[i][0],suppliers[i][1]);
				}
				System.out.println("+---------------+-----------------------+---------------------------------------+");
				while(true){
					System.out.print("Enter the supplier number > ");
					int id=input.nextInt();
					if (id<=suppliers.length){
						items[items.length-1][1]=suppliers[id-1][0];
						break;
					}
					System.out.println("Enter VALID number ! ");
				}
				System.out.println("Item Categories : ");
				System.out.println("+---------------+---------------------------------------+");
				System.out.println("|      #        |              CATEGORY NAME            |");
				System.out.println("+---------------+---------------------------------------+");
				for (int i = 0; i < category.length; i++){
					System.out.printf("|\t%d\t|\t\t%s    \t\t|%n",(i+1),category[i]);
				}
				System.out.println("+---------------+---------------------------------------+");
				while(true){
					System.out.print("Enter the category number > ");
					int id=input.nextInt();
					if (id<=category.length){
						items[items.length-1][2]=category[id-1];
						break;
					}
					System.out.println("Enter VALID number ! ");
				}
				System.out.print("\nDescription : ");
				items[items.length-1][3]=input.next();
				System.out.print("Unit Price : ");
				items[items.length-1][4]=input.next();
				System.out.print("Qty on hand : ");
				items[items.length-1][5]=input.next();
				
				System.out.println("added successfully!");
				while(true){
					System.out.print("Do you want to add another item ? (Y/N)");
					char option = input.next().charAt(0);
					if (option=='N'||option=='n'){
						stockManage();
					}else if(option=='Y' || option=='y'){
						break ; 
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
				
			}
		}
	}
}
	
	public static void getItemSupplierWise(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                             SEARCH SUPPLIER                             |");
		System.out.println("+-------------------------------------------------------------------------+\n");
		
		while(true){
			System.out.print("Enter Supplier ID\t:\t");
			String id = input.next();
			boolean flag= false;
			int index=-1;
			for (int i = 0; i < items.length; i++) {
				if (items[i][1].equals(id)){
					flag=true;
					index=i;
					break;
				}
			}
			if(flag){
				System.out.println("Supplier Name\t:\t"+suppliers[index][1]);
				System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
				System.out.println("|     ITEM CODE     |      DESCRIPTION         |    UNIT PRICE    |  QTY ON HAND  |    CATEGORY    |");
				System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
				for (int i = 0; i < items.length; i++){
					if (items[i][1].equals(id)){
					System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",items[i][0],items[i][3],items[i][4],items[i][5],items[i][2]);
					}
				}
				System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
				System.out.print("Search successfull ! ");
				while(true){
					System.out.print("Do you want to  another search ? (Y/N)");
					char option = input.next().charAt(0);
					if (option=='N'||option=='n'){
						return;
					}else if(option=='Y' || option=='y'){
						break;
					}else{
						System.out.println("Please enter correct character !!");
					}
				}
				
			}else{
				System.out.println("Can\'t find supplier ! ");
			}
			
		}
	}
	
	public static void viewItem(){
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                               VIEW ITEMS                                |");
		System.out.println("+-------------------------------------------------------------------------+\n");
		
		for (int i = 0; i < category.length; i++){
			System.out.println(category[i]+" : ");
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
			System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |");
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+");
			for (int j = 0; j < items.length; j++){
				if (items[j][2].equals(category[i])){
					System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |\n",items[j][1],items[j][0],items[j][3],items[j][4],items[j][5]);
				}
			}
			System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+\n\n");
		}
		while(true){
			System.out.print("Do you want to go stock management page(Y/N) ? ");
			char option = input.next().charAt(0);
			if(option=='Y' || option=='y'){
				return;
			}else if(option=='N' || option=='n'){
				System.exit(0);
			}else{
				System.out.println("Please enter correct character !!");
			}
		}
		
	}
	
	public static void sortItem(){
		double[] sortedAr=new double[items.length];
		for (int i = 0; i < items.length; i++)
			sortedAr[i]=Double.parseDouble(items[i][4]);
			
		for (int i = 0; i < sortedAr.length; i++){
			for (int j = 0; j < sortedAr.length-1; j++){
				if (sortedAr[j]>sortedAr[j+1]){
					double x = sortedAr[j];
					sortedAr[j]=sortedAr[j+1];
					sortedAr[j+1]=x;
				}
			}
		}
		clearConsole();
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                            RANKED UNIT PRICE                            |");
		System.out.println("+-------------------------------------------------------------------------+\n");
		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		System.out.println("|        SID        |           CODE           |       DESC       |     PRICE     |       QTY      |       CAT      |");
		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		for (int i = 0; i < sortedAr.length; i++){
			for (int j = 0; j < items.length; j++){
				if( Double.parseDouble(items[j][4])==sortedAr[i]){
					System.out.printf("|%10S         |%16S          |%10S        |%10S     |%10S      |%10S      |\n",items[j][1],items[j][0],items[j][3],items[j][4],items[j][5],items[j][2]);
				}
			}
		}
		System.out.println("+-------------------+--------------------------+------------------+---------------+----------------+----------------+");
		
		while(true){
			System.out.print("Do you want to go stock management page(Y/N) ? ");
			char option = input.next().charAt(0);
			if(option=='Y' || option=='y'){
				return;
			}else if(option=='N' || option=='n'){
				System.exit(0);
			}else{
				System.out.println("Please enter correct character !!");
			}
		}
	}
	
	public static void growS(){
		String[][] temp = new String[suppliers.length+1][2];
		for (int i = 0; i < suppliers.length; i++) {
			for (int j = 0; j < suppliers[i].length; j++) {
				temp[i][j]=suppliers[i][j];
			}
		}
		suppliers= temp;
	}
	
	public static void growI(){
		String[][] temp = new String[items.length+1][6];
		for (int i = 0; i <items.length ; i++) {
			for (int j = 0; j < items[i].length; j++){
				temp[i][j]=items[i][j];
			}
		}
		items=temp;
	}
	
	public static void growC(){
		String[] temp = new String[category.length+1];
		for (int i = 0; i < category.length; i++){
			temp[i]=category[i];
		}
		category=temp;
	}
	
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removes(){
		String[][] temp = new String[suppliers.length-1][2];
		for (int i = 0,k=0; i < temp.length; i++) {
			if(suppliers[i][0].equals("null")){
				k++;
			}
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j]=suppliers[i+k][j];
			}
		}
		suppliers=temp;
	}
	
	public static void removec(){
		String[] temp = new String[category.length-1];
		for (int i = 0,k=0; i < temp.length; i++) {
			if(category[i].equals("null")){
				k++;
			}
			temp[i]=category[i+k];
			
		}
		category=temp;
	}
	
}

